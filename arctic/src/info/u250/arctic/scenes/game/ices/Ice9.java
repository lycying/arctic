package info.u250.arctic.scenes.game.ices;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;

public class Ice9 extends AbstractIce {
	
	public Ice9(){
		super(Engine.resource("RES",TextureAtlas.class).findRegion("ice9"));
		this.polygon = new Polygon(new float[]{
				
				7,15,
				21,125,
				74,163,
				158,143,
				162,101,
				209,21,
				166,0,
				91,10,
				30,4
		});
	}
}
