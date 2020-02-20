package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import itIsAProject.main.Main;

public class SpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.spawn")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(config.getString("Spawn.World"));
					double x = config.getDouble("Spawn.X");
					double y = config.getDouble("Spawn.Y");
					double z = config.getDouble("Spawn.Z");
					float yaw = (float) config.getDouble("Spawn.Yaw");
					float pitch = (float) config.getDouble("Spawn.Pitch");
					Location loc = new Location(world, x, y, z, yaw, pitch);
					player.teleport(loc);
					
				}else
					player.sendMessage("§cPls use §6/spawn§c!");
			}else
				player.sendMessage("§cYou are not allowed to do this!");
		}else
			sender.sendMessage("This Command just makes sense as Player!");
		return false;
	}

}
