package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.mygdx.game.manager.MagicLandManager;

public class MagicLand extends Game {
	MagicLandManager magicLandManager;

	@Override
	public void create () {
		magicLandManager = new MagicLandManager();
		magicLandManager.create();
	}

	@Override
	public void render () {
		super.render();
	}

	public void update(int speed){
		magicLandManager.update(speed);
	}
	@Override
	public void dispose () {
		magicLandManager.dispose();
	}
}
