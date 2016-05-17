package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;

public class Projectile extends LevelObject {

    protected Animation animation;

    public Projectile(float x, float y) throws SlickException {
	super(x, y);
	x_velocity = (float) 1.8;
	y_velocity = 0;

	animation = new Animation(
		new Image[] { new Image("ressources/map/tuiles/platformerGraphicsDeluxe_Updated/Tiles/laserPurpleDot.png") },
		125);
	boundingShape = new AABoundingRect(x, y, 10, 10);
	maximumFallSpeed = (float) 0.1;

    }

    public void render(float offset_x, float offset_y) {
	animation.draw(x - 2 - offset_x, y - 2 - offset_y);
    }

}