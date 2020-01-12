package com.mygdx.game.manager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.utility.Constants;

public class HudManager {
    private FitViewport viewPort;
    Stage stage;
    Table scoreBoardTable;

    private Label scoreTag;
    private Label scoreLabel;
    public Integer score = 0;

    private Label healthTag;
    private Label healthLabel;
    private Integer healthPercentage;

    private Label timeTag;
    private Label timeLabel;
    private Label time;

    public HudManager(SpriteBatch spriteBatch){
        viewPort = new FitViewport(Constants.WIDTH,550, new OrthographicCamera());
        score = 0;
        stage = new Stage(viewPort,spriteBatch);
        scoreBoardTable = new Table();
        scoreBoardTable.top();
        scoreBoardTable.setFillParent(true);
        scoreTag = new Label(String.format("SCORE"), new Label.LabelStyle(new BitmapFont(), Color.BROWN));
        healthLabel =  new Label(String.format("%03d", healthPercentage), new Label.LabelStyle(new BitmapFont(), Color.BROWN));
        scoreBoardTable.add(scoreTag).expandX().padTop(10);
        scoreBoardTable.row();
        scoreLabel =  new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.BROWN));
        scoreBoardTable.add(scoreLabel).expandX().padTop(10);

        scoreBoardTable.setDebug(true);
        stage.addActor(scoreBoardTable);
    }







}
