package ch.hearc.p2.game.controller;

import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.level.Level;

import org.newdawn.slick.Input;

public abstract class PlayerController {

        protected Player player;
        protected Level level;
    
        public PlayerController(Player player, Level level) {
         this.player = player;
         this.level = level;
        }

	public abstract void handleInput(Input i, int delta);

}
