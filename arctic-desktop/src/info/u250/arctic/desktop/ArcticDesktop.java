package info.u250.arctic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import info.u250.arctic.Arctic;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.graphic.AdControl;

public class ArcticDesktop {
	public static void main(String[] args) {
		Arctic arctic = new Arctic(new AdControl() {
			
			@Override
			public void show() {
				
			}
			
			@Override
			public void hide() {
				
			}
		});
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config .width = (int)Engine.getWidth();
		config.height = (int)Engine.getHeight();
		config.useGL20 = Engine.useGL20();
		new LwjglApplication(arctic, config);
	}

}
