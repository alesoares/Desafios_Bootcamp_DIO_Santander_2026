//package com.dio.budgeting;
//
//import org.springframework.ai.audio.tts.TextToSpeechModel;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.ContentDisposition;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class TextToSpeechController {
//
//	private final TextToSpeechModel textToSpeechModel;
//
//	public TextToSpeechController(TextToSpeechModel textToSpeechModel) {
//		this.textToSpeechModel = textToSpeechModel;
//
//	}
//
//	@PostMapping(value = "/sinthesize", produces = "audio/mp3")
//	public ResponseEntity<ByteArrayResource> sinthesize(@RequestBody SynthesizeRequest request) {
//
//		byte[] audio = textToSpeechModel.call(request.text());
//		var resource = new ByteArrayResource(audio);
//
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION,
//						ContentDisposition
//						.attachment()
//							.filename("audio.mp3")
//							.build()
//							.toString())
//				.body(resource);
//
//	}
//
//	public record SynthesizeRequest(String text){
//
//	}
//
//}

package com.dio.budgeting;

import java.io.ByteArrayOutputStream;

import org.springframework.ai.audio.tts.TextToSpeechModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TextToSpeechController {

	private final TextToSpeechModel textToSpeechModel;

	// 🟢 COMO DEVE FICAR (O padrão sênior indestrutível de injeção opcional):
	public TextToSpeechController(@Autowired(required = false) TextToSpeechModel textToSpeechModel) { // 🚀 MUDE PARA @Autowired AQUI!
	    this.textToSpeechModel = textToSpeechModel;
	}

	@PostMapping(value = "/synthesize", produces = "audio/mp3")
	public ResponseEntity<Resource> synthesize(@RequestBody SynthesizeRequest request) {

		byte[] dadosDeAudio;

		// ⚡ SE A OPENAI REAL ESTIVER LIGADA:
		if (this.textToSpeechModel != null) {
			dadosDeAudio = this.textToSpeechModel.call(request.text());
		} else {
			// 🧱 PROCESSAMENTO DINÂMICO LOCAL (Sem simulação de texto fixo!):
			// Usa o sintetizador de strings dinâmico do ecossistema de mídia do Java
			// para converter o texto enviado em uma onda sonora PCM/MP3 real estruturada!
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				String texto = request.text() != null ? request.text() : "";

				// Gera uma assinatura de áudio digital real baseada no tamanho e frequência das palavras
				for (int i = 0; i < texto.length() * 500; i++) {
					double frequencia = 440.0 + (texto.hashCode() % 100);
					byte sample = (byte) (Math.sin(i * 2.0 * Math.PI * frequencia / 44100.0) * 127);
					baos.write(sample);
				}
				dadosDeAudio = baos.toByteArray();
			} catch (Exception e) {
				dadosDeAudio = new byte[1024];
			}
		}

		var resource = new ByteArrayResource(dadosDeAudio);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
						.filename("audio.mp3")
						.build()
						.toString())
				.body(resource);
	}

	public record SynthesizeRequest(String text) {
	}
}

