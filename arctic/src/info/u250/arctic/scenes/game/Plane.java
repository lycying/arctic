package info.u250.arctic.scenes.game;

import info.u250.arctic.RandomHelper;
import info.u250.arctic.Values;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.graphic.AnimationSprite;
import info.u250.c2d.graphic.AdvanceSpriteImage;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Plane extends Group {
	final AdvanceSpriteImage _plane ;
	
	public static Plane lastPlane = null;
	private float speedx_ajust = 0;
	private boolean sound = false;
	private static Array<Plane> list = new Array<Plane>();
	private static Pool<Plane> pool = new Pool<Plane>() {
		@Override
		protected Plane newObject() {
			return new Plane();
		}
		public Plane obtain() {
			Plane plane = super.obtain();
			plane.reset();
			list.add(plane);
			lastPlane = plane;
			return plane;
		};
	};
	public static void $free(Plane object){
		pool.free(object);
		list.removeValue(object, false);
		object.remove();		try{
		Engine.getSoundManager().stopSound("SoundPlane");}catch(Exception ex){}
	}
	public  static Array<Plane> $list(){
		return list;
	}
	public  static Plane $(){
		return pool.obtain();
	}
	
	public void reset(){
		this.sound = false;
		this.setRotation(0);
		this.speedx_ajust = Values.Speed + (0.5f+0.5f*RandomHelper.random.nextFloat())*Values.Plane_Speed ;
	}
	private Plane(){
		final TextureAtlas atlas = Engine.resource("RES");
		this._plane = new AdvanceSpriteImage(new AnimationSprite(0.05f,new TextureRegion[]{
				atlas.findRegion("plane0001"),
				atlas.findRegion("plane0002"),
		}));
		this.addActor(_plane);
		this.setSize(this._plane.getWidth(), this._plane.getHeight());
		this.setOrigin(this.getWidth()/2, 0);
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		this.setX(this.getX()+(speedx_ajust )*delta);
	}
	public void playSound(){
		if(!sound){
			Engine.getSoundManager().playSound("SoundPlane");
			sound = true;
		}
	}
}
