package assignment;

import java.util.Scanner;

public class MergeSortAssignment {
	public static void main(String[] args) {
		//Taking input from user.
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		s.close();
		//if k is even we will not be able to find the solution because number of mergesort call will be always odd
		//First call on the whole array
		//then every time 2 or zero calls 
		//so total number of calls will be always odd
		if(k%2 == 0) {
			System.out.println("-1");
		}else {
			//initialize the array with values 1 .....n
			int[] data = new int[n];
			for(int i=0;i<n;i++) {
				data[i] = i+1;
			}
			//First Call so decrementing k by 1
			k=k-1;
			//in every modify data call i am reshuffling the data by swapping data at mid index with data at mid-1 index
			//once k reached to zero we have the desired permutation of data
			modifyData(data,0,n-1,k);
			for(int i=0;i<n;i++) {
				System.out.print(data[i]+" ");
			}
		}
	}

	private static void modifyData(int[] data, int i, int j, int k) {
		if(k==0 || i+1 ==j) {
			return;
		}else {
			int mid=(i+j)/2;
			int temp=data[mid];
			data[mid] = data[mid-1];
			data[mid-1]=temp;
			//decrement k by two as we are making to calls
			k=k-2;
			modifyData(data, i, mid, k);
			modifyData(data, mid+1, j, k);
		}
		
	}
}
