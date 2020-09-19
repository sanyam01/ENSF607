package TreesPractice;

/**
 * TreeApp represents front-end for Trees. It calls fucntions to insert and
 * delete the nodes.
 * 
 * @author Sanyam
 *
 */
public class TreeApp {

	public static void main(String[] args) {
		
		System.out.println("Tree App");
		
		studentTree myTree = new studentTree();
		myTree.insert(new StudentNode("Sarah",10));
		myTree.insert(new StudentNode("Bob",5));
		myTree.insert(new StudentNode("Sam",2));
		myTree.insert(new StudentNode("joe",7));
		myTree.insert(new StudentNode("a",17));
		myTree.insert(new StudentNode("b",12));
		myTree.insert(new StudentNode("c",20));
		myTree.insert(new StudentNode("e",15));
		myTree.insert(new StudentNode("f",23));
		myTree.insert(new StudentNode("g",34));
		myTree.insert(new StudentNode("h",8));
		myTree.insert(new StudentNode("i",6));
		myTree.insert(new StudentNode("j",100));
		myTree.insert(new StudentNode("k",18));
		myTree.insert(new StudentNode("l",32));
		
		System.out.println("Printing the elements inorder");
		myTree.printInorder();

		
		myTree.delete(12);
		System.out.println("\n\nTree after deletion 12 is : ");
		myTree.printInorder();
		
		myTree.delete(17);
		System.out.println("\n\nTree after deletion 17 is : ");
		myTree.printInorder();
		
		myTree.delete(20);
		System.out.println("\n\nTree after deletion 20 is : ");
		myTree.printInorder();
		
		myTree.delete(10);
		System.out.println("\n \nTree after deletion is 10: ");
		myTree.printInorder();
		
		myTree.delete(34);
		System.out.println("\n \nTree after deletion 34 is : ");
		myTree.printInorder();
		
		myTree.delete(7);
		System.out.println("\n \nTree after deletion 7 is : ");
		myTree.printInorder();
		
		myTree.insert(new StudentNode("i",105));
		myTree.insert(new StudentNode("i",104));
		myTree.insert(new StudentNode("i",106));
		
	    myTree.delete(100);
		System.out.println("\n \nTree after deletion 100 is : ");
		myTree.printInorder();
		
		myTree.delete(104);
		System.out.println("\n \nTree after deletion 104 is : ");
		myTree.printInorder();
		
		myTree.delete(18);
		System.out.println("\n\nTree after deletion 18 is : ");
		myTree.printInorder();
		
		myTree.delete(5);
		System.out.println("\n\nTree after deletion 5 is : ");
		myTree.printInorder();
		
		myTree.insert(new StudentNode("i",1));
		myTree.insert(new StudentNode("i",4));
		
		myTree.delete(2);
		System.out.println("\n\nTree after deletion 2 is : ");
		myTree.printInorder();
		
		
		System.out.println("\n\nTree as preorder is : ");
		myTree.printPreorder();
		
		System.out.println("\n\nTree as postorder is : ");
		myTree.printPostorder();
		
	}
}
