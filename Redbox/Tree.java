package Redbox;


public class Tree <Node extends LeftRightPointable, Comparable<Node>, Payload extends Comparable<Payload>>
{
	private Node root;
	
	// starter public function that takes a string
	public Payload search(Payload search)
	{
		if (root == null)
			return null;
		else if (root.compareTo(search) == 0)
			return root;
		else if (root.compareTo(search) < 0)
			return search(root.getRight(), search);

		return search(root.getLeft(), search);
	}
	
	// main search that recursively iterates through tree
	private Payload search(Node cur, Payload search)
	{
		if (cur == null)
			return null;
		if (cur.compareTo(search) == 0)
			return cur;
		if (cur.compareTo(search) < 0)
			return search(cur.getRight(), search);
		// else comparteTo(search) > 0
		return search(cur.getLeft(), search);
	}
}