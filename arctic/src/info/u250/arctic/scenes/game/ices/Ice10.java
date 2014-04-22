package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice10 extends AbstractIce {
	
	public Ice10(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice10"));
		this.polygon = new Polygon(new float[]{
				
				7,11,
				23,35,
				86,56,
				124,61,
				143,9,
				114,0,
				79,0,
				23,5
		});
	}
}
