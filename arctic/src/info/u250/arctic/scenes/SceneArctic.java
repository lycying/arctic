package info.u250.arctic.scenes;

import info.u250.arctic.Arctic;
import info.u250.arctic.RandomHelper;
import info.u250.arctic.Values;
import info.u250.arctic.scenes.game.Box;
import info.u250.arctic.scenes.game.HpBar;
import info.u250.arctic.scenes.game.Ice;
import info.u250.arctic.scenes.game.Plane;
import info.u250.arctic.scenes.game.Points;
import info.u250.arctic.scenes.game.Together;
import info.u250.arctic.scenes.game.Umbrella;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.engine.Scene;
import info.u250.c2d.graphic.AdvanceSprite;
import info.u250.c2d.graphic.C2dStage;
import info.u250.c2d.graphic.parallax.ParallaxGroup;
import info.u250.c2d.graphic.parallax.ParallaxLayer;

import java.util.Iterator;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class SceneArctic extends C2dStage implements Scene {
	final ParallaxGroup _pbg ;
	final Together _together;
	
	
	public void reset(){
		Points.getInstance().reset();
		HpBar.getInstance().reset();
		_together.setDie( false );
		
		Iterator<Actor> itr = this.getActors().iterator();
		while(itr.hasNext()){
			Actor actor = itr.next();
			if(actor instanceof Umbrella){
				Umbrella.$free((Umbrella)(actor));
			}else if(actor instanceof Ice){
				Ice.$free((Ice)(actor));
			}else if(actor instanceof Box){
				Box.$free((Box)(actor));
			}else if(actor instanceof Plane){
				Plane.$free((Plane)(actor));
			}
		}
		
		this.clear();
		
		_together.reset();
		
		Box _box = Box.$();
		_box.setPosition(-100, 110);
		this.addActor(_box);
		
		Ice _ice = Ice.$();
		_ice.setPosition(-200, 100);
		this.addActor(_ice);
		
		
		Umbrella _umbrella = Umbrella.$();
		_umbrella.setPosition(-100, 400);
		this.addActor(_umbrella);
		
		Plane _plane = Plane.$();
		_plane.setPosition(-800, 380);
		this.addActor(_plane);
		this.addActor(_together);
	}
	public SceneArctic(){
		final TextureAtlas atlas = Engine.resource("RES");
		
		_pbg = new ParallaxGroup(this.getWidth(), this.getHeight() , new Vector2());
		_pbg.addActor(new ParallaxLayer(_pbg, new Image(new SpriteDrawable(new AdvanceSprite(atlas.findRegion("bg")))),
				new Vector2(0,0), new Vector2(),new Vector2()));
		_pbg.addActor(new ParallaxLayer(_pbg, new Image(new SpriteDrawable(new AdvanceSprite(atlas.findRegion("movebg")))),
				new Vector2(1,0), new Vector2(0,1000), new Vector2(0,120)));
		
		_pbg.setSpeed(-(Values.Speed-30), 0);
		
		_together = new Together();
		
		
	}
	@Override
	public void update(float delta) {}

	Rectangle tmp  = new Rectangle();
	@Override
	public void render(float delta) {
		if(!_together.isDie()){
			Rectangle tmp1 = _together.getWorldRect();
			
			for(Ice ice:Ice.$list()){
				{//left bottom
					float x = tmp1.x - ice.getX()  ;
					float y = tmp1.y - ice.getY()  ;
					if(ice.getIce().contains(x, y)){
						this.dieOnIce();
					}
				}
				{//right bottom
					float x = tmp1.x + tmp1.width - ice.getX() ;
					float y = tmp1.y -ice.getY() ;
					if(ice.getIce().contains(x, y)){
						this.dieOnIce();
					}
				}
				
			}
			
			
			//box
			for(Box box:Box.$list()){
				if(box.getX() > this.getWidth()){
					Box.$free(box);
				}else{
					tmp.x = box.getX() ;
					tmp.y = box.getY() ;
					tmp.width = box.getWidth();
					tmp.height = box.getHeight();
					if(tmp1.overlaps(tmp)){
						this.addPoints(10);
						Box.$free(box);
					}
				}
			}
	//		if(Box.lastBox.x > 0){
	//			Box box = Box.$();
	//			box.x = -200 - RandomHelper.random.nextFloat() * 400;
	//			box.y = 110;
	//			this.addActor(box);
	//		}
			//ice
			for(Ice box:Ice.$list()){
				if(box.getX() > this.getWidth()){
					Ice.$free(box);
				}
			}
			if(Ice.lastIce.getX() > 0){
				Ice ice = Ice.$();
				ice.setPosition( -350 - RandomHelper.random.nextFloat() * 400 ,100 );
				this.addActor(ice);
				float base = Math.abs(ice.getX())-ice.getWidth();
				if(base >=350){
					if(RandomHelper.random.nextBoolean()){
						{
							Box box = Box.$();
							box.setPosition(-base*RandomHelper.random.nextFloat(), 110);
							this.addActor(box);
						}
					}
					if(RandomHelper.random.nextBoolean()){
						if(RandomHelper.random.nextBoolean()){
							{
								Box box = Box.$();
								box.setPosition(-base*RandomHelper.random.nextFloat(), 110);
								this.addActor(box);
							}
							{
								Box box = Box.$();
								box.setPosition( -base*RandomHelper.random.nextFloat(), 110);
								this.addActor(box);
							}
						}else{
							{
								Box box = Box.$();
								box.setPosition(-base*RandomHelper.random.nextFloat(),110);
								this.addActor(box);
							}
						}
						
					}
					
				}else if(base>200){
					if(RandomHelper.random.nextBoolean()){
						{
							Box box = Box.$();
							box.setPosition( -base*RandomHelper.random.nextFloat(),110);
							
							this.addActor(box);
						}
						{
							Box box = Box.$();
							box.setPosition(-base*RandomHelper.random.nextFloat(),110);
							
							this.addActor(box);
						}
					}
				}else if(base > 100){
					if(RandomHelper.random.nextBoolean()){
						{
							Box box = Box.$();
							box.setPosition(-base*RandomHelper.random.nextFloat(),110);
							
							this.addActor(box);
						}
					}
				}else{
					if(RandomHelper.random.nextBoolean()){
						if(RandomHelper.random.nextBoolean()){
							{
								Box box = Box.$();
								box.setPosition( -base*RandomHelper.random.nextFloat(),110);
								
								this.addActor(box);
							}
						}
					}
				}
				
			}
			//umbrella
			for(Umbrella umbrella:Umbrella.$list()){
				if(umbrella.getX() > this.getWidth()){
					Umbrella.$free(umbrella);
				}else{
					tmp.x = umbrella.getX() ;
					tmp.y = umbrella.getY() ;
					tmp.width = umbrella.getWidth();
					tmp.height = umbrella.getHeight();
					if(tmp1.overlaps(tmp)){
						this.addPoints(20);
						Umbrella.$free(umbrella);
					}
				}
			}
			if(Umbrella.lastUmbrella.getX() > 0){
				Umbrella umbrella = Umbrella.$();
				umbrella.setPosition( -300 - RandomHelper.random.nextFloat() * 800, 450);
				this.addActor(umbrella);
			}	
			//plane
			for(Plane plane:Plane.$list()){
				if(plane.getX() > this.getWidth()){
					Plane.$free(plane);
				}else{
					tmp.x = plane.getX() ;
					tmp.y = plane.getY() ;
					tmp.width = plane.getWidth();
					tmp.height = plane.getHeight();
					
					if(tmp1.x - tmp.x< 100 ){
						plane.playSound();
					}
					if(tmp1.overlaps(tmp)){
						this.dieOnPlane();
						Plane.$free(plane);
					}
				}
			}
			if(Plane.lastPlane.getX() > 0){
				Plane plane = Plane.$();
				plane.setPosition(-800 - RandomHelper.random.nextFloat() * 800 * 3, 200+130*RandomHelper.random.nextFloat());
				this.addActor(plane);
			}	
		}
		_pbg.act(delta);
		Engine.getSpriteBatch().begin();
		_pbg.draw(Engine.getSpriteBatch(), 1);
		Engine.getSpriteBatch().end();
		this.act(delta);
		this.draw();
		
		Engine.getSpriteBatch().begin();
		HpBar.getInstance().act(delta);
		HpBar.getInstance().draw(Engine.getSpriteBatch(), 1);
		Points.getInstance().act(delta);
		Points.getInstance().draw(Engine.getSpriteBatch(), 1);
		Engine.getSpriteBatch().end();
	}

	@Override
	public void show() {
		((Arctic)Engine.get()).ad.show();
		Engine.getMusicManager().playMusic("MusicExplorer", true);
	}

	@Override
	public void hide() {
		Engine.getMusicManager().stopMusic("MusicExplorer");
	}

	@Override
	public InputProcessor getInputProcessor() {return new InputAdapter(){
		@Override
		public boolean touchDown(int x, int y, int pointer, int button) {
			_together.shit();
			return super.touchDown(x, y, pointer, button);
		}
		@Override
		public boolean keyUp(int keycode) {
			if (Gdx.app.getType() == ApplicationType.Android) {
				if (keycode == Keys.BACK) {
					Engine.getEventManager().fire(Arctic.Event_SceneMain);
				}
			} else {
				if (keycode == Keys.DEL){
					Engine.getEventManager().fire(Arctic.Event_SceneMain);
				}
			}
			return super.keyUp(keycode);
		}
	};}

	public void dieOnIce(){
		if(!_together.isDie()){
			_together.dieOnIce();
			//move it to the top
			_together.remove();
			this.addActor(_together);
		}
	}
	public void dieOnPlane(){
		if(!_together.isDie()){
			_together.dieOnPlane();
			//move it to the top
			_together.remove();
			this.addActor(_together);
		}
	}
	public void addPoints(int points){
		HpBar.getInstance().setCurrentValue(HpBar.getInstance().getCurrentValue()+points);
		Engine.getSoundManager().playSound("SoundEat");
		Points.getInstance().setPoints(Points.getInstance().getPoints()+points);
	}
}
