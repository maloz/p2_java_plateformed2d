package ch.hearc.p2.game.level.object;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;

public class Objective extends LevelObject {

    protected Image image;

    public Objective(float x, float y) throws SlickException {
	super(x, y);

	// add the right animation for this objective
	image =  new Image("ressources/map/tuiles/platformerGraphicsDeluxe_Updated/Items/coinGold.png");
	boundingShape = new AABoundingRect(x, y, 60, 70);
    }

    public void render(float offset_x, float offset_y) {
	image.draw(x - 2 - offset_x, y - 2 - offset_y);
    }


}