package ch.hearc.p2.game.weapon;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import ch.hearc.p2.game.enums.Facing;
import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.ProjectilePlayer;

public class Weapon extends LevelObject {

    protected List<LevelObject> toAddList = new LinkedList<LevelObject>();
    protected Image arme;
    private int munition;
    protected Facing way;
    private Facing playerFacing;
    protected Sound tir;
    private Random random;


    public Weapon(float x, float y, int mun) throws SlickException {
	super(x, y);
	way = Facing.LEFT;
	playerFacing = Facing.RIGHT;
	munition = 1000; // remplacer par mun
	x_velocity = 0;
	y_velocity = 0;

	arme = new Image("ressources/tiles/item/raygunBig.png");

	boundingShape = new AABoundingRect(x, y, 0, 0);
	maximumFallSpeed = (float) 0;
	tir = new Sound("ressources/audio/sound/shoot.ogg");
	random = new Random();
    }

    public void render(float offset_x, float offset_y) {
	if (playerFacing == Facing.RIGHT)
	    arme.draw(x - offset_x, y - offset_y);
	else {
	    arme.getFlippedCopy(true, false).draw(x - offset_x - 80, y - offset_y);
	}

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
	    if (way == Facing.RIGHT)
		toAddList.add(new ProjectilePlayer(x + 50, y + 30, velocityX, velocityY));
	    else
		toAddList.add(new ProjectilePlayer(x - 90, y + 30, velocityX, velocityY));

	    munition--;

	    tir.play();

	}
    }

    public List<LevelObject> getToAddList() {
	return toAddList;
    }

    public void clearToAddList() {
	toAddList.clear();
    }

    public int getMunition() {
	return munition;
    }

    public Facing getWay() {
	return way;
    }

    public void setPlayerFacing(Facing facing) {
	playerFacing = facing;
    }

}
