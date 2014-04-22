package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice7 extends AbstractIce {
	
	public Ice7(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice7"));
		this.polygon = new Polygon(new float[]{
				8,5,
				40,62,
				63,51,
				130,107,
				192,8,
				114,0,
				51,0
		});
	}
}
