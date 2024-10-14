package org.vaadin.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

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


//@Route("main")
public class MainView extends VerticalLayout {

    private List<MessageListItem> messages;

    public MainView() {

        setSizeFull();
        setPadding(false);
        setSpacing(false);

        messages = new ArrayList<>();
        MessageList messageList = new MessageList();

        // Set the MessageList to take up the rest of the space
        messageList.setWidthFull();
        messageList.setHeightFull(); // Full height to take up the available space
        messageList.getStyle().set("overflow", "auto"); // Allow scrolling for long messages

        MessageInput messageInput = new MessageInput();
        messageInput.addSubmitListener(submitEvent -> {
            String userMessage = submitEvent.getValue();
            Notification.show("Message received: " + userMessage, 3000, Notification.Position.MIDDLE);

            MessageListItem newItem = new MessageListItem(
                    userMessage,
                    Instant.now(),
                    "User"
            );

            messages.add(newItem);
            messageList.setItems(messages);

            // Scroll to the bottom when a new message is added
            messageList.getElement().executeJs("this.scrollTop = this.scrollHeight;");
        });

        // Make sure the message input is always at the bottom
        messageInput.setWidthFull();
        messageInput.getStyle().set("position", "fixed");
        messageInput.getStyle().set("bottom", "0");
        messageInput.getStyle().set("left", "0");
        messageInput.getStyle().set("right", "0");

        add(messageList, messageInput);
        setFlexGrow(1, messageList); // Ensure messageList takes up the remaining space
    }
}
