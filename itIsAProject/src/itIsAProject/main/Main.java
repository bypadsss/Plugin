package itIsAProject.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import itIsAProject.command.HealCommand;
import itIsAProject.command.KitCommand;
import itIsAProject.command.RmHealCommand;
import itIsAProject.command.SetSpawnCommand;
import itIsAProject.listener.JoinListener;
import itIsAProject.listener.RespawnListener;

public class Main extends JavaPlugin{
	
	private static Main plugin;
	
    //onEnable wird beim Start des Plugins geladen
	
	public void onEnable() {
		
		plugin = this;
	
		//der Command wird hier initialisiert und "erstellt"
	
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("removeheal").setExecutor(new RmHealCommand());
		getCommand("kit").setExecutor(new KitCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		
		//registriert den PluginManager für Events
		
		PluginManager pmanager = Bukkit.getPluginManager();
		//JoinListener (event) wird initialisiert
		
		pmanager.registerEvents(new JoinListener(), this);
		pmanager.registerEvents(new RespawnListener(), this);
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
