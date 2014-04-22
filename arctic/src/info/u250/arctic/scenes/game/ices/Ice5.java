package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice5 extends AbstractIce {
	
	public Ice5(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice5"));
		this.polygon = new Polygon(new float[]{
				13,22,
				37,77,
				48,143,
				65,237,
				152,256,
				176,132,
				304,12,
				155,1,
				69,0
		});
	}
}
