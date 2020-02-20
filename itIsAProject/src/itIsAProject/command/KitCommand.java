package itIsAProject.command;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KitCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("beispiel.kit")) {
				if(args.length == 0) {
					
					Inventory inv = Bukkit.createInventory(null, 9*3, "§a§lSelect your Weapon!");
					
					ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta swordMeta = sword.getItemMeta();
					swordMeta.setDisplayName("§6One Hit Wonder");
					swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 10000, true);
					swordMeta.addEnchant(Enchantment.KNOCKBACK, 1000, true);
					swordMeta.addEnchant(Enchantment.QUICK_CHARGE, 100, true);
					swordMeta.addEnchant(Enchantment.RIPTIDE, 100, true);
					sword.setItemMeta(swordMeta);
					
					inv.setItem(0, sword);
					
					ItemStack stick = new ItemStack(Material.STICK);
					ItemMeta stickMeta = stick.getItemMeta();
					stickMeta.setDisplayName("§6Send to the Moon");
					stickMeta.addEnchant(Enchantment.KNOCKBACK, 10000, true);
					stick.setItemMeta(stickMeta);
					
					inv.setItem(1, stick);
					
					player.openInventory(inv);
					player.sendMessage("§c" + player.getName() + " §ayou can now select your Weapon!");
					
				}else
					player.sendMessage("§cPls use §6/kit§c!");
			}else
				player.sendMessage("§cSTOP! You are not allowed to do this!");
		}else
			System.out.println("This command is just for Players!");
		
		return false;
	}

}
