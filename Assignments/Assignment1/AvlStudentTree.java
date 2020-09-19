package AVLImplementation;

/**
 * Class studentTree represents an AVL tree. It includes all the functions
 * performing back end functionality i.e. inserting and deleting the node in the
 * tree.
 * 
 * Reference : https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * 
 * @author Sanyam
 *
 */
public class AvlStudentTree {
	private AvlStudentNode root;

	public AvlStudentTree() {
		setRoot(null);
	}

	public AvlStudentNode getRoot() {
		return root;
	}

	public void setRoot(AvlStudentNode root) {
		this.root = root;
	}

	/**
	 * Integer heightNode(StudentNode node) calculates the height of the node
	 * 
	 * @param node for which height is to be calculated
	 * @return the height of the node
	 */
	public int heightNode(AvlStudentNode node) {
		if (node == null)
			return 0;
		else
			return node.getHeight();
	}

	/**
	 * Integer max(Integer a, Integer b) find the greater number between the two.
	 * 
	 * @param a first number
	 * @param b second number
	 * @return the greater number among both the numbers
	 */
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * StudentNode rightRotation(StudentNode node) performs the right rotation
	 * around the node that is passed as the parameter.
	 * 
	 * @param node around which right rotation is performed
	 * @return the final node after rotation
	 */
	AvlStudentNode rightRotation(AvlStudentNode node) {

		// accessing nodes
		AvlStudentNode left = node.getLeft();
		AvlStudentNode right = left.getRight();

		// changing pointers(i.e. performing rotation)
		node.setLeft(right);
		left.setRight(node);

		// adjusting the height of the nodes
		node.setHeight((max(heightNode(node.getLeft()), heightNode(node.getRight()))) + 1);
		left.setHeight((max(heightNode(left.getLeft()), heightNode(left.getRight()))) + 1);

		return left;
	}

	/**
	 * StudentNode leftRotation(StudentNode node) performs the left rotation around
	 * the node that is passed as the parameter.
	 * 
	 * @param node around which left rotation is performed
	 * @return the final node after rotation
	 */
	AvlStudentNode leftRotation(AvlStudentNode node) {

		// accessing nodes
		AvlStudentNode right = node.getRight();
		AvlStudentNode left = right.getLeft();

		// changing pointers(i.e. performing rotation)
		node.setRight(left);
		right.setLeft(node);

		// adjusts the height of the nodes
		node.setHeight((max(heightNode(node.getLeft()), heightNode(node.getRight()))) + 1);
		right.setHeight((max(heightNode(right.getLeft()), heightNode(right.getRight()))) + 1);

		return right;
	}

	/**
	 * getBalance(StudentNode node) returns the balance of the node
	 * 
	 * @param node for which balance is to be calculated
	 * @return the balance
	 */
	int getBalance(AvlStudentNode node) {
		if (node == null)
			return 0;

		// subtracts left height from right height to get balance
		return heightNode(node.getLeft()) - heightNode(node.getRight());
	}

	/**
	 * StudentNode insertNode(StudentNode node) calls insert function to insert the
	 * node passed as an argument.
	 * 
	 * @param node represents the node that is to be inserted
	 * @return the current root node
	 */
	public AvlStudentNode insertNode(AvlStudentNode node) {
		root = insert(root, node);
		return root;
	}

	/**
	 * StudentNode insert(StudentNode root, StudentNode node) inserts the node in
	 * the tree.
	 * 
	 * @param root represents root node of the tree
	 * @param node represents the node to be inserted
	 * @return the root node
	 */
	private AvlStudentNode insert(AvlStudentNode root, AvlStudentNode node) {

		if (node == null)
			return null;

		// make sure both left and right are null
		node.setLeft(null);
		node.setRight(null);

		if (root == null)
			root = node;
		// binary search tree insertion
		if (root.getId() < node.getId())
			root.setRight(insert(root.getRight(), node));
		else if (root.getId() > node.getId())
			root.setLeft(insert(root.getLeft(), node));
		else // duplicate keys not allowed
			return node;

		// Update height of this ancestor node
		root.setHeight(1 + max(heightNode(root.getLeft()), heightNode(root.getRight())));

		// balance of ancestor node
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && node.getId() < root.getLeft().getId())
			return rightRotation(root);

		// Right Right Case
		if (balance < -1 && node.getId() > root.getRight().getId())
			return leftRotation(root);

		// Left Right Case
		if (balance > 1 && node.getId() > root.getLeft().getId()) {
			root.setLeft(leftRotation(root.getLeft()));
			return rightRotation(root);
		}

		// Right Left Case
		if (balance < -1 && node.getId() < root.getRight().getId()) {
			root.setRight(rightRotation(root.getRight()));
			return leftRotation(root);
		}

		/* return the (unchanged) node pointer */
		return root;

	}

	/**
	 * printInorder() calls the TraverseInorder() for traversing the tree in
	 * in-order manner.
	 */
	public void printInorder() {
		TraverseInorder(getRoot());
	}

	/**
	 * TraverseInorder(StudentNode cursor) traverses the tree in 'in-order'
	 * 
	 * @param cursor represents the root node of the tree
	 */
	private void TraverseInorder(AvlStudentNode cursor) {
		if (cursor != null) {
			TraverseInorder(cursor.getLeft());
			System.out.print(cursor.getId() + " ");
			TraverseInorder(cursor.getRight());
		}
	}

	/**
	 * printPreorder() calls the TraversePreorder() for traversing the tree in
	 * 'pre-order' manner
	 */
	public void printPreorder() {
		TraversePreorder(getRoot());
	}

	/**
	 * TraversePreorder(StudentNode cursor) traverses the tree in 'Pre-order' manner
	 * 
	 * @param cursor represents the root node of the tree
	 */
	private void TraversePreorder(AvlStudentNode cursor) {
		if (cursor != null) {
			System.out.print(cursor.getId() + " ");
			TraversePreorder(cursor.getLeft());
			TraversePreorder(cursor.getRight());
		}
	}

	/**
	 * printPostorder() calls the TraversePostorder() for traversing the tree in
	 * 'Post-order' manner
	 */
	public void printPostorder() {
		TraversePostorder(getRoot());
	}

	/**
	 * TraversePostorder(StudentNode cursor) traverses the tree in 'Post-order'
	 * 
	 * @param cursor represents the root node of the tree
	 */
	private void TraversePostorder(AvlStudentNode cursor) {
		if (cursor != null) {
			TraversePostorder(cursor.getLeft());
			TraversePostorder(cursor.getRight());
			System.out.println(cursor.getId());
		}
	}

}
