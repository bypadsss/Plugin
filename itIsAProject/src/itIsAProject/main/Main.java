package itIsAProject.main;

import org.bukkit.plugin.java.JavaPlugin;

import itIsAProject.command.HealCommand;
import itIsAProject.command.RmHealCommand;

public class Main extends JavaPlugin{
    //onEnable wird beim Start des Plugins geladen
	public void onEnable() {
		//der Command wird hier initialisiert und "erstellt"
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("removeheal").setExecutor(new RmHealCommand());
		
	}
}
