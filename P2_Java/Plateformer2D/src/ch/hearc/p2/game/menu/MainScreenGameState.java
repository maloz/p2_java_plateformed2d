package ch.hearc.p2.game.menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreenGameState extends BasicGameState {

	public static final int ID = 1;
	private Image background;
	private StateBasedGame game;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		this.background = new Image("background.jpg");
	}

	/**
	 * Contenons nous d'afficher l'image de fond. Le text est plac�
	 * approximativement au centre.
	 */

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0, 0, container.getWidth(), container.getHeight());

		Image jouer = new Image("ressources/menu/jouer.png");
		g.drawImage(jouer, container.getWidth() / 2 - 200, 250);

		Image niveaux = new Image("ressources/menu/niveaux.png");
		g.drawImage(niveaux, container.getWidth() / 2 - 200, 400);

		Image options = new Image("ressources/menu/options.png");
		g.drawImage(options, container.getWidth() / 2 - 200, 550);

		Image credits = new Image("ressources/menu/credits.png");
		g.drawImage(credits, container.getWidth() / 2 - 200, 700);

	}

	/**
	 * Passer � l��cran de jeu � l'appui de n'importe quel touche.
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (x > this.game.getContainer().getWidth() / 2 - 200 && x < this.game.getContainer().getWidth() / 2 + 200
				&& y > 250 && y < 340) {
			game.enterState(0);
			// Remove l'ancien state et le replace pour un nouveau pour reset
			// l'�tat du lvl
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