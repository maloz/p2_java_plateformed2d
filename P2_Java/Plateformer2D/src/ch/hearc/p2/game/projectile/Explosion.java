package ch.hearc.p2.game.projectile;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.physics.AABoundingRect;

public class Explosion extends Projectile {
    protected Image bullet;
    protected long time1;
    protected long time2;

    public Explosion(float x, float y) throws SlickException {
	super(x, y);
	this.x_velocity = 0;
	this.y_velocity = 0;
	time1 = System.currentTimeMillis();
	time2 = System.currentTimeMillis();

	bullet = new Image("ressources/tiles/item/flash00.png");
	bullet = bullet.getScaledCopy(0.5f);
	boundingShape = new AABoundingRect(x, y, 250, 250);
	maximumFallSpeed = (float) 1;
    }

    public void render(float offset_x, float offset_y) {
	bullet.draw(x - 2 - offset_x, y - 2 - offset_y);
    }
    
    public void setTime2(long time)
    {
	time2 = time;
    }
    public long getTime1()
    {
	return time1;
    }
    public long getTime2()
    {
	return time2;
    }
}
