package com.mygdx.game.players;

public class AttackerFlight extends Flight {
    public AttackerFlight(int x, int y, String textureImage) {
        super(x, y, textureImage);
    }

    @Override
    public void update(int speed) {
        super.update(-speed);
    }
}
