package ch.hearc.p2.game.controller;

import ch.hearc.p2.game.character.Player;

import org.newdawn.slick.Input;

public abstract class PlayerController {

	protected Player player;

	public PlayerController(Player player) {
		this.player = player;
	}

	public abstract void handleInput(Input i, int delta);

}