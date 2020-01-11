package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.inputhandler.KeyDown;
import com.mygdx.game.players.AttackerFlight;
import com.mygdx.game.players.HeroFlight;
import com.mygdx.game.utility.Constants;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicLandManager  {
    private SpriteBatch batch;
    private Texture backgroundImage;
    private HeroFlight heroFlight;
    private List<AttackerFlight> attackerFlights;
    private KeyDown keyDown;
    private OrthographicCamera gameCam;
    private Viewport viewport;
    public void create () {
        gameCam = new OrthographicCamera();
        viewport = new FillViewport(Constants.WIDTH, Constants.HEIGHT, gameCam);
        batch = new SpriteBatch();
        backgroundImage = new Texture("background.png");
        heroFlight = new HeroFlight(50, 400, "flight.png");
        attackerFlights = new ArrayList<>();
        keyDown = new KeyDown(heroFlight, 5 , 5, "downKey.png");
        createAttackerFlights();
    }

    public void render () {
        Gdx.gl.glClearColor(0, 6, 9, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();  //Open batch
        batch.draw(backgroundImage, 0, 0, Constants.WIDTH, Constants.HEIGHT); //put Image(s)
        batch.draw(heroFlight.getFlightTexture(), heroFlight.getPosition().x, heroFlight.getPosition().y);
      //  batch.draw(attackerFlight.getFlightTexture(),  attackerFlight.getPosition().x, attackerFlight.getPosition().y);
        for(int i = 0; i < attackerFlights.size(); i++){
            batch.draw(attackerFlights.get(i).getFlightTexture(),  attackerFlights.get(i).getPosition().x, attackerFlights.get(i).getPosition().y);
        }
        batch.draw(keyDown.getKeyTexture(), keyDown.getPosition().x, keyDown.getPosition().y);
        batch.end(); //Close batch
        //update(Gdx.graphics.getDeltaTime());
        update(Constants.STANDARD_SPEED);
    }

    public void update(int dt){
        heroFlight.update(0);
    //    attackerFlight.update(dt);
        for(int i = 0; i < attackerFlights.size(); i++){
            attackerFlights.get(i).update(dt);
            destroyItems(attackerFlights.get(i));
        }
        keyDown.update(dt, -1);
    }
    public void dispose () {
        batch.dispose();
        backgroundImage.dispose();
    }

    public void createAttackerFlights(){
        System.out.println("Flight getting created");
        Timer.Task task = new Timer.Task(){
            @Override
            public void run() {
                AttackerFlight attackerFlight = new AttackerFlight(Constants.WIDTH,  randomNumberGenerator(), "enemyFlight.png");
                attackerFlights.add(attackerFlight);
            }
        };
        Timer.schedule(task, 5, 5);
    }

    private int randomNumberGenerator(){
        Random random = new Random();
        return random.nextInt(Constants.HEIGHT-100);
    }

    private void destroyItems(AttackerFlight attackerFlight){
        if(attackerFlight.getPosition().x < 10){
            attackerFlight.getFlightTexture().dispose();
            attackerFlights.remove(attackerFlight);
        }
        System.out.println(attackerFlights.size());
    }

}
