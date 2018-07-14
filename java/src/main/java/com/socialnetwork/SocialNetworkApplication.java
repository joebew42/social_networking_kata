package com.socialnetwork;

import java.util.List;

public class SocialNetworkApplication implements ReadUserWallEvents {
    private final InputAdapter inputAdapter;
    private final OutputAdapter outputAdapter;

    public SocialNetworkApplication(InputAdapter inputAdapter, OutputAdapter outputAdapter) {
        this.inputAdapter = inputAdapter;
        this.outputAdapter = outputAdapter;
    }

    public void start() {
        Wall wall = new Wall();

        String message;
        while ((message = inputAdapter.read()) != null) {
            if ("Alice -> I love the weather today".equals(message)) {
                UseCase useCase = new PostMessageAs("Alice", "I love the weather today", wall);
                useCase.run();
            }

            if ("Alice".equals(message)) {
                UseCase useCase = new ReadUserWall("Alice", wall, this);
                useCase.run();
            }
        }
    }


    public void onReadUserWall(List<WallMessage> messages) {
        for (WallMessage message : messages) {
            outputAdapter.write(formatMessage(message));
        }
    }

    private String formatMessage(WallMessage message) {
        return message.text() + " (5 minutes ago)";
    }
}
