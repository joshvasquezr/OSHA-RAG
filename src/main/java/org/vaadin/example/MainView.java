package org.vaadin.example;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.List;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.messages.MessageListItem;
import org.vaadin.firitin.components.messagelist.MarkdownMessage;


@Route
public class MainView extends VerticalLayout {
    private Button clearChatButton;
    private VerticalLayout messageList;
    private MessageInput messageInput;
    private H2 Title;

    private List<MessageListItem> messages;

    public MainView() {

        this.clearChatButton = new Button("Clear Chat");
        this.messageList = new VerticalLayout();  //
        this.messageInput = new MessageInput();

        this.Title = new H2("OSHA Expert Conversation");

        this.Title.addClassName(LumoUtility.AlignContent.CENTER);

        // setPadding and setSpacing below
        setPadding(true);
        setSpacing(true);
        this.messageList.setSpacing(false);

        // messageList area and clearChat button are given styling attributes
        this.messageList.addClassNames(LumoUtility.Padding.Horizontal.XSMALL, LumoUtility.Margin.Horizontal.XSMALL,
                LumoUtility.MaxWidth.SCREEN_LARGE);
        this.clearChatButton.addClassName("clear-chat-button");

        // Listening event to clear chat on clearChatButton click
        this.clearChatButton.addClickListener(e -> {
            this.messageList.removeAll();
            focusMessageInput();
        });





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


                MarkdownMessage question = new MarkdownMessage(userMessage, "You");
                question.addClassName("user");

                MarkdownMessage reply = new MarkdownMessage(response.body(), "Assistant");
                reply.addClassName("assistant");

                // Add the user query first and then the reply to the messageList
                this.messageList.add(question);
                this.messageList.add(reply);

                // Scroll to the bottom when a new message is added
                messageList.getElement().executeJs("this.scrollTop = this.scrollHeight;");

            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Error sending message", 3000, Notification.Position.MIDDLE);
            }

            messageInput.getElement().executeJs("this.value=''"); // Manually clear the value in the input
        });

        add(this.Title);
        add(new Hr());

        // This creates the section of the app for the messages to fill up and sets it to be scrollable. Width takes
        // up the hole space
        Scroller scroller = new Scroller(this.messageList);
        scroller.setWidthFull();
        scroller.addClassName(LumoUtility.AlignContent.END);
        addAndExpand(scroller);

        focusMessageInput(); // Uses method defined below to focus on messageInput box so the user doesn't have to
        // click on it before typing


        // Add styling attributes to the messageInput textfield (Horizontal/Vertical padding, horizontal margin and
        // the max width related to the screen of the device
        this.messageInput.addClassNames(LumoUtility.Padding.Horizontal.XSMALL, LumoUtility.Padding.Vertical.MEDIUM,
                LumoUtility.Margin.Horizontal.XSMALL, LumoUtility.MaxWidth.SCREEN_XLARGE);

        HorizontalLayout inputLayout = new HorizontalLayout();
        inputLayout.setWidthFull();
        inputLayout.setSpacing(true); // Adds default spacing between components
        inputLayout.add(clearChatButton, messageInput);
        inputLayout.setAlignItems(Alignment.BASELINE);
        inputLayout.setFlexGrow(1, messageInput); // Ensure messageInput takes up remaining space

//        add(inputLayout);


        // Add the horizontal layout to the view
        add(inputLayout);
    }

    private void focusMessageInput() {
        this.messageInput.getElement().executeJs("requestAnimationFrame(() => this.querySelector('vaadin-text-area')" +
                ".focus() )");
    }
}
