package org.BehavioralDesignPattern;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private String sender;
    private List<String> recipients;
    private String content;
    private LocalDateTime timestamp;

    public Message(String sender, List<String> recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
