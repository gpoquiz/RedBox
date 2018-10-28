package Redbox;
/*
     * Grant Poquiz
     * gep160230
     * 2336.003
     * Jason Smith
     * 10/26/2018
     * Our tree class for holding our binary tree.
*/
public class Tree <Payload extends Comparable<Payload>> implements Cloneable
{
	// root as the head of the tree
	private BinaryNode<Payload> root;

	// stnadard getters/setters
	public BinaryNode<Payload> getRoot(){return root;}
	public void setRoot(BinaryNode<Payload> root){this.root = root;}
	// default constructor
	public Tree(){root = null;}
	// copy constructor
	public Tree(Tree<Payload> original)
	{
		root = clone(original).getRoot();
	}
	// starter public function that takes a string
	public BinaryNode<Payload> search(Payload search)
	{
		if (root == null)
			return null;
		else if (root.getPayload().compareTo(search) == 0)
			return root;
		else if (root.getPayload().compareTo(search) < 0)
			return search(root.getRight(), search);

		return search(root.getLeft(), search);
	}
	// main search recursor
	private BinaryNode<Payload> search(BinaryNode<Payload> cur, Payload search)
	{
		if (cur == null)
			return null;
		if (cur.getPayload().compareTo(search) == 0)
			return cur;
		if (cur.getPayload().compareTo(search) < 0)
			return search(cur.getRight(), search);
		// else comparteTo(search) > 0
		return search(cur.getLeft(), search);
	}
	
	// insert a node into our tree, assumes no duplicates will be passed
	public void insert(Payload item)
	{
		insert(new BinaryNode<Payload>(item));
	}
	// insert a node into our tree, assumes no duplicates will be passed
	private void insert(BinaryNode<Payload> item)
	{
		if (root == null)
		{
			root = item;
		}
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
		if(cur == null)
			return;
		if (item.getPayload().compareTo(cur.getPayload()) < 0)
		{
			if (cur.getLeft() == null)
				cur.setLeft(item);
			else
				insert(cur.getLeft(), item);
		}
		else if (item.getPayload().compareTo(cur.getPayload()) > 0)
		{
			if (cur.getRight() == null)
				cur.setRight(item);
			else
				insert(cur.getRight(), item);
		}
	}
	
	public Payload delete(Payload Search)
	{
		BinaryNode<Payload> deletion = search(Search);
		switch(deletion.getNumChildren())
		{
		case 0:
			
		}
		return return deletion.getPayload();
	}
	@Override
	public String toString()
	{
		String returnString = "";
		returnString = toString(root);
		return returnString;
	}
	
	public String toString(BinaryNode<Payload> item)
	{
		String hold = "";
		if(item.getLeft() != null)
			hold += toString(item.getLeft());
		if(item.getRight() != null)
			hold += toString(item.getRight());
		return (hold + item.getPayload() + " ");
	}
	
	// output the tree post order depth first
	public void output()
	{
		System.out.println("Post Order Depth First");
		output(root);
		System.out.println();
	}
	// main recursor for output
	private void output(BinaryNode<Payload> item)
	{
		if(item.getLeft() != null)
			output(item.getLeft());
		if(item.getRight() != null)
			output(item.getRight());
		System.out.print(item.getPayload() + " ");
	}
	
	// clone a tree, return that new tree
	public Tree<Payload> clone(Tree<Payload> original)
	{
		Tree<Payload> newTree = new Tree<Payload>();
		clone(original.getRoot(), newTree);
		return newTree;
	}
	private void clone(BinaryNode<Payload> cur, Tree<Payload> newTree)
	{
		newTree.insert(cur.getPayload());
		if(cur.getLeft() != null)
			clone(cur.getLeft(), newTree);
		if(cur.getRight() != null)
			clone(cur.getRight(), newTree);
	}
	
	// test if both trees are equal
	public boolean equals(Tree<Payload> otherTree)
	{
		return this.toString().equals(otherTree.toString());
	}
}