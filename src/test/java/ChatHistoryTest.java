import org.BehavioralDesignPattern.ChatHistory;
import org.BehavioralDesignPattern.Message;
import org.BehavioralDesignPattern.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ChatHistoryTest {

    @Test
    void testAddAndRetrieveMessages() {
        ChatHistory chatHistory = new ChatHistory();
        Message message1 = new Message("Luffy", Arrays.asList("Eustass"), "Hi, Eustass!");
        Message message2 = new Message("Eustass", Arrays.asList("Luffy"), "Hello, Luffy!");

        chatHistory.addMessage(message1);
        chatHistory.addMessage(message2);

        assertEquals(2, chatHistory.getMessages().size());
        assertEquals(message2, chatHistory.getLastMessage());
    }

    @Test
    void testIteratorByUser() {
        ChatHistory chatHistory = new ChatHistory();
        Message message1 = new Message("Luffy", Arrays.asList("Eustass"), "Hi, Eustass!");
        Message message2 = new Message("Eustass", Arrays.asList("Luffy"), "Hello, Luffy!");
        chatHistory.addMessage(message1);
        chatHistory.addMessage(message2);

        Iterator<Message> iterator = chatHistory.iterator(new User("Luffy", null));
        assertTrue(iterator.hasNext());
        assertEquals("Hi, Eustass!", iterator.next().getContent());
    }
}
