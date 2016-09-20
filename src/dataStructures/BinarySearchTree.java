package dataStructures;

public class BinarySearchTree{
	class Node{
		Node left;
		Node right;
		int value;
		Node(){
			left = null;
			right = null;
		}
		Node(int value){
		  this.value = value;
		}
	}
	  Node root = new Node();
	  
	  BinarySearchTree(int value){
	    root = new Node(value);
	  }
	  //object.insert(value). inserts into the tree
	  public void insert(int value){
	    Node x = new Node(value);
		Node y = this.root;
	
		Node pary = new Node();
		while( y != null){
		  pary = y;
		  if(value < y.value){
			if(y.left == null) {
				pary.left = x;
				break;
			}
		    y = y.left;
		  } 
		  else{
			if(y.right == null){
				pary.right = x;
				break;
			} 
		    y = y.right;
			
		  }
		}		
	  }
	  //object.delete(value). Deletes an object from the tree
	  public void delete(int value, Node x){
		Node y = x;
		Node pary = new Node();
		
		if(value < y.value){
		  pary = y;
		  delete(value, y.left);
		}else if(value > y.value){
		  pary = y;
		  delete(value, y.right);
		}else {
		  if((y.right != null) && (y.left != null)){
		    Node nxt = findMin(y.right);
			y.value = nxt.value;
			delete(value, nxt);
		  }else if(y.right == null){
			  exchange(pary, y.left, true);
		      y = null;
		  }else if(y.left == null){
			  exchange(pary, y.right, true);
		      y = null;
		  }else{
		    y = null;
		  }
		}
	  }
	  void exchange(Node pary, Node y, Boolean x){
		  if(x){
			  if(pary.value < y.value)
				  pary.right = y;
			  else
				  pary.left = y;
		  }
	  }
	  
	  //Find the minimum element in the subtree with the node x, as root.
	  Node findMin(Node x){
	    Node current = x;
		while (current.left != null){
		  current = current.left;
		}
		return current;
	  }
      
	  void inOrderTraversal(Node x){
		  if(x.left != null)
		      inOrderTraversal(x.left);
		  System.out.println(x.value);
		  if(x.right != null)
			  inOrderTraversal(x.right);
		  }
	  public static void main(String args[]){
		  BinarySearchTree bst = new BinarySearchTree(5);
		  bst.insert(3);
		  bst.insert(4);
		  bst.insert(2);
		  bst.insert(9);
		  bst.insert(8);
		  bst.insert(7);
		  bst.delete(9, bst.root);
		  bst.inOrderTraversal(bst.root);
	    
	  }
	}

	