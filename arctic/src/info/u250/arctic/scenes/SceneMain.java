package info.u250.arctic.scenes;


import info.u250.arctic.Arctic;
import info.u250.arctic.Values;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.engine.Scene;
import info.u250.c2d.graphic.C2dStage;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SceneMain extends C2dStage implements Scene {
	
	@Override
	public boolean keyDown(int keycode) {
		if (Gdx.app.getType() == ApplicationType.Android) {
			if (keycode == Keys.BACK) {
				System.exit(0);
			}
		} else {
			if (keycode == Keys.DEL) {
				//do nothing
			}
		}
		return super.keyDown(keycode);
	}

	public SceneMain(){
		final TextureAtlas atlas = Engine.resource("RES");
		final BitmapFont font = Engine.resource("Font");
		
		
		final Image bg = new Image(atlas.findRegion("main-bg"));
		bg.setX(-100);
		bg.getColor().a = 0.3f;
		this.addActor(bg);
		
		final Image start = new Image(atlas.findRegion("start"));
		start.setPosition((this.getWidth()-start.getWidth())/2, 70);
		start.setOrigin(start.getWidth()/2, start.getHeight()/2);
		start.addAction(Actions.forever(Actions.sequence(Actions.scaleTo(0.9f, 0.9f,0.05f),Actions.scaleTo(1, 1, 0.05f))));
		this.addActor(start);
		
		final Image title = new Image(atlas.findRegion("title"));
		title.setPosition(this.getWidth()/2-title.getWidth()/2, 400);
		title.addAction(Actions.forever(Actions.sequence(Actions.scaleTo(0.9f, 0.9f,0.03f),Actions.scaleTo(1, 1, 0.04f))));
		this.addActor(title);
		
		Color color = new Color(102f/255f,178f/255f,216f/255f,1);
		
		Table helpTable = new Table();
		helpTable.add(new Label("Help the small explorer boat to avoid the icebergs ",new LabelStyle(font,color)));
		helpTable.row();
		helpTable.add(new Label("by touch your screen ",new LabelStyle(font,color)));
		helpTable.row();
		helpTable.add(new Label("Grab the supply boxes to increase your score & energy.",new LabelStyle(font,color)));
		helpTable.row();
		helpTable.add(new Label("and watch out for the airplanes!",new LabelStyle(font,color)));
		helpTable.pack();
		helpTable.setY(150);
		this.addActor(helpTable);
		
		Image logo = new Image(atlas.findRegion("logo"));
		logo.setPosition(this.getWidth()-logo.getWidth(), 20);
		this.addActor(logo);
		
		final Label speedLabel = new Label("2",new LabelStyle(font,Color.RED));
		final Slider slider = new Slider(1, 8, 1, false ,Engine.resource("Skin", Skin.class));
		slider.getColor().set(color);
		slider.setValue(2);
		Table speedTable = new Table();
		speedTable.add(new Label("Speed:",new LabelStyle(font,color)));
		speedTable.add(slider);
		speedTable.add(speedLabel);
		speedTable.add(new Label("X",new LabelStyle(font,color)));
		speedTable.pack();
		speedTable.setPosition(30, 80);
		slider.getColor().a = 0.5f;
		slider.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Values.setSpeed((int)slider.getValue());
				speedLabel.setText(""+(int)slider.getValue());
			}
			
		});
		this.addActor(speedTable);
		start.addListener(new ClickListener() {
			public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
				Engine.getEventManager().fire(Arctic.Event_SceneArctic);
			};
		});
	}
	
	@Override
	public void update(float delta) {}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		this.act(delta);
		this.draw();
	}

	@Override
	public void show() {
		((Arctic)Engine.get()).ad.hide();
	}

	@Override
	public void hide() {}

	@Override
	public InputProcessor getInputProcessor() {return this;}

}
