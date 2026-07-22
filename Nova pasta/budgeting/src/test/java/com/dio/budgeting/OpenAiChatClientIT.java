package com.dio.budgeting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@EnabledIfEnvironmentVariable(named = "OPENAI_API_KEY", matches = ".+")
public class OpenAiChatClientIT {
//
//    @Autowired
//    OpenAiChatModel openAiChatModel;
//
//    @Test
//    void should_executeSum_when_prompted() {
//        var chatClient = ChatClient
//        		.builder(openAiChatModel)
//        			.defaultSystem("Você é um matemático")
//        				.build();
//
//        var response = chatClient
//        		.prompt("Some 10 mais 20. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações")
//                	.call()
//                		.content();
//
//        assertThat(response).contains("0");
//        System.out.println(response);
//    }

    @Autowired
    private OllamaChatModel chatModel; // 🚀 Injeção limpa do Gemma do Google

    @Test
    void should_executeSum_when_prompted() {
        // O ChatClient aceita QUALQUER modelo do planeta, inclusive o nosso Gemma!
        var chatClient = ChatClient
        		.builder(chatModel)
        			.defaultSystem("Você é um matemático")
        				.build();

        var response = chatClient
        		.prompt("Some 10 mais 20. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações")
                	.call()
                		.content();

        assertThat(response).contains("0");
        System.out.println("Resultado da IA Local: " + response);
    }
}
