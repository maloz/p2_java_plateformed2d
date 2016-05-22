package ch.hearc.p2.game.controller;

import java.awt.AWTException;
import java.awt.Robot;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.level.Level;

public class MouseAndKeyBoardPlayerController extends PlayerController {

    private long time1;
    private long time2;
    private Controller controller;
    private int posX = 0;
    private int posY = 0;
    private Robot robot;

    public MouseAndKeyBoardPlayerController(Player player, Level level) {
	super(player, level);
	time1 = System.currentTimeMillis();
	time2 = System.currentTimeMillis();
	try {
	    robot = new Robot();
	} catch (AWTException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void handleInput(Input i, int delta) {
	// handle any input from the keyboard
	time1 = System.currentTimeMillis();

	handleKeyboardInput(i, delta);

	try {
	    handleMouseInput(i, delta);
	    handleControllerInput(i, delta);
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

	if (i.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && time1 - time2 > player.getWeapon().getCadence()) {

	    int mouseWorldX = level.getXOffset() + i.getMouseX() - 64; // Ok
	    int mouseWorldY = level.getYOffset() + i.getMouseY() - 95; // Ok
	    player.shoot(mouseWorldX, mouseWorldY);
	    time2 = System.currentTimeMillis();
	}
    }

    private void handleControllerInput(Input i, int delta) throws SlickException {
	// Work
	if (i.isControllerLeft(Input.ANY_CONTROLLER)) {
	    player.moveLeft(delta);
	} else if (i.isControllerRight(Input.ANY_CONTROLLER)) {
	    player.moveRight(delta);
	}
	// Work
	if (i.isButton1Pressed(Input.ANY_CONTROLLER)) {
	    player.jump();
	}
	if (i.isButtonPressed(4, 1) && time1 - time2 > player.getWeapon().getCadence()) {
	    int mouseWorldX = level.getXOffset() + i.getMouseX() - 64; // Ok
	    int mouseWorldY = level.getYOffset() + i.getMouseY() - 95; // Ok
	    player.shoot(mouseWorldX, mouseWorldY);
	    time2 = System.currentTimeMillis();
	}

	if (i.getAxisValue(1, 3) != 0 || i.getAxisValue(1, 2) != 0) {

	    int y = (int) (i.getAxisValue(1, 2) * delta);
	    int x = (int) (i.getAxisValue(1, 3) * delta);

	    robot.mouseMove(i.getMouseX() + x, i.getMouseY() + y);

	}
    }

}
