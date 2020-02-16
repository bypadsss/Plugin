package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RmHealCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.removehealth")) {
				//es müssen Food Level so wie Health Level gesetzt werden deswegen muss args mindestens die Länge 2 haben
				if(args.length == 2) {
					player.setHealth(Integer.parseInt(args[0]));
					player.setFoodLevel(Integer.parseInt(args[1]));
					player.sendMessage("§cYou have sacrificed your self!");
				//falls die Länge 3 ist wurde noch ein Spieler genannt dessen Leben gekürzt werden sollen
				} else if (args.length == 3) {
					Player target = Bukkit.getPlayer(args[2]);
					if(target != null) {
						target.setHealth(Integer.parseInt(args[0]));
						target.setFoodLevel(Integer.parseInt(args[1]));
						target.sendMessage("§c" + player.getDisplayName() + " §chas stolen your health!");
						player.sendMessage("§aYou successfully stole " + target.getDisplayName() + "§a's health!");
					} else
						player.sendMessage("§cThe Player §6" + args[0] + " §cis not online!");
				} else
					player.sendMessage("§cUsage: §6/removeheal <HEALTH TO STEAL> <FOODLEVEL TO STEAL> <PLAYER> §c!");
			} else
				player.sendMessage("§cYou are not allowed to do this!");
		} else 
			sender.sendMessage("This Command just makes sense as Player!");
		return false;
	}

}
