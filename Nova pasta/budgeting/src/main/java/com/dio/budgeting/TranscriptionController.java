//package com.dio.budgeting;
//
//import org.springframework.ai.audio.transcription.TranscriptionModel;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//public class TranscriptionController {
//
//	private final TranscriptionModel transcriptionModel;
//
//	public TranscriptionController(TranscriptionModel transcriptionModel) {
//		this.transcriptionModel= transcriptionModel;
//	}
//
//	@PostMapping(value = "/transcribe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public String transcribe(@RequestParam MultipartFile file) {
//		var resource = file.getResource();
//		return transcriptionModel.transcribe(resource);
//	}
//
//}

package com.dio.budgeting;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api")
public class TranscriptionController {

    private final RestClient restClient;

    // Inicializa o cliente HTTP nativo do Spring mirando na porta 9000 do Whisper
    public TranscriptionController() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:9000")
                .build();
    }

    @PostMapping(value = "/transcribe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> transcribe(@RequestParam("audio_file") MultipartFile file) {
        try {
            // 🧼 EXTRAÇÃO SEGURA: Puxa o nome original e o fluxo de dados em bytes
            String nomeOriginal = file.getOriginalFilename() != null ? file.getOriginalFilename() : "audio.m4a";
            byte[] bytesDoAudio = file.getBytes();

            // 🧠 CONVERSÃO DE GRIFE: Envelopa em um Resource que o Spring sabe ler e carimba o nome real
            org.springframework.core.io.ByteArrayResource recursoDeAudio = new org.springframework.core.io.ByteArrayResource(bytesDoAudio) {
                @Override
                public String getFilename() {
                    return nomeOriginal; // Essencial para o container saber qual é o formato do áudio!
                }
            };

            // 🚀 A FUSÃO DE ALTA PATENTE: Usa o Builder oficial do Spring para travar o formato MULTIPART!
            MultipartBodyBuilder builder = new MultipartBodyBuilder();
            // Adiciona a peça no formulário forçando explicitamente a leitura como arquivo binário
            builder.part("audio_file", recursoDeAudio, MediaType.APPLICATION_OCTET_STREAM);

            // Monta o corpo físico final da requisição (A maçaroca correta de formulário)
            MultiValueMap<String, HttpEntity<?>> multipartBody = builder.build();

            // Chuta os dados na calha contra o Whisper local na porta 9000
            // 🚀 AJUSTE DE GRIFE: Força o retorno em JSON para garantir a captura das propriedades textuais
            String textoTranscrevido = restClient.post()
                    .uri("/asr?language=pt&output=text") // ⚡ MUDE PARA "json" AQUI!
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(multipartBody)
                    .retrieve()
                    .body(String.class);


            // Devolve a string limpa direto para o navegador ou REST Client
            return ResponseEntity.ok(textoTranscrevido != null ? textoTranscrevido.trim() : "");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro no barramento de audio local: " + e.getMessage());
        }
    }

}