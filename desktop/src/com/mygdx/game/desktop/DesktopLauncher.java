package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MagicLand;
import com.mygdx.game.manager.MagicLandManager;
import com.mygdx.game.utility.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	/*	config.height = Constants.HEIGHT;
		config.width = Constants.WIDTH;
		config.title = Constants.TITLE; */
		new LwjglApplication(new MagicLand(), config);
	}
}
