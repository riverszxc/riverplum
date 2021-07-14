/**
 * 
 */
package me.riverz.bishi;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @ClassName: Weibo 
 * @author rivers
 * @date 2017年9月16日 下午4:53:37
 * @Description:
 */
public class Weibo {

	/**@date 2017年9月16日 下午4:53:37
	 * @Description: */
	public static void main(String[] args) {
		Node root = new Node(0);
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		root.left=a;
		root.right=b;
		a.left=c;
		a.right=d;
		b.left=e;
		AddLeftToRight(root);
		while(c!=null){
			System.out.println(c.value);
			c = c.next;
		}

	}
	
	public static void AddLeftToRight(Node root){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node a = q.poll(), b = a;
			while(!q.isEmpty()){
				b.next = q.poll();
				b = b.next;
			}
			while(a != null){
				if(a.left!=null)
					q.add(a.left);
				if(a.right!=null)
					q.add(a.right);
				a = a.next;
			}
		}
		
	}

}
class Node{
	int value;
	Node left, right, next;
	Node(int v){
		value = v;
	}
}

