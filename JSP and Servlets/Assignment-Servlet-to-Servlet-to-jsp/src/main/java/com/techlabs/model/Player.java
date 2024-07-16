package com.techlabs.model;

public class Player {
	private int playerId;
	private String playerName;
	private String playerLevel;

	public Player(int playerId, String playerName, String playerLevel) {

		this.playerId = playerId;
		this.playerName = playerName;
		this.playerLevel = playerLevel;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(String playerLevel) {
		this.playerLevel = playerLevel;
	}

}
