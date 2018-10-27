package Redbox;


public class Tree <Node extends BinaryNode<Payload>, Payload extends Comparable<Payload>>
{
	private BinaryNode<Payload> root;
	
	public Tree(){root = null;}

	// starter public function that takes a string
	public Payload search(Payload search)
	{
		if (root == null)
			return null;
		else if (root.getPayload().compareTo(search) == 0)
			return root.getPayload();
		else if (root.getPayload().compareTo(search) < 0)
			return search(root.getRight(), search);

		return search(root.getLeft(), search);
	}
	
	// main search recursor
	private Payload search(BinaryNode<Payload> cur, Payload search)
	{
		if (cur == null)
			return null;
		if (cur.getPayload().compareTo(search) == 0)
			return cur.getPayload();
		if (cur.getPayload().compareTo(search) < 0)
			return search(cur.getRight(), search);
		// else comparteTo(search) > 0
		return search(cur.getLeft(), search);
	}
	
	// insert a node into our tree, assumes no duplicates will be passed
	public void insert(BinaryNode<Payload> item)
	{
		if (root == null)
			root = item;
		else if (item.getPayload().compareTo(root.getPayload()) < 0)
		{
			if (root.getLeft() == null)
				root.setLeft(item);
			else
				insert(root.getLeft(), item);
		}
		else if (item.getPayload().compareTo(root.getPayload()) > 0)
		{
			if (root.getRight() == null)
				root.setRight(item);
			else
				insert(root.getRight(), item);
		}
	}
	// main recursor for insert function
	private void insert(BinaryNode<Payload> cur, BinaryNode<Payload> item)
	{
		if (item.getPayload().compareTo(cur.getPayload()) < 0)
		{
			if (root.getLeft() == null)
				root.setLeft(item);
			else
				insert(root.getLeft(), item);
		}
		else if (item.getPayload().compareTo(cur.getPayload()) > 0)
		{
			if (root.getRight() == null)
				root.setRight(item);
			else
				insert(root.getRight(), item);
		}
	}
	public void output()
	{
		output(root);
	}

	private void output(BinaryNode<Payload> item)
	{
		if(item.getLeft() != null)
		{
			output(item.getLeft());
		}
		if(item.getRight() != null)
		{
			output(item.getLeft());
		}
		System.out.print(item.getPayload() + " ");
	}
}