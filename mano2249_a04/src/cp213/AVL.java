package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 * 
 * @author ramina manouchehri
 * @author David Brown
 * @version 2023-09-06
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance item of node. If greater than 1, then left heavy, if less
     * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
     * balanced. Used to determine whether to rotate a node upon insertion.
     * 
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {
	return this.nodeHeight(node.getLeft()) - this.nodeHeight(node.getRight());
    }

    /**
     * Performs a left rotation around node.
     * 
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {
	final TreeNode<T> temp = node.getRight();
	node.setRight(temp.getLeft());
	temp.setLeft(node);
	node.updateHeight();
	return temp;
    }

    /**
     * Performs a right rotation around node.
     * 
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {
	final TreeNode<T> temp = node.getLeft();
	node.setLeft(temp.getRight());
	temp.setRight(node);
	node.updateHeight();
	return temp;
    }

    /**
     * Auxiliary method for insert. Inserts data into this AVL.
     * 
     * @param node The current node (TreeNode).
     * @param cs   Data to be inserted into the node.
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedItem<T> cs) {
	int bal = 0;
	if (node == null) {
	    node = new TreeNode<T>(cs);
	    this.size++;
	    cs.incrementCount();
	} else {
	    final int total = node.getdata().compareTo(cs);
	    if (total > 0) {
		node.setLeft(this.insertAux(node.getLeft(), cs));
		node.updateHeight();
		bal = this.balance(node);
		if (bal > 1 && this.balance(node.getLeft()) >= 0) {
		    node = this.rotateRight(node);
		} else if (bal > 1 && this.balance(node.getLeft()) < 0) {
		    node.setLeft(this.rotateLeft(node.getLeft()));
		    node = this.rotateRight(node);
		}
	    } else if (total < 0) {
		node.setRight(this.insertAux(node.getRight(), cs));
		bal = this.balance(node);
		if (bal < -1 && this.balance(node.getRight()) <= 0) {
		    node = this.rotateLeft(node);
		} else if (bal < -1 && this.balance(node.getRight()) > 0) {
		    node.setRight(this.rotateRight(node.getRight()));
		    node = this.rotateLeft(node);
		}
	    } else {
		this.size++;
	    }
	}
	node.updateHeight();
	return node;
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An AVL must meet the BST validation conditions, and additionally be
     * balanced in all its subtrees - i.e. the difference in height between any two
     * children must be no greater than 1.
     * 
     * @param node    The root of the subtree to test for validity.
     * @param minNode Minimum valid node.
     * @param maxNode Maximum valid node.
     * @return true if the subtree based on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {
	boolean valid = false;
	if (node == null) {
	    valid = true;
	} else if (Math.max(this.nodeHeight(node.getLeft()), this.nodeHeight(node.getRight())) != node.getHeight()
		- 1) {
	    valid = false;
	} else if (node.getLeft() != null && node.getLeft().getdata().compareTo(node.getdata()) >= 0
		|| node.getRight() != null && node.getRight().getdata().compareTo(node.getdata()) <= 0) {
	    valid = false;
	} else if (Math.abs(this.nodeHeight(node.getLeft()) - this.nodeHeight(node.getRight())) > 1) {
	    valid = false;
	} else {
	    valid = this.isValidAux(node.getLeft(), minNode, maxNode)
		    && this.isValidAux(node.getRight(), minNode, maxNode);
	}
	return valid;
    }

    /**
     * Determines whether two AVLs are identical.
     * 
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         item, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }
}