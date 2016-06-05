package com.pranav.datastructure.queue;

import java.util.Stack;

class MyQueue{
	private Stack<Integer> q_stack = new Stack<>();
	
	public void enQueue(int item) {
		q_stack.push(item);
	}

	public Stack<Integer> getQ_stack() {
		return q_stack;
	}

	public void setQ_stack(Stack<Integer> q_stack) {
		this.q_stack = q_stack;
	}
	
	public int deQueue(){
		return deQueue(this.q_stack);
	}
	private int deQueue(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return stack.pop();
		}
		int item = stack.pop();
		int result = deQueue(stack);
		stack.push(item);
		return result;
	}

	@Override
	public String toString() {
		return q_stack.toString();
	}
} 
public class QueueUsingOneStack {
	 public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
	}
}
