package Redbox;

public class NodeBackup <Payload extends Comparable<Payload>> implements Comparable<NodeBackup<Payload>>, LeftRightPointable
{
	// members for navigation
	private NodeBackup <Payload> left;
	private NodeBackup <Payload> right;
	// will hold container class for data
	private Payload payload;

	// generic getters
	public LeftRightPointable getLeft(){return left;}
	public LeftRightPointable getRight(){return right;}
	public Payload getPayload(){return payload;}

	// generic setters
	public void setLeft(NodeBackup<Payload> left){this.left = left;}
	public void setRight(NodeBackup<Payload> right){this.right = right;}
	public void setPayload(Payload payload){this.payload = payload;}
	
	// default constructor
	public NodeBackup()
	{
		left = right = null;
		payload = null;
	}
	// overloaded constructor
	public NodeBackup(Payload payload)
	{
		this();
		this.payload = payload;
	}
	@Override
	public int compareTo(NodeBackup<Payload> item)
	{
		return payload.compareTo(item.getPayload());
	}
}
