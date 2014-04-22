package info.u250.arctic.client;

import info.u250.arctic.Arctic;
import info.u250.c2d.engine.Engine;
import info.u250.c2d.engine.EngineCallback;
import info.u250.c2d.engine.EngineDrive;
import info.u250.c2d.engine.Scene;
import info.u250.c2d.engine.EngineDrive.EngineOptions;
import info.u250.c2d.engine.resources.AliasResourceManager;
import info.u250.c2d.graphic.AdControl;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(800, 480);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		Engine engine = new Arctic(new AdControl() {
			
			@Override
			public void show() {
				
			}
			
			@Override
			public void hide() {
				
			}
		});
//		Engine engine = new Engine() {
//			
//			@Override
//			protected EngineDrive onSetupEngineDrive() {
//				return new EngineDrive() {
//					
//					@Override
//					public EngineOptions onSetupEngine() {
//						return new EngineOptions(new String[]{}, 480, 800);
//					}
//					
//					@Override
//					public void onResourcesRegister(AliasResourceManager<String> reg) {
//						
//						
//					}
//					
//					@Override
//					public void onLoadedResourcesCompleted() {
//Engine.setMainScene(new Scene() {
//							
//							@Override
//							public void update(float delta) {
//								// TODO Auto-generated method stub
//								
//							}
//							
//							@Override
//							public void show() {
//								// TODO Auto-generated method stub
//								
//							}
//							
//							@Override
//							public void render(float delta) {
//								// TODO Auto-generated method stub
//								
//							}
//							
//							@Override
//							public void hide() {
//								// TODO Auto-generated method stub
//								
//							}
//							
//							@Override
//							public InputProcessor getInputProcessor() {
//								// TODO Auto-generated method stub
//								return null;
//							}
//						});
//					}
//					
//					@Override
//					public void dispose() {
//						// TODO Auto-generated method stub
//						
//					}
//				};
//			}
//		};
		Engine.setEngineCallback(new EngineCallback() {
			@Override
			public void postLoad() {}

			@Override
			public void preLoad(DisplayMode mode, String[] assets) {
				for(String key : getPreloader().binaries.keys() ){
					itr(assets, key);
				}
				for(String key : getPreloader().images.keys() ){
					itr(assets, key);
				}
				for(String key : getPreloader().texts.keys() ){
					itr(assets, key);
				}
				for(String key : getPreloader().audio.keys() ){
					itr(assets, key);
				}
			}
			
			void itr(String[] assets,String key){
				for(String s : assets){
					if(key.contains(s)){
						Engine.getAliasResourceManager().load(key);
						return;
					}
				}
			}
			
		});
		return engine;
	}
}