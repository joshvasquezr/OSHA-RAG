package org.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;


@Route
public class MainView extends VerticalLayout {

    private List<MessageListItem> messages;

    public MainView() {

        setSizeFull();
        setPadding(false);
        setSpacing(false);

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        messages = new ArrayList<>();
        MessageList messageList = new MessageList();
        messageList.setWidth("75%");
        messageList.getStyle().set("flex-grow1", "1").set("overflow", "auto");

        VerticalLayout messageContainer = new VerticalLayout(messageList);
        messageContainer.setPadding(false);
        messageContainer.getStyle().set("overflow", "hidden");

        MessageInput messageInput = new MessageInput();
        messageInput.setWidth("50%");
        messageInput.addSubmitListener(submitEvent -> {
            String userMessage = submitEvent.getValue();

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/api/chat/send"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(userMessage))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String assistantResponse = response.body();

                MessageListItem userItem = new MessageListItem(userMessage, Instant.now(), "User");
                MessageListItem assistantItem = new MessageListItem(assistantResponse, Instant.now(), "Assistant");

                messages.add(userItem);
                messages.add(assistantItem);
                messageList.setItems(messages);

                // Scroll to the bottom when a new message is added
                messageList.getElement().executeJs("this.scrollTop = this.scrollHeight;");
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Error sending message", 3000, Notification.Position.MIDDLE);
            }

            messageInput.getElement().executeJs("this.value=''"); // Manually clear the value in the input
        });

        add(messageList, messageInput);
        setFlexGrow(1, messageList); // Ensure messageList takes up the remaining space
    }
}
