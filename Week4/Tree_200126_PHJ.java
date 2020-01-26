	
	public class Tree {
		class Node{
			int data;
			Node left;
			Node right;
		}
		
		public Node root;
		public void setRoot(Node node) {
			this.root = node;
		}
		public Node getRoot() {
			return root;
		}
		
		public Node createNode(Node left, int data, Node right) {
			Node node = new Node();
			node.data = data;
			node.left = left;
			node.right = right;
			
			return node;
		}
		
		public void inOrder(Node node) {
			if(node != null) {
				inOrder(node.left);
				System.out.println(node.data);
				inOrder(node.right);
			}
		}
		
		public void preOrder(Node node) {
			if(node != null) {
				System.out.println(node.data);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		
		public void postOrder(Node node) {
			if(node != null) {
				preOrder(node.left);
				preOrder(node.right);
				System.out.println(node.data);
			}
		}
		
		public static void main(String[] args) {
			Tree t = new Tree();
			Node n4 = t.createNode(null, 4, null);
	        Node n5 = t.createNode(null, 5, null);
	        Node n2 = t.createNode(n4, 2, n5);
	        Node n3 = t.createNode(null, 3, null);
	        Node n1 = t.createNode(n2, 1, n3);
	        
	        t.setRoot(n1);
	        t.inOrder(t.getRoot());
		}
	}
