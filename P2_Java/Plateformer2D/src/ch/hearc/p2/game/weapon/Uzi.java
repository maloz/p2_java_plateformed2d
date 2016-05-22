package ch.hearc.p2.game.weapon;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import ch.hearc.p2.game.enums.Facing;
import ch.hearc.p2.game.projectile.ProjectilePlayer;

public class Uzi extends Weapon {

    public Uzi(float x, float y) throws SlickException {
	super(x, y);
	munition = 3000;
	cadence = 120;

	tir = new Sound("ressources/audio/sound/shoot.ogg");
	arme = new Image("ressources/tiles/item/raygunBig.png");
    }

    public void shoot(float playerX, float playerY, int mouseX, int mouseY) throws SlickException {
	if (munition > 0) {
	    // Calcul de la v�locit� X et Y
	    float velocityX = 3.5f;
	    float velocityY = 3.5f;

	    double angle = Math.atan(Math.abs(mouseY - playerY) / Math.abs(mouseX - playerX));
	    angle += Math.toRadians(random.nextInt(5));
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
	    if (way == Facing.RIGHT) {
		toAddList.add(new ProjectilePlayer(x + 50, y + 30, velocityX, velocityY));
		toAddList.add(new ProjectilePlayer(x + 50, y + 30, velocityX, (float) (velocityY + Math.toRadians(7))));
		toAddList
			.add(new ProjectilePlayer(x + 50, y + 30, velocityX, (float) (velocityY + Math.toRadians(-7))));
		toAddList.add(new MuzzleFlash(x + 40, y + 10));
	    } else {
		toAddList.add(new ProjectilePlayer(x - 90, y + 30, velocityX, velocityY));
		toAddList.add(new ProjectilePlayer(x - 90, y + 30, velocityX, (float) (velocityY + Math.toRadians(7))));
		toAddList
			.add(new ProjectilePlayer(x - 90, y + 30, velocityX, (float) (velocityY + Math.toRadians(-7))));
		toAddList.add(new MuzzleFlash(x - 85, y + 10));
	    }

	    munition -= 3;

	    tir.play();

	}
    }
}
