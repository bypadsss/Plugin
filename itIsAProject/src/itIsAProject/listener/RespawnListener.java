package itIsAProject.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import itIsAProject.main.Main;

public class RespawnListener implements Listener{
	
	@EventHandler
	public void onPlayerDeath(PlayerRespawnEvent revent) {
		
		FileConfiguration config = Main.getPlugin().getConfig();
		World world = Bukkit.getWorld(config.getString("Spawn.World"));
		double x = config.getDouble("Spawn.X");
		double y = config.getDouble("Spawn.Y");
		double z = config.getDouble("Spawn.Z");
		float yaw = (float) config.getDouble("Spawn.Yaw");
		float pitch = (float) config.getDouble("Spawn.Pitch");
		Location loc = new Location(world, x, y, z, yaw, pitch);
		revent.setRespawnLocation(loc);
		
	}

}
