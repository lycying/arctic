package info.u250.arctic.scenes.game;

import info.u250.arctic.RandomHelper;
import info.u250.arctic.Values;
import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Umbrella extends Group {
	final Image _umbrella ;
	
	public static Umbrella lastUmbrella = null;
	private float speed = 0;
	private float speedx_ajust = 0;
	
	private static Array<Umbrella> list = new Array<Umbrella>();
	private static Pool<Umbrella> pool = new Pool<Umbrella>() {
		@Override
		protected Umbrella newObject() {
			return new Umbrella();
		}
		public Umbrella obtain() {
			Umbrella umbrella = super.obtain();
			umbrella.reset();
			list.add(umbrella);
			lastUmbrella = umbrella;
			return umbrella;
		};
	};
	public static void $free(Umbrella object){
		pool.free(object);
		list.removeValue(object, false);
		object.remove();
	}
	public  static Array<Umbrella> $list(){
		return list;
	}
	public  static Umbrella $(){
		return pool.obtain();
	}
	public void reset(){
		this.setRotation(-30);
		this.speed = RandomHelper.random.nextFloat()*(Values.Speed+Values.Umbrella_Speed)/4;
		this.speedx_ajust = Values.Speed/2+RandomHelper.random.nextFloat()*( Values.Speed/2+Values.Umbrella_Speed);
	}
	private Umbrella(){
		final TextureAtlas atlas = Engine.resource("RES");
		this._umbrella = new Image(atlas.findRegion("umbrella"));
		this.addActor(_umbrella);
		this.setSize(this._umbrella.getWidth(), this._umbrella.getHeight());
		this.setOrigin(this.getWidth()/2, 0);
		this.setRotation(-30);
		this.addAction(Actions.forever(Actions.sequence(Actions.rotateBy(60,3),Actions.rotateBy(-60,3))));
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		this.setX(this.getX() + (speedx_ajust)*delta);
		if(this.getY() <= 150){
			this.setY(150);
		}else{
			this.setY(this.getY() - speed*delta);
		}
	}
}
