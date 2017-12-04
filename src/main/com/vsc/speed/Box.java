package com.vsc.speed;

import java.util.ArrayList;
import java.util.List;

/**
 * A Box holding integers.
 * <br/>
 * The number of items it can hold is not limited, but the added value of the
 * items it holds may not be higher than the given maximal size.
 */
public class Box {

    /**
     * maximal allowed added value of items.
     */
    protected int maxSize;
    /**
     * current added value of items.
     */
    protected int currentSize;
    /**
     * list of items in box.
     */
    protected List<Integer> items;

    /**
     * construct new box with given maximal size.
     *
     * @param maxSize
     */
    public Box(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.items = new ArrayList<Integer>();
    }

    /**
     * adds given item to this box, and increases the currentSize of the box by
     * value of item. If item does not fit, it will not be put in the box and
     * false will be returned.
     *
     * @param item item to put in box
     * @return true if item fit in box, false otherwise
     */
    public boolean put(Integer item) {
        if (currentSize + item <= maxSize) {
            items.add(item);
            currentSize += item;
            return true;
        } else {
            return false; // item didn't fit
        }
    }


    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < items.size(); i++) {
            res += items.get(i);
        }
        return res;
    }
}
