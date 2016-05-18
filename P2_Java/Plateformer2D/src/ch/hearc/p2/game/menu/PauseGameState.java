package ch.hearc.p2.game.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import net.java.games.input.Component.Identifier.Button;

public class PauseGameState extends BasicGameState {

    public static final int ID = 50;
    public static int ID_Last;
    private Image background;
    private Image quitter;
    private Image reprendre;
    private StateBasedGame game;
   // private Image cursor;

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	this.game = game;
	this.background = new Image("ressources/background/background.jpg");
	//cursor = new Image("ressources/cursor/hand_cursor.png");
	quitter = new Image("ressources/menu/quitter.png");
	reprendre = new Image("ressources/menu/reprendre.png");
	
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	background.draw(0, 0, container.getWidth(), container.getHeight());
	g.drawImage(quitter, container.getWidth() / 2 - 200, 250);
	g.drawImage(reprendre, container.getWidth() / 2 - 200, 400);
	//container.setMouseCursor(cursor, 0, 0);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 250 && y < 340) {
	    game.enterState(0);
	}

	// Menu - niveau
	if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
		&& y > 400 && y < 490) {
	    game.enterState(ID_Last);
	}
    }


    @Override
    public int getID() {
	return ID;
    }

    public static void setID(int id) {
	ID_Last = id;
    }

}