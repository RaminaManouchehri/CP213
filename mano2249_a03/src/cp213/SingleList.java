package cp213;

import java.util.ArrayList;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2023-09-06
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

	// your code here
	SingleNode<T> node = this.front;

	int counter = 1;

	while ((node.getItem().compareTo(key) != 0) && (counter < this.length)) {
	    node = node.getNext();
	    counter++;
	}

	if (node.getItem().compareTo(key) != 0) {
	    node = null;
	}

	return node;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The value to append.
     */
    public void append(final T data) {

	// your code here
	SingleNode<T> node1 = new SingleNode<T>(data, null);
	SingleNode<T> node = new SingleNode<T>(data, null);

	if (this.rear != null)
	    this.rear.setNext(node);

	this.rear = node;

	if (this.front == null) {
	    this.front = node;
	}

	this.length++;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

	// your code here
	SingleNode<T> prev = this.front;
	SingleNode<T> cur = this.front;

	ArrayList<T> arr = new ArrayList<T>();

	int counter = 0;

	while (counter < this.length) {
	    if (arr.contains(cur.getItem())) {
		prev.setNext(cur.getNext());
		if (cur == this.rear) {
		    this.rear = prev;
		}
		cur = cur.getNext();
		this.length--;
	    } else {
		arr.add(cur.getItem());
		prev = cur;
		cur = cur.getNext();
		counter++;
	    }
	}

	return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	while ((left.length > 0) || (right.length > 0)) {
	    if (left.length > 0) {
		this.moveFrontToRear(left);
	    }

	    if (right.length > 0) {
		this.moveFrontToRear(right);
	    }
	}

	return;
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	// your code here
	SingleNode<T> node = this.linearSearch(key);

	boolean true1 = false;

	if (node != null) {
	    true1 = true;
	}

	return true1;

    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	// your code here
	int countnum = 0;

	if (this.length > 0) {
	    SingleNode<T> current = this.front;

	    int i = 0;

	    while (i < this.length) {
		if (current.getItem().compareTo(key) == 0) {
		    countnum++;
		}
		current = current.getNext();
		i++;
	    }
	}

	return countnum;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

	// your code here
	SingleNode<T> node1 = this.linearSearch(key);
	T val = node1 == null ? null : node1.getItem();
	return val;
    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	// your code here
	int i = 0;
	SingleNode<T> returnNode = this.front;
	while (i < n) {
	    returnNode = returnNode.getNext();
	    i++;
	}
	return returnNode.getItem();
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {

	// your code here
	boolean bool = true;

	if (this.length != source.length) {
	    bool = false;
	} else {
	    int i = 0;
	    SingleNode<T> cur = this.front;
	    SingleNode<T> sour = source.front;

	    while ((i < this.length) && (bool)) {
		if (cur.getItem().compareTo(sour.getItem()) != 0) {
		    bool = false;
		}

		cur = cur.getNext();
		sour = sour.getNext();
		i++;
	    }
	}

	return bool;
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

	// your code here
	SingleNode<T> node = this.front;

	int i = 0;

	while ((node.getItem().compareTo(key) != 0) && (i < this.length - 1)) {
	    node = node.getNext();
	    i++;
	}

	if (this.length > 0) {
	    if (node.getItem().compareTo(key) != 0) {
		i = -1;
	    }
	}

	return i;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new value to insert into this SingleList.
     */
    public void insert(int i, final T data) {

	// your code here
	SingleNode<T> node = new SingleNode<T>(data, null);
	if (this.length <= i) {
	    if (this.rear == null) {
		this.front = node;
		this.rear = node;
	    } else {
		this.rear.setNext(node);
		this.rear = node;
	    }

	} else if (i == 0) {
	    node.setNext(this.front);
	    this.front = node;
	} else {

	    SingleNode<T> cur = this.front;

	    for (int index = 1; index < i; index++) {
		cur = cur.getNext();
	    }

	    node.setNext(cur.getNext());
	    cur.setNext(node);
	}

	this.length++;

	return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	SingleNode<T> node = left.front;

	for (int i = 0; i < left.length; i++) {
	    if (right.contains(node.getItem())) {
		this.append(node.getItem());
	    }
	    node = node.getNext();
	}

	return;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

	// your code here
	T max = this.front.getItem();

	SingleNode<T> cur = this.front;

	for (int i = 0; i < this.length; i++) {
	    if (cur.getItem().compareTo(max) > 0) {
		max = cur.getItem();
	    }

	    cur = cur.getNext();
	}

	return max;

    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

	// your code here
	T min = this.front.getItem();

	SingleNode<T> cur = this.front;

	for (int i = 0; i < this.length; i++) {
	    if (cur.getItem().compareTo(min) < 0) {
		min = cur.getItem();
	    }

	    cur = cur.getNext();
	}

	return min;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param data The value to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

	// your code here
	SingleNode<T> node = new SingleNode<T>(data, this.front);

	this.front = node;

	if (this.rear == null) {
	    this.rear = this.front;
	}

	this.length++;

	return;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

	// your code here
	SingleNode<T> node = this.front;
	SingleNode<T> prev = this.front;

	T value;

	int i = 1;

	while ((node.getItem().compareTo(key) != 0) && (i < this.length)) {
	    prev = node;
	    node = node.getNext();
	    i++;
	}

	if (node != null) {
	    if (node.getItem().compareTo(key) != 0) {
		node = null;
	    } else {
		if (node == this.front) {
		    this.front = this.front.getNext();
		} else {
		    prev.setNext(node.getNext());
		}
		this.length--;
		if (this.length == 0) {
		    this.front = null;
		    this.rear = null;
		}
	    }
	}

	value = node == null ? null : node.getItem();

	return value;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

	// your code here
	SingleNode<T> node1 = this.front;

	this.front = this.front.getNext();

	this.length--;

	if (this.length == 0) {
	    this.rear = null;
	}

	return node1.getItem();
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

	// your code here
	SingleNode<T> current = this.front;
	SingleNode<T> prev = this.front;

	int i = 0;
	while (i < this.length) {
	    if (current.getItem().compareTo(key) == 0) {
		if (current == this.front) {
		    this.front = this.front.getNext();
		    current = this.front;
		} else {
		    prev.setNext(current.getNext());
		    if (current == this.rear) {
			this.rear = prev;
		    }
		    current = current.getNext();
		}
		this.length--;
	    } else {
		prev = current;
		current = current.getNext();
		i++;
	    }
	}

	if (this.front == null) {
	    this.rear = null;
	}

	return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {

	// your code here
	SingleNode<T> current = this.front;
	SingleNode<T> prev = null;
	SingleNode<T> next;
	for (int i = 0; i < this.length; i++) {
	    next = current.getNext();
	    current.setNext(prev);
	    prev = current;
	    current = next;
	}

	next = this.front;

	this.front = this.rear;

	this.rear = next;

    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	int value = (this.length / 2);

	while (this.length > 0) {
	    if (this.length > value) {
		left.moveFrontToRear(this);
	    } else {
		right.moveFrontToRear(this);
	    }
	}

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	// your code
	while (this.length > 0) {
	    left.moveFrontToRear(this);

	    if (this.length > 0) {
		right.moveFrontToRear(this);
	    }
	}

	return;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	SingleNode<T> node1 = left.front;
	SingleNode<T> node2 = right.front;

	for (int i = 0; i < left.length; i++) {
	    this.append(node1.getItem());
	    node1 = node1.getNext();
	}

	for (int i = 0; i < right.length; i++) {
	    this.append(node2.getItem());
	    node2 = node2.getNext();
	}

	return;
    }
}
