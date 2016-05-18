package ch.hearc.p2.game.character;

import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.SGL;

import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.Projectile;
import ch.hearc.p2.game.projectile.ProjectileAbeille;

public class Abeille extends Ennemie {

    public Abeille(float x, float y) throws SlickException {

	super(x, y);
	dead = false;
	// setSprite(new Image("ressources/sprites/p2_walk01.png"));

	sprites = setSprite(new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee.png"),
		sprites);
	movingAnimations = setMovingAnimation(
		new Image[] { new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee.png"),
			new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/Enemies/bee_move.png") },
		80, movingAnimations);

	Image bee = new Image("ressources/bee.png");
	Image bee2 = new Image("ressources/bee_move.png");
	int filter =  SGL.GL_LINEAR;
	bee.setFilter(filter);
	//bee.setAlpha(0);
	bee2.setFilter(filter);
	//bee2.setAlpha(0);
	hitedSprites = setSprite(bee, hitedSprites);
	hitedMovingAnimations = setMovingAnimation(new Image[] { bee, bee2 }, 80, hitedMovingAnimations);

	boundingShape = new AABoundingRect(x, y, 100, 100);
	deadPicture = new Image("ressources/bee_dead.png");
	accelerationSpeed = 0.002f;
	maximumSpeed = 0.55f;
	maximumFallSpeed = 0.0f;
	decelerationSpeed = 0.001f;
	life = 13;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x + 20, y);
    }

    public void shoot() throws SlickException {
	int randomX = -2  + (int) (Math.random() * 1);
	int randomY = 0 + (int) (Math.random() * 1);

	toAddList.add(new ProjectileAbeille(x + 10, y + 10, randomX, randomY));
    }

    public void moveRandom() {
	int randomNum = 0 + (int) (Math.random() * 50);
	int randomWay = 0 + (int) (Math.random() * 2);
	if (randomWay < 1) {
	    moveLeft(randomNum);
	    // this.y += randomNum;
	} else {
	    moveRight(randomNum);
	    // this.y -= randomNum;
	}

    }

    public void setMaximumFallSpeed(float maximumFallSpeed) {
	this.maximumFallSpeed = maximumFallSpeed;
    }

}