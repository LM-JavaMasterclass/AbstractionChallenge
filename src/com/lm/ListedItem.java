package com.lm;

public abstract class ListedItem {
    protected ListedItem previousItem = null;
    protected ListedItem nextItem = null;
    protected ListedItem aboveItem = null;

    protected Object value;

    public ListedItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract void setPreviousItem(ListedItem previousItem);
    abstract void setNextItem(ListedItem nextItem);
    abstract void setAboveItem(ListedItem aboveItem);
    abstract ListedItem goPrevious();
    abstract ListedItem goNext();
    abstract ListedItem goUp();

    abstract int compareTo (ListedItem itemToCompare);



}
