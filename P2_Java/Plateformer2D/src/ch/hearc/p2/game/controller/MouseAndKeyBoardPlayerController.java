package ch.hearc.p2.game.controller;

import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.level.Level;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MouseAndKeyBoardPlayerController extends PlayerController {

        public MouseAndKeyBoardPlayerController(Player player, Level level) {
            super(player, level);
        }

	public void handleInput(Input i, int delta) {
		// handle any input from the keyboard
		handleKeyboardInput(i, delta);

		try {
			handleMouseInput(i, delta);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handleKeyboardInput(Input i, int delta) {
		// we can both use the WASD or arrow keys to move around, obviously we
		// can't move both left and right simultaneously
		if (i.isKeyDown(Input.KEY_A) || i.isKeyDown(Input.KEY_LEFT)) {
			player.moveLeft(delta);
		} else if (i.isKeyDown(Input.KEY_D) || i.isKeyDown(Input.KEY_RIGHT)) {
			player.moveRight(delta);
		} else {
			// we dont move if we don't press left or right, this will have the
			// effect that our player decelerates
			player.setMoving(false);
		}

		if (i.isKeyDown(Input.KEY_SPACE)) {
			player.jump();
		}
		if (i.isKeyDown(Input.KEY_ESCAPE)) {

		}
	}

	private void handleMouseInput(Input i, int delta) throws SlickException {

	int mouseWorldX = level.getXOffset() + i.getMouseX(); // OK
	int mouseWorldY = level.getYOffset() + i.getMouseY(); // Fausse
							      // coordonn�es
	System.out.println("MouseW x : " + mouseWorldX);
	System.out.println("MouseW y : " + mouseWorldY);
	System.out.println("Player x : " + player.getX());
	System.out.println("Player y : " + player.getY()); // Valeur bizarre vers le haut de l'�cran. Le 0 ne commence pas o� il devrait;
	    	
	if (i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			player.shoot();
		}
	}

}
