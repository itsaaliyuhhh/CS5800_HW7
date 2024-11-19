import org.BehavioralDesignPattern.MessageMemento;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageMementoTest {

    @Test
    void testMementoCreation() {
        LocalDateTime timestamp = LocalDateTime.now();
        MessageMemento memento = new MessageMemento("Test message!", timestamp);

        assertEquals("Test message!", memento.getContent());
        assertEquals(timestamp, memento.getTimestamp());
    }
}
