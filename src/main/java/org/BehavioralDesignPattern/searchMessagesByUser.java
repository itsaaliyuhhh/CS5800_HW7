package org.BehavioralDesignPattern;

import java.util.Iterator;
import java.util.List;

public class searchMessagesByUser implements Iterator<Message> {
    private List<Message> messages;
    private String userName;
    private int position;

    public searchMessagesByUser(List<Message> messages, String userName) {
        this.messages = messages;
        this.userName = userName;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < messages.size()) {
            Message message = messages.get(position);
            if (message.getSender().equals(userName) || message.getRecipients().contains(userName)) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Message next() {
        Message message = messages.get(position);
        position++;
        return message;
    }
}
