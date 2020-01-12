package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.MagicLand;
import com.mygdx.game.inputhandler.InputHandler;
import com.mygdx.game.inputhandler.KeyDown;
import com.mygdx.game.players.AttackerFlight;
import com.mygdx.game.players.HeroFlight;
import com.mygdx.game.utility.Constants;
import com.sun.prism.image.ViewPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicLandManager implements Screen {
    private Texture backgroundImage;
    private HeroFlight heroFlight;
    private List<AttackerFlight> attackerFlights;
    private InputHandler inputHandler;
    private MagicLand magicLand;
    private HudManager hudManager;
   // private HudTwo hudTwo;
    private OrthographicCamera gameCam;
    private Viewport viewPort;

    public MagicLandManager(MagicLand magicLand) {
        this.magicLand = magicLand;
        hudManager = new HudManager(magicLand.spriteBatch);
 //       hudTwo = new HudTwo(magicLand.spriteBatch);
        gameCam = new OrthographicCamera();
        viewPort = new FitViewport(Constants.WIDTH, Constants.HEIGHT, gameCam);
        create();
    }

    public void create() {
        backgroundImage = new Texture("background.png");
        heroFlight = new HeroFlight(0, Constants.HEIGHT/2, "flight.png");
        attackerFlights = new ArrayList<>();
      //  keyDown = new KeyDown(magicLand, heroFlight, 5, 5, "downKey.png");
        inputHandler = new InputHandler(magicLand,heroFlight, 5, 5, "downKey.png");
        createAttackerFlights();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 6, 9, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        magicLand.spriteBatch.setProjectionMatrix(hudManager.stage.getCamera().combined);
        magicLand.spriteBatch.begin();  //Open batch
        magicLand.spriteBatch.draw(backgroundImage, 0, 0, Constants.WIDTH, Constants.HEIGHT); //put Image(s)
        magicLand.spriteBatch.draw(heroFlight.getFlightTexture(), heroFlight.getPosition().x, heroFlight.getPosition().y);
        for (int i = 0; i < attackerFlights.size(); i++) {
            magicLand.spriteBatch.draw(attackerFlights.get(i).getFlightTexture(), attackerFlights.get(i).getPosition().x, attackerFlights.get(i).getPosition().y);
        }
     //   magicLand.spriteBatch.draw(keyDown.getKeyTexture(), keyDown.getPosition().x, keyDown.getPosition().y);

        magicLand.spriteBatch.end(); //Close batch
        inputHandler.draw();
        inputHandler.update(delta, Constants.STANDARD_SPEED);
        hudManager.stage.draw();

        update(Constants.STANDARD_SPEED);
    }

    public void update(int dt) {
        heroFlight.update(0);
        for (int i = 0; i < attackerFlights.size(); i++) {
            attackerFlights.get(i).update(dt);
            destroyItems(attackerFlights.get(i));
        }
//        keyDown.update(dt, -1);
    }

    @Override
    public void show() {

    }


    @Override
    public void resize(int width, int height) {
        viewPort.update(width, height);
        inputHandler.resize(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void dispose() {
        magicLand.spriteBatch.dispose();
        backgroundImage.dispose();
    }

    public void createAttackerFlights() {
        System.out.println("Flight getting created");
        Timer.Task task = new Timer.Task() {
            @Override
            public void run() {
                AttackerFlight attackerFlight = new AttackerFlight(Constants.WIDTH, randomNumberGenerator(), "enemyFlight.png");
                attackerFlights.add(attackerFlight);
            }
        };
        Timer.schedule(task, 5, 5);
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(Constants.HEIGHT - 100);
    }

    private void destroyItems(AttackerFlight attackerFlight) {
        if (attackerFlight.getPosition().x < 10) {
            attackerFlight.getFlightTexture().dispose();
            attackerFlights.remove(attackerFlight);
        }
    }

}
