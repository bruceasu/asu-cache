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
import java.util.NoSuchElementException;

/**
 * {@link cn.hutool.cache.impl.AbstractCache} 的CacheObj迭代器.
 * 
 * @author looly
 *
 * @param <K> 键类型
 * @param <V> 值类型
 * @since 4.0.10
 */
public class CacheObjIterator<K, V> implements Iterator<CacheObj<K, V>> {

	private final Iterator<CacheObj<K, V>> iterator;
	private CacheObj<K, V> nextValue;

	/**
	 * 构造
	 * 
	 * @param iterator 原{@link Iterator}
	 * @param readLock 读锁
	 */
	CacheObjIterator(Iterator<CacheObj<K, V>> iterator) {
		this.iterator = iterator;
		nextValue();
	}

	/**
	 * @return 是否有下一个值
	 */
	@Override
	public boolean hasNext() {
		return nextValue != null;
	}

	/**
	 * @return 下一个值
	 */
	@Override
	public CacheObj<K, V> next() {
		if (false == hasNext()) {
			throw new NoSuchElementException();
		}
		final CacheObj<K, V> cachedObject = nextValue;
		nextValue();
		return cachedObject;
	}

	/**
	 * 从缓存中移除没有过期的当前值，此方法不支持
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Cache values Iterator is not support to modify.");
	}

	/**
	 * 下一个值，当不存在则下一个值为null
	 */
	private void nextValue() {
		while (iterator.hasNext()) {
			nextValue = iterator.next();
			if (nextValue.isExpired() == false) {
				return;
			}
		}
		nextValue = null;
	}
}
