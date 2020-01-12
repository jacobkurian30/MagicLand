package com.mygdx.game.inputhandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MagicLand;
import com.mygdx.game.players.Flight;

public class InputHandler {
    private Viewport viewport;
    public Stage stage;
    boolean upPressed, downPressed;
    OrthographicCamera orthographicCamera;
    private Flight flight;
    private Vector3 position;
    private Texture keyTexture;


    public InputHandler(MagicLand magicLand, Flight flight, float xAxis, float yAxis, String texture){
        this.flight = flight;
        position = new Vector3(xAxis, yAxis,0);
        keyTexture = new Texture(texture);
        orthographicCamera = new OrthographicCamera();
        viewport = new FitViewport(800, 480, orthographicCamera);
        stage = new Stage(viewport, magicLand.spriteBatch);

        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.left().bottom();
        table.setFillParent(true);

        final Image upImage = new Image(new Texture("upButton.png"));
        upImage.setSize(100, 100);
        upImage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                System.out.println("Uppressed " + upPressed);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });


        final Image downBtnImage = new Image(new Texture("downButton.png"));
        downBtnImage.setSize(100, 100);
        downBtnImage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                System.out.println("Uppressed " + upPressed);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        });
        table.add(upImage);
        table.add(downBtnImage);
        table.setDebug(true);

        stage.addActor(table);
    }

    public void draw(){
        stage.draw();
    }
    public void  resize(int width, int height){
        viewport.update(width,height);
    }


    public void verticalMovement(float dt, float speed){
      //  this.flight.getVelocity().add(0, speed/20, 0);
        this.flight.getPosition().add(0, speed , 0);
      //  System.out.println(this.flight.getVelocity().y);
    }


    public void update(float delta, int speed){
        if(upPressed){
            System.out.println("Up" + upPressed);
            verticalMovement(delta, speed);
        } else {
            this.flight.getVelocity().set(0,0,0);
        }
        if(downPressed){
            System.out.println("down " + downPressed);
            verticalMovement(delta, -speed);
        }
    }




}
