package edu.isu.cs2263.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test is to make sure that the PushbackTokenizer adapter is running correctly
 */
public class PushbackTokenizerTest {

    // Basic Variables

    /**
     * This test checks that PushbackTokenizer can check that there are more tokens
     */
    @Test
    void pushbackHasMoreTest() {
        String data = "Berp a derp murp gerp";
        Boolean expected = true;
        PushbackTokenizer pusherT = new PushbackTokenizer(data);
        Boolean actual = pusherT.hasMoreTokens();
        assertEquals(expected, actual, "Problem with Pushback");
    }

    /**
     * This test is to check that the nextToken method is running correctly
     */
    @Test
    void pushbackTokenTest() {
        String data = "Berp a derp murp gerp";
        String actual = "";
        PushbackTokenizer pusherT = new PushbackTokenizer(data);
        actual += pusherT.nextToken();
        while (pusherT.hasMoreTokens()){
            actual += " " + pusherT.nextToken();
        }
        assertEquals(data, actual, "Problem with Pushback");
    }

    /**
     * This test checks that PushbackTokenizer can push tokens back then grab them again
     */
    @Test
    void pushbackPushTest() {
        String data = "Berp a derp murp gerp";
        String expected = "a";
        String actual;
        PushbackTokenizer pusherT = new PushbackTokenizer(data);
        pusherT.nextToken(); // Should be "Berp"
        pusherT.nextToken(); // Should be "a"
        pusherT.pushback();  // Should store "a"
        actual = pusherT.nextToken(); // Should pull back "a" again
        assertEquals(expected, actual, "Problem with Pushback");
    }
}
