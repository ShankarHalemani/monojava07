package com.techlabs.model;

import java.util.Queue;

//FIFO - First In First Out

public class FIFO implements IEvectionStrategy {
    @Override
    public void evict(MemoryMap memoryMap) {
        Queue<String> insertionOrder = memoryMap.getInsertionOrder();
        if (!insertionOrder.isEmpty()) {
            String key = insertionOrder.poll();
            memoryMap.getMemoryMap().remove(key);
            memoryMap.getAccessOrder().remove(key);
        }

    }
}
