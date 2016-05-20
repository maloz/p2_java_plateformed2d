package ch.hearc.p2.game.state;

import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.character.Abeille;
import ch.hearc.p2.game.character.Player;
import ch.hearc.p2.game.level.object.Coin;
import ch.hearc.p2.game.level.object.Key;

public class Level3 extends LevelState {

    public Level3(String startingLevel) {
	super(startingLevel);
	ID = 103;
	this.startinglevel = startingLevel;
	nextLevel = 104;

    }

    @Override
    public void instanciation() throws SlickException {
	// ID for the next state (0 is main menu, ID+1 is the next level)

	player = new Player(2 * 70, 14 * 70);

	// Remplis ennemis
	ennemies.add(new Abeille(12 * 70, 8 * 70));
	ennemies.add(new Abeille(12 * 70, 1 * 70));
	ennemies.add(new Abeille(43 * 70, 2 * 70));
	ennemies.add(new Abeille(1 * 70, 5 * 70));

	// Remplis Objectifs
	objectives.add(new Coin(23 * 70, 14 * 70));
	objectives.add(new Coin(37 * 70, 4 * 70));
	objectives.add(new Coin(18 * 70, 4 * 70));
	objectives.add(new Key(4 * 70, 4 * 70));

	// setup music (si rien, on garde la m�me musique qu'au niveau d'avant)
	// musiclvl = new Music("ressources/audio/music/lvl1.ogg");

	initialisationSuite();

    }

}