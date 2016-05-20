package ch.hearc.p2.game.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainScreenGameState extends BasicGameState {

    public static final int ID = 0;
    private Image background;
    private Image jouer;
    private Image niveaux;
    private Image options;
    private Image credits;
    private Image quitter;
    private Image cursor;
    private StateBasedGame game;
    private Music sound;

    public MainScreenGameState() {
	super();
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");
	jouer = new Image("ressources/menu/jouer.png");
	niveaux = new Image("ressources/menu/niveaux.png");
	options = new Image("ressources/menu/options.png");
	credits = new Image("ressources/menu/credits.png");
	quitter = new Image("ressources/menu/quitter.png");

	sound = new Music("ressources/audio/music/home.ogg");

    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);
	sound.loop();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	// rien
    }

    /**
     * Contenons nous d'afficher l'image de fond. Le text est plac�
     * approximativement au centre.
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	background.draw(0, 0, container.getWidth(), container.getHeight());
	g.drawImage(jouer, container.getWidth() / 2 - 200, 250);
	g.drawImage(niveaux, container.getWidth() / 2 - 200, 400);
	g.drawImage(options, container.getWidth() / 2 - 200, 550);
	g.drawImage(credits, container.getWidth() / 2 - 200, 700);
	g.drawImage(quitter, container.getWidth() / 2 - 200, 850);

    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 250 && y < 340) {
	    game.enterState(101, new FadeOutTransition(), new FadeInTransition());
	    // game.enterState(101, new FadeOutTransition(), new
	    // BlobbyTransition(new Color(255,255,255)));
	    // Remove l'ancien state et le replace pour un nouveau pour reset
	    // l'�tat du lvl
	}

	// Menu - niveau
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 400 && y < 490) {
	    game.enterState(11); // TODO Faire game states
	}

	// Menu - options
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 550 && y < 640) {
	    System.exit(0);
	}

	// Menu - credits
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 700 && y < 790) {
	    System.exit(0);
	}

	// Menu - quitter
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 850 && y < 940) {
	    System.exit(0);
	}
    }

    /**
     * L'identifiant permet d'identifier les diff�rentes boucles. Pour passer de
     * l'une � l'autre.
     */
    @Override
    public int getID() {
	return ID;
    }

}