package com.lm;

public class Person extends ListedItem {
    private String name;

    public Person(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void setPreviousItem(ListedItem previousItem) {
        this.previousItem = previousItem;
    }

    @Override
    public void setNextItem(ListedItem nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public void setAboveItem(ListedItem aboveItem) {
        this.aboveItem = aboveItem;
    }

    @Override
    public ListedItem goPrevious() {
        return this.previousItem;
    }

    @Override
    public ListedItem goNext() {
        return this.nextItem;
    }

    @Override
    public ListedItem goUp() {
        return this.aboveItem;
    }

    @Override
    public int compareTo(ListedItem itemToCompare) {
        if (itemToCompare!=null) {
            String value = (String) itemToCompare.getValue();
            int i = this.name.compareTo(value);
            return i;
        } else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
