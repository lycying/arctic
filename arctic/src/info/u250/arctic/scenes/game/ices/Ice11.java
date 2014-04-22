package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice11 extends AbstractIce {
	
	public Ice11(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice11"));
		this.polygon = new Polygon(new float[]{
			12,12,
			29,26,
			46,49,
			81,55,
			188,13,
			91,6,
			36,0
		});
	}
}
