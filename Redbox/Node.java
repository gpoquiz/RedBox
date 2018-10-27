package Redbox;

public class Node <Payload extends Comparable<Payload>> implements Comparable<Node<Payload>>, LeftRightPointable
{
	// members for navigation
	private Node <Payload> left;
	private Node <Payload> right;
	// will hold container class for data
	private Payload payload;

	// generic getters
	public LeftRightPointable getLeft(){return left;}
	public LeftRightPointable getRight(){return right;}
	public Payload getPayload(){return payload;}

	// generic setters
	public void setLeft(Node<Payload> left){this.left = left;}
	public void setRight(Node<Payload> right){this.right = right;}
	public void setPayload(Payload payload){this.payload = payload;}
	
	// default constructor
	public Node()
	{
		left = right = null;
		payload = null;
	}
	// overloaded constructor
	public Node(Payload payload)
	{
		this();
		this.payload = payload;
	}
	@Override
	public int compareTo(Node<Payload> item)
	{
		return payload.compareTo(item.getPayload());
	}
}
