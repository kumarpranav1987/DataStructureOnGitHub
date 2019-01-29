package assignment;

import java.util.Scanner;

public class MergeSortAssignment {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		s.close();
		if(k%2 == 0) {
			System.out.println("-1");
		}else {
			int[] data = new int[n];
			for(int i=0;i<n;i++) {
				data[i] = i+1;
			}
			k=k-1;
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
			k=k-2;
			modifyData(data, i, mid, k);
			modifyData(data, mid+1, j, k);
		}
		
	}
}
