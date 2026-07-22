package com.dio.budgeting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class ToolCallingIT {
//
//	@Autowired
//    private OpenAiChatModel openAiChatModel;
//
//
//    static class MathTools {
//    	@Tool(description = "soma dois números inteiros, a e b")
//    	public int sum(int a, int b) {
//    		return a + b;
//    	}
//
//    	@Tool(description = "subtrai dois números inteiros, a e b")
//    	public int diff(int a, int b) {
//    		return a - b;
//    	}
//    }
//
//
//    @Test
//    void should_executeSum_when_prompted() {
//        var chatClient = ChatClient.builder(openAiChatModel)
//                .defaultSystem("Você é um matemático")
//                .defaultTools(new MathTools())
//                .build();
//
//        var response = chatClient.prompt("Some 10 mais 20. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações")
//                .call().content();
//
//        assertThat(response).contains("0");
//        System.out.println(response);
//    }


	@Autowired
    private OllamaChatModel chatModel; // 🧠 Injeta o Gemma do Google/Docker

    // As ferramentas Java continuam iguaizinhas e puras!
    static class MathTools {
    	@Tool(description = "soma dois números inteiros, a e b")
    	public int sum(int a, int b) {
    		return a + b;
    	}

    	@Tool(description = "subtrai dois números inteiros, a e b")
    	public int diff(int a, int b) {
    		return a - b;
    	}
    }

    @Test
    void should_executeSum_when_prompted() {
        // O ChatClient repassa as ferramentas Java nativas para o Ollama ler!
        var chatClient = ChatClient.builder(chatModel)
                .defaultSystem("Você é um matemático")
                .defaultTools(new MathTools()) // Solda os plugues de ferramentas na calha
                .build();

        var response = chatClient.prompt("Some 10 mais 20. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações")
                .call().content();

        // O resultado vai cravar 0 com precisão cirúrgica de calculadora!
        assertThat(response).contains("0");
     // Valida se a resposta contém o número zero exato
        assertThat(response).contains("0");
        System.out.println("--------------------------------------------------");
        System.out.println("🚀 RESPOSTA DO TOOL CALLING LOCAL: " + response);
        System.out.println("--------------------------------------------------");
    }

}
