package com.lintcode.sourcecode.impl;

import com.lintcode.sourcecode.MyList;

/**
 * @author YL
 * @date 22:39 2020/8/19
 */
public class MyArrayList<K> implements MyList<K> {

    Object[] elementData;
    private static final int DEFAULT_INITIAL_CAPACITY = 1;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public boolean add(K k) {
        checkCapacity();
        this.elementData[size++] = k;
        return true;
    }


    @Override
    public boolean add(K k, int index) {
        
        return false;
    }

    /**
     * 检查数组，判断是否需要扩容
     *
     * @return void
     * @author YL
     * @date 2020/8/20 23:34
     */
    private void checkCapacity() {
        if (size >= elementData.length) {
            int newLength = size + 1;
            Object[] newElementData = new Object[newLength];
            for (int i = 0; i < elementData.length; i++) {
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
        }

    }

    @Override
    public K remove(int index) {
        return null;
    }

    @Override
    public int clear() {
        return 0;
    }

    @Override
    public void set(int index, K k) {

    }

}
