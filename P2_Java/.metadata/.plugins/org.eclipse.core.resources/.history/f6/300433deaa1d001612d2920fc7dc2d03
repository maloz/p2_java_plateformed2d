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

	sprites = setSprite(new Image("ressources/character/ennemi/bee.png"),
		sprites);
	movingAnimations = setMovingAnimation(
		new Image[] { new Image("ressources/character/ennemi/bee.png"),
			new Image("ressources/character/ennemi/bee_fly.png") },
		80, movingAnimations);

	Image bee = new Image("ressources/character/ennemi/bee_hit.png");

	hitedSprites = setSprite(bee, hitedSprites);
	hitedMovingAnimations = setMovingAnimation(new Image[] { bee, bee }, 80, hitedMovingAnimations);

	boundingShape = new AABoundingRect(x, y, 56, 48);
	deadPicture = new Image("ressources/character/ennemi/bee_dead.png");
	accelerationSpeed = 0.003f;
	maximumSpeed = 0.6f;
	maximumFallSpeed = 0.0f;
	decelerationSpeed = 0.001f;
	life = 5;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x , y);
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