package com.lm;

public class LinkedListClass implements IsListed{
    private ListedItem headItem = null;
    private ListedItem currentItem = null;

    @Override
    public ListedItem getRoot() {
        return headItem;
    }



    public ListedItem getCurrentItem() {
        return currentItem;
    }

    @Override
    public boolean addItem(ListedItem newItem) {
        ListedItem iterateItem = headItem;
        if (headItem == null) {
            headItem = newItem;
            return true;
        }

        if (headItem.compareTo(newItem) > 0) {
            this.headItem.setPreviousItem(newItem); // Could be abbreviated by returning the item
            newItem.setNextItem(headItem);
            this.headItem = newItem;
            return true;
        } else {
            while (iterateItem.compareTo(newItem)!=0 && iterateItem.goNext() != null) {
                iterateItem = iterateItem.goNext();
                if (iterateItem.compareTo(newItem) > 0) {
                    newItem.setPreviousItem(iterateItem.goPrevious());
                    iterateItem.setPreviousItem(newItem);
                    newItem.setNextItem(iterateItem);
                    return true;
                }
            }
            if (iterateItem.compareTo(newItem)==0){
                System.out.println("Item already exists. Not added, no duplicates allowed.");
                return false;
            }
            if (iterateItem.compareTo(newItem) > 0) {
                newItem.setPreviousItem(iterateItem.goPrevious());
                iterateItem.setPreviousItem(newItem);
                newItem.setNextItem(iterateItem);
                return true;
            } else {
                newItem.setPreviousItem(iterateItem);
                iterateItem.setNextItem(newItem);
                newItem.setNextItem(null);
                return true;
            }
        }

    }

    @Override
    public boolean removeItem(ListedItem removingItem) {
        ListedItem iterateItem = headItem;
        while (iterateItem != null) {
            if (iterateItem.equals(removingItem)) {
                if (iterateItem.equals(headItem)){
                    this.headItem = iterateItem.goNext(); // Set a new head of list
                }
                iterateItem.goPrevious().setNextItem(iterateItem.goNext());
                iterateItem.goNext().setPreviousItem(iterateItem.goPrevious());
                return true;
            }
            iterateItem = iterateItem.goNext();
        }
        if (iterateItem == null) {  // Could be more efficient, by checking where item should be
//            and stopping at that point...
            System.out.println("Did not find object in list.");
            return false;
        }
        return false;
    }

    @Override
    public void goThrough(ListedItem root) {
        ListedItem iterateItem = root;
        while (iterateItem != null) {
            System.out.println(iterateItem);
            iterateItem = iterateItem.goNext();
        }
    }


}
