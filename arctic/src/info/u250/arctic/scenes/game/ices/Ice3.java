package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice3 extends AbstractIce {
	
	public Ice3(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice3"));
		this.polygon = new Polygon(new float[]{
				10,18,
				52,70,
				57,105,
				83,125,
				134,94,
				157,16,
				79,0
		});
	}
}
