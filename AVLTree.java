package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;

    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */

    private AVLTree<T> rotateLeft() {
        AVLTree<T> right = this._right;
        this._right = right._left;
        right._left = this;
        this.updateHeight();
        this._right.updateHeight();


        // You should implement left rotation and then use this
        // method as needed when fixing imbalances.
        // TODO
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
        // TODO


        return null;
    }

    public void updateHeight(){
        int maxHeight = Math.max(heightChecker(this._left), heightChecker(this._right));
        this._height = maxHeight + 1;
    }

    private int heightChecker(AVLTree<T> tree){
        return tree != null ? tree._height : 0;
    }


    private AVLTree<T> engageRotation(AVLTree<T> thisOne){
        int balanceF = thisOne.balanceFactor();
        if (balanceF > 1){
            // ie, this means that its left heavy
            if(thisOne._left.balanceFactor() < 0){
                thisOne._left = thisOne._left.rotateLeft();
            }
            return thisOne.rotateRight();
        }
        if (balanceF < -1){
            // ie, this means that its right heavy
            if(thisOne._right.balanceFactor() > 0){
                thisOne._right = thisOne._right.rotateLeft();
            }
            return thisOne.rotateLeft();
        }
        return thisOne;
    }

    @Override
    public AVLTree<T> insert(T element) {
        // TODO
            // one traverses i suppose through the Getters?
            //element here works as a cur basically
            int result = _value.compareTo(element);
            if (result <= 0) {     // insert on right, or if they are equal
                if (_right.isEmpty()) {
                    _right = new AVLTree<T>(element);
                } else {
                    _right = _right.insert(element);
                }
            } else if (result > 0) {            // insert on left
                if (_left.isEmpty()) {
                    _left = new AVLTree<T>(element);
                } else {
                    _left = _left.insert(element);
                }

            }
            this._size +=1;

            // if result = 0,inserting with euivalence to root
            return this;
    }

    @Override
    public AVLTree<T> remove(T element) {
        // TODO
        if(isEmpty()){
            return this;
        }
        if (_value.compareTo(element) < 0) {
            _right = _right.remove(element);
        } else if (_value.compareTo(element) > 0) {
            _left = _left.remove(element);
        } else if (element.compareTo(_value) == 0) { // Ie they do equal

            if((_right.isEmpty()) && (_left.isEmpty())){
                return this;
            }
            else if ((_right.isEmpty())) { // cases where node have only one child
                return _left;
            } else if ((_left.isEmpty())) { // cases where node have only one child
                return _right;
            } else { // case 3. node has 2 children. Lets use successor from right.
                AVLTree<T> successor = findMinNode(_right);
                _right = _right.remove(successor._value);
                _value = successor._value;

            }
        }
        this._size -=1;
        this.updateHeight();
        return engageRotation(this);
    }

    AVLTree<T> findMinNode(AVLTree<T> thing) {    // returns smallest node in tree starting at node
        if (thing.getLeft().isEmpty()) {
            return(thing);
        } else {
            return findMinNode((AVLTree<T>) thing.getLeft());
        }

    }

    public int balanceFactor(){
        return this != null
                ? heightChecker(this._left) - heightChecker(this._right)
                : 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }



    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_left.isEmpty()) {
            return _value;
        } else {
            return _left.findMin();
        }
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_right.isEmpty()) {
            return _value;
        } else {
            return _right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
        // TODO
        return false;
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }

        return _right;
    }

}