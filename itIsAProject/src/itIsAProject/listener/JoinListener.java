package itIsAProject.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	//event
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent jevent){
		jevent.setJoinMessage("§aThe Player §c" + jevent.getPlayer().getName() + " §ahas joined!");
		
	}

}
