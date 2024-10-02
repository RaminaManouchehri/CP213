package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author your name, id, email here
 * @version 2023-05-07
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {

	// your code here
	int s = 0;
	int total = 0;
	int size = 0;
	if (foods.isEmpty() == false) {
	    for (Food food : foods) {
		total += food.getCalories();
		size++;
	    }
	    s = total / size;

	}
	return s;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {

	// your code here
	int s = 0;
	int total = 0;
	int size = 0;
	if (foods.isEmpty() == false) {
	    for (Food food : foods) {
		if (food.getOrigin() == origin) {
		    total += food.getCalories();
		    size++;
		}
	    }
	    s = total / size;

	}
	return s;
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {

	// your code here
	ArrayList<Food> llist = new ArrayList<Food>();
	for (Food food : foods) {
	    if (food.getOrigin() == origin) {
		llist.add(food);
	    }
	}

	return llist;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {

	// your code here
	boolean v;
	System.out.print("Name: ");
	String name = keyboard.nextLine();

	System.out.println(Food.originsMenu());
	System.out.print("Origin: ");
	int origin = keyboard.nextInt();

	System.out.print("Vegetarian (Y/N): ");
	String vegetarian = keyboard.next();

	System.out.print("Calories: ");
	int calories = keyboard.nextInt();

	if (origin > 11 || origin < 0) {
	    return null;
	}

	if (vegetarian.toUpperCase().compareTo("Y") == 0)
	    v = true;
	else
	    v = false;

	Food food = new Food(name, origin, v, calories);
	return food;

    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

	// your code here
	ArrayList<Food> veg = new ArrayList<Food>();

	for (int i = 0; i < foods.size(); i++) {
	    if (foods.get(i).isVegetarian())
		veg.add(foods.get(i));
	}

	return veg;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {

	// your code here
	int counter = 0;
	int origin = 0;
	int calories = 0;
	char letter;
	String name = "", vegetarian = "", org = "", cal = "";
	boolean veg;

	for (int i = 0; i < line.length(); i++) {
	    letter = line.charAt(i);
	    if (letter == '|') {
		counter = counter + 1;
		continue;
	    }
	    if (counter == 0) {
		name = name + letter;
	    } else if (counter == 1) {
		org = org + letter;
	    } else if (counter == 2) {
		vegetarian = vegetarian + letter;
	    } else {
		cal = cal + letter;
	    }
	}
	calories = Integer.parseInt(cal);
	origin = Integer.parseInt(org);

	if (vegetarian.toLowerCase().compareTo("false") == 0)
	    veg = false;
	else
	    veg = true;

	Food food = new Food(name, origin, veg, calories);

	return food;

    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {

	// your code here
	String input = "";
	ArrayList<Food> list = new ArrayList<Food>();

	while (fileIn.hasNextLine()) {
	    input = fileIn.nextLine();
	    Food food = readFood(input);
	    list.add(food);
	}

	return list;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {

	// your code here
	ArrayList<Food> newList = new ArrayList<Food>();

	for (int i = 0; i < foods.size(); i++) {
	    if (origin == -1 || foods.get(i).getOrigin() == origin) {
		if (maxCalories == 0 || foods.get(i).getCalories() <= maxCalories) {
		    if (isVegetarian == false)
			newList.add(foods.get(i));
		    else if (foods.get(i).isVegetarian() == true)
			newList.add(foods.get(i));
		}
	    }

	}

	return newList;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

	// your code here
	for (int i = 0; i < foods.size(); i++) {
	    ps.println(foods.get(i));
	}

    }
}
