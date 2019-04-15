/*
 * Copyright (C) 2017 Bruce Asu<bruceasu@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *  　　
 * 　　The above copyright notice and this permission notice shall
 * be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package me.asu;

import me.asu.impl.FIFOCache;
import me.asu.impl.LFUCache;
import me.asu.impl.LRUCache;
import me.asu.impl.NoCache;
import me.asu.impl.TimedCache;
import me.asu.impl.WeakCache;

/**
 * 缓存工具类
 * @author Looly
 *@since 3.0.1
 */
public class CacheUtil {
	
	/**
	 * 创建FIFO(first in first out) 先进先出缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link FIFOCache}
	 */
	public static <K, V> FIFOCache<K, V> newFIFOCache(int capacity, long timeout){
		return new FIFOCache<K, V>(capacity, timeout);
	}
	
	/**
	 * 创建FIFO(first in first out) 先进先出缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @return {@link FIFOCache}
	 */
	public static <K, V> FIFOCache<K, V> newFIFOCache(int capacity){
		return new FIFOCache<K, V>(capacity);
	}
	
	/**
	 * 创建LFU(least frequently used) 最少使用率缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link LFUCache}
	 */
	public static <K, V> LFUCache<K, V> newLFUCache(int capacity, long timeout){
		return new LFUCache<K, V>(capacity, timeout);
	}
	
	/**
	 * 创建LFU(least frequently used) 最少使用率缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @return {@link LFUCache}
	 */
	public static <K, V> LFUCache<K, V> newLFUCache(int capacity){
		return new LFUCache<K, V>(capacity);
	}
	
	
	/**
	 * 创建LRU (least recently used)最近最久未使用缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link LRUCache}
	 */
	public static <K, V> LRUCache<K, V> newLRUCache(int capacity, long timeout){
		return new LRUCache<K, V>(capacity, timeout);
	}
	
	/**
	 * 创建LRU (least recently used)最近最久未使用缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param capacity 容量
	 * @return {@link LRUCache}
	 */
	public static <K, V> LRUCache<K, V> newLRUCache(int capacity){
		return new LRUCache<K, V>(capacity);
	}
	
	/**
	 * 创建定时缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link TimedCache}
	 */
	public static <K, V> TimedCache<K, V> newTimedCache(long timeout){
		return new TimedCache<K, V>(timeout);
	}
	
	/**
	 * 创建若引用缓存.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @param timeout 过期时长，单位：毫秒
	 * @return {@link WeakCache}
	 * @since 3.0.7
	 */
	public static <K, V> WeakCache<K, V> newWeakCache(long timeout){
		return new WeakCache<K, V>(timeout);
	}
	
	/**
	 * 创建无缓存实现.
	 * 
	 * @param <K> Key类型
	 * @param <V> Value类型
	 * @return {@link NoCache}
	 */
	public static <K, V> NoCache<K, V> newNoCache(){
		return new NoCache<K, V>();
	}
	
}
