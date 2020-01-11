package com.mygdx.game.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.utility.Constants;

public abstract class Flight {

    private Vector3 position;
    private Vector3 velocity;
    private Texture flightTexture;

    public Flight(int x, int y, String textureImage){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        flightTexture = new Texture(textureImage);
    }

    public void update(int speed){
        position.add(speed, 0 , 0);
    }

    public void accelerator(float dt){
        velocity.add(Constants.STANDARD_SPEED, 0, 0);
        velocity.scl(dt);
        position.add(velocity.x, 0 , 0);
        velocity.scl(1/dt);
        System.out.println(velocity.x);
    }


    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }


    public Texture getFlightTexture() {
        return flightTexture;
    }

}
