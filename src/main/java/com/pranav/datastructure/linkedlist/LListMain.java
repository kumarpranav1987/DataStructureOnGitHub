package com.pranav.datastructure.linkedlist;

public class LListMain {

	public static void main(String[] args) {
		LList lList = new LList();
		populateList(lList);
		lList.print();

	}

	private static void populateList(LList lList) {
		for (int i = 1; i <= 6; i++) {
			lList.insertLast(i);
		}
	}
}
