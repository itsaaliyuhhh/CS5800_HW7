package org.BehavioralDesignPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> blockedUsers = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockedUsers.put(user.getName(), new HashSet<>());
    }

    public void unregisterUser(String userName) {
        users.remove(userName);
        blockedUsers.remove(userName);
    }

    public void sendMessage(Message message) {
        for (String recipient : message.getRecipients()) {
            if (!blockedUsers.get(recipient).contains(message.getSender())) {
                User recipientUser = users.get(recipient);
                if (recipientUser != null) {
                    recipientUser.receiveMessage(message);
                }
            }
        }
    }

    public void blockUser(String userName, String blockedUserName) {
        blockedUsers.get(userName).add(blockedUserName);
    }
}
