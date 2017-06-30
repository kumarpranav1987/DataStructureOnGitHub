package com.pranav.geeksforgeeks;
/*http://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
*/public class PrintABinaryTreeInVerticalOrder {

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class GfG {
		class Depth {
			int min = 0;
			int max = 0;
		}

		void verticalOrder(Node node) {
			Depth d = new Depth();
			verticalOrder(node, 0, d);
			for (int i = d.min; i <= d.max; i++) {
				printNodeAtAParticularDistance(node, 0, i);
				System.out.print("$");
			}
		}

		private void printNodeAtAParticularDistance(Node node, int distancefromRoot, int requiredDistance) {
			if(node==null){
				return;
			}else {
				if(distancefromRoot==requiredDistance){
					System.out.print(node.data+" ");
				}
				printNodeAtAParticularDistance(node.left, distancefromRoot-1, requiredDistance);
				printNodeAtAParticularDistance(node.right, distancefromRoot+1, requiredDistance);
			}
		}

		private void verticalOrder(Node node, int distanceFromRoot, Depth d) {
			if (node == null) {
				return;
			} else {
				if (distanceFromRoot < d.min) {
					d.min = distanceFromRoot;
				}
				if (distanceFromRoot > d.max) {
					d.max = distanceFromRoot;
				}
				verticalOrder(node.left, distanceFromRoot - 1, d);
				verticalOrder(node.right, distanceFromRoot + 1, d);
			}
		}
	}
}
