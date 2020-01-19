package edu.cx.searching.bst;

/*
 * 讲解：
 * 二个方法函数，一个寻找关键字--searchkey 另一个是插入一个结点：insertTree
 * 另外这是一个完全的先序遍历二叉树的语法。先根结点，再左结点，如无再右结点，
 * 如此递归至搜索完毕。
 *
 */
public class BinaryTreeTest {
	private static BinaryTree root = null;

	public BinaryTreeTest() {
		init();
	}

	/**
	 * 初始化给定数据的二叉树结构
	 * 
	 */
	private void init() {
		int data[] = { 12, 11, 34, 45, 67, 38, 56, 43, 22, 8 };
		root = new BinaryTree(data[0]);
		System.out.println("构造的二叉树的数据结构:");
		System.out.println("--------------start----------------------");
		System.out.println(data[0] + ":root");
		for (int i = 1; i < data.length; i++) {
			System.out.print(data[i] + ":");
			root.insertTree(root, data[i]);
		}
		System.out.println("----------------end--------------------");
	}

	/*
	 * public void serach(int key) { if (searchkey(root, key)) {
	 * System.out.println("找到了:" + key); } else { System.out.println("没有找到：" +
	 * key); } }
	 * 
	 * private boolean searchkey(BinaryTree root, int key) { if (root == null) {
	 * return false; } else if (root.data == key) { return true; } else if (key
	 * >= root.data) { return searchkey(root.rightpoiter, key); } return
	 * searchkey(root.leftpoiter, key); }
	 */

	class BinaryTree {
		int data;
		BinaryTree lchild;
		BinaryTree rchild;

		BinaryTree(int data) {
			this.data = data;
			lchild = null;// 构造一个新节点是，左右子树为空
			rchild = null;
		}

		private void insertTree(BinaryTree root, int data) {
			/**
			 * 1 对于新节点还没递归而言，每次的root都是从12开始的。树的节点越多，比如30层，每新增一个节点都要遍历30次。 2
			 * 递归中的，有些节点临时充当根节点。
			 */
			if (data >= root.data) {
				if (root.rchild == null) {
					System.out.println(" -> new rchild");
					root.rchild = new BinaryTree(data);
				} else {
					System.out.print(" -> rchild");
					// 递归
					insertTree(root.rchild, data);
				}
			} else {
				if (root.lchild == null) {
					System.out.println(" -> new lchild");
					root.lchild = new BinaryTree(data);
				} else {
					System.out.print(" -> lchild");
					insertTree(root.lchild, data);
				}
			}
		}
	}

	public static void preTraverse(BinaryTree root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}
	}

	/**
	 * 中序遍历
	 */
	public static void inTraverse(BinaryTree root) {
		if (root != null) {
			inTraverse(root.lchild);
			System.out.print(root.data + " ");
			inTraverse(root.rchild);
		}
	}

	/**
	 * 后序遍历
	 */
	public static void postTraverse(BinaryTree root) {
		if (root != null) {
			postTraverse(root.lchild);
			postTraverse(root.rchild);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String args[]) {
		// 创建一棵树
		BinaryTreeTest b = new BinaryTreeTest();
		// BinaryTree root = new BinaryTree(12);
		System.out.println("前序遍历----");
		preTraverse(root);
		//
		// int key = 8; // key：任意数值
		// b.serach(key); // 到二叉树中查找
	}
}
