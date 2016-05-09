package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.physics.AABoundingRect;

public class ProjectileAbeille extends Projectile {

    protected Animation animation;

    public ProjectileAbeille(float x, float y, float x_velocity, float y_velocity) throws SlickException {
	super(x, y);
	this.x_velocity = x_velocity;
	this.y_velocity = y_velocity;

	// add the right animation for this objective
	animation = new Animation(
		new Image[] {
			new Image("ressources/map/tuiles/platformerGraphicsDeluxe_Updated/Tiles/laserPurpleDot.png") },
		125);
	boundingShape = new AABoundingRect(x, y, 10, 10);
	maximumFallSpeed = (float) 1;

    }

    public void render(float offset_x, float offset_y) {
	animation.draw(x - 2 - offset_x, y - 2 - offset_y);
    }

}