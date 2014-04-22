package info.u250.arctic.scenes.game;

import info.u250.c2d.engine.Engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Points extends Group {
	private static Points instance;

	public static Points getInstance() {
		if (null == instance) {
			instance = new Points();
		}
		return instance;
	}

	public void reset() {
		this.setPoints(0);
	}

	private int points = 0;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
		this.label.setText(this.points + "");
	}

	Label label;

	private Points() {
		label = new Label("0", new LabelStyle(Engine.resource("Font",
				BitmapFont.class), new Color(102f / 255f, 178f / 255f,
				216f / 255f, 1)));
		this.addActor(label);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.setWidth(this.label.getWidth());
		this.setHeight(this.label.getHeight());
		this.setPosition(Engine.getWidth() - this.getWidth() - 50, Engine.getHeight() - this.getHeight());
		super.draw(batch, parentAlpha);
	}
}
