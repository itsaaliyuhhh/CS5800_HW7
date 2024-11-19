import org.BehavioralDesignPattern.ChatServer;
import org.BehavioralDesignPattern.Message;
import org.BehavioralDesignPattern.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testSendMessage() {
        ChatServer chatServer = new ChatServer();
        User luffy = new User("Luffy", chatServer);
        User eustass = new User("Eustass", chatServer);

        luffy.sendMessage("Hi, Eustass!", Arrays.asList("Eustass"));
        Iterator<Message> iterator = eustass.searchMessagesByUser("Luffy");

        assertTrue(iterator.hasNext());
        assertEquals("Hi, Eustass!", iterator.next().getContent());
    }

    @Test
    void testUndoLastMessage() {
        ChatServer chatServer = new ChatServer();
        User luffy = new User("Luffy", chatServer);

        luffy.sendMessage("Test message", Arrays.asList("Eustass"));
        luffy.undoLastMessage();

        assertNull(luffy.searchMessagesByUser("Eustass").next());
    }

    @Test
    void testBlockUser() {
        ChatServer chatServer = new ChatServer();
        User luffy = new User("Luffy", chatServer);
        User eustass = new User("Eustass", chatServer);

        eustass.blockUser("Luffy");
        luffy.sendMessage("Hi, Eustass!", Arrays.asList("Eustass"));

        Iterator<Message> iterator = eustass.searchMessagesByUser("Luffy");
        assertFalse(iterator.hasNext());
    }
}
