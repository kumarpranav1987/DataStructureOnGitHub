package com.pranav.datastructure.linkedlist.generic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		LinkedList<Tenant> tenantLinkedList = new LinkedList<Tenant>();

		// Node<Tenant> myTenatNode = new Node<Tenant>();
		Node<Tenant> newTenatNode = new Node<Tenant>();
		// Tenant t1 = new Tenant(name, category,lease, squareFeet);
		// Tenant t2 = new Tenant();
		// myTenatNode.setData(t1);
		// tenantLinkedList.addFirst(myTenatNode);

		// tenantLinkedList.print();

		/*
		 * Node<Integer> myNewNode = new Node<Integer>(); Node<Integer> myNewNode2 = new
		 * Node<Integer>(); Node<Integer> myNewNode3 = new Node<Integer>();
		 * Node<Integer> myNewNode4 = new Node<Integer>(); Node<Integer> myNewNode5 =
		 * new Node<Integer>();
		 * 
		 * myNewNode.setData(50); myNewNode2.setData(2); myNewNode3.setData(30);
		 * myNewNode4.setData(10); myNewNode5.setData(8);
		 * 
		 * myLinkedList.addFirst(myNewNode); myLinkedList.addFirst(myNewNode2);
		 * myLinkedList.addFirst(myNewNode3); myLinkedList.addFirst(myNewNode4);
		 */

		/*
		 * myLinkedList.addLast(myNewNode5); myLinkedList.deletedFirst();
		 */

		// myLinkedList.addAtStart(myNewNode5);;

		// myLinkedList.selectionSort();

		// System.out.println();
		// myLinkedList.printDisplay();

		/*
		 * myLinkedList.getCount(); Node mytravese = myLinkedList.traverseArrList();
		 */
		// System.out.print("Travel elements: " + mytravese.getData() + " ");

		// boolean item = myLinkedList.search(25);

		// System.out.println("The search method returned: " + item);

		System.out.println("Please enter your numeric option choice: ");
		int option = 0;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("Enter your option");
			System.out.println("1 --- Add First");
			System.out.println("2 --- Remove First");
			System.out.println("3 --- Add Last");
			System.out.println("4 --- Traverse");
			System.out.println("5 --- Sequential Search");
			System.out.println("6 --- Selection Sort");
			System.out.println("0 --- Exit");
			option = Integer.parseInt(s.nextLine());
			switch (option) {
			case 1:
				// Node<Tenant> newTenatNode = new Node<Tenant>();

				// String str = scan.nextLine();

				System.out.println("Enter the tenant name: ");
				String name = scan.nextLine();

				// String str = scan.nextLine();

				System.out.println("Enter the category: ");
				String category = scan.nextLine();

				System.out.println("Enter the leasing term in years:");
				int lease = Integer.parseInt(s.nextLine());

				System.out.println("Enter the square feet: ");
				int squareFeet = Integer.parseInt(s.nextLine());

				Tenant tenantObj = new Tenant(name, category, lease, squareFeet);
				newTenatNode.setData(tenantObj);
				tenantLinkedList.addFirst(newTenatNode);
				// tenantLinkedList.print();
				// System.out.println();
				System.out.println("The tenant is added to the 'head' of the linked list.");
				break;
			case 2:

				// tenantLinkedList.deletedFirst();

				break;
			case 3:
				Node<Tenant> TenatAddLastNode = new Node<Tenant>();

				// String str2 = scan.nextLine();

				System.out.println("Enter the tenant name: ");
				String nameOfTenant = scan.nextLine();

				// scan.nextLine(); //This prevents two string scanner following each others

				System.out.println("Enter the category: ");
				String tenantCategory = scan.nextLine();

				System.out.println("Enter the leasing term in years:");
				int tenantLease = Integer.parseInt(s.nextLine());

				System.out.println("Enter the square feet: ");
				int tenantSquareFeet = Integer.parseInt(s.nextLine());

				Tenant tenantObjAddLast = new Tenant(nameOfTenant, tenantCategory, tenantLease, tenantSquareFeet);
				TenatAddLastNode.setData(tenantObjAddLast);
				tenantLinkedList.addLast(TenatAddLastNode);
				// tenantLinkedList.print();
				// System.out.println();
				System.out.println("The tenant is added to the 'tail' of the linked list.");

				break;
			case 4:
				// myLinkedList.getCount();
//			Node mytravese = myLinkedList.traverseArrList();
				break;
			case 5:
				// System.out.println("Enter Name of Tenant to be searched");

//			Node tenantName = s.nextLine();
//			boolean item =  myLinkedList.search(tenantName);	
				break;
			case 6:

				// 1String Category_name;
				// System.out.print("Enter your category name: ");
				// Category_name = s.nextLine( );
//			printListTenantName(Category_name);

				break;
			case 0:
				break;
			default:
				System.out.println("Available options 1/2/3/4/5/6/0");
				break;
			}
		} while (option != 0);
		tenantLinkedList.print();
		System.out.println();

		s.close();

	}
}
