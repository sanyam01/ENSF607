package TreesPractice;

/**
 * Class studentTree represents the tree. It includes all the functions
 * performing back end functionality i.e. inserting and deleting the node in the
 * tree.
 * 
 * @author Sanyam
 *
 */

public class studentTree {
	private StudentNode root;

	public studentTree() {
		setRoot(null);
	}

	public StudentNode getRoot() {
		return root;
	}

	public void setRoot(StudentNode root) {
		this.root = root;
	}

	/**
	 * insert(StudentNode node) gets node as a parameter which is to be inserted in
	 * the tree.
	 * 
	 * @param node represents the node to be inserted.
	 * 
	 */
	public void insert(StudentNode node) {

		// if passed node is null, then do nothing
		if (node == null)
			return;

		// make sure both left and right are null
		node.setLeft(null);
		node.setRight(null);

		// if tree is empty, make passed node as root node
		if (root == null)
			root = node;
		else {
			// start with the root and look for the spot to insert
			StudentNode cursor = getRoot();

			// iterates until spot is found to insert the node
			while (true) {
				StudentNode parent = cursor;

				// checks whether to insert the node to left or right
				if (cursor.getId() > node.getId()) {
					cursor = cursor.getLeft();
					// if left child has no children insert the new node
					if (cursor == null) {
						parent.setLeft(node);
						return;
					}
				} else if (cursor.getId() < node.getId()) {
					cursor = cursor.getRight();
					if (cursor == null) {
						parent.setRight(node);
						return;
					}
				}
				// node is not added if it already exists
				else {
					System.out.println("Student already exists");
					return;
				}

			}

		}
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
	private void TraverseInorder(StudentNode cursor) {
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
	private void TraversePreorder(StudentNode cursor) {
		if (cursor != null) {
			System.out.println(cursor.getId());
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
	private void TraversePostorder(StudentNode cursor) {
		if (cursor != null) {
			TraversePostorder(cursor.getLeft());
			TraversePostorder(cursor.getRight());
			System.out.println(cursor.getId());
		}
	}

	/**
	 * StudentNode delete(int key) calls the function deleteRec, for deleting the
	 * node with Id value equal to key.
	 * 
	 * It returns the root of the tree
	 * 
	 * @param key represents the key to be deleted
	 * @return the root of the tree
	 */
	StudentNode delete(int key) {
		root = deleteRec(root, key);
		return root;
	}

	/**
	 * StudentNode deleteRec(StudentNode root, int key) deletes the node with value
	 * equal to key. It returns the root of the tree.
	 * 
	 * @param root of tree
	 * @param key  represents the node that has to be deleted
	 * @return the root node of the tree
	 * 
	 *         Reference for deleteRec is taken from
	 *         'https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/'
	 * 
	 */
	StudentNode deleteRec(StudentNode root, int key) {
		// If the tree is empty
		if (root == null)
			return root;

		// Recur down to the left or to the right of the tree
		// depending on the node and key values
		if (key < root.getId())
			root.setLeft(deleteRec(root.getLeft(), key));
		else if (key > root.getId())
			root.setRight(deleteRec(root.getRight(), key));

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.setId(minValue(root.getRight()));

			// Delete the in-order successor
			root.setRight(deleteRec(root.getRight(), root.getId()));
		}

		return root;
	}

	// finding the minimum value in sub-tree
	int minValue(StudentNode root) {
		int minv = root.getId();

		// Recurring down to the left end of the subtree
		while (root.getLeft() != null) {
			minv = root.getLeft().getId();
			root = root.getLeft();
		}
		return minv;
	}

}
