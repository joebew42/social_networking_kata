package com.socialnetwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkShould {

    @Mock private SocialNetwork socialNetwork;

    @Test
    public void publish_message_to_alice_time_line() {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine(socialNetwork);

        commandLine.execute("Alice -> I love the weather today");

        verify(socialNetwork).publish("Alice", "I love the weather today");
    }

    @Test
    public void publish_message_to_bob_time_line() {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine(socialNetwork);

        commandLine.execute("Bob -> Damn! We lost!");

        verify(socialNetwork).publish("Bob", "Damn! We lost!");
    }

    @Test
    public void publish_another_message_to_bob_time_line() {
        SocialNetworkCommandLine commandLine = new SocialNetworkCommandLine(socialNetwork);

        commandLine.execute("Bob -> Good game though.");

        verify(socialNetwork).publish("Bob", "Good game though.");
    }

}
