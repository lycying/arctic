package info.u250.arctic.scenes.game;

import info.u250.arctic.Arctic;
import info.u250.arctic.RandomHelper;
import info.u250.arctic.Values;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.graphic.AnimationSprite;
import info.u250.c2d.graphic.AdvanceSpriteImage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Together extends Group {
	Rectangle tmp = new Rectangle();
	public Rectangle getWorldRect(){
		if(type==TogetherType.Normal){
			tmp.x = this.getX() + this._explorer_normal.getX() ;
			tmp.y = this.getY() + this._explorer_normal.getY() ;
			tmp.width = this._explorer_normal.getWidth();
			tmp.height = this._explorer_normal.getHeight();
		}else{
			tmp.x = this.getX() + this._explorer_top.getX() ;
			tmp.y = this.getY() + this._explorer_top.getY() ;
			tmp.width = this._explorer_top.getWidth();
			tmp.height = this._explorer_top.getHeight();
		}
		return tmp;
	}
	
	
	public boolean isDie() {
		return die;
	}
	public void setDie(boolean die) {
		this.die = die;
	}


	final AdvanceSpriteImage _whale ;
	final AdvanceSpriteImage _explorer_normal ;
	final AdvanceSpriteImage _explorer_top ;
	final AdvanceSpriteImage _water ;
	
	boolean die = false;
	final static float Water_Level =  120;
	final static float Y = 30;
	TogetherType type;
	final ParticleEmitter pSmoke ;
	final ParticleEmitter pFire ;
	final ParticleEmitter pExplose ;
	public Together(){
		final TextureAtlas atlas = Engine.resource("RES");
		
		this._whale = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("whale0001"),
				atlas.findRegion("whale0002"),
				atlas.findRegion("whale0003"),
				atlas.findRegion("whale0004"),
				atlas.findRegion("whale0005"),
				atlas.findRegion("whale0006"),
				atlas.findRegion("whale0007"),
				atlas.findRegion("whale0008"),
				atlas.findRegion("whale0009"),
				atlas.findRegion("whale0010"),
				atlas.findRegion("whale0011"),
				atlas.findRegion("whale0012"),
				atlas.findRegion("whale0013"),
				atlas.findRegion("whale0014"),
				atlas.findRegion("whale0015"),
				atlas.findRegion("whale0016"),
				atlas.findRegion("whale0017"),
				atlas.findRegion("whale0018"),
				atlas.findRegion("whale0019"),
				atlas.findRegion("whale0020"),
				atlas.findRegion("whale0021"),
				atlas.findRegion("whale0022"),
				atlas.findRegion("whale0023"),
				atlas.findRegion("whale0024"),
				atlas.findRegion("whale0025"),
				atlas.findRegion("whale0026"),
				atlas.findRegion("whale0027"),
				atlas.findRegion("whale0028"),
				atlas.findRegion("whale0029"),
				atlas.findRegion("whale0030"),
				atlas.findRegion("whale0031"),
				atlas.findRegion("whale0032"),
				atlas.findRegion("whale0033"),
				atlas.findRegion("whale0034"),
				atlas.findRegion("whale0035"),
				atlas.findRegion("whale0036"),
				atlas.findRegion("whale0037"),
				atlas.findRegion("whale0038"),
				atlas.findRegion("whale0039"),
				atlas.findRegion("whale0040"),
		}));
		
		this._explorer_normal = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("explorer-normal0001"),
				atlas.findRegion("explorer-normal0002"),
				atlas.findRegion("explorer-normal0003"),
				atlas.findRegion("explorer-normal0004"),
				atlas.findRegion("explorer-normal0005"),
		}));
		this._explorer_top = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("explorer-top0001"),
				atlas.findRegion("explorer-top0002"),
				atlas.findRegion("explorer-top0003"),
				atlas.findRegion("explorer-top0004"),
				atlas.findRegion("explorer-top0005"),
				atlas.findRegion("explorer-top0006"),
				atlas.findRegion("explorer-top0007"),
				atlas.findRegion("explorer-top0008"),
				atlas.findRegion("explorer-top0009"),
				atlas.findRegion("explorer-top0010"),
				atlas.findRegion("explorer-top0011"),
				atlas.findRegion("explorer-top0012"),
				atlas.findRegion("explorer-top0013"),
				atlas.findRegion("explorer-top0014"),
				atlas.findRegion("explorer-top0015"),
				atlas.findRegion("explorer-top0016"),
				atlas.findRegion("explorer-top0017"),
				atlas.findRegion("explorer-top0018"),
				atlas.findRegion("explorer-top0019"),
				atlas.findRegion("explorer-top0020"),
				atlas.findRegion("explorer-top0021"),
				atlas.findRegion("explorer-top0022"),
				atlas.findRegion("explorer-top0023"),
		}));
		
		this._water = new AdvanceSpriteImage(new AnimationSprite(0.05f, new TextureRegion[]{
				atlas.findRegion("water0001"),
				atlas.findRegion("water0002"),
				atlas.findRegion("water0003"),
		}));
		
		this.setSize(this._whale.getWidth(), this._whale.getHeight());
		this.setPosition(Engine.getWidth() - this.getWidth() - 120, Y);
		
		this.normal();
		
		
		final ParticleEffect effect = new ParticleEffect();
		effect.load(Gdx.files.internal("data/e.p"), Gdx.files.internal("data/"));
		pSmoke = effect.findEmitter("smoke");
		pFire  = effect.findEmitter("fire");
		pExplose = effect.findEmitter("explose");
	}
	private void normal(){
		type = TogetherType.Normal;
		this.clear();
		this._explorer_normal.setPosition(15, Water_Level-Y);
		
		this.addActor(_explorer_normal);
		this.addActor(_water);
		this.addActor(_whale);
		
		
	}
	public void reset(){
		((AnimationSprite)this._explorer_top.getSprite()).replay();
		((AnimationSprite)this._explorer_normal.getSprite()).replay();
		this._explorer_normal.setPosition(15, Water_Level-Y);
		this._explorer_top.setPosition(15, Water_Level-Y);
		this.normal();
		this._explorer_top.getColor().a = 1;
		this._explorer_normal.getColor().a  = 1;
	}
	float gravityValue = 0;
	float t;
	float v = 0;
	float a = 15;
	void test(){
		Engine.getSoundManager().playSound("SoundUp2");
		this.gravityValue = 0;
//		this.a = -30 * (400-this._explorer_top.y )/400;;
//		this.v = 400* (450-this._explorer_top.y )/450;
		if(this._explorer_top.getY() > 400){
			this.v = 0;
		}else if(this._explorer_top.getY() > 350){
			this.v = 100+400*RandomHelper.random.nextFloat();
		}else if(this._explorer_top.getY()> 300){
			this.v = 200;
		}else if(this._explorer_top.getY() > 200){
			this.v = 300;
		}else if(this._explorer_top.getY() > 100){
			this.v = 250;
		}else{
			this.v = 150;
		}
	}
	public void shit(){
		if(type == TogetherType.Normal){
			type = TogetherType.Shit;
			this.clear();
			this._explorer_top.setPosition(15, Water_Level-Y);
			this.addActor(_explorer_top);
			this.addActor(_water);
			this.addActor(_whale);
		}
		HpBar.getInstance().setCurrentValue(HpBar.getInstance().getCurrentValue()-1);
		Engine.getSoundManager().playSound("SoundUp1");
		
		
		final Water w = Water.$();
		w.setPosition((this._water.getWidth()-w.getWidth())/2, 60);
		w.addAction(Actions.sequence(
				Actions.parallel(Actions.moveBy(0, this._water.getY() - w.getY() , 0.3f),Actions.scaleTo(1f, 2, 0.3f)),
				Actions.run(new Runnable() {
					@Override
					public void run() {
						Water.$free(w);
					}
				})));
		test();
		this.addActor(w);
		this.t = 0;
	}
	
	boolean iceDie = false;
	public void dieOnPlane(){
		iceDie = false;
		this.setDie( true );
		this._water.remove();
		((AnimationSprite)this._explorer_normal.getSprite()).stop();
		((AnimationSprite)this._explorer_top.getSprite()).stop();
		Engine.getSoundManager().playSound("SoundDie");
		Engine.getMusicManager().stopMusic("MusicExplorer");
		Gdx.input.setInputProcessor(null);
		Actor actor = null;
		if(type==TogetherType.Normal){
			actor = this._explorer_normal;
		}else{
			actor = this._explorer_top;
		}
		actor.remove();
		this.addAction(Actions.delay(3, Actions.run(new Runnable() {
			@Override
			public void run() {
				Engine.getEventManager().fire(Arctic.Event_SceneScore);
			}
		})));
		pExplose.start();
	}
	public void dieOnIce(){
		iceDie = true;
		this.setDie( true );
		this._water.remove();
		((AnimationSprite)this._explorer_normal.getSprite()).stop();
		((AnimationSprite)this._explorer_top.getSprite()).stop();
		Engine.getSoundManager().playSound("SoundDie");
		Engine.getMusicManager().stopMusic("MusicExplorer");
		Gdx.input.setInputProcessor(null);
		Actor actor = null;
		if(type==TogetherType.Normal){
			actor = this._explorer_normal;
		}else{
			actor = this._explorer_top;
		}
		actor.addAction(Actions.sequence(Actions.moveBy(Values.Speed*3,0,3f),Actions.run(new Runnable() {
			
			@Override
			public void run() {
				Engine.getEventManager().fire(Arctic.Event_SceneScore);
				
			}
		})));
	}
	@Override
	public void act(float delta) {
		if(!die){
			for(Water w:Water.$list()){
				if(w.getY() + w.getHeight() >  _water.getY()){
					w.clearActions();
					Water.$free(w);
				}
			}
			
			if(type == TogetherType.Normal){
				_water.setScale(0.7f);
				this._water.setY( this._explorer_normal.getY() - this._water.getHeight()/3*2 );
			}else{
				if(this.v>0){
					t+=delta;
					this.v = this.v - a*t;
					this._explorer_top.setY(this._explorer_top.getY()+this.v * delta );
				}
				
				
				gravityValue+=delta;
				this._explorer_top.setY( this._explorer_top.getY() - gravityValue * a );
				
				if(this._explorer_top.getY() <  Water_Level - Y){
					Engine.getSoundManager().playSound("SoundDown");
					_water.addAction(Actions.scaleTo(1.3f, 1f, 0.2f));
					gravityValue = 0;
					this.normal();
				}
				
				_water.setScale(1);
				this._water.setY(this._explorer_top.getY()-this._water.getHeight()/3*2);
			}
		}
		super.act(delta);
	}
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		getWorldRect();
		if(die){
			if(iceDie){
				pFire.setPosition(tmp.x+tmp.width/3*2, tmp.y+tmp.height/2);
				pFire.draw(batch, Engine.getDeltaTime());
			}else{
				pExplose.setPosition(tmp.x, tmp.y);
				pExplose.draw(batch, Engine.getDeltaTime());
			}
		}else{
			pSmoke.setPosition(tmp.x+tmp.width/3*2, tmp.y+tmp.height);
			pSmoke.draw(batch, Engine.getDeltaTime());
		}
		super.draw(batch, parentAlpha);
	}
	enum TogetherType{
		Normal,
		Shit,
	}
}
