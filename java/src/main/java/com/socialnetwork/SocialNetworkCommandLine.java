package com.socialnetwork;

public class SocialNetworkCommandLine {
    private SocialNetwork socialNetwork;

    public SocialNetworkCommandLine(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public void execute(String command) {
        if (command.startsWith("Alice")) {
            socialNetwork.publish("Alice", "I love the weather today");
        } else {
            if (command.contains("Damn")) {
                socialNetwork.publish("Bob", "Damn! We lost!");
            } else {
                socialNetwork.publish("Bob", "Good game though.");
            }
        }
    }
}
