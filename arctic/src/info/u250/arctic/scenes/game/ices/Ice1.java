package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice1 extends AbstractIce {
	
	public Ice1(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice1"));
		this.polygon = new Polygon(new float[]{
				10,14,
				29,27,
				46,50,
				87,56,
				188,13
		});
	}
}
