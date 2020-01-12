package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.utility.Constants;

public class HudTwo {
    private FitViewport viewPort;
    Stage stage;
    Table scoreBoardTable;


    private boolean upPressed;
    public HudTwo(SpriteBatch spriteBatch){
        viewPort = new FitViewport(Constants.WIDTH,550, new OrthographicCamera());
        stage = new Stage(viewPort,spriteBatch);
        scoreBoardTable = new Table();
        scoreBoardTable.left().bottom();
        scoreBoardTable.setFillParent(true);
        Gdx.input.setInputProcessor(stage);

        Image upImage = new Image(new Texture("upButton.png"));
        upImage.setSize(100, 100);
        upImage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                System.out.println("Uppressed " + upPressed);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });

        scoreBoardTable.add(upImage);
        scoreBoardTable.setDebug(true);
        stage.addActor(scoreBoardTable);
    }







}
