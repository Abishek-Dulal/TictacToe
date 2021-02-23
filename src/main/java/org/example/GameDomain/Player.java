package org.example.GameDomain;

public class Player {

    private PlayerState playerState;

    public Player(PlayerState playerState) {
        this.playerState = playerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }
}
