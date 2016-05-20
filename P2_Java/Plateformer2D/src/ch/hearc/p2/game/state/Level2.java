package ch.hearc.p2.game.state;

import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.character.Bat;
import ch.hearc.p2.game.character.Ghost;
import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.character.SnakeLava;
import ch.hearc.p2.game.character.Spider;
import ch.hearc.p2.game.character.SpinnerHalf;
import ch.hearc.p2.game.character.VoidFlyer;
import ch.hearc.p2.game.level.object.Coin;
import ch.hearc.p2.game.level.object.Key;

public class Level2 extends LevelState {

    public Level2(String startingLevel) {
	super(startingLevel);
	ID = 102;
	this.startinglevel = startingLevel;
	nextLevel = 103;

    }

    public void instanciation() throws SlickException {
	// ID for the next state (0 is main menu, ID+1 is the next level)

	player = new Player(1 * 70, 16 * 70);

	// Remplis ennemis
	ennemies.add(new Bat(7 * 70, 3 * 70));
	ennemies.add(new Bat(2 * 70, 7 * 70));
	ennemies.add(new Bat(26 * 70, 2 * 70));
	ennemies.add(new Bat(7 * 70, 14 * 70));
	ennemies.add(new Spider(15 * 70, 17 * 70));
	ennemies.add(new SnakeLava(7 * 70, 16 * 70));
	ennemies.add(new Ghost(23 * 70, 10 * 70));
	ennemies.add(new VoidFlyer(23 * 70, 7 * 70));
	ennemies.add(new SpinnerHalf(10 * 70, 18 * 70));

	// Remplis Objectifs
	objectives.add(new Coin(25 * 70, 2 * 70));
	objectives.add(new Coin(2 * 70, 10 * 70));
	objectives.add(new Coin(47 * 70, 6 * 70));
	objectives.add(new Coin(35 * 70, 14 * 70));
	objectives.add(new Key(43 * 70, 2 * 70));

	// setup music (si rien, on garde la m�me musique qu'au niveau d'avant)
	// musiclvl = new Music("ressources/audio/music/lvl1.ogg");

	initialisationSuite();

    }

}