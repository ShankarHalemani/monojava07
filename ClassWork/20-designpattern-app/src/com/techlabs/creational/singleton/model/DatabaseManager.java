package com.techlabs.creational.singleton.model;

public class DatabaseManager {
    private static DatabaseManager databaseManager;
    private DatabaseManager(){}

    public static DatabaseManager getDatabaseManager() {
        if(databaseManager==null)
            databaseManager=new DatabaseManager();

        return databaseManager;
    }
}
