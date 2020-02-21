package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendToTheMoon implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.sendtothemoon")) {
				if(args.length == 0) {
					World world = player.getWorld();
					double y = player.getLocation().getY();
					for(int y2 = 0; y2<100; y2++) {
						try {
							Thread.sleep(10);
							Location loc = new Location(world, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
							player.spawnParticle(Particle.LAVA, loc, 100);
							if(y%10 == 0) {
								player.spawnParticle(Particle.EXPLOSION_LARGE, loc, 1);
							}
							y+=1;
							Location loc2 = new Location(world, player.getLocation().getX(), y, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
							player.teleport(loc2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						World world = target.getWorld();
						double y = target.getLocation().getY();
						for(int y2 = 0; y2<100; y2++) {
							try {
								Thread.sleep(10);
								Location loc = new Location(world, target.getLocation().getX(), target.getLocation().getY(), target.getLocation().getZ(), target.getLocation().getYaw(), target.getLocation().getPitch());
								target.spawnParticle(Particle.LAVA, loc, 100);
								if(y%10 == 0) {
									target.spawnParticle(Particle.EXPLOSION_LARGE, loc, 1);
								}
								y+=1;
								Location loc2 = new Location(world, target.getLocation().getX(), y, target.getLocation().getZ(), target.getLocation().getYaw(), target.getLocation().getPitch());
								target.teleport(loc2);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
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
