package com.lm;

public interface IsListed {
    ListedItem getRoot();
    boolean addItem(ListedItem newItem);
    boolean removeItem (ListedItem removingItem);
    void goThrough (ListedItem root);
}
