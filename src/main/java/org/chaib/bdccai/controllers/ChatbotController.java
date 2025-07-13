package org.chaib.bdccai.controllers;

import org.chaib.bdccai.service.ChatbotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @GetMapping("/ask")
    public String askQuestion(@RequestParam String message) {
        return chatbotService.askGpt4(message);
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = chatbotService.askGpt4(request.getMessage());
        return new ChatResponse(request.getMessage(), response);
    }

    @PostMapping("/custom")
    public ChatResponse chatWithCustomPrompt(@RequestBody CustomChatRequest request) {
        String response = chatbotService.askWithCustomSystem(
                request.getMessage(),
                request.getSystemPrompt()
        );
        return new ChatResponse(request.getMessage(), response);
    }

    // Simple DTOs
    public static class ChatRequest {
        private String message;

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public static class CustomChatRequest {
        private String message;
        private String systemPrompt;

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public String getSystemPrompt() { return systemPrompt; }
        public void setSystemPrompt(String systemPrompt) { this.systemPrompt = systemPrompt; }
    }

    public static class ChatResponse {
        private String question;
        private String answer;

        public ChatResponse(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() { return question; }
        public String getAnswer() { return answer; }
    }
}