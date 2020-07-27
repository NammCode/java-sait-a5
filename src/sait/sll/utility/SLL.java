package sait.sll.utility;

import java.io.Serializable;

/**
 * @author Nam Khanh Nguyen
 * @author Mathew Monis
 * @version 2019-07-25
 */
public class SLL implements LinkedListADT, Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Node head;

	private int size;

	public SLL() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {

		if (head == null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public void append(Object data) {

		// Create a new node with data
		Node newNode = new Node(data);
		
		// Set this node is the last node
		newNode.setNext(null);

		// Check if no node exist, then make the new node as head
		if (head == null) {
			head = new Node(data);
			size++;
			return;
		}
		
		// Loop until the last node
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		
		// Set the next of the last node to the new node
		last.setNext(newNode);
		
		// Increment size of the linked list by 1
		size++;
	}

	@Override
	public void prepend(Object data) {

		// Create a new node with data
		Node newNode = new Node(data);

		// Set next of the new node to the head 
		newNode.setNext(head);

		// Set the new node to be the head
		head = newNode;

		// Increment size of the linked list by 1
		size++;
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {

		Node newNode = new Node(data);

		// Check for negative index
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// Check if the index is 0
		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
			size++;
		} else {
			Node currentNode = head;
			int tempIndex = 0;
			while (tempIndex < index - 1) {
				currentNode = currentNode.getNext();
				tempIndex++;
			}

			// Step 3: get the next of the node at index - 1
			Node tempNode = currentNode.getNext();

			// Step 4: get the next of current NOde
			currentNode.setNext(newNode);

			// Step 5: Set next of the node to the next of current Node
			newNode.setNext(tempNode);

			size++;
		}

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// Check for negative index, will throws exception
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node currentNode = head;
			int tempIndex = 0;
			// Loop until the node at index
			while (tempIndex < index) {
				currentNode = currentNode.getNext();
				tempIndex++;
			}
			// Set the new data at current Node
			currentNode.setData(data);
		}

	}

	@Override
	public int size() {
		int size = 0;

		Node count = head;
		
		// Loop through the linked list, increment sizer by 1 each time through
		while (count != null) {
			size++;
			count = count.getNext();
		}

		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		// Check the index, throws exception if index is negative
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// If index is 0, delete the head and set the head is next node of head
		if (index == 0) {
			Node deleteNode = head;
			head = head.getNext();
			deleteNode.setNext(null);
			size--;
		} else {
			Node previousNode = head;
			int tempIndex = 0;
			// Loop until the node at previous index
			while (tempIndex < index - 1) {
				previousNode = previousNode.getNext();
				tempIndex++;
			}
			// Get the next of previous node (node to delete)
			Node deleteNode = previousNode.getNext();

			// Set the next of the previous to the next of node to delete
			previousNode.setNext(deleteNode.getNext());

			// Set next to null
			deleteNode.setNext(null);

			// Decrement size by 1
			size--;
		}

	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {

		Object data;
		
		// Check for negative index, throw exception
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node currentNode = head;
			int tempIndex = 0;
			// Loop until node at index is reached
			while (tempIndex < index) {
				currentNode = currentNode.getNext();
				tempIndex++;
			}

			// Get data in current node
			data = currentNode.getData();
		}
		return data;
	}

	@Override
	public int indexOf(Object data) {
		int index = 0;

		Node contain = head;
		// Loop until the node with matching data is reached
		while (contain != null) {
			if (contain.getData() == data) {
				return index;
			}
			contain = contain.getNext();
			index++;
		}
		// Return -1 if no node have matching datas
		return -1;
	}

	@Override
	public boolean contains(Object data) {

		Node contain = head;
		// Loop until the node with matching data is reached
		while (contain != null) {
			if (contain.getData() == data) {
				return true;
			}
			contain = contain.getNext();
		}
		// Return false if no node have matching datas
		return false;
	}

}
