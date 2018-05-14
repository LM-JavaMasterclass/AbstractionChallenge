package com.lm;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeSearchClass implements IsListed{
    ListedItem rootItem = null;

    @Override
    public ListedItem getRoot() {
        return rootItem;
    }

    @Override
    public boolean removeItem(ListedItem removingItem) { // Not currently functional
        // In TB's solution:
        // Find right spot, identify the item
        // Then created its own method for removal separately

        // Requires comparing all the involved links to know which is the right spot
        // can be found in his answer for challenge online.

        return false;
    }

    public boolean addItem(ListedItem newItem) {
        ListedItem iterateItem = rootItem;
        if (rootItem == null) {
            rootItem = newItem;
        } else {
            while (iterateItem != null) {
                if (iterateItem.compareTo(newItem) == 0) {
                    System.out.println(newItem + " already exists. Did not add.");
                    return false;
                } else if (iterateItem.compareTo(newItem) > 0) {
                    if (iterateItem.goPrevious() != null) {
                        iterateItem = iterateItem.goPrevious();
                    } else {
                        iterateItem.setPreviousItem(newItem);
                        newItem.setAboveItem(iterateItem);
                        return true;
                    }
                } else {
                    if (iterateItem.goNext() != null) {
                        iterateItem = iterateItem.goNext();
                    } else {
                        iterateItem.setNextItem(newItem);
                        newItem.setAboveItem(iterateItem);
                        return true;
                    }
                }
            }
        }
        return true;
    }

    public void goThrough(ListedItem root) {
        ListedItem iterateItem = root;
        ListedItem check = rootItem;
        ListedItem justVisited = rootItem;


        boolean quit = false;

        if (rootItem == null) {
            System.out.println("List has no items");
            return;
        }

        while (iterateItem.goPrevious() != null) { // Go to first item
            iterateItem = iterateItem.goPrevious();
        }

        while (iterateItem.compareTo(rootItem) != 0) {  // Traverse tree until root item
            if (iterateItem.goNext() == null) {
                System.out.println(iterateItem);
                justVisited = iterateItem;
                iterateItem = iterateItem.goUp();
            } else if (iterateItem.compareTo(check) != 0 && justVisited.compareTo(iterateItem.goNext()) != 0) {// has not yet printed that node

                check = iterateItem;
                System.out.println(iterateItem);
                justVisited = iterateItem;
                iterateItem = iterateItem.goNext();
                while (iterateItem.goPrevious() != null) {
                    iterateItem = iterateItem.goPrevious();
                }
            } else {
                justVisited = iterateItem;
                iterateItem = iterateItem.goUp();
            }

        }

        System.out.println(iterateItem);
        iterateItem = iterateItem.goNext();
        justVisited = rootItem; // To make sure it is not null
        while (iterateItem.goPrevious() != null) {
            iterateItem = iterateItem.goPrevious();
        }

        // Traverse list after root item
        while (iterateItem.compareTo(rootItem) != 0) {  // Traverse tree until root item
            if (iterateItem.goNext() == null) {
                System.out.println(iterateItem);
                justVisited = iterateItem;
                iterateItem = iterateItem.goUp();
            } else if (iterateItem.compareTo(check) != 0 && justVisited.compareTo(iterateItem.goNext()) != 0) {// has not yet printed that node

                check = iterateItem;
                System.out.println(iterateItem);
                justVisited = iterateItem;
                iterateItem = iterateItem.goNext();
                while (iterateItem.goPrevious() != null) {
                    iterateItem = iterateItem.goPrevious();
                }
            } else {
                justVisited = iterateItem;
                iterateItem = iterateItem.goUp();
            }

        }
    }

    public void printList2() {
        ListedItem iterateItem = rootItem;

        ArrayList<ListedItem> toPrint = new ArrayList<>();
        int i = 0;

        if (rootItem == null) {
            System.out.println("List has no items");
            return;
        }

        while (iterateItem.goPrevious() != null) { // Go to first item
            iterateItem = iterateItem.goPrevious();
        }

        while (iterateItem.compareTo(rootItem) != 0) {  // Traverse tree until root item
            if (iterateItem.goNext() == null) {
                toPrint.add(i, iterateItem);
                iterateItem = iterateItem.goUp();
                i++;
            } else if (!toPrint.contains(iterateItem)) {
                toPrint.add(iterateItem);
                iterateItem = iterateItem.goNext();
                i++;
                while (iterateItem.goPrevious() != null) {
                    iterateItem = iterateItem.goPrevious();
                }
            } else {
                iterateItem = iterateItem.goUp();
            }

        }

        toPrint.add(i, iterateItem);
        i++;
        iterateItem = iterateItem.goNext();

        while (iterateItem.goPrevious() != null) {
            iterateItem = iterateItem.goPrevious();
        }

        while (iterateItem.compareTo(rootItem) != 0) {  // Traverse tree until root item
            if (iterateItem.goNext() == null) {
                toPrint.add(i, iterateItem);
                iterateItem = iterateItem.goUp();
                i++;
            } else if (!toPrint.contains(iterateItem)) {
                toPrint.add(i, iterateItem);
                iterateItem.goNext();
                i++;
                while (iterateItem.goPrevious() != null) {
                    iterateItem = iterateItem.goPrevious();
                }
            } else {
                iterateItem = iterateItem.goUp();
            }

        }

        for (int j = 0; j < toPrint.size(); j++) {
            System.out.println(toPrint.get(j));
        }
    }




    // Following method is taken from TB's answer to the challenge, using RECURSIVITY
    public void traverse(ListedItem root){
        // recursive method
        if (root != null) {
            traverse(root.goPrevious());
            System.out.println(root.getValue());
            traverse(root.goNext());
        }

    }


}
