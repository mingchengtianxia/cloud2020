package com.soundSystem;

import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    private Map<Integer, Integer> trackCounters = new HashMap<>();

    public void countTrack(int trackNumer){
        int currentCount = getPlayCount(trackNumer);
        trackCounters.put(trackNumer, currentCount+1);
    }

    public int getPlayCount(int trackNumber){
        return trackCounters.getOrDefault(trackNumber, 0);
    }
}
