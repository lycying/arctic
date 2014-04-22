package info.u250.arctic.scenes.game.ices;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class AbstractIce extends Image{
	Polygon polygon ;
	public AbstractIce(TextureRegion region){
		super(region);
	}
	public  Polygon getPolygon(){
		return this.polygon;
	}
	public boolean contains(float x,float y){
		return this.polygon.contains(x, y);
	}
}
