package com.mygdx.game.sprint3.objects;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import com.mygdx.game.sprint3.GameSettings;

import java.util.Random;

public class PlainObject extends GameObject {
    private static final int paddingHorizontal = 30;

    private int livesLeft;


    public PlainObject(int width, int height, String texturePath, World world) {
        super(
                texturePath,
                width / 2 + paddingHorizontal + (new Random()).nextInt((GameSettings.SCREEN_WIDTH - 2 * paddingHorizontal - width)),
                GameSettings.SCREEN_HEIGHT + height / 2,
                width, height,
                GameSettings.PLAIN_BIT,
                world
        );

        body.setLinearVelocity(new Vector2(0, -GameSettings.PLAIN_VELOCITY));
        livesLeft = 1;
    }

    public boolean isAlive() {
        return livesLeft > 0;
    }



    @Override
    public void hit() {
        livesLeft--;
    }

    public boolean isInFrame() {
        return getY() + height / 2 > 0;
    }


}
