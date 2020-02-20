package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SendToTheMoon implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.sendtothemoon")) {
				if(args.length == 0) {
					Vector v = player.getVelocity();
					World world = player.getWorld();
					v.setY(5);
					player.setVelocity(v);
					for(int i = 0; i<10; i++) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Location loc = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
						player.spawnParticle(Particle.FIREWORKS_SPARK, loc, 100);
					}
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						World world = target.getWorld();
						Location loc = new Location(world, target.getLocation().getX(), 5000.0, target.getLocation().getZ(), target.getLocation().getYaw(), target.getLocation().getPitch());
						target.teleport(loc);
					}
				}else
					player.sendMessage("§cPls use §6/sendtothemoon§c!");
			}else
				player.sendMessage("§cYou are not allowed to do this!");
		}else
			sender.sendMessage("This Command just makes sense as Player!");
		return false;
	}

}
