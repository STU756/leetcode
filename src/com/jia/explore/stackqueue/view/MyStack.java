package com.jia.explore.stackqueue.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class MyStack {
	private List<Integer> data;

	public MyStack() {
		data = new ArrayList<Integer>();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public int top() {
		return data.get(data.size() - 1);
	}

	public void push(int x) {
		data.add(x);
	}

	public boolean pop() {
		if (isEmpty())
			return false;
		data.remove(data.size() - 1);
		return true;
	}

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(1);
		s.push(2);
		s.push(3);
		for (int i = 0; i < 4; ++i) {
			if (!s.isEmpty()) {
				System.out.println(s.top());
			}
			System.out.println(s.pop());
		}
	}
}
