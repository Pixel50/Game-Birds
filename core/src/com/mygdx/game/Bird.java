package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 position;
    float vy;
    float gravity;

    public Bird() {
        img = new Texture("kar.png");
        position = new Vector2(100,300);
        vy = 0;
        gravity = - 0.7f;

    }
    public void render(SpriteBatch batch){
        batch.draw(img,position.x,position.y);
    }
    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 5;
        }
        vy += gravity;
        position.y += vy;

    }
    public void  recreate(){
        position = new Vector2(100,300);
        vy=0;
    }
}
