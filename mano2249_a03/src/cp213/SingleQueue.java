package cp213;

/**
 * A single linked queue structure of <code>Node T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2023-09-06
 * @param <T> the SingleQueue data type.
 */
public class SingleQueue<T> extends SingleLink<T> {

    /**
     * Combines the contents of the left and right SingleQueues into the current
     * SingleQueue. Moves nodes only - does not refer to values in any way, or call
     * the high-level methods insert or remove. left and right SingleQueues are
     * empty when done. Nodes are moved alternately from left and right to this
     * SingleQueue.
     *
     * You have two source queues named left and right. Move all nodes from these
     * two queues to the current queue. It does not make a difference if the current
     * queue is empty or not, just get nodes from the right and left queues and add
     * them to the current queue. You may use any appropriate SingleLink helper
     * methods available.
     *
     * Do not assume that both right and left queues are of the same length.
     *
     * @param left  The first SingleQueue to extract nodes from.
     * @param right The second SingleQueue to extract nodes from.
     */
    public void combine(final SingleQueue<T> left, final SingleQueue<T> right) {

	// your code here
	while (left.front != null) {
	    SingleNode<T> node = left.front;
	    left.front = left.front.getNext();
	    node.setNext(null);
	    if (this.front == null) {
		this.front = node;
		this.rear = node;
		this.length++;
	    } else {
		this.rear.setNext(node);
		this.rear = node;
		this.length++;
	    }
	    if (right.front != null) {
		node = right.front;
		right.front = right.front.getNext();
		node.setNext(null);
		this.rear.setNext(node);
		this.rear = node;
		this.length++;

	    }
	}
	while (right.front != null) {
	    SingleNode<T> node = right.front.getNext();
	    node.setNext(null);
	    right.front = right.front.getNext();
	    if (this.front == null) {
		this.front = node;
		this.rear = node;
		this.length++;
	    } else {
		this.rear.setNext(node);
		this.rear = node;
		this.length++;
	    }
	}

	return;
    }

    /**
     * Adds value to the rear of the queue. Increments the queue length.
     *
     * @param data The value to added to the rear of the queue.
     */
    public void insert(final T data) {

	// your code here
	SingleNode<T> node1 = new SingleNode<T>(data, null);
	if (this.front == null) {
	    this.front = node1;
	    this.rear = node1;
	} else {
	    this.rear.setNext(node1);
	    this.rear = node1;
	}
	this.length++;

	return;
    }

    /**
     * Returns the front value of the queue and removes that value from the queue.
     * The next node in the queue becomes the new first node. Decrements the queue
     * length.
     *
     * @return The value at the front of the queue.
     */
    public T remove() {

	// your code here
	SingleNode<T> temp = this.front;

	if (this.length == 1) {
	    this.front = null;
	    this.rear = null;

	} else if (this.length > 1) {
	    this.front = this.front.getNext();

	}
	this.length--;

	return temp.getItem();

    }

    /**
     * Splits the contents of the current SingleQueue into the left and right
     * SingleQueues. Moves nodes only - does not move value or call the high-level
     * methods insert or remove. this SingleQueue is empty when done. Nodes are
     * moved alternately from this SingleQueue to left and right. left and right may
     * already contain values.
     *
     * This is the opposite of the combine method.
     *
     * @param left  The first SingleQueue to move nodes to.
     * @param right The second SingleQueue to move nodes to.
     */
    public void splitAlternate(final SingleQueue<T> left, final SingleQueue<T> right) {

	// your code here
	while (this.length > 0) {
	    left.moveFrontToRear(this);

	    if (this.length > 0) {
		right.moveFrontToRear(this);
	    }
	}

	return;
    }
}
