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


@Route
public class MainView extends VerticalLayout {

    private List<MessageListItem> messages;

    public MainView() {

        messages = new ArrayList<>();
        MessageList messageList = new MessageList();


        MessageInput messageInput = new MessageInput();
        messageInput.addSubmitListener(submitEvent -> {
            String userMessage = submitEvent.getValue();
            Notification.show("Message received: " + userMessage, 3000, Notification.Position.MIDDLE);

            MessageListItem newItem = new MessageListItem(
                    userMessage,
                    LocalDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault()),
                    "User"
            );

            messages.add(newItem);
            messageList.setItems(messages);
        });


        add(messageList, messageInput);
    }
}
