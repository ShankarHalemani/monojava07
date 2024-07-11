package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//LFU - LEAST FREQUENTLY USED

public class LFU implements IEvectionStrategy {
    @Override
    public void evict(MemoryMap memoryMap) {
        int minValue = Integer.MAX_VALUE;
        String lfuElement;
        List<String> candidates = new ArrayList<>();

//        Candidates list keeps track of one element with the least frequency,
//        or it keeps track of two or more elements with same frequency
        for (Map.Entry<String, Integer> entry : memoryMap.getMemoryMap().entrySet()) {
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                candidates.clear();
                candidates.add(entry.getKey());
            }
            if (entry.getValue() == minValue) {
                candidates.add(entry.getKey());
            }
        }

//        If there is only one element in candidate list then that is lfu element
        lfuElement = candidates.get(0);

//        if there are more than one elements in candidate list and the third element has higher frequency
//        than those two in candidate list then we need to use fifo to remove element not that third element with
//        higher frequency will not be in candidate list
        if (candidates.size() > 1) {
            for (String candidate : memoryMap.getInsertionOrder()) {
                if (candidates.contains(candidate)) {
                    lfuElement = candidate;
                    break;
                }
            }
        }

        if (lfuElement != null) {
            memoryMap.getMemoryMap().remove(lfuElement);
            memoryMap.getInsertionOrder().remove(lfuElement);
            memoryMap.getAccessOrder().remove(lfuElement);
        }
    }
}
