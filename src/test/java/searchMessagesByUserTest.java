import org.BehavioralDesignPattern.Message;
import org.BehavioralDesignPattern.searchMessagesByUser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class searchMessagesByUserTest {

    @Test
    void testIteratorFiltering() {
        List<Message> messages = Arrays.asList(
                new Message("Luffy", Arrays.asList("Eustass"), "Hi, Eustass!"),
                new Message("Eustass", Arrays.asList("Luffy"), "Hello, Luffy!"),
                new Message("Law", Arrays.asList("Luffy"), "Hi, Luffy!")
        );

        searchMessagesByUser iterator = new searchMessagesByUser(messages, "Luffy");
        assertTrue(iterator.hasNext());
        assertEquals("Hi, Eustass!", iterator.next().getContent());
        assertTrue(iterator.hasNext());
        assertEquals("Hello, Luffy!", iterator.next().getContent());
        assertFalse(iterator.hasNext());
    }
}
