package ch.hearc.p2.game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.enums.Facing;

public class Player extends Character {

	public Player(float x, float y) throws SlickException {
		super(x, y);
		setSprite(new Image("dataTuto/img/characters/player/player.png"));

		setMovingAnimation(new Image[] { new Image("dataTuto/img/characters/player/player_1.png"),
				new Image("dataTuto/img/characters/player/player_2.png"),
				new Image("dataTuto/img/characters/player/player_3.png"),
				new Image("dataTuto/img/characters/player/player_4.png") }, 125);
	}

	public void moveLeft(int delta) {
		x = x - (0.15f * delta);
		facing = Facing.LEFT;
		lastTimeMoved = System.currentTimeMillis();
	}

	public void moveRight(int delta) {
		x = x + (0.15f * delta);
		facing = Facing.RIGHT;
		lastTimeMoved = System.currentTimeMillis();
	}
}
