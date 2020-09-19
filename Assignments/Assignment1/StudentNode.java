package TreesPractice;

/**
 * Class StudentNode represents the node in a tree. Each node corresponds to a
 * name and an ID. Based on the ID, the nodes are compared.
 * 
 * @author Sanyam
 *
 */

public class StudentNode {

	private int id;
	private String name;
	private StudentNode left, right;

	/**
	 * Constructs a StudentNode object, which is called whenever a new node is
	 * constructed.
	 * 
	 * @param name represents name of the node
	 * @param id   represents key of the node
	 */

	public StudentNode(String name, int id) {

		setName(name);
		setId(id);
		setLeft(null);
		setRight(null);
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

	public StudentNode getLeft() {
		return left;
	}

	public void setLeft(StudentNode left) {
		this.left = left;
	}

	public StudentNode getRight() {
		return right;
	}

	public void setRight(StudentNode right) {
		this.right = right;
	}

}
