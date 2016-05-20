package ch.hearc.p2.game.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LevelScreen1GameState extends BasicGameState {

    public static final int ID = 11;
    private Image background;
    private Image niveau1;
    private Image niveau2;
    private Image niveau3;
    private Image niveau4;
    private Image niveau5;
    private Image niveau6;
    private Image niveau7;
    private Image niveau8;
    private Image niveau9;
    private Image niveau10;
    private Image suivant;
    private Image retour;
    private Image cursor;

    private StateBasedGame game;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	suivant = new Image("ressources/menu/suivant.jpg");
	retour = new Image("ressources/menu/retour.jpg");
	niveau1 = new Image("ressources/menu/niveaux/niveau1.jpg");
	niveau2 = new Image("ressources/menu/niveaux/niveau2.jpg");
	niveau3 = new Image("ressources/menu/niveaux/niveau3.jpg");
	niveau4 = new Image("ressources/menu/niveaux/niveau4.jpg");
	niveau5 = new Image("ressources/menu/niveaux/niveau5.jpg");
	niveau6 = new Image("ressources/menu/niveaux/niveau6.jpg");
	niveau7 = new Image("ressources/menu/niveaux/niveau7.jpg");
	niveau8 = new Image("ressources/menu/niveaux/niveau8.jpg");
	niveau9 = new Image("ressources/menu/niveaux/niveau9.jpg");
	niveau10 = new Image("ressources/menu/niveaux/niveau10.jpg");
	cursor = new Image("ressources/cursor/hand_cursor.png");
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	container.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	background.draw(0, 0, container.getWidth(), container.getHeight());
	g.drawImage(niveau1, 550, 300);
	g.drawImage(niveau2, 750, 300);
	g.drawImage(niveau3, 950, 300);
	g.drawImage(niveau4, 1150, 300);
	g.drawImage(niveau5, 1350, 300);
	g.drawImage(niveau6, 550, 480);
	g.drawImage(niveau7, 750, 480);
	g.drawImage(niveau8, 950, 480);
	g.drawImage(niveau9, 1150, 480);
	g.drawImage(niveau10, 1350, 480);
	g.drawImage(retour, 550, 750);
	g.drawImage(suivant, 1030, 750);

    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	if (x > 550 && x < 550 + 80 && y > 300 && y < 380) { // Lvl1
	    game.enterState(101); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 750 && x < 750 + 80 && y > 300 && y < 380) { // Lvl2
	    game.enterState(102); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 950 && x < 950 + 80 && y > 300 && y < 380) { // Lvl3
	    game.enterState(103); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 1150 && x < 1150 + 80 && y > 300 && y < 380) { // Lvl4
	    game.enterState(104); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 1350 && x < 1350 + 80 && y > 300 && y < 380) { // Lvl5
	    game.enterState(105); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 550 && x < 550 + 80 && y > 480 && y < 560) { // Lvl6
	    game.enterState(106); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 750 && x < 750 + 80 && y > 480 && y < 560) { // Lvl7
	    game.enterState(107); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 950 && x < 950 + 80 && y > 480 && y < 560) { // Lvl8
	    game.enterState(108); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 1150 && x < 1150 + 80 && y > 480 && y < 560) { // Lvl9
	    game.enterState(109); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}
	if (x > 1350 && x < 1350 + 80 && y > 480 && y < 560) { // Lvl10
	    game.enterState(110); // Il faudrait mettre les ID correspodnant au
				  // niveau
				  // ou appeler la fonction lvl avec le string
				  // du nom du lvl
	}

	if (x > 550 && x < 550 + 400 && y > 750 && y < 750 + 80) { // RetourAuHome
	    game.enterState(0); // Il faudrait mettre les ID correspodnant au
				// niveau
				// ou appeler la fonction lvl avec le string du
				// nom du lvl
	}
	if (x > 1030 && x < 1030 + 400 && y > 750 && y < 750 + 80) { // Page2desNiveaux
	    game.enterState(12); // Il faudrait mettre les ID correspodnant au
				 // niveau
				 // ou appeler la fonction lvl avec le string du
				 // nom du lvl
	}

    }

    @Override
    public int getID() {
	return ID;
    }

}