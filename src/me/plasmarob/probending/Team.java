package me.plasmarob.probending;

import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.md_5.bungee.api.ChatColor;

public class Team {
	
	private static ConcurrentHashMap<String, Team> teamList = new ConcurrentHashMap<String, Team>();
	
	private Player earthbender = null;
	private Player firebender = null;
	private Player waterbender = null;
	private String teamName;
	private Color color;
	
	public Player getEarthbender() {return earthbender;}
	public Player getFirebender() {return firebender;}
	public Player getWaterbender() {return waterbender;}
	public void setEarthbender(Player earthbender) {this.earthbender = earthbender;}
	public void setFirebender(Player firebender) {this.firebender = firebender;}
	public void setWaterbender(Player waterbender) {this.waterbender = waterbender;}

	public String getName() {return teamName;}
	public void setName(String name) {this.teamName = name;}
	
	
	Team(CommandSender cs, String name) {
		if (exists(name)) {
			cs.sendMessage(ChatColor.RED + "A team with this name already exists!");
		}
		this.teamName = name;
		color = Color.WHITE; //Color.fromRGB(255, 0, 0)
		teamList.put(name, this);
		cs.sendMessage("Team " + name + " created!");
	}
	
	// g 99c160
	// r ca744c
	// b 949eb1
	
	// Fire Ferrets - 962c1f, fad5b5 
	// Rabbaroo - a58d76, ffd7b7
	// Boarqpines - 949c7b, d7ac7a
	// Buzzardwasp - ae8356, 583d32
	// Wolfbats - 412f28, 694f40
	
	public void trySetColor(Player p, String colorStr) {
		if (colorStr.length() == 6 && colorStr.matches("[0-9a-fA-F]+")) {
			setColor(colorStr);
			giveUniforms();
		} else if (colorStr.matches("[0-9]+")) {
			try {
				int colorInt = Integer.parseInt(colorStr);
				setColor(colorInt);
				giveUniforms();
			} catch (Exception e) {
				p.sendMessage(ChatColor.RED + "Invalid color.");
			}
		}	
	}
	public void setColor(String hexColor) {
		color = Color.fromRGB(
			Integer.valueOf( hexColor.substring( 0, 2 ), 16 ),
			Integer.valueOf( hexColor.substring( 2, 4 ), 16 ),
			Integer.valueOf( hexColor.substring( 4, 6 ), 16 )
			);
	}
	public void setColor(int numColor) {
		color = Color.fromRGB(numColor);
	}
	public void setColor(int red, int green, int blue) {
		color = Color.fromRGB(red,green,blue);
	}
	
	public void setArmor(Player p) {
		ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestmeta = (LeatherArmorMeta)chest.getItemMeta();
		chestmeta.setColor(color);
		chestmeta.spigot().setUnbreakable(true);
		chestmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		chestmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chest.setItemMeta(chestmeta);
        
        ItemStack helm = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta helmmeta = (LeatherArmorMeta)helm.getItemMeta();
		helmmeta.setColor(color);
		helmmeta.spigot().setUnbreakable(true);
		helmmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		helmmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		helm.setItemMeta(helmmeta);
		
		ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta legsmeta = (LeatherArmorMeta)legs.getItemMeta();
		legsmeta.setColor(color);
		legsmeta.spigot().setUnbreakable(true);
		legsmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		legsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		legs.setItemMeta(legsmeta);
		
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bootmeta = (LeatherArmorMeta)boots.getItemMeta();
		bootmeta.setColor(color);
		bootmeta.spigot().setUnbreakable(true);
		bootmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		bootmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		boots.setItemMeta(bootmeta);
        
        p.getEquipment().setHelmet(helm);
        p.getEquipment().setChestplate(chest);
        p.getEquipment().setLeggings(legs);
        p.getEquipment().setBoots(boots);
	}
	public void giveUniforms() {
		
		if (earthbender != null) {
			if(earthbender.getInventory().getHelmet() != null) earthbender.getInventory().addItem(earthbender.getInventory().getHelmet());
			if(earthbender.getInventory().getChestplate() != null) earthbender.getInventory().addItem(earthbender.getInventory().getChestplate());
			if(earthbender.getInventory().getLeggings() != null) earthbender.getInventory().addItem(earthbender.getInventory().getLeggings());
			if(earthbender.getInventory().getBoots() != null) earthbender.getInventory().addItem(earthbender.getInventory().getBoots());
			setArmor(earthbender);
		}
		
		if (firebender != null) {
			if(firebender.getInventory().getHelmet() != null) firebender.getInventory().addItem(firebender.getInventory().getHelmet());
			if(firebender.getInventory().getChestplate() != null) firebender.getInventory().addItem(firebender.getInventory().getChestplate());
			if(firebender.getInventory().getLeggings() != null) firebender.getInventory().addItem(firebender.getInventory().getLeggings());
			if (firebender.getInventory().getBoots() != null) firebender.getInventory().addItem(firebender.getInventory().getBoots());
			setArmor(firebender);
		}
		if (waterbender != null) {
			if(waterbender.getInventory().getHelmet() != null) waterbender.getInventory().addItem(waterbender.getInventory().getHelmet());
			if(waterbender.getInventory().getChestplate() != null) waterbender.getInventory().addItem(waterbender.getInventory().getChestplate());
			if(waterbender.getInventory().getLeggings() != null) waterbender.getInventory().addItem(waterbender.getInventory().getLeggings());
			if(waterbender.getInventory().getBoots() != null) waterbender.getInventory().addItem(waterbender.getInventory().getBoots());
			setArmor(waterbender);
		}
		
	}
	
	
	
	public void tryJoin(Player p, String position) {
		position = position.toLowerCase();
		if (position.equals("earth"))
			if (earthbender == null) {
				unassignPlayer(p);
				earthbender = p;
				p.sendMessage("You are now an earthbender for " + teamName + "!");
			} else
				p.sendMessage("That position is already taken by " + earthbender.getName());
		if (position.equals("fire"))
			if (firebender == null) {
				unassignPlayer(p);
				firebender = p;
				p.sendMessage("You are now a firebender for " + teamName + "!");
			} else
				p.sendMessage("That position is already taken by " + firebender.getName());
		if (position.equals("water"))
			if (waterbender == null) {
				unassignPlayer(p);
				waterbender = p;
				p.sendMessage("You are now a waterbender for " + teamName + "!");
			} else
				p.sendMessage("That position is already taken by " + waterbender.getName());
		
		
	}
	
	
	
	public boolean removePlayer(Player p) {
		if (p.equals(earthbender)) {
			earthbender = null;
			return true;
		} else if (p.equals(firebender)) {
			firebender = null;
			return true;
		} else if (p.equals(waterbender)) {
			waterbender = null;
			return true;
		}
		return false;
	}
	
	public static boolean unassignPlayer(Player p) {
		for (String s : teamList.keySet()) {
			Team t = teamList.get(s);
			if (p.equals(t.getEarthbender())) {
				t.setEarthbender(null);
				return true;
			} else if (p.equals(t.getFirebender())) {
				t.setFirebender(null);
				return true;
			} else if (p.equals(t.getWaterbender())) {
				t.setWaterbender(null);
				return true;
			}
		}
		return false;
	}
	
	public static Team getPlayerTeam(Player p) {
		for (String s : teamList.keySet()) {
			Team t = teamList.get(s);
			if (p.equals(t.getEarthbender())
				|| p.equals(t.getFirebender())
				|| p.equals(t.getWaterbender())) {
				return t;
			}
		}
		return null;
	}
	
	public static void getTeams(CommandSender cs) {
		for (String s : teamList.keySet()) {
			cs.sendMessage(s);
		}
	}
	public static Team getTeam(String name) {
		if (teamList.containsKey(name)) 
			return teamList.get(name);
		else
			return null;
	}
	
	public static boolean exists(String teamName) {return teamList.containsKey(teamName);}
	
	public static void getRoster(CommandSender cs) {
		cs.sendMessage("Water:" + " ");
	}
	public static void getRoster(CommandSender cs, String team) {
		if (!teamList.containsKey(team))
			cs.sendMessage("No team with this name exists.");
		Team t = teamList.get(team);
		
		String earth = "";
		String fire = "";
		String water = "";
		if (t.earthbender != null) earth = t.earthbender.getName();
		if (t.firebender != null) fire = t.firebender.getName();
		if (t.waterbender != null) water = t.waterbender.getName();
		cs.sendMessage("Earth:" + earth);
		cs.sendMessage(" Fire:" + fire);
		cs.sendMessage("Water:" + water);
	}
}
