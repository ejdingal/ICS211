/**
 * BinarySearchTree.java
 * Copyright (c) Emeri Joe Dingal 2018
 */

package edu.ics211.h09;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree. Written with help from ATA, Angeli Amascual, Kason Shiroma, Derrick Luyen, Eddie Wen
 * 
 * @author Emeri Joe Dingal
 * @param <E> a generic
 */
public class BinarySearchTree<E> implements SearchTree<E> {
  BinaryNode root;
  List<E> list = null;
  private Comparator<E> comp;

  /**
   * Inner node class.
   * 
   * @author Emeri Joe Dingal
   *
   */
  private class BinaryNode {
    E data;
    BinaryNode left;
    BinaryNode right;


    public BinaryNode() {
      this.data = null;
      this.left = null;
      this.right = null;
    }


    public BinaryNode(E data, BinaryNode left, BinaryNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }


  /**
   * Creates a new BinarySearchTree.
   * 
   * @param c the comparator to use for determining order.
   */
  public BinarySearchTree(Comparator<E> c) {
    this.root = new BinaryNode();
    this.comp = c;
  }


  /**
   * Creates an in order list of the binary tree.
   * 
   * @return the items in order as a List.
   */
  public List<E> inorder() { // needs recursive helper
    {
      // traverse in order of binary tree
      // add to list as traverses
      // return list as in order
    }
    list = new LinkedList<E>();
    return inorder(list, root); // begin recursive traversal

  }


  /**
   * Recursive inorder helper method for inorder.
   * 
   * @param list the list of nodes
   * @param node the current node being looked at
   * @return the list of nodes in order
   */
  private List<E> inorder(List<E> list, BinaryNode node) {

    if (node == null) { // no node
      return list; // leave list alone
    }
    inorder(list, node.left); // go to left subtree
    if (node != null) { // reached farthest left
      list.add((E) node.data); // add node to list
    }
    inorder(list, node.right); // go to right subtree
    return list; // return completed list

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#add(java.lang.Object)
   */
  @Override
  public boolean add(E item) { // needs recursive helper
    return add(item, root); // start recursive to add item starting at root
  }


  /**
   * Recursive add helper method for add.
   * 
   * @param item item to be added
   * @param node root of tree or subtree to be added to
   * @return boolean successful addition of item
   */
  public boolean add(E item, BinaryNode node) {
    if (node.data == null) { // if node is empty
      node.data = item; // add data to node
      System.out.println("STORED");
      return true;
    }
    if (comp.compare(item, (E) node.data) < 0) { // item is less than root, look to left subtree
      if (node.left == null) { // no node to the left
        node.left = new BinaryNode(); // create one
      }
      return add(item, node.left); // add to the left subtree
    }
    if (comp.compare(item, (E) node.data) > 0) { // item is greater than root, look to right subtree
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
   * @see edu.ics211.h09.SearchTree#contains(java.lang.Object)
   */
  @Override
  public boolean contains(E item) {
    // use find
    // traverse in order
    // find item

    if (find(item) == null) { // attempts to find item in tree
      return false; // if null, item not in tree
    }
    return true; // not null, target found, returns true
  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#find(java.lang.Object)
   */
  @Override
  public E find(E target) { // needs recursive helper -- binary search
    return find(target, root); // start recursive search starting at root of tree
  }


  /**
   * Recursive find helper method for find, recursively searches tree for target.
   * 
   * @param target target to be found
   * @param node node to be searched
   * @return E the node that was successfully found
   */
  @SuppressWarnings("unchecked")
  public E find(E target, BinaryNode node) {

    if (node == null) { // no tree here
      return null; // not found, returning null
    }

    if (comp.compare(target, (E) node.data) == 0) { // target match on node

      return node.data; // return nodes data
    }

    if (comp.compare(target, (E) node.data) < 0) { // target less than node -- look left
      return find(target, node.left);
    }

    if (comp.compare(target, (E) node.data) > 0) { // target greater than node -- look right

      return find(target, node.right);
    }

    return (E) node; // unreachable? - error if i don't write this line

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#delete(java.lang.Object)
   */
  @Override
  public E delete(E target) { // need recursive helper
    {
      // case 1: no children
      // no need to touch rest of tree
      // case 2: one child
      // child replaces parent
      // case 3: two children
      // take left node, reach farthest right, copy to deleted node
    }
    return delete(target, root); // start recursively finding target to delete

  }


  /**
   * Recursive delete helper for delete, recursively finds target to delete.
   * 
   * @param target the target to be deleted
   * @param node the current node being looked at
   * @return E the node deleted
   */
  public E delete(E target, BinaryNode node) {
    if (node == null) { // no tree or reached end of branch, no node
      return null;
    }
    int comparison = comp.compare(target, (E) node.data);

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
        return (E) temp.data; // return saved data
      }
      if (node.left == null && node.right != null) { // has right child
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = node.right.data; // overwrite
        return (E) temp.data; // return saved data
      }
      if (node.left != null && node.right == null) { // has left child
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = node.left.data; // overwrite
        return (E) temp.data; // return saved data
      }
      { // last case, has two children
        BinaryNode farthest = node.left;// go to left child
        while (farthest.right != null) {
          farthest = farthest.right; // go to farthest right child
        }
        BinaryNode temp = new BinaryNode(node.data, node.left, node.right); // save node data
        node.data = farthest.data; // copy
        node.left = null; // delete farthest
        return (E) temp.data; // return saved data

      }
    } // end if statement -- target match

  }


  /*
   * (non-Javadoc)
   * 
   * @see edu.ics211.h09.SearchTree#remove(java.lang.Object)
   */
  @Override
  public boolean remove(E target) { // use delete
    if (delete(target) == null) { // if couldn't find target to delete
      return false;
    }
    return true;
  }

}
