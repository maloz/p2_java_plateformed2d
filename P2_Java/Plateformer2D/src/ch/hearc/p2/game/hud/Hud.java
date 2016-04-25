package ch.hearc.p2.game.hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.character.Player;

public class Hud {

	private Image[] life;

	public void init() throws SlickException {
		this.life = new Image[3];
		life[0] = new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/HUD/hudHeart_full.png");
		life[1] = new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/HUD/hudHeart_half.png");
		life[2] = new Image("ressources/map/tuiles/platformer-pack-redux-360-assets/PNG/HUD/hudHeart_empty.png");
	}

	public void render(Graphics g, Player p) {
		g.resetTransform();

		switch (p.getLife()) {
		case 6:
			g.drawImage(life[0], 20, 20);
			g.drawImage(life[0], 148, 20);
			g.drawImage(life[0], 286, 20);
			break;
		case 5:
			g.drawImage(life[0], 20, 20);
			g.drawImage(life[0], 148, 20);
			g.drawImage(life[1], 286, 20);
			break;
		case 4:
			g.drawImage(life[0], 20, 20);
			g.drawImage(life[0], 148, 20);
			g.drawImage(life[2], 286, 20);
			break;
		case 3:
			g.drawImage(life[0], 20, 20);
			g.drawImage(life[1], 148, 20);
			g.drawImage(life[2], 286, 20);
			break;
		case 2:
			g.drawImage(life[0], 20, 20);
			g.drawImage(life[2], 148, 20);
			g.drawImage(life[2], 286, 20);
			break;
		case 1:
			g.drawImage(life[1], 20, 20);
			g.drawImage(life[2], 148, 20);
			g.drawImage(life[2], 286, 20);
			break;
		case 0:
			g.drawImage(life[2], 20, 20);
			g.drawImage(life[2], 148, 20);
			g.drawImage(life[2], 286, 20);
			break;
		default:
			break;

		}
		// g.drawImage(playerbars, 20, 20);
	}

}