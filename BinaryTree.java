package basicAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	static Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}

		return current;
	}

	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}

		if (value == current.value) {
			return true;
		}

		return value < current.value ? containsNodeRecursive(current.left, value)
				: containsNodeRecursive(current.right, value);
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private static BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		return bt;
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Leaf node
			if (current.left == null && current.right == null) {
				return null;
			}

			// Node with only one child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}
			
			// Node with 2 child node
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;

		}

		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
		}

		current.right = deleteRecursive(current.right, value);
		return current;
	}
	
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public void delete(int value) {
	    deleteRecursive(root, value);
	}

	public static void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.println(node.value);
			traverseInOrder(node.right);
		}
	}
	
	public static void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.value);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	
	public static void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.value);
	    }
	}
	
	public static void traverseLevelOrder() {
		if(root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			
			Node node = nodes.remove();
			
			System.out.println(" " + node.value);
			
			if(node.left != null) {
				nodes.add(node.left);
			}
			
			if(node.right != null) {
				nodes.add(node.right);
			}
			
		}
	}
	
	/*public static void main(String args[]) {
		// Create complete binary tree
		createBinaryTree();

		// check whether it contains the specific node
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		bt.add(11);
		bt.add(2);

		BinaryTree.traverseLevelOrder();
		BinaryTree.traverseInOrder(root);
		boolean result = bt.containsNode(11);
		System.out.println(result);
		
		bt.delete(4);
		boolean result1 = bt.containsNode(4);
		bt.delete(9);
		System.out.println(result1);
	}*/
}
