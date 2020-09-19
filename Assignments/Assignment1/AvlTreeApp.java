package AVLImplementation;

/**
 * TreeApp represents front-end for Trees. It calls the functions to insert and
 * delete the nodes.
 * 
 * @author Sanyam
 *
 */

public class AvlTreeApp {

	public static void main(String[] args) {
		
		System.out.println("Tree App");
		
		AvlStudentTree myTree = new AvlStudentTree();
		myTree.insertNode(new AvlStudentNode("Sarah",10));
		
		
		myTree.insertNode(new AvlStudentNode("Bob",5));
		System.out.println("\nPrinting the elements preorder");
		myTree.printPreorder();
		
		
		myTree.insertNode(new AvlStudentNode("Sam",2));
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
		myTree.insertNode(new AvlStudentNode("joe",7));
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
		myTree.insertNode(new AvlStudentNode("a",17));
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
		myTree.insertNode(new AvlStudentNode("b",12));
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
		myTree.insertNode(new AvlStudentNode("c",20));
		myTree.insertNode(new AvlStudentNode("e",15));
		myTree.insertNode(new AvlStudentNode("f",23));
		myTree.insertNode(new AvlStudentNode("g",34));
		myTree.insertNode(new AvlStudentNode("h",8));
		myTree.insertNode(new AvlStudentNode("i",6));
		myTree.insertNode(new AvlStudentNode("i",100));
		myTree.insertNode(new AvlStudentNode("i",18));
		myTree.insertNode(new AvlStudentNode("i",32));
		
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
		myTree.insertNode(new AvlStudentNode("i",104));
		myTree.insertNode(new AvlStudentNode("i",103));
		
		System.out.println("\n\nPrinting the elements preorder");
		myTree.printPreorder();
		
	}
}
