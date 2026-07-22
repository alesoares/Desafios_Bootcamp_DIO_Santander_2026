package com.dio.budgeting;

//import org.springframework.ai.openai.OpenAiChatModel;

import org.springframework.ai.ollama.OllamaChatModel;// 🚀 Import do motor gratuito!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ChatModelController {

//	private final OpenAiChatModel openAiChatModel;

	private final OllamaChatModel chatModel; // 🚀 Injeção limpa da IA local


//	public ChatModelController(OpenAiChatModel openAiChatModel) {
//		this.openAiChatModel = openAiChatModel;
//	}

	public ChatModelController(OllamaChatModel chatModel) {
		this.chatModel = chatModel;
	}


//	@GetMapping("/chat-model")
//	public String chat(@RequestParam("prompt") String prompt) {
//		return this.openAiChatModel.call(prompt);
//	}

	@GetMapping("/chat-model")
	public String chat(@RequestParam String prompt) {
		// Bate direto no Docker, 100% de graça e sem limites de quota!
		return this.chatModel.call(prompt);
	}


}
