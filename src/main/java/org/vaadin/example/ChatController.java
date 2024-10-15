package org.vaadin.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import shared.Assistant;

import static org.vaadin.example.Naive_RAG_Example.createAssistant;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final Assistant assistant;

    // Initialize the assistant once
    public ChatController() {
        this.assistant = createAssistant("src/main/resources/docs/title-29.json");
    }

    @PostMapping("/send")
    public ResponseEntity<String> handleChat(@RequestBody String userMessage) {
        String response = assistant.chat(userMessage); // Reuse the existing assistant instance
        return ResponseEntity.ok(response);
    }
}
