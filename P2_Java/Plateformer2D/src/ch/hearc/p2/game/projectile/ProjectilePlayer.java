package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;

public class ProjectilePlayer extends Projectile {

    protected Image bullet;
    protected float angle;

    public ProjectilePlayer(float x, float y, float x_velocity, float y_velocity, float angle) throws SlickException {
	super(x, y);
	this.x_velocity = x_velocity;
	this.y_velocity = y_velocity;
	this.angle = angle;

	bullet = new Image("ressources/tiles/item/fireball.png");
	bullet.setCenterOfRotation(bullet.getWidth()/2, bullet.getHeight()/2);
	bullet.setRotation((float) Math.toDegrees(angle) - 90);
	boundingShape = new AABoundingRect(x, y, 20, 20);
	maximumFallSpeed = (float) 0;

    }

    public void render(float offset_x, float offset_y) {
	bullet.draw(x - 2 - offset_x, y - 2 - offset_y);
    }

}