package ch.hearc.p2.game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.enums.Facing;
import ch.hearc.p2.game.physics.AABoundingRect;

public class Player extends Character {

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

		/*
		 * setMovingAnimation(new Image[]{new
		 * Image("ressources/sprites/p2_walk01.png"),new
		 * Image("ressources/sprites/p2_walk02.png"), new
		 * Image("ressources/sprites/p2_walk03.png"),new
		 * Image("ressources/sprites/p2_walk04.png"), new
		 * Image("ressources/sprites/p2_walk05.png"),new
		 * Image("ressources/sprites/p2_walk06.png"), new
		 * Image("ressources/sprites/p2_walk07.png"),new
		 * Image("ressources/sprites/p2_walk08.png"), new
		 * Image("ressources/sprites/p2_walk09.png"),new
		 * Image("ressources/sprites/p2_walk10.png"), new
		 * Image("ressources/sprites/p2_walk11.png")},75);
		 */
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


}