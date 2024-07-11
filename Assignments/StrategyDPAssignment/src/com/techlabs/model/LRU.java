package com.techlabs.model;

public class LRU implements IEvectionStrategy {
    @Override
    public void evict(MemoryMap memoryMap) {
        if (!memoryMap.getAccessOrder().isEmpty()) {
            String lruElement = memoryMap.getAccessOrder().pollFirst();
            memoryMap.getMemoryMap().remove(lruElement);
            memoryMap.getInsertionOrder().remove(lruElement);
        }
    }
}
