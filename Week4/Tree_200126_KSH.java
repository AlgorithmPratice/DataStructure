package datastructure;

public class Tree_200126_KSH {
	class Node{
		String value;
		Node left, right;
		public Node(String value) {
			this.value=value;
			this.left=null;
			this.right=null;
		}
	}
	public Node root;
	
	public void add(String data,String left,String right) {
		if(root==null) {
			if(data.equals("."))root=new Node(data);
			if(left.equals(".")) root.left=new Node(left);
			if(right.equals(".")) root.left=new Node(right);
		}else search(root, data, left, right);
	}
	public void search(Node root,String data,String left, String right) {
		if(root==null) return;
		else if (root.value==data) {
			if(!left.equals(".")) root.left=new Node(left);
			if(!right.equals(".")) root.right=new Node(right);
		}else {
			search(root.left,data,left,right);
			search(root.right,data,left,right);
		}
	}
	
	public void preOrder(Node root) {
		System.out.print(root.value);
		if(root.left!=null)preOrder(root.left);
		if(root.right!=null)preOrder(root.right);
	}
	public void inOrder(Node root) {
		if(root.left!=null)preOrder(root.left);
		System.out.print(root.value);
		if(root.right!=null)preOrder(root.right);
	}
	public void postOrder(Node root) {
		if(root.left!=null)preOrder(root.left);
		if(root.right!=null)preOrder(root.right);
		System.out.print(root.value);
	}
}
