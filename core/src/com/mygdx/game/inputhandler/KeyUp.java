package com.mygdx.game.inputhandler;

import com.mygdx.game.MagicLand;
import com.mygdx.game.players.Flight;

public class KeyUp extends InputHandler{

    public KeyUp(MagicLand magicLand, Flight flight, float xAxis, float yAxis, String texture) {
        super(magicLand, flight, xAxis, yAxis, texture);
    }
}
