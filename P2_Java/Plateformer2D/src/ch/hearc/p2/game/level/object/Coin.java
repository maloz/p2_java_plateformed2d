package ch.hearc.p2.game.level.object;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;

public class Coin extends Objective {

    private int value;

    public Coin(float x, float y) throws SlickException {
	super(x, y);
	value = 1;

	// add the right animation for this objective
	image =	new Image("ressources/map/tuiles/platformerGraphicsDeluxe_Updated/Items/coinGold.png");
	boundingShape = new AABoundingRect(x, y, 60, 70);
    }
    public int getValue()
    {
	return value;
    }

}