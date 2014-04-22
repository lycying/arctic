package info.u250.arctic.scenes.game;

import info.u250.arctic.Values;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.graphic.AnimationSprite;
import info.u250.c2d.graphic.AdvanceSpriteImage;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Box extends Group {
	final AdvanceSpriteImage _box ;
	
	public static Box lastBox = null;
	
	private static Array<Box> list = new Array<Box>();
	private static Pool<Box> pool = new Pool<Box>() {
		@Override
		protected Box newObject() {
			return new Box();
		}
		public Box obtain() {
			Box bird = super.obtain();
			list.add(bird);
			lastBox = bird;
			return bird;
		};
	};
	
	public static void $free(Box object){
		pool.free(object);
		list.removeValue(object, false);
		object.remove();
	}
	public  static Array<Box> $list(){
		return list;
	}
	public  static Box $(){
		return pool.obtain();
	}
	
	private Box(){
		final TextureAtlas atlas = Engine.resource("RES");
		this._box = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("box0001"),
				atlas.findRegion("box0002"),
				atlas.findRegion("box0003"),
				atlas.findRegion("box0004"),
				atlas.findRegion("box0005"),
				atlas.findRegion("box0006"),
				atlas.findRegion("box0007"),
				atlas.findRegion("box0008"),
				atlas.findRegion("box0009"),
				atlas.findRegion("box0010"),
				atlas.findRegion("box0011"),
				atlas.findRegion("box0012"),
				atlas.findRegion("box0013"),
				atlas.findRegion("box0014"),
				atlas.findRegion("box0015"),
				atlas.findRegion("box0016"),
				atlas.findRegion("box0017"),
				atlas.findRegion("box0018"),
				atlas.findRegion("box0019"),
				atlas.findRegion("box0020"),
				atlas.findRegion("box0021"),
				atlas.findRegion("box0022"),
				atlas.findRegion("box0023"),
				atlas.findRegion("box0024"),
				atlas.findRegion("box0025"),
				atlas.findRegion("box0026"),
				atlas.findRegion("box0027"),
				atlas.findRegion("box0028"),
				atlas.findRegion("box0029"),
				atlas.findRegion("box0030"),
				atlas.findRegion("box0031"),
				atlas.findRegion("box0032"),
				atlas.findRegion("box0033"),
				atlas.findRegion("box0034"),
				atlas.findRegion("box0035"),
				atlas.findRegion("box0036"),
				atlas.findRegion("box0037"),
				atlas.findRegion("box0038"),
				atlas.findRegion("box0039"),
				atlas.findRegion("box0040"),
				atlas.findRegion("box0041"),
				atlas.findRegion("box0042"),
		}));
		this.addActor(_box);
		this.setSize(this._box.getWidth(), this._box.getHeight());
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		this.setX(this.getX()+Values.Speed *delta);
	}
}
