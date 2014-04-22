package info.u250.arctic;

import info.u250.arctic.scenes.SceneArctic;
import info.u250.arctic.scenes.SceneMain;
import info.u250.arctic.scenes.SceneScore;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.engine.EngineDrive;
import info.u250.c2d.engine.events.Event;
import info.u250.c2d.engine.events.EventListener;
import info.u250.c2d.engine.resources.AliasResourceManager;
import info.u250.c2d.graphic.AdControl;

public class Arctic extends Engine {
	public AdControl ad;
	public Arctic(AdControl ad){
		this.ad = ad;
	}

	public static final String Event_SceneMain = "_Event_SceneMain";
	public static final String Event_SceneScore = "_Event_SceneScore";
	public static final String Event_SceneArctic = "_Event_SceneArctic";
	@Override
	protected EngineDrive onSetupEngineDrive() {
		return new EngineDrive() {
			
			@Override
			public EngineOptions onSetupEngine() {
				final EngineOptions opt = new EngineOptions(new String[]{
						"data/arctic.atlas",
						"data/font.fnt",
						"data/sounds",
						"data/musics",
						"data/skin/uiskin.json"
				},800,480);
				opt.useGL20 = false;
				opt.debug = false;
				opt.configFile = "info.u250.arctic.cnf";
				return opt;
			}
			
			@Override
			public void onResourcesRegister(AliasResourceManager<String> reg) {
				reg.textureAtlas("RES", "data/arctic.atlas");
				
				reg.font("Font", "data/font.fnt");
				
				reg.music("MusicBg", "data/musics/bg.mp3");
				reg.music("MusicExplorer", "data/musics/explorer.mp3");
				
				reg.sound("SoundUp1", "data/sounds/up.mp3");
				reg.sound("SoundUp2", "data/sounds/up2.mp3");
				reg.sound("SoundDie", "data/sounds/die.mp3");
				reg.sound("SoundEat", "data/sounds/eat.mp3");
				reg.sound("SoundDown", "data/sounds/down.mp3");
				reg.sound("SoundPlane", "data/sounds/plane.wav");
				
				reg.skin("Skin", "data/skin/uiskin.json");
				
			}
			
			
			SceneMain sceneMain ;
			SceneScore sceneScore ;
			SceneArctic sceneArctic ;
			@Override
			public void onLoadedResourcesCompleted() {
				Values.setSpeed(2);
				this.sceneMain = new SceneMain();
				this.sceneScore = new SceneScore();
				this.sceneArctic = new SceneArctic();
				
				Engine.getEventManager().register(Event_SceneMain, new EventListener() {
					@Override
					public void onEvent(Event event) {
						Engine.setMainScene(sceneMain);
					}
				});
				Engine.getEventManager().register(Event_SceneScore, new EventListener() {
					@Override
					public void onEvent(Event event) {
						Engine.setMainScene(sceneScore);
					}
				});
				Engine.getEventManager().register(Event_SceneArctic, new EventListener() {
					@Override
					public void onEvent(Event event) {
						sceneArctic.reset();
						Engine.setMainScene(sceneArctic);
					}
				});
				Engine.setMainScene(this.sceneMain);
				Engine.getMusicManager().playMusic("MusicBg", true);
			}
			
			@Override
			public void dispose() {}
		};
	}

}
