package com.mygdx.game.inputhandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.players.Flight;

public class InputHandler {
    private Flight flight;
    private Vector3 position;
    private Texture keyTexture;


    public InputHandler(Flight flight, float xAxis, float yAxis, String texture){
        this.flight = flight;
        position = new Vector3(xAxis, yAxis,0);
        keyTexture = new Texture(texture);
    }

    public void verticalMovement(float dt, float speed){
        this.flight.getVelocity().add(0, speed/20, 0);
        this.flight.getPosition().add(0, this.flight.getVelocity().y , 0);
        System.out.println(this.flight.getVelocity().y);
    }

    public Texture getKeyTexture() {
        return keyTexture;
    }
    public Vector3 getPosition() {
        return position;
    }

    public void update(float delta, int speed){
        if(Gdx.input.isTouched()){
            verticalMovement(delta, speed);
        } else {
            this.flight.getVelocity().set(0,0,0);
        }
    }


}
