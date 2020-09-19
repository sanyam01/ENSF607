package AVLImplementation;

/**
 * Class StudentNode represents the node in an AVL tree. Each node corresponds
 * to a name and an ID. Based on the ID, the nodes are compared.
 * 
 * @author Sanyam
 *
 */

public class AvlStudentNode {

	private int id, height;
	private String name;
	private AvlStudentNode left, right;

	/**
	 * Constructs a StudentNode object, which is called when a new node is
	 * constructed.
	 * 
	 * @param name represents name of the node
	 * @param id   represents key of the node
	 */

	public AvlStudentNode(String name, int id) {

		setName(name);
		setId(id);
		setLeft(null);
		setRight(null);
		setHeight(1);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return name + " " + id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AvlStudentNode getLeft() {
		return left;
	}

	public void setLeft(AvlStudentNode left) {
		this.left = left;
	}

	public AvlStudentNode getRight() {
		return right;
	}

	public void setRight(AvlStudentNode right) {
		this.right = right;
	}

}
