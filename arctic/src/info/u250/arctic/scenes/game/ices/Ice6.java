package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice6 extends AbstractIce {
	
	public Ice6(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice6"));
		this.polygon = new Polygon(new float[]{
				10,13,
				21,26,
				77,37,
				88,84,
				162,94,
				188,11,
				102,0,
				27,6
		});
	}
}
