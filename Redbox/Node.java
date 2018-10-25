package Redbox;

public class Node <E extends Comparable<E>>
{
	// members for navigation
	Node <E> left;
	Node <E> right;
	// will hold container class for data
	E payload;

	// generic getters
	public Node<E> getLeft(){return left;}
	public Node<E> getRight(){return right;}
	public E getPayload(){return payload;}

	// generic setters
	public void setLeft(Node<E> left){this.left = left;}
	public void setRight(Node<E> right){this.right = right;}
	public void setPayload(E payload){this.payload = payload;}
	
	// default constructor
	public Node()
	{
		left = right = null;
		payload = null;
	}
	// overloaded constructor
	public Node(E payload)
	{
		this();
		this.payload = payload;
	}
}
