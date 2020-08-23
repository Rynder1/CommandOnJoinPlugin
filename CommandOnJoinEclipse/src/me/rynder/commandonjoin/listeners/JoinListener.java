package me.rynder.commandonjoin.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.rynder.commandonjoin.Main;



public class JoinListener implements Listener{

	public Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {// joining server

		
		List<String> cmds = plugin.getConfig().getStringList("commandList");
				
		for(String cmd : cmds) {
			String newCmd = cmd;
			if(newCmd.contains("%player%")) {
				newCmd = newCmd.replace("%player%", e.getPlayer().getName());
			}
			Bukkit.getServer().dispatchCommand(e.getPlayer(), newCmd);
		}
		

	}
	
}
