package com.important.problems;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/discuss/interview-experience/5354969/Thoughspot-or-MTS4-or-JUN'24
//TODO: COMPLETED IT , NOT YET DONE
public class MultiLevelCache {

    private int layers;
    private final List<Cache> cacheLayers = new ArrayList<>();

    void addCacheLayers(Cache cache) {
        cacheLayers.add(cache);
    }

    /*Start from L1, keep reading till you find key or reach last layer.
    If the value is found in lower layer, then its value should also be written to all layers above it.*/
    private String get(String key) {

        for (Cache cache : cacheLayers) {
            if (cache.get(key) != null) {
                // element in cache
                var answer = cache.get(key);
                return answer;
            }
        }

        return null;
    }

    //Write at a given level and all level below it
    private void put(String key, String value) {

        for (Cache cache : cacheLayers) {
            cache.put(key, value);
        }
    }
}

abstract class Cache {

    private String name;
    private int capacity;

    Duration evictionTime;

    protected Cache(String name, int capacity, Duration evictionTime) {
        this.name = name;
        this.capacity = capacity;
        this.evictionTime = evictionTime;
    }


    abstract void put(String key, String value);

    abstract String get(String key);

}

class InMemoryCache extends Cache {

    Map<String, String> cacheValues = new HashMap<>();

    InMemoryCache(String name, int capacity, Duration evictionTime) {
        super(name, capacity, evictionTime);
    }

    @Override
    void put(String key, String value) {
        cacheValues.put(key, value);
    }

    @Override
    String get(String key) {
        return cacheValues.get(key);

    }
}

class RedisCache extends Cache {

    // Have instance of RedisService here.
    // using hashmap just for testing

    RedisCache(String name, int capacity, Duration evictionTime) {
        super(name, capacity, evictionTime);
    }

    Map<String, String> redisValues = new HashMap<>();

    @Override
    void put(String key, String value) {
        redisValues.put(key, value);
    }

    @Override
    String get(String key) {
        return redisValues.get(key);
    }
}






