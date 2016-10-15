package me.plasmarob.probending;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ProbendCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command command, String commandLabel, String[] args) {
		
		if(args[0].toLowerCase().equals("help")) {
			cs.sendMessage("Hello!");
		}
		
		return false;
	}

}
