package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair{
        Vector2 position;
        float speed;
        int offset;
        Rectangle emtySpase;


        public WallPair(Vector2 pos){
            position = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emtySpase = new Rectangle(position.x , position.y -offset + 300, 100, betweenDistance);
        }
        public void update() {
            position.x -= speed;
            if (position.x < - 70) {
                position.x = 700;
                offset = new Random().nextInt(250);
            }
            emtySpase.x = position.x;
        }
    }
   static WallPair[] obs;
    Texture txt;
    int betweenDistance;

    public Obstacles() {
        txt = new Texture("12.png");
        obs = new WallPair[4];
        betweenDistance = 280;
        int startPosX = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX,0));
            startPosX += 220;
        }
    }
    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) {
            batch.draw(txt, obs[i].position.x , obs[i].position.y);
            batch.draw(txt, obs[i].position.x , obs[i].position.y + betweenDistance + txt.getHeight() - obs[i].offset);
        }
    }
    public void update() {
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();

        }
    }
    public void recreate(){
        int startPosX = 200;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosX,50));
            startPosX += 220;
        }
    }
}
