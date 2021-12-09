package com.project.schedule.api.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CustomCacheManager implements CacheManager {
    private final ConcurrentMap<String, Cache> cacheMap;
    private volatile Set<String> cacheNames;

    public CustomCacheManager() {
        this.cacheMap = new ConcurrentHashMap<>();
        this.cacheNames = new HashSet<>();
    }

    @Nullable
    public Cache getCache(String name) {
        return cacheMap.get(name);
    }

    public Collection<String> getCacheNames() { return cacheNames; }

    @Deprecated
    protected final void addCache(Cache cache) {
        cacheMap.put(cache.getName(), cache);
        cacheNames.add(cache.getName());
    }

    public void setCaches(List<ConcurrentMapCache> asList) {
        asList.stream().forEach(concurrentMapCache -> cacheMap.put(concurrentMapCache.getName(), concurrentMapCache));
    }
}
