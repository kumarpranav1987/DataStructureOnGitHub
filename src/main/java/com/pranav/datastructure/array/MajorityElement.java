package com.pranav.datastructure.array;


/**
 * Majority Element: A majority element in an array A[] of size n is an element
 * that appears more than n/2 times (and hence there is at most one such
 * element).
 */
public class MajorityElement {
	public static void main(String[] args) {
		int data[] = new int[]{1,1,1,5,1,2,3};
		int key = findMajorityElement(data);
		if(findCount(data, key) > (data.length)/2){
			System.out.println(key);
		}else {
			System.out.println("Not Found");
		}
	}

	private static int findMajorityElement(int[] data) {
		int index_of_maj_ele = 0;
		int count = 1;
		for (int i = 1; i < data.length; i++) {
			if (data[i] == data[index_of_maj_ele]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				index_of_maj_ele = i;
				count = 1;
			}
		}
		return data[index_of_maj_ele];
	}
	private static int findCount(int[] data,int key){
		int count =0;
		for(int i =0; i<data.length;i++){
			if(data[i]==key){
				count++;
			}
		}
		return count;
	}
}
