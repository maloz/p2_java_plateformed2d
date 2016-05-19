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

public class Spider extends Ennemie {

    public Spider(float x, float y) throws SlickException {

	super(x, y);
	dead = false;
	// setSprite(new Image("ressources/sprites/p2_walk01.png"));

	sprites = setSprite(new Image("ressources/character/ennemi/spider.png"),
		sprites);
	movingAnimations = setMovingAnimation(
		new Image[] { new Image("ressources/character/ennemi/spider_walk1.png"),
			new Image("ressources/character/ennemi/spider_walk2.png") },
		80, movingAnimations);

	Image spider_hit = new Image("ressources/character/ennemi/spider_hit.png");

	hitedSprites = setSprite(spider_hit, hitedSprites);
	hitedMovingAnimations = setMovingAnimation(new Image[] { spider_hit, spider_hit }, 80, hitedMovingAnimations);

	boundingShape = new AABoundingRect(x, y, 56, 48);
	deadPicture = new Image("ressources/character/ennemi/spider_dead.png");
	accelerationSpeed = 0.008f;
	maximumSpeed = 0.8f;
	decelerationSpeed = 0.008f;
	life = 5;
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x , y);
    }

    public void shoot() throws SlickException {
	/*int randomX = -2  + (int) (Math.random() * 1);
	int randomY = 0 + (int) (Math.random() * 1);

	toAddList.add(new ProjectileAbeille(x + 10, y + 10, randomX, randomY));*/
    }

    public void moveRandom() {
	int randomNum = 0 + (int) (Math.random() * 50);
	int randomWay = 0 + (int) (Math.random() * 2);
	if (randomWay < 1) {
	    moveLeft(randomNum);
	} else {
	    moveRight(randomNum);
	}

    }



}