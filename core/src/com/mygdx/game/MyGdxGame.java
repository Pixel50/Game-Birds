package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BackGraund bg;
	Bird bird;
	Obstacles obstacles;
	boolean gameOver;
	Texture restartTexture;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new BackGraund();
		bird = new Bird();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture =new Texture("2maxresdefault-fotor-20240429202947.jpg");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(0.5F, 0, 0.5F, 0.5F);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		if (!gameOver) {
			bird.render(batch);
		}else {
			batch.draw(restartTexture,0,0);
		}
		batch.end();
	}
	public void update() {
		bg.update();
		bird.update();
		obstacles.update();
		for (int i = 0; i < obstacles.obs.length; i++) {
			if (bird.position.x > obstacles.obs[i].position.x && bird.position.x < obstacles.obs[i].position.x+4){
				if (!obstacles.obs[i].emtySpase.contains(bird.position)) {
					gameOver = true;
				}
			}
		}
		if (bird.position.y < 0 || bird.position.y > 600){
			gameOver = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)&&gameOver){
			recreate();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	public void recreate() {
		bird.recreate();
		obstacles.recreate();
		gameOver = false;
	}
}
