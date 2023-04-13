package assn06;
// credit to geekific for helping explain AVL trees and their functioning
public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Put your fields here.


    public AVLTree() {
        // You code for constructor here.







    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private AVLTree<T> rotateLeft() {

        //Generalized:








         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
         return null;
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.

        //Generalize:



         
         return null;
     }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        return null;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        return null;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return null;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return null;
    }

    // Your code for public methods here.

    //doi needinsertand remove??
    @Override
    public remove(T element){
         if(contains(element) == false){
             return false;
         } else {
             // we will remove that node, and set it equal to the one below it,the successor

         }


    }
}
