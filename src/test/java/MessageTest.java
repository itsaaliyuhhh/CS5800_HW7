import org.BehavioralDesignPattern.Message;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageCreation() {
        Message message = new Message("Luffy", Arrays.asList("Eustass", "Law"), "Hello, crew!");

        assertEquals("Luffy", message.getSender());
        assertEquals(Arrays.asList("Eustass", "Law"), message.getRecipients());
        assertEquals("Hello, crew!", message.getContent());
        assertNotNull(message.getTimestamp());
        assertTrue(message.getTimestamp().isBefore(LocalDateTime.now().plusSeconds(1)));
    }
}
