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

package me.asu.impl;

import java.util.Iterator;
import me.asu.Cache;

/**
 * 无缓存实现，用于快速关闭缓存
 * 
 * @param <K> 键类型
 * @param <V> 值类型
 * @author Looly,jodd
 */
public class NoCache<K, V> implements Cache<K, V> {

	@Override
	public int capacity() {
		return 0;
	}

	@Override
	public long timeout() {
		return 0;
	}

	@Override
	public void put(K key, V object) {
		// 跳过
	}

	@Override
	public void put(K key, V object, long timeout) {
		// 跳过
	}

	@Override
	public boolean containsKey(K key) {
		return false;
	}

	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public V get(K key, boolean isUpdateLastAccess) {
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		return null;
	}
	
	@Override
	public Iterator<CacheObj<K, V>> cacheObjIterator() {
		return null;
	}

	@Override
	public int prune() {
		return 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void remove(K key) {
		// 跳过
	}

	@Override
	public void clear() {
		// 跳过
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
