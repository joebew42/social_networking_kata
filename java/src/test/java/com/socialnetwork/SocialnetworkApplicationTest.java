package com.socialnetwork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SocialnetworkApplicationTest {

    @Test
    public void as_a_user_i_can_write_and_read_my_timeline() {
        InputAdapter inputAdapter = new InputAdapterThatReads(
                "Alice -> I love the weather today",
                "Alice"
        );
        List<String> output = new ArrayList<String>();
        OutputAdapter outputAdapter = new SpyOutputAdapter(output);

        SocialNetworkApplication application = new SocialNetworkApplication(inputAdapter, outputAdapter);
        application.start();

        assertEquals("I love the weather today (5 minutes ago)", output.get(0));
    }

    private class InputAdapterThatReads implements InputAdapter {
        private List<String> lines;

        public InputAdapterThatReads(String ... lines) {
            this.lines = new ArrayList<String>(asList(lines));
        }

        public String read() {
            if (lines.isEmpty()) {
                return null;
            }

            return lines.remove(0);
        }
    }

    private class SpyOutputAdapter implements OutputAdapter {
        private List<String> output;

        public SpyOutputAdapter(List<String> output) {
            this.output = output;
        }

        public void write(String message) {
            output.add(message);
        }
    }
}
