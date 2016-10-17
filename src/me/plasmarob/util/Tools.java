package me.plasmarob.util;

import org.bukkit.entity.Player;

public class Tools {

	static boolean isNaked(Player p) {
		p.getInventory().getArmorContents();
		return false;
	}
}
