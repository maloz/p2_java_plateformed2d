package ch.hearc.p2.game.character;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.Projectile;
import ch.hearc.p2.game.projectile.ProjectileAbeille;

public class Abeille extends Character {

    private List<LevelObject> toAddList;
    
    public Abeille(float x, float y) throws SlickException {
	
	super(x, y);
	toAddList = new LinkedList<LevelObject>();
	// setSprite(new Image("ressources/sprites/p2_walk01.png"));

	setSprite(new Image(
		"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee.png"));
	setMovingAnimation(
		new Image[] {
			new Image(
				"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee.png"),
			new Image(
				"ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee_move.png") },
		80);

	boundingShape = new AABoundingRect(x, y, 100, 100);

	accelerationSpeed = 0.002f;
	maximumSpeed = 0.55f;
	maximumFallSpeed = 0.0f;
	decelerationSpeed = 0.001f;
	life = 6;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x + 20, y);
    }

    public void shoot() throws SlickException {
	int randomX = -5 + (int)(Math.random() * 5); 
	int randomY = 0 + (int)(Math.random() * 5); 
	
	toAddList.add(new ProjectileAbeille(x+50,y+50, randomX, randomY));
    }
    public List<LevelObject> getToAddList()
    {
	return toAddList;
    }
    public void clearList()
    {
	toAddList.clear();
    }
    
    public void moveRandom()
    {
	int randomNum = 0 + (int)(Math.random() * 50); 
	int randomWay = 0 + (int)(Math.random() * 2); 
	if(randomWay < 1)
	    moveLeft(randomNum);
	else
	    moveRight(randomNum);
    }

}