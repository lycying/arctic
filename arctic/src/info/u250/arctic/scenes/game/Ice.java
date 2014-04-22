package info.u250.arctic.scenes.game;

import info.u250.arctic.RandomHelper;
import info.u250.arctic.Values;
import info.u250.arctic.scenes.game.ices.AbstractIce;
import info.u250.arctic.scenes.game.ices.Ice1;
import info.u250.arctic.scenes.game.ices.Ice10;
import info.u250.arctic.scenes.game.ices.Ice11;
import info.u250.arctic.scenes.game.ices.Ice2;
import info.u250.arctic.scenes.game.ices.Ice3;
import info.u250.arctic.scenes.game.ices.Ice4;
import info.u250.arctic.scenes.game.ices.Ice5;
import info.u250.arctic.scenes.game.ices.Ice6;
import info.u250.arctic.scenes.game.ices.Ice7;
import info.u250.arctic.scenes.game.ices.Ice8;
import info.u250.arctic.scenes.game.ices.Ice9;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Ice extends Group {
	public AbstractIce getIce(){
		return _ice;
	}
	
	AbstractIce _ice ;
	
	public static Ice lastIce = null;
	
	private static Array<Ice> list = new Array<Ice>();
	private static Pool<Ice> pool = new Pool<Ice>() {
		@Override
		protected Ice newObject() {
			return new Ice();
		}
		public Ice obtain() {
			Ice umbrella = super.obtain();
			umbrella.reset();
			list.add(umbrella);
			lastIce = umbrella;
			return umbrella;
		};
	};
	public static void $free(Ice object){
		pool.free(object);
		list.removeValue(object, false);
		object.remove();
	}
	public  static Array<Ice> $list(){
		return list;
	}
	public  static Ice $(){
		return pool.obtain();
	}
	public void reset(){
		this.clear();
		try {
			int i = RandomHelper.random.nextInt(11)+1;
			switch(i){
			case 1:this._ice = new Ice1();break;
			case 2:this._ice = new Ice2();break;
			case 3:this._ice = new Ice3();break;
			case 4:this._ice = new Ice4();break;
			case 5:this._ice = new Ice5();break;
			case 6:this._ice = new Ice6();break;
			case 7:this._ice = new Ice7();break;
			case 8:this._ice = new Ice8();break;
			case 9:this._ice = new Ice9();break;
			case 10:this._ice = new Ice10();break;
			case 11:this._ice = new Ice11();break;
			}
			this.addActor(_ice);
			this.setSize(this._ice.getWidth(), this._ice.getHeight());
			this.setOrigin(this.getWidth()/2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private Ice(){
		this.reset();
	}
	@Override
	public void act(float delta) {
		super.act(delta);
		this.setX(this.getX()+Values.Speed *delta);
	}
}
