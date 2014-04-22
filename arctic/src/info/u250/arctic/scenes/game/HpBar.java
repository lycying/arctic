package info.u250.arctic.scenes.game;

import info.u250.arctic.Arctic;
import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class HpBar extends Group {
	private static HpBar instance ;
	public static HpBar getInstance(){
		if(null == instance ){
			instance = new HpBar();
		}
		return instance;
	}
	
	public void reset(){
		this.currentValue = 200;
		final TextureAtlas atlas = Engine.resource("RES");
		this.bg = atlas.findRegion("hp-bar-bg");
	}
	Image barTop ;
	TextureRegion bg ;
	static float fullValue = 200;
	private float currentValue = 200;
	
	public float getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(float currentValue) {
		this.currentValue = currentValue;
		if(this.currentValue>fullValue){
			this.currentValue = fullValue;
		}
		if(this.currentValue <=0 ){
			Engine.getEventManager().fire(Arctic.Event_SceneScore);
		}
	}

	private HpBar(){
		final TextureAtlas atlas = Engine.resource("RES");
		barTop = new Image(atlas.findRegion("hp-bar"));
		this.addActor(barTop);
		this.bg = atlas.findRegion("hp-bar-bg");
		this.setSize(barTop.getWidth(), barTop.getHeight());
		this.setPosition(20, Engine.getHeight()-this.getHeight()-20);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		bg.setRegion(bg,0,0,(int)(currentValue/fullValue*this.getWidth()),bg.getRegionHeight());
		batch.draw(bg,this.getX(),this.getY());
		super.draw(batch, parentAlpha);
	}
}
