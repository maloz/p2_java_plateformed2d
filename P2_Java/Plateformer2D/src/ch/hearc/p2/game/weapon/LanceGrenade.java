package ch.hearc.p2.game.weapon;

import org.newdawn.slick.SlickException;

import ch.hearc.p2.game.enums.Facing;
import ch.hearc.p2.game.projectile.Grenade;

public class LanceGrenade extends Weapon {
    private int munition;

    public LanceGrenade(float x, float y, int mun) throws SlickException {
	super(x, y, mun);
	this.munition = mun;
	// arme = new Image("ressources/tiles/item/raygunBig.png");
	// tir = new Sound("ressources/audio/sound/shoot.ogg");
    }

    public void shoot(float playerX, float playerY, int mouseX, int mouseY) throws SlickException {
	if (this.munition > 0) {
	    float velocityX = 1.5f;
	    float velocityY = 1.5f;

	    double angle = Math.atan(Math.abs(mouseY - playerY) / Math.abs(mouseX - playerX));
	    velocityX *= Math.cos(angle);
	    velocityY *= Math.sin(angle);

	    if (mouseX - playerX < 0) // Clique � gauche du joueur
	    {
		if (mouseY - playerY < 0) // Clique en dessous du joueur
		{
		    velocityY *= -1;

		} else // Clique en dessus du joueur
		{

		}
		velocityX *= -1;

		way = Facing.LEFT;
	    } else // Clique � droite du joueur
	    {
		if (mouseY - playerY < 0) // Clique en dessous du joueur
		{
		    velocityY *= -1;
		} else // Clique en dessus du joueur
		{

		}
		way = Facing.RIGHT;

	    }

	    if (way == Facing.RIGHT)
		toAddList.add(new Grenade(x + 50, y + 30, velocityX, velocityY));
	    else
		toAddList.add(new Grenade(x - 90, y + 30, velocityX, velocityY));
	    this.munition--;

	    tir.play();

	}
    }

    public void clearToAddList() {
	toAddList.clear();
    }

}
