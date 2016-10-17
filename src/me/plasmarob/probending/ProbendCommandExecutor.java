package me.plasmarob.probending;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ProbendCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command command, String commandLabel, String[] args) {
		
		String arg0 = null;
		String arg1 = null;
		//String arg3 = null;
		//String arg4 = null;
		//String arg5 = null;
		//String arg6 = null;
		int len = args.length;
		
		if (len < 1) {
			return false;
		}
		arg0 = args[0].toLowerCase();
		
		if (len >= 2)
			arg1 = args[1].toLowerCase();

		
		if(arg0.equals("help")) {
			cs.sendMessage("Hello!");
		}
		if(arg0.equals("team")) {
			if (len >= 2 && arg1.equals("list")) {
				Team.getTeams(cs);
			}
			if (len >= 2 && arg1.equals("color")) {
				if (cs instanceof Player) {
					Team t = Team.getPlayerTeam((Player)cs);
					if (t != null) {
						if (len == 3) {
							t.trySetColor((Player)cs, args[2]);
						} else if (len == 5) {
							try {
								int r = Integer.parseInt(args[2]);
								int g = Integer.parseInt(args[3]);
								int b = Integer.parseInt(args[4]);
								t.setColor(r,g,b);
								t.giveUniforms();
							} catch (Exception e) {
								cs.sendMessage(ChatColor.RED + "Invalid Color.");
							}
						} else {
							cs.sendMessage(ChatColor.RED + "Invalid Color.");
						}
					} else {
						cs.sendMessage(ChatColor.RED + "You are not on a team.");
					}
				} else {
					cs.sendMessage("Only players on a team can run this command.");
				}
			}
			if (len >= 2 && arg1.equals("uniform")) {
				if (cs instanceof Player) {
					Team t = Team.getPlayerTeam((Player)cs);
					if (t != null) {
						t.giveUniforms();
					} else {
						cs.sendMessage(ChatColor.RED + "You are not on a team.");
					}
				} else {
					cs.sendMessage("Only players on a team can run this command.");
				}
			}
			if (len >= 3 && arg1.equals("create")) {
				// TODO: handle creation via console
				if (cs instanceof Player) {
					String name = args[2];
					new Team(cs, name);
				}
			}
			if (cs instanceof Player && len >= 4 && arg1.equals("join")) {
				String team = args[2];
				String position = args[3];
				if (Team.exists(team))
					Team.getTeam(team).tryJoin((Player)cs, position);	
				else
					cs.sendMessage("No team exists by that name.");
			}
			
		}
		
		
		return false;
	}

}
