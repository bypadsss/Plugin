package itIsAProject.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	//event
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent jevent){
		Player player = jevent.getPlayer();
		jevent.setJoinMessage("§aThe Player §c" + jevent.getPlayer().getName() + " §ahas joined!");
		
		player.sendMessage("§6Welcome to our Server! We are proud that you joined us §a" + player.getName() + " §6!");
		
	}

}
