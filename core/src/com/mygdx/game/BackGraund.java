package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BackGraund {
    class BGpicture{
        public Texture tx;
        public Vector2 pos;
        public BGpicture(Vector2 pos){
            tx = new Texture("1maxresdefault.jpg");
            this.pos = pos;
        }

    }

    private int speed;
    private BGpicture[] backs;

    public  BackGraund() {
        backs = new BGpicture[2];
        backs[0] = new BGpicture(new Vector2(0,0));
        backs[1] = new BGpicture(new Vector2(800,0));
        speed = 4;

    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < backs.length; i++ ) {
            batch.draw(backs[i].tx, backs[i].pos.x,backs[i].pos.y);
        }
    }
    public void update() {
        for (int i = 0; i < backs.length; i++) {
        backs[i].pos.x -= speed;
        }
//        backs[0].pos.y -= speed;
        if (backs[0].pos.x < -800 ) {
            backs[0].pos.x = 0;
            backs[1].pos.x = 800;
        }

    }


}
