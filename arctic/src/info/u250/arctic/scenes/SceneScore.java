package info.u250.arctic.scenes;


import info.u250.arctic.Arctic;
import info.u250.arctic.Configure;
import info.u250.arctic.scenes.game.Points;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.engine.Scene;
import info.u250.c2d.graphic.C2dStage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class SceneScore extends C2dStage implements Scene {
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		Engine.getEventManager().fire(Arctic.Event_SceneMain);
		return super.touchDown(x, y, pointer, button);
	}
	Label scoreLabelX;
	Label maxScoreLabelX;
	public SceneScore(){
		final TextureAtlas atlas = Engine.resource("RES");
		final BitmapFont font = Engine.resource("Font");
		
		final Image bg = new Image(atlas.findRegion("main-bg"));
		bg.getColor().a = 0.3f;
		bg.setX(-100);
		this.addActor(bg);
		
		
		Color color = new Color(102f/255f,178f/255f,216f/255f,1);
		Label gameOver = new Label("Game Over ",new LabelStyle(font,color));
		gameOver.setPosition(400, 300);
		this.addActor(gameOver);
		
		
		Label scoreLabel = new Label("Score:   ",new LabelStyle(font,Color.BLACK));
		scoreLabel.setPosition(450, 200);
		
		scoreLabelX = new Label( "0000",new LabelStyle(font,Color.RED));
		scoreLabelX.setPosition(550, 200);
		this.addActor(scoreLabel);
		this.addActor(scoreLabelX);
		
		Label maxScoreLabel = new Label("Max:   ",new LabelStyle(font,Color.BLACK));
		maxScoreLabel.setPosition(450, 150);
		
		maxScoreLabelX = new Label( "0000",new LabelStyle(font,Color.RED));
		maxScoreLabelX.setPosition(550, 150);
		this.addActor(maxScoreLabel);
		this.addActor(maxScoreLabelX);
		
		final Image j = new Image(atlas.findRegion("whale0001"));
		j.setPosition(200, 200);
		this.addActor(j);
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
		int max = Configure.getInstance().getMaxScore();
		int current = Points.getInstance().getPoints();
		if(current>max){
			Configure.getInstance().setMaxScore(current);
		}
		scoreLabelX.setText(""+current);
		maxScoreLabelX.setText(""+max);
	}

	@Override
	public void hide() {}

	@Override
	public InputProcessor getInputProcessor() {return this;}

}
