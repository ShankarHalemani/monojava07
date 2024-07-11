package com.techlabs.creational.singleton.test;

import com.techlabs.creational.singleton.model.DatabaseManager;

public class DatabaseManagerTest {
    public static void main(String[] args) {
        DatabaseManager databaseManager1 = DatabaseManager.getDatabaseManager();
        DatabaseManager databaseManager2 = DatabaseManager.getDatabaseManager();

        System.out.println(databaseManager1.hashCode());
        System.out.println(databaseManager2.hashCode());
    }

}
