package com.example.contentgenerator.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContentGeneratorController {

    // Corrected the type from 'ChatCl' to 'ChatClient'
    private final ChatClient chatClient;

    // Corrected the constructor to use the ChatClient builder properly
    public ContentGeneratorController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/generate/description")
    public String generateProductDescription(@RequestParam String product){

        String promptText = """
                Generate a catchy and concise product description for a new item.
                The item is called {productName}.
                Highlight its unique features and benefits.
                The tone should be enthusiastic and persuasive.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        Prompt prompt = promptTemplate.create(Map.of("productName", product));

        return chatClient.prompt(prompt).call().content();
    }
}
