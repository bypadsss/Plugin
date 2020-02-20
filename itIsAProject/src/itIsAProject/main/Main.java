package itIsAProject.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import itIsAProject.command.HealCommand;
import itIsAProject.command.KitCommand;
import itIsAProject.command.RmHealCommand;
import itIsAProject.listener.JoinListener;

public class Main extends JavaPlugin{
	
	private static Main plugin;
	
    //onEnable wird beim Start des Plugins geladen
	
	public void onEnable() {
		
		plugin = this;
	
		//der Command wird hier initialisiert und "erstellt"
	
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("removeheal").setExecutor(new RmHealCommand());
		getCommand("kit").setExecutor(new KitCommand());
		
		//registriert den PluginManager für Events
		
		PluginManager pmanager = Bukkit.getPluginManager();
		//JoinListener (event) wird initialisiert
		
		pmanager.registerEvents(new JoinListener(), this);
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
