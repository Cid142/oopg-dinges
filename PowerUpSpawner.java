package OOPG_Tank_game_Rein;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;

public class PowerUpSpawner implements IAlarmListener {
	private int[][] locations = { {600, 600}, {100, 100}, {400, 700}, {800, 200} };
	private World world;
	public Health health;
	public int placedObjects;
	private int location;
	public PowerUpSpawner(World world) {
		this.world = world;
		startAlarm();
	}
	
	private void startAlarm() {
        Alarm alarm = new Alarm("Health", 3);
        alarm.addTarget(this);
        alarm.start();
    }
	
	@Override
	public void triggerAlarm(String alarmName) {
		if(placedObjects == 0) {
			health = new Health(this.world, 10);
			world.addGameObject(health, this.locations[location][0], this.locations[location][1]);
			placedObjects++;
			location++;
		}
		if(location>4) {
			location = 0;
		}
		startAlarm();		
	}
}
