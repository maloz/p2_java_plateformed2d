package ch.hearc.p2.game.character;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.Projectile;

public class Player extends Character {

    private List<LevelObject> toAddList = new LinkedList<LevelObject>();
    
    
    public Player(float x, float y) throws SlickException {
	super(x, y);
	// setSprite(new Image("ressources/sprites/p2_walk01.png"));

	setSprite(new Image(
		"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Players/128x256/Blue/alienBlue_walk1.png"));
	setMovingAnimation(
		new Image[] {
			new Image(
				"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Players/128x256/Blue/alienBlue_walk1.png"),
			new Image(
				"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Players/128x256/Blue/alienBlue_walk2.png") },
		100);

	boundingShape = new AABoundingRect(x, y, 85, 256);

	accelerationSpeed = 0.002f;
	maximumSpeed = 0.55f;
	maximumFallSpeed = 0.6f;
	decelerationSpeed = 0.001f;
	life = 6;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x + 20, y);
    }

    public void shoot() throws SlickException {
	toAddList.add(new Projectile(x+40,y+150));
    }
    public List<LevelObject> getToAddList()
    {
	return toAddList;
    }
    public void clearList()
    {
	toAddList.clear();
    }

}