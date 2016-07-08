package com.pranav.hackerrank;

import java.awt.Image;
import java.util.Scanner;

class MyHeap {
	int maxsize = 100000;
	int[] heap = new int[maxsize];
	int currentHeapLastIndex = -1;

	void insert(int num) {
		heap[++currentHeapLastIndex] = num;
		int current = currentHeapLastIndex;
		while (current != 0) {
			if (heap[current] < heap[(current - 1) / 2]) {
				int temp = heap[current];
				heap[current] = heap[(current - 1) / 2];
				heap[(current - 1) / 2] = temp;
				current = (current - 1) / 2;
			} else {
				break;
			}
		}
	}

	void delete(int num) {
		int indexOfNum = getIndexOfNum(num);
		heap[indexOfNum] = heap[currentHeapLastIndex];
		currentHeapLastIndex--;
		heapify(indexOfNum);
	}

	private void heapify(int indexOfNum) {
		if (checkHeapProperty(indexOfNum)) {
			return;
		} else {
			int minIndex = getMinIndex(indexOfNum);
			int temp = heap[indexOfNum];
			heap[indexOfNum] = heap[minIndex];
			heap[minIndex] = temp;
			heapify(minIndex);
		}
	}

	private int getMinIndex(int indexOfNum) {
		int leftChildInedx = (2*indexOfNum)+1;
		int rightChildIndex = (2*indexOfNum)+2;
		int result = -1;
		if (leftChildInedx <= currentHeapLastIndex && rightChildIndex <= currentHeapLastIndex) {
			if (heap[leftChildInedx] < heap[rightChildIndex]) {
				return leftChildInedx;
			}else {
				return rightChildIndex;
			}
		}else if (leftChildInedx<= currentHeapLastIndex){
			return leftChildInedx;
		}else if (rightChildIndex <= currentHeapLastIndex) {
			return rightChildIndex;
		}else {
			return -1;
		}
		
	}

	private boolean checkHeapProperty(int indexOfNum) {
		int leftChildInedx = (2*indexOfNum)+1;
		int rightChildIndex = (2*indexOfNum)+2;
		int leftdata ;
		int rightdata;
		if (leftChildInedx <= currentHeapLastIndex) {
			leftdata = heap[leftChildInedx];
		}else {
			leftdata = Integer.MAX_VALUE;
			
		}
		
		if (rightChildIndex <= currentHeapLastIndex) {
			rightdata = heap[rightChildIndex];
		}else {
			rightdata = Integer.MAX_VALUE;
			
		}
		
		if (heap[indexOfNum] < leftdata && heap[indexOfNum] < rightdata) {
			return true;
		}
		return false;
	}

	private int getIndexOfNum(int num) {
		int i = 0;
		while (heap[i] != num) {
			i++;
		}
		return i;
	}

	int getMinimum() {
		return heap[0];
	}
}

public class QHEAP1 {

	public static void main(String[] args) {
		MyHeap heap = new MyHeap();
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		for (int i = 0; i < numOfTestCases; i++) {
			int opertionType = s.nextInt();
			switch (opertionType) {
			case 1:
				int num = s.nextInt();
				heap.insert(num);
				break;
			case 2:
				int num1 = s.nextInt();
				heap.delete(num1);
				break;
			case 3:
				System.out.println(heap.getMinimum());
				break;
			default:
				break;
			}
		}

	}

}
