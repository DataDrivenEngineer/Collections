package dbelousov.petprojects.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAppenderTest {

    @Test
    void testStringAppender() {

        StringAppender appender = new StringAppender("someTestString    ");

        appender.append(null);
        appender.append("new String");
        appender.append("_andLastOne");
        appender.append("\nunexpected?");

        assertEquals("someTestString    new String_andLastOne\nunexpected?", appender.toString());
    }
}