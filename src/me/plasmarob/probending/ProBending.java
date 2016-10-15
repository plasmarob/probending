package me.plasmarob.probending;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ProBending extends JavaPlugin {
	
	
	@Override
	public void onEnable()
	{
		//----------------------
	  	// Send off valid commands to command executor
		this.getCommand("pb").setExecutor(new ProbendCommandExecutor());
		this.getCommand("probend").setExecutor(new ProbendCommandExecutor());
		
		Bukkit.getConsoleSender().sendMessage("ProBending Loaded!");
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		
		return false;
	}
}
