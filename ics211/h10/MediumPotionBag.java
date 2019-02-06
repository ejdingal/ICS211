/**
 * MediumPotionBag.java
 * Copyright (c) Emeri Joe Dingal 2018
 */

package edu.ics211.h10;

/**
 * A medium potion bag with the runtime of about O(log(n)) using a binary search tree.
 * 
 * @author Emeri Joe Dingal
 *
 */
public class MediumPotionBag implements PotionBag {
  private static MediumPotionBag instance;
  private BinaryNode root = new BinaryNode();
  private static int size;

  /**
   * Inner binary node class.
   * 
   * @author Emeri Joe Dingal
   *
   */
  private class BinaryNode {
    Potion data;
    BinaryNode left;
    BinaryNode right;


    /**
     * Constructor for BinaryNode. All member variables set to null;
     */
    public BinaryNode() {
      this.data = null;
      this.left = null;
      this.right = null;
    }


    /**
     * Constructor for BinaryNode.
     * 
     * @param data the item the node holds
     * @param left the node to the left
     * @param right the node to the right
     */
    public BinaryNode(Potion data, BinaryNode left, BinaryNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#store(edu.ics211.h10.Potion)
   */
  @Override
  public void store(Potion p) {
    add(p, root); // start recursive to add item starting at root
    size++;

  }


  /**
   * Recursive add helper method for store.
   * 
   * @param item item to be added
   * @param node root of tree or subtree to be added to
   * @return boolean successful addition of item
   */
  public boolean add(Potion item, BinaryNode node) {
    if (node.data == null) { // if node is empty
      node.data = item; // add data to node
      return true;
    }
    if (item.getName().compareTo(node.data.getName()) < 0) { // item is less, go left subtree
      if (node.left == null) { // no node to the left
        node.left = new BinaryNode(); // create one
      }
      return add(item, node.left); // add to the left subtree
    }
    if (item.getName().compareTo(node.data.getName()) > 0) { // item is greater, go right subtree
      if (node.right == null) { // no node to the right
        node.right = new BinaryNode(); // create one
      }
      return add(item, node.right); // add to right subtree
    }
    return false; // comparator is equal to zero -- duplicates forbidden

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedStore(edu.ics211.h10.Potion)
   */
  @Override
  public long timedStore(Potion p) {
    long startTime = System.nanoTime();
    store(p);
    return System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#retrieve(edu.ics211.h10.Potion)
   */
  @Override
  public Potion retrieve(Potion p) {
    Potion retVal = delete(p, root);
    if (retVal != null) {
      size--;
    }
    return retVal;
  }


  /**
   * Recursive delete helper for delete, recursively finds target to delete.
   * 
   * @param target the target to be deleted
   * @param node the current node being looked at
   * @return E the node deleted
   */
  public Potion delete(Potion target, BinaryNode node) {
    if (node == null) { // no tree or reached end of branch, no node
      return null;
    }
    int comparison = target.getName().compareTo(node.data.getName());

    if (comparison < 0) { // target less than node -- look left
      return delete(target, node.left);
    } // end if comparator left statement

    else if (comparison > 0) { // target greater than node -- look right
      return delete(target, node.right);
    } // end if comparator right statement

    else { // target match on node -- begin deleting
      if (node.left == null && node.right == null) { // node does not have children
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node = null; // delete node
        return temp.data; // return saved data
      }
      if (node.left == null && node.right != null) { // has right child
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = node.right.data; // overwrite
        return temp.data; // return saved data
      }
      if (node.left != null && node.right == null) { // has left child
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = node.left.data; // overwrite
        return temp.data; // return saved data
      }
      { // last case, has two children
        BinaryNode farthest = node.left;// go to left child
        while (farthest.right != null) {
          farthest = farthest.right; // go to farthest right child
        }
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = farthest.data; // copy
        node.left = null; // delete farthest
        return temp.data; // return saved data

      }
    } // end if statement -- target match

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#timedRetrieve(edu.ics211.h10.Potion)
   */
  @Override
  public long timedRetrieve(Potion p) {
    long startTime = System.nanoTime();
    retrieve(p);
    return System.nanoTime() - startTime;
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h10.PotionBag#size()
   */
  @Override
  public int size() {
    return size;
  }


  /**
   * Creates a single and only instance of potion bag.
   * 
   * @return the instance of this potion bag.
   */
  public static MediumPotionBag getInstance() {
    if (instance == null) {
      instance = new MediumPotionBag();
    }
    return instance;
  }

}
