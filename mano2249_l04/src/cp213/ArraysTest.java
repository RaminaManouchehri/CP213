package cp213;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Arrays Lab task methods.
 *
 * @author
 * @version 2022-01-25
 */
public class ArraysTest {

    /**
     * Tests arrays.
     *
     * @param args unused default parameter
     */
    public static void main(final String[] args) {
	System.out.println("Task 1");
	System.out.println(ArraysTest.task1());
	System.out.println("Task 2");
	System.out.println(ArraysTest.task2());
	System.out.println("Task 3");
	System.out.println(ArraysTest.task3());
	System.out.println("Task 4");
	System.out.println(ArraysTest.task4());
	System.out.println("Task 5");
	System.out.println(Arrays.toString(ArraysTest.task5()));
    }

    /**
     * Print the contents of the arrays first and second using a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task1() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	// your code here
	System.out.println("Values in first:");

	for (int i = 0; i < first.length; i++) {
	    System.out.println(first[i]);
	}
	System.out.println("Values in second:");

	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	return true;
    }

    /**
     * Double the contents of the array first with a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task2() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	// your code here
	System.out.println("Values in first:");
	for (int i = 0; i < first.length; i++) {
	    first[i] = first[i] * 2;
	    System.out.println(first[i]);

	}
	System.out.println("Values in second:");
	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	return true;
    }

    /**
     * Double the contents of the array first with an enhanced for loop.
     *
     * @return true if the values in first are permanently changed, false otherwise
     */
    public static boolean task3() {
	final int[] first = { 1, 3, 5, 7, 9 };
	System.out.println("Values in first:");
	for (int value : first) {
	    value = value * 2;
	    System.out.println(value);
	}
	System.out.println("Values in first after update:");
	for (int value : first) {
	    System.out.println(value);
	}
	// your code here
	return false;
    }

    /**
     * Attempt to assign the array first to a row of the 2D array third.
     *
     * @return true if this is allowed, false otherwise
     */
    public static boolean task4() {
	final int[] first = { 1, 3, 5, 7, 9 };
	int rows = 2;
	int columns = 5;
	final int[][] third = new int[rows][columns];
	// your code here
	third[0] = first;
	for (int[] x : third) {
	    for (int y : x) {
		System.out.print(y + " ");
	    }
	    System.out.println();
	}

	return true;
    }

    /**
     * Assign the values 1 through 10 to an Integer ArrayList.
     *
     * @return the contents of the ArrayList as an Integer[] array.
     */
    public static Integer[] task5() {
	final ArrayList<Integer> values = new ArrayList<>();
	int n = values.size();
	Integer[] valuesArray = new Integer[n];
	// your code here
	for (int i = 0; i < 10; i++) {
	    values.add(i);
	}
	valuesArray = values.toArray(valuesArray);
	return valuesArray;

    }
}
