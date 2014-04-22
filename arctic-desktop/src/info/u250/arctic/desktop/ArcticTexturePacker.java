package info.u250.arctic.desktop;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class ArcticTexturePacker {

	
	public static void main(String[] args) {
		TexturePacker2.Settings settings= new TexturePacker2.Settings();
		TexturePacker2.process(settings, 
				"raw", 
				"../arctic-android/assets","arctic");
	}

}
