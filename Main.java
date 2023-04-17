package assn06;

public class Main {
    public static void main(String[] args) {
//
        //1. Convert your code that you wrote for BSTs (for insert and delete) to work with the AVL Trees.

        //2. Create a method that checks if you need to rotate 

        //3. Create a method that does the rotation (rotate right / rotate left)


        // Create a new empty tree.
        SelfBalancingBST<Integer> avl_bst = new AVLTree<Integer>();

        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post insertion root that is
        // returned might change because of the insertion

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert((int) (Math.random()*100));
        }

        System.out.println(avl_bst.height());

        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad.

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert(i);
        }

        System.out.println(avl_bst.height());
    }
}
