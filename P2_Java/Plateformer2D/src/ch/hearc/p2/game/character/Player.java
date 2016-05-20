package ch.hearc.p2.game.character;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import ch.hearc.p2.game.enums.Facing;
import ch.hearc.p2.game.level.LevelObject;
import ch.hearc.p2.game.physics.AABoundingRect;
import ch.hearc.p2.game.projectile.Projectile;
import ch.hearc.p2.game.weapon.Weapon;

public class Player extends Character {

    private List<LevelObject> toAddList = new LinkedList<LevelObject>();
    private Weapon weapon;
    private int point;
    private boolean key;
    private Sound jump;
    private HashMap<Facing, Image> jumpSprite;
    private long damage1;
    private long damage2;
   

    public Player(float x, float y) throws SlickException {
	super(x, y);
	damage1 = System.currentTimeMillis();
	damage2 = System.currentTimeMillis();
	
	point = 0;
	key = false;
	sprites = setSprite(
		new Image("ressources/character/player/blue/p2_stand.png"),
		sprites);
	movingAnimations = setMovingAnimation(
		new Image[] {
			new Image(
				"ressources/character/player/blue/p2_walk01.png"),
			new Image(
				"ressources/character/player/blue/p2_walk02.png"),
			new Image(
				"ressources/character/player/blue/p2_walk03.png"),
			new Image(
				"ressources/character/player/blue/p2_walk04.png"),
			new Image(
				"ressources/character/player/blue/p2_walk05.png"),
			new Image(
				"ressources/character/player/blue/p2_walk06.png"),
			new Image(
				"ressources/character/player/blue/p2_walk07.png"),
			new Image(
				"ressources/character/player/blue/p2_walk08.png"),
			new Image(
				"ressources/character/player/blue/p2_walk09.png"),
			new Image(
				"ressources/character/player/blue/p2_walk10.png"),
			new Image(
				"ressources/character/player/blue/p2_walk11.png")},
		50, movingAnimations);
	
	jumpSprite = setSprite(
		new Image("ressources/character/player/blue/p2_jump.png"), jumpSprite);
	hitedSprites = setSprite(new Image("ressources/character/player/blue/p2_stand.png"), hitedSprites); //image par d�faut

	boundingShape = new AABoundingRect(x, y, 60, 90);

	accelerationSpeed = 0.002f;
	maximumSpeed = 0.55f;
	maximumFallSpeed = 0.6f;
	decelerationSpeed = 0.002f;
	life = 6;
	weapon = new Weapon(0, 0, 100);
	jump = new Sound("ressources/audio/sound/jump.ogg");
    }

    public void updateBoundingShape() {
	boundingShape.updatePosition(x+5, y+2);
	weapon.setPlayerFacing(this.facing);
    }

    public void shoot(int mouseX, int mouseY) throws SlickException {

	float velocityX = (float) 0.12;
	float velocityY = (float) 0.12;
	double angle = Math.atan(Math.abs(mouseY - y) / Math.abs(mouseX - x));	
	velocityY *= angle;
	if (mouseX - x < 0) // Clique � gauche du joueur
	{
	    if (mouseY - y < 0) // Clique en dessous du joueur
		velocityY *= 1;
	    else
		velocityY *= -1;

	} else // Clique � droite du joueur
	{
	    if (mouseY - y < 0) // Clique en dessous du joueur
		velocityY *= 1;
	    else
		velocityY *= -1;
	}

	weapon.shoot(x, y, mouseX, mouseY);
	this.facing = weapon.getWay();
	weapon.setPlayerFacing(this.facing);
	
	if (facing == Facing.RIGHT && (Math.abs(x_velocity) < x_velocity  + 2*velocityX))
	    x_velocity -= velocityX/2;
	else if(facing == Facing.LEFT && Math.abs(x_velocity) < x_velocity  + 2*velocityX)
	    x_velocity += velocityX/2;
	if(Math.abs(y_velocity) < velocityY *2)
		y_velocity = velocityY;
    }

    public List<LevelObject> getToAddList() {
	return toAddList;
    }

    public void clearList() {
	toAddList.clear();
    }

    public Weapon getWeapon() {
	return weapon;
    }

    public void setWeapon(Weapon weapon) {
	this.weapon = weapon;
    }

    public void addPoint(int i) {
	point += i;
    }

    public void setPoint(int i) {
	point = i;
    }

    public int getPoint() {
	return point;
    }

    public void jump() {
	if (onGround){
	    y_velocity = -1f;
	    jump.play(1, (float) 0.5);
	}
	
    }
    
    public void setKey(boolean key)
    {
	this.key = key;
    }
    
    public boolean hasKey()
    {
	return key;
    }
    
    public void render(int offset_x, int offset_y) {

   	time1 = System.currentTimeMillis();
   	damage1 = System.currentTimeMillis();
   	
   	if (dead == false && hited == false) {
   	    if (movingAnimations != null && moving && onGround == true) {
   		movingAnimations.get(facing).draw(x - offset_x, y - offset_y);
   	    } else if(movingAnimations != null && onGround == false){
   		jumpSprite.get(facing).draw(x - offset_x, y - offset_y);
   	    }
   	    else{
   		sprites.get(facing).draw(x - offset_x, y - offset_y);
   	    }
   	} else if(hited == true && dead == false)
   	{
   	    
   	    if (hitedMovingAnimations != null && moving) {
   		hitedMovingAnimations.get(facing).draw(x - offset_x, y - offset_y);
   	    } else {
   		hitedSprites.get(facing).draw(x - offset_x, y - offset_y);
   	    }   
   	    if(time1 - time2 > 50)
   		    hited = false;
   	}
   	else
   	    deadPicture.draw(x -offset_x, y - offset_y);
   	
       }
    public void damage(int value) {
	if(damage1 - damage2 > 500){
	    this.life -= value;
	    damage2 = System.currentTimeMillis();
	}
      }

}