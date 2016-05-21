package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.physics.AABoundingRect;

public class ProjectileAbeille extends Projectile {

    protected Image projectile;

    public ProjectileAbeille(float x, float y, float x_velocity, float y_velocity) throws SlickException {
	super(x, y);
	this.x_velocity = x_velocity;
	this.y_velocity = y_velocity;

	// add the right animation for this objective
	projectile = new Image("ressources/tiles/item/fireball.png");
	projectile = projectile.getScaledCopy(0.75f);
	boundingShape = new AABoundingRect(x, y, 15, 15);
	maximumFallSpeed = (float) 1;

    }

    public void render(float offset_x, float offset_y) {
	projectile.draw(x - offset_x, y - offset_y);
    }

}