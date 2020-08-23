package me.rynder.commandonjoin;


import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import me.rynder.commandonjoin.listeners.JoinListener;



public class Main extends JavaPlugin{

	private static Main plugin;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		plugin = this;
		
		
		Logger logger = this.getLogger();
		 
        new UpdateChecker(this, 83016).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("There is not a new update available.");
            } else {
                logger.info("There is a new update available.");
            }
        });
		
		new JoinListener(this);
		
	}
	
	
	@Override
	public void onDisable() {



	}
	
	
}
