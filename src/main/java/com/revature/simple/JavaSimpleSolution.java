package com.revature.simple;

import java.util.Stack;

public class JavaSimpleSolution implements JavaSimple {

	@Override
	public int castToInt(double n) {
		return (int) n;
	}

	@Override
	public byte castToByte(short n) {
		return (byte) n;
	}

	@Override
	public double divide(double operandOne, double operandTwo) throws IllegalArgumentException {
		if (operandTwo == 0)
			throw new IllegalArgumentException("Can't divide by 0!");
		return operandOne / operandTwo;
	}

	@Override
	public boolean isEven(int n) {
		double result = (double) n / 2.0;
		int nonDec = (int) result;
		result = result - nonDec;

		if (result > 0)
			return false;
		return true;
	}

	@Override
	public boolean isAllEven(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if (isEven(array[i]) == false)
				return false;				
		}
		return true;
	}

	@Override
	public double average(int[] array) throws IllegalArgumentException {
		if (array == null)
			throw new IllegalArgumentException("Can't have empty array!");
		double sum = 0;
		for(int i = 0; i < array.length; i++)
			sum += array[i];
		return sum / array.length;
	}

	@Override
	public int max(int[] array) throws IllegalArgumentException {
		if (array == null)
			throw new IllegalArgumentException("Can't have empty array!");
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if (max < array[i])
				max = array[i];
		}
		return max;
	}

	@Override
	public int fibonacci(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("Can't have negative number!");
		
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			int a = 0;
			int b = 1;
			int val = 0;
			for (int i = 2; i <= n; i++) {
				val = a + b;
				a = b;
				b = val;
			}
			return val;
		}
	}

	@Override
	public int[] sort(int[] array) throws IllegalArgumentException {

		for(int i = 0; i < array.length - 1; i++) {
			int idx = i;
			for(int j = i+1; j < array.length; j++) {
				if (array[j] < array[idx]) {
					idx = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[idx];
			array[idx] = temp;
		}
		
		return array;
	}

	@Override
	public int factorial(int n) throws IllegalArgumentException {
		if (n < 0)
			throw new IllegalArgumentException("Can't have negative number!");
		
		if (n == 0 || n == 1)
			return 1;
		else {
			return n * factorial(n-1);
		}
	}

	@Override
	public int[] rotateLeft(int[] array, int n) throws IllegalArgumentException {
		while(n > array.length) {
			n = n - array.length;
		}
		if (n < 0 || array == null)
			throw new IllegalArgumentException("Can't have negative number or empty array!");
		int location = 0;
		int[] returnArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			location = i - n;
			if (location < 0)
				location = array.length - n + i;
			returnArray[location] = array[i];
		}
		return returnArray;
	}

	@Override
	public String isPrime(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Can't have negative number!");
		int i;
		for(i = 2; i < n && n%i != 0; i++);
		return (n != 0 && n != 1 && n%--i != 0) ? "true" : "false";
	}

	@Override
	public boolean balancedBrackets(String brackets) throws IllegalArgumentException {
		if (brackets == null)
			throw new IllegalArgumentException("Can't have null value!");
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < brackets.length(); i++) {
			//parens
			if (brackets.charAt(i) == '(')
				stack.push('(');
			else if (brackets.charAt(i) == ')') {
				if((char)stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
			//curlys
			else if (brackets.charAt(i) == '{')
				stack.push('{');
			else if (brackets.charAt(i) == '}') {
				if((char)stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
			//brackets
			else if (brackets.charAt(i) == '[')
				stack.push('[');
			else if (brackets.charAt(i) == ']') {
				if((char)stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
		}
		
		if(stack.empty() == false)
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		JavaSimpleSolution demo = new JavaSimpleSolution();
		System.out.println(demo.castToInt(3.1));
		short n = -128;
		System.out.println(demo.castToByte(n));
		System.out.println(demo.divide(3,  2));
		System.out.println(demo.isEven(2));
		System.out.println(demo.isEven(5));
		int array[] = {0, 2, 4, 6, 8};
		System.out.println(demo.isAllEven(array));
		System.out.println(demo.average(array));
		System.out.println(demo.max(array));
		System.out.println(demo.fibonacci(5));
		int array1[] = {2,4,5,1,3,1};
		array1 = demo.sort(array1);
		for (int element: array1) {
			System.out.print(element + ", ");
		}
		System.out.println();
		System.out.println(demo.factorial(3));
		int array2[] = {1,2,3,4,5};
		array = demo.rotateLeft(array2, 3);
		for (int element: array) {
			System.out.print(element + ", ");
		}
		System.out.println();
		System.out.println(demo.isPrime(5));
		System.out.println(demo.balancedBrackets("({[]})"));
		System.out.println(demo.balancedBrackets("([)]"));
		
	}

}
