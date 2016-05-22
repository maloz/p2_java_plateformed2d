package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;

public class Projectile extends LevelObject {

    protected Animation animation;
    protected int damage;

    public Projectile(float x, float y) throws SlickException {
	super(x, y);
	x_velocity = (float) 1;
	y_velocity = 0;
	damage = 1;
	animation = new Animation(new Image[] { new Image("ressources/tiles/item/laserRed02.png") }, 125);
	boundingShape = new AABoundingRect(x, y, 15, 15);
	maximumFallSpeed = 0.0f;

    }

    public void render(float offset_x, float offset_y) {
	animation.draw(x - 2 - offset_x, y - 2 - offset_y);
    }

    public void setDamage(int d) {
	damage = d;
    }

    public int getDamage() {
	return damage;
    }

}