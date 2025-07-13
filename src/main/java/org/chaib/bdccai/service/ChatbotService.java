package org.chaib.bdccai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    private final ChatClient chatClient;

    public ChatbotService(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    public String askGpt4(String message) {
        return chatClient.prompt()
                .system("You are a helpful AI assistant. Provide clear and concise answers.")
                .user(message)
                .call()
                .content();
    }

    public String askWithCustomSystem(String message, String systemPrompt) {
        return chatClient.prompt()
                .system(systemPrompt)
                .user(message)
                .call()
                .content();
    }
}