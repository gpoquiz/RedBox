package Redbox;

public class BinaryNode <E extends Comparable<E>> implements Comparable<BinaryNode<E>>
{
	// members for navigation
	private BinaryNode <E> left;
	private BinaryNode <E> right;
	// will hold container class for data
	private E payload;

	// generic getters
	public BinaryNode<E> getLeft(){return left;}
	public BinaryNode<E> getRight(){return right;}
	public E getPayload(){return payload;}

	// generic setters
	public void setLeft(BinaryNode<E> left){this.left = left;}
	public void setRight(BinaryNode<E> right){this.right = right;}
	public void setPayload(E payload){this.payload = payload;}
	
	// default constructor
	public BinaryNode()
	{
		left = right = null;
		payload = null;
	}
	// overloaded constructor
	public BinaryNode(E payload)
	{
		this();
		this.payload = payload;
	}
	@Override
	public int compareTo(BinaryNode<E> item)
	{
		return payload.compareTo(item.getPayload());
	}
}