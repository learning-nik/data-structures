package com.important.problems;

import java.time.Duration;

public class TestMultiLevelCache {
       /* {
            "layersCount": 3,
                "cache_Details": [
            {
                "name": "In Memory",
                    "capacity": "100",
                    "evictionTime": "10"
            },
            {
                "name": "Redis",
                    "capacity": "1000",
                    "evictionTime": "20"
            },
            {
                "name": "ElasticSearch"
            }
  ]
        }*/

    // do CacheSetUp

    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache();

        cache.addCacheLayers(new InMemoryCache("In_Memory", 3, Duration.ofMinutes(5)));
        cache.addCacheLayers(new RedisCache("In_Redis", 5, Duration.ofMinutes(15)));



    }

}
