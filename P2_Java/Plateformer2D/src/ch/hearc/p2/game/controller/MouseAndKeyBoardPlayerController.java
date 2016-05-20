package ch.hearc.p2.game.controller;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.level.Level;

public class MouseAndKeyBoardPlayerController extends PlayerController {

    private long time1;
    private long time2;

    public MouseAndKeyBoardPlayerController(Player player, Level level) {
	super(player, level);
	time1 = System.currentTimeMillis();
	time2 = System.currentTimeMillis();
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
    }

    private void handleMouseInput(Input i, int delta) throws SlickException {
	time1 = System.currentTimeMillis();

	/*
	 * if (i.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
	 * 
	 * int mouseWorldX = level.getXOffset() + i.getMouseX() - 64; // OK int
	 * mouseWorldY = level.getYOffset() + i.getMouseY() - 95; // Fausse
	 * player.shoot(mouseWorldX, mouseWorldY); // coordonnées //
	 * System.out.println("MouseW x : " + mouseWorldX); //
	 * System.out.println("MouseW y : " + mouseWorldY); //
	 * System.out.println("Player x : " + player.getX()); //
	 * System.out.println("Player y : " + player.getY()); // Valeur //
	 * bizarre vers le haut de l'écran. Le 0 ne commence pas où il //
	 * devrait; }
	 */
	if (i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && time1 - time2 > 100) {

	    int mouseWorldX = level.getXOffset() + i.getMouseX() - 64; // Ok
	    int mouseWorldY = level.getYOffset() + i.getMouseY() - 95; // Ok
	    player.shoot(mouseWorldX, mouseWorldY);
	    time2 = System.currentTimeMillis();
	}

    }

}
