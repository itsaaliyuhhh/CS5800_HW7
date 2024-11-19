package org.BehavioralDesignPattern;

import java.util.Iterator;
import java.util.List;

public class User {
    private String name;
    private ChatHistory chatHistory = new ChatHistory();
    private ChatServer chatServer;
    private MessageMemento lastMessageMemento;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String content, List<String> recipients) {
        Message message = new Message(name, recipients, content);
        chatHistory.addMessage(message);
        lastMessageMemento = new MessageMemento(content, message.getTimestamp());
        chatServer.sendMessage(message);
    }

    public void undoLastMessage() {
        if (lastMessageMemento != null) {
            System.out.println("Undoing last message: " + lastMessageMemento.getContent());
            lastMessageMemento = null; // Reset memento after undo
        }
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
        System.out.println("Message received by " + name + ": " + message.getContent());
    }

    public void blockUser(String userName) {
        chatServer.blockUser(name, userName);
    }

    public Iterator<Message> searchMessagesByUser(String userName) {
        return chatHistory.iterator(new User(userName, chatServer));
    }
}
