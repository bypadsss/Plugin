package itIsAProject.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import itIsAProject.main.Main;


public class SetSpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.setspawn")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Spawn.World", player.getWorld().getName());
					config.set("Spawn.X", player.getLocation().getX());
					config.set("Spawn.Y", player.getLocation().getY());
					config.set("Spawn.Z", player.getLocation().getZ());
					config.set("Spawn.Yaw", player.getLocation().getYaw());
					config.set("Spawn.Pitch", player.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					player.sendMessage("§aYour new Spawnpoint is on your Position!");
				}else
					player.sendMessage("§cPls use §6/setspawn§c!");
			}else
				player.sendMessage("§cHey what did you want to do?");
		}else
			System.out.println("The Command just makes sense as a Player!");
		return false;
	}

}
