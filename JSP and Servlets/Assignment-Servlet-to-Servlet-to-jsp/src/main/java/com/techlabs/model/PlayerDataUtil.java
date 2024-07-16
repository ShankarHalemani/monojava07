package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerDataUtil {
	public static List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player(1, "Mortal", "Ace"));
		players.add(new Player(2, "Dynamo", "Conquerer"));
		players.add(new Player(3, "Payal", "Diamon"));
		players.add(new Player(4, "GodV", "Gold"));
		players.add(new Player(5, "Inonix", "Ace Dominator"));

		return players;

	}

}
