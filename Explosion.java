package OOPG_Tank_game_Rein;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

public class Explosion extends AnimatedSpriteObject implements IAlarmListener{
	
	private int currentFrame;
	private World world;
	public Explosion(World world) {
		super(new Sprite(World.MEDIA_URL.concat("explosion_strip7.bmp")), 7);
		this.world = world;
		this.currentFrame = 0;
		startAlarm();
		// TODO Auto-generated constructor stub
	}

	private void startAlarm() {
        Alarm alarm = new Alarm("Explosion", 0.5);
        alarm.addTarget(this);
        alarm.start();
        if(currentFrame > 6) {
        	alarm.stop();
        }
    }

    @Override
    public void triggerAlarm(String alarmName) {
    	System.out.println("timer triggered");
        currentFrame++;
        if(currentFrame > 6) {
        	world.deleteGameObject(this);
        }
        startAlarm();
    }

	@Override
	public void update() {
		setCurrentFrameIndex(currentFrame);
		// TODO Auto-generated method stub
		
	}

}
