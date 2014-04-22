package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice2 extends AbstractIce {
	
	public Ice2(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice2"));
		this.polygon = new Polygon(new float[]{
				10,11,
				23,50,
				71,69,
				114,196,
				184,204,
				241,19,
				214,2,
				152,7,
				131,0,
				29,6,
				
		});
	}
}
