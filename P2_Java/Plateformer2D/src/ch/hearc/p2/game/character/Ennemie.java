package ch.hearc.p2.game.character;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.Projectile;

public class Ennemie extends Character {

    protected List<LevelObject> toAddList;

    public Ennemie(float x, float y) throws SlickException {

	super(x, y);
	toAddList = new LinkedList<LevelObject>();
	// setSprite(new Image("ressources/sprites/p2_walk01.png"));

	boundingShape = new AABoundingRect(x, y, 45, 45);

	accelerationSpeed = 0.002f;
	maximumSpeed = 0.55f;
	maximumFallSpeed = 0.0f;
	decelerationSpeed = 0.001f;
	life = 6;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x + 20, y + 70);
    }

    public void shoot() throws SlickException {

    }

    public List<LevelObject> getToAddList() {
	return toAddList;
    }

    public void clearList() {
	toAddList.clear();
    }

    public void dead(Boolean b) {
	this.dead = true;
    }

    public Boolean isDead() {
	return dead;
    }

    public void moveRandom() {
	// TODO Auto-generated method stub
	
    }
    public void setMaximumFallSpeed(float maximumFallSpeed) {
	this.maximumFallSpeed = maximumFallSpeed;
    }

}