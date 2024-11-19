package org.BehavioralDesignPattern;

import java.util.Arrays;
import java.util.Iterator;

public class MessageDriver {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User luffy = new User("Luffy", chatServer);
        User eustass = new User("Eustass", chatServer);
        User law = new User("Law", chatServer);

        luffy.sendMessage("Hi Eustass!", Arrays.asList("Eustass"));
        eustass.sendMessage("Hello Luffy!", Arrays.asList("Luffy"));
        law.sendMessage("Hi everyone!", Arrays.asList("Luffy", "Eustass"));

        eustass.blockUser("Law");
        law.sendMessage("Blocked message", Arrays.asList("Eustass"));

        luffy.undoLastMessage();

        Iterator<Message> messagesWithEustass = luffy.searchMessagesByUser("Eustass");
        while (messagesWithEustass.hasNext()) {
            Message message = messagesWithEustass.next();
            System.out.println("Message in chat history with Eustass: " + message.getContent());
        }
    }
}
