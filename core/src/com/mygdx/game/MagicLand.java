package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.manager.MagicLandManager;

public class MagicLand extends Game {
	MagicLandManager magicLandManager;
	public SpriteBatch spriteBatch;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		setScreen(new MagicLandManager(this));
	}

	@Override
	public void render () {
		super.render();
	}


	@Override
	public void dispose () {
	//	magicLandManager.dispose();
	}
}
