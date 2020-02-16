package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor{

	@Override
	//Vorgefertigte Methode um Commandos zu erstellen 
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//Es wird geprüft das nur Spieler sich heilen können denn die für die Koonsole wäre es sinnlos
		if(sender instanceof Player) {
			//Sender wird als Player gecastet
			Player player = (Player) sender;
			//Prüfung ob Spieler das Recht dazu hat
			if(player.hasPermission("beispiel.health")) {
				//im Array args ist alles nach dem Befehl enthalten (z.b. "/heal Beispiel", args[0] = Beispiel )
				//falls in args nichts steht wird der Spieler selber geheilt
				if(args.length == 0) {
					player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage("§aYou now have full health!");
				//falls in args ein Argument ist wird der Spieler der an Stelle args[0] steht geheilt	
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					//wenn der Spieler nicht online ist wäre target null falls dies nicht der Fall ist wird der Spieler geheilt
					if(target != null) {
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage("§aYou now have full health! Thanks to " + player.getDisplayName() + "§a!");
						player.sendMessage("§aYou successfully healed " + target.getDisplayName() + "§a!");
					} else
						player.sendMessage("§cThe Player §6" + args[0] + " §cis not online!");
				} else
					player.sendMessage("§cUsage: §6/heal <PLAYER> §c!");
			} else
				player.sendMessage("§cYou are not allowed to do this!");
		} else 
			sender.sendMessage("This Command just makes sense as Player!");
		return false;
	}
}
