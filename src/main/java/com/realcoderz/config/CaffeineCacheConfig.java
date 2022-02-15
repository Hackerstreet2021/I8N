package com.realcoderz.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CaffeineCacheConfig {

    public CacheManager cacheManager() {
	CaffeineCacheManager cacheManager = new CaffeineCacheManager("resources-cache", "languages-cache");
	cacheManager.setCaffeine(caffeineCacheBuilder());
	return cacheManager;
    }

    Caffeine<Object, Object> caffeineCacheBuilder() {
	return Caffeine.newBuilder().initialCapacity(100).maximumSize(500).expireAfterAccess(5, TimeUnit.SECONDS)
		.weakKeys().recordStats();
    }
}