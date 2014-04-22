package info.u250.arctic.scenes.game;

import info.u250.c2d.engine.Engine;
import info.u250.c2d.graphic.AnimationSprite;
import info.u250.c2d.graphic.AdvanceSpriteImage;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Water extends Group {
	final AdvanceSpriteImage _water ;
	
	
	private static Array<Water> list = new Array<Water>();
	private static Pool<Water> pool = new Pool<Water>() {
		@Override
		protected Water newObject() {
			return new Water();
		}
		public Water obtain() {
			Water water = super.obtain();
			water.reset();
			list.add(water);
			return water;
		};
	};
	public static void $free(Water object){
		pool.free(object);
		list.removeValue(object, false);
		object.remove();
	}
	public  static Array<Water> $list(){
		return list;
	}
	public  static Water $(){
		return pool.obtain();
	}
	public void reset(){
		this.clearActions();
		this.setScale(0.2f);
	}
	private Water(){
		final TextureAtlas atlas = Engine.resource("RES");
		this._water = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("up0001"),
				atlas.findRegion("up0002"),
		}));
		this.addActor(_water);
		this.setSize(this._water.getWidth(), this._water.getHeight());
		this.setOrigin(this.getWidth()/2, this.getHeight()/2);
	}
}
