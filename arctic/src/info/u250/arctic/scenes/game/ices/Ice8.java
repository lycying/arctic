package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice8 extends AbstractIce {
	
	public Ice8(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice8"));
		this.polygon = new Polygon(new float[]{
				9,20,
				46,124,
				62,130,
				77,123,
				109,167,
				175,135,
				204,13,
				103,0,
				72,12,
				41,7,
				
				
		});
	}
}
