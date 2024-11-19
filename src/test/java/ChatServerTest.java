import org.BehavioralDesignPattern.ChatServer;
import org.BehavioralDesignPattern.Message;
import org.BehavioralDesignPattern.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest {

    @Test
    void testMessageDelivery() {
        ChatServer chatServer = new ChatServer();
        User luffy = new User("Luffy", chatServer);
        User eustass = new User("Eustass", chatServer);

        luffy.sendMessage("Hi, Eustass!", Arrays.asList("Eustass"));

        assertEquals(1, eustass.searchMessagesByUser("Luffy").next().getContent().length());
    }

    @Test
    void testBlockingUser() {
        ChatServer chatServer = new ChatServer();
        User luffy = new User("Luffy", chatServer);
        User eustass = new User("Eustass", chatServer);

        eustass.blockUser("Luffy");
        luffy.sendMessage("Hi, Eustass!", Arrays.asList("Eustass"));

        Iterator<Message> iterator = eustass.searchMessagesByUser("Luffy");
        assertFalse(iterator.hasNext());
    }
}
