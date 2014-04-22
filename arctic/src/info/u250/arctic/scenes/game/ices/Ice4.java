package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice4 extends AbstractIce {
	
	public Ice4(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice4"));
		this.polygon = new Polygon(new float[]{
				13,19,
				72,60,
				84,108,
				122,134,
				172,243,
				245,15,
				207,0,
				66,2
		});
	}
}
