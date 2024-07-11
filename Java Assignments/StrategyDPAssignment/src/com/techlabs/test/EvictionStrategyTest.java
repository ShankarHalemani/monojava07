package com.techlabs.test;

import com.techlabs.model.FIFO;
import com.techlabs.model.LFU;
import com.techlabs.model.LRU;
import com.techlabs.model.MemoryMap;

public class EvictionStrategyTest {
    public static void main(String[] args) {
        MemoryMap memoryMap;

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("\nStrategy : FIFO");
        memoryMap = new MemoryMap(new FIFO());
        memoryMap.put("a");
        memoryMap.put("b");
        memoryMap.put("c");

        memoryMap.get("b");
        memoryMap.get("b");
        memoryMap.get("a");
        memoryMap.get("a");
        memoryMap.get("c");
        memoryMap.get("a");

        System.out.println("\nMemory map elements and their frequency before putting new elements\n");
        memoryMap.printMap();

        memoryMap.put("d");

        System.out.println("\nMemory map elements and their frequency after putting new elements\n");
        memoryMap.printMap();

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("\nStrategy : LRU");
        memoryMap = new MemoryMap(new LRU());
        memoryMap.put("a");
        memoryMap.put("b");
        memoryMap.put("c");

        memoryMap.get("b");
        memoryMap.get("b");
        memoryMap.get("a");
        memoryMap.get("a");
        memoryMap.get("c");
        memoryMap.get("a");

        System.out.println("\nRecent access Order : ");
        System.out.println(memoryMap.getAccessOrder());

        System.out.println("\nMemory map elements and their frequency before putting elements\n");
        memoryMap.printMap();

        memoryMap.put("d");

        System.out.println("\nMemory map elements and their frequency after putting elements\n");
        memoryMap.printMap();

        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("\nStrategy : LFU");
        memoryMap = new MemoryMap(new LFU());
        memoryMap.put("a");
        memoryMap.put("b");
        memoryMap.put("c");

        memoryMap.get("b");
        memoryMap.get("b");
        memoryMap.get("a");
        memoryMap.get("a");
        memoryMap.get("c");
        memoryMap.get("a");

        System.out.println("\nMemory map elements and their frequency before putting elements\n");
        memoryMap.printMap();

        memoryMap.put("d");

        System.out.println("\nMemory map elements and their frequency after putting elements\n");
        memoryMap.printMap();


    }
}
