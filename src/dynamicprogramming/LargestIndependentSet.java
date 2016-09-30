package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/largest-independent-set-problem/
 * @author munishk
 *
 */
public class LargestIndependentSet {
	static class Node {
		int value;
		Node left; Node right;

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public Node(int value) {
			super();
			this.value = value;
		}
		@Override
		public String toString() {
			return value + "";
		}
	}
	
	static class Result {
		List<Node> nodes = new ArrayList<>();
		
	   void append(Node node) {
		   if(node == null) {
			   return;
		   }
		   if(this.nodes == null) {
			   nodes = new ArrayList<>();
		   }
		   nodes.add(node);
	   }
	   
	   Result append(Result res) {
		   if(res == null) {
			   return this;
		   }
		   if(res.nodes == null) {
			   return this;
		   }
		   
		   this.nodes.addAll(res.nodes);
		   return this;
	   }
	   
	   int size() {
		   if(nodes == null) {
			   return 0;
		   }
		   return nodes.size();
	   }

	@Override
	public String toString() {
		return "Result [nodes=" + nodes + "]";
	}
	}
	
	static Result LIS(Node root) {
		if(root == null) {
			return new Result();
		}
		
		Result lis_excl = LIS(root.left).append(LIS(root.right));
		
		Result lis_incl = null;
	    if(root.left != null) {
	    	lis_incl =  LIS(root.left.left).append(LIS(root.left.right));
	    }
	    if(root.right != null) {
	    	lis_incl =   LIS(root.right.left).append(LIS(root.right.left));
	    }
	    
	    if(lis_incl == null) {
	    	lis_incl = new Result();
	    }
	    lis_incl.append(root);
	    
	    return lis_excl.size() > lis_incl.size() ? lis_excl : lis_incl;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.left.right.left = new Node(70);
		root.left.right.right = new Node(80);
		
		/*root.right = new Node(30);
		root.right = new Node(60);*/
		
		Result res = LIS(root);
		System.out.println(res);

	}

}
