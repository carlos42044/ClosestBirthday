import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import java.lang.IllegalArgumentException;
// this is the hash
public class Birthday {
	static String nameOfFile = "birthdayInputFile.txt";
	
	//try {
		
		//Create an array of classes and an array of queries
	static ArrayList<ArrayList<Student>> classes = new ArrayList<ArrayList<Student>>();
	static ArrayList<ArrayList<Student>> queries = new ArrayList<ArrayList<Student>>();
	//} catch (FileNotFoundException e) {
		//e.printStackTrace();
	//}
	//scanFile(inputFile);
	//List<List<Student>> classes = new ArrayList<List<Student>>(numOfClasses/2);
	//List<List<Student>> queries = new ArrayList<List<Student>>(numOfClasses/2);



	public static void main(String[] args) throws FileNotFoundException {
		// input file
		
		// Scanner input = new Scanner(System.in);
		// System.out.println("enter a MONTH, day, and year: ");
		// String month = input.next();
		// int day = input.nextInt();
		// int year = input.nextInt();
		// Student s = new Student("first", "last", month, day, year);
		scanFile();
		// for (int i = 0 ; i < 5; i++) {
		// 	classes.get(i).add(new Student("jim" ,"rie", "MARCH", (10+i), 1993));
		// }
		// //System.out.println(classes);
		// for (ArrayList<Student> i : classes) {
		// 	System.out.println(i.get(0));
		// }
	}

	class MyClass<E> 
    {
        ArrayList<E> mylist = new ArrayList<>();
      
    }

	public static void scanFile() throws FileNotFoundException {
		// Scanner fileReader = new Scanner(file);
		// int numClasses = fileReader.nextInt();
		//System.out.println("it worked " + numClasses);
	 	File inputFile = new File(nameOfFile);
		Scanner fileReader = new Scanner(inputFile);
		int numOfClasses = fileReader.nextInt();
		int i = 0;

		for (int h = 0; h < 20; h++) {
			classes.add(new ArrayList<Student>());
			queries.add(new ArrayList<Student>());
		}

		while (i < numOfClasses/2) {
			int studentsInClass = fileReader.nextInt();
			//System.out.println(studentsInClass);
			int j = 0;

			while (j < studentsInClass) {
				String firstName = fileReader.next();
				String lastName = fileReader.next();
				String month = fileReader.next();
				int day = fileReader.nextInt();
				int year = fileReader.nextInt();
				//System.out.println("should be class: " + i + " size in that is: " + classes.get(i).size());
				//classes.add(i, null);
				//classes.add(new ArrayList<Student>());
				classes.get(i).add(new Student(firstName, lastName, month, day, year));
				j++;
			}
			//System.out.println("should be class: " + i + " size class in that is: " + classes.get(i).size());

			int queriesInClass = fileReader.nextInt();
			//System.out.println(queriesInClass);
			int k = 0;
			while (k <  queriesInClass) {
				String firstName = fileReader.next();
				String lastName = fileReader.next();
				//queries.add(new ArrayList<Student>());

				queries.get(i).add(new Student(firstName, lastName, "MARCH", 0, 0));
				k++;
			}
			//System.out.println("should be class: " + i + " size of queries in that is: " + queries.get(i).size());

			i++;
		}
	}
}

class Student {
	String firstName;
	String lastName;
	String stringMonth;
	int numericalBirthDate;
	int day;
	int year;

	public Student(String firstName, String lastName, String stringMonth, int day, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.stringMonth = stringMonth;
		this.day = day;
		this.year = year;
		numericalBirthDate = monthToNumerical(stringMonth, day, year);
		//System.out.println(firstName + " " + lastName + " " + this.stringMonth + " " + this.day + " " + this.year);
		//System.out.println("The day is: " + numericalBirthDate);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStringMonth() {
		return stringMonth;
	}

	public int getNumericalBirthDate() {
		return numericalBirthDate;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return firstName + " " + lastName + " " + numericalBirthDate;
	}

	public int monthToNumerical(String month, int day, int year) {
		int date = day;
		//if (isLeapYear)

		switch(month) {
			case "JANUARY":
				break;
			case "FEBRUARY":
				date += 31;
				break;
			case "MARCH":
				// put this at the end 
				//if (isLeapYear(year)) day += 1;
				date += 59;
				break;
			case "APRIL":
				date += 90;//???s
				break;
			case "MAY":
				date += 120;
				break;
			case "JUNE":
				date += 151;
				break;
			case "JULY":
				date += 181;
				break;
			case "AUGUST":
				date += 212;
				break;
			case "SEPTEMBER":
				date+= 243;
				break;
			case "OCTOBER":
				date += 273;
				break;
			case "NOVEMBER":
				date += 304;
				break;
			case "DECEMBER":
				date += 334;
				break;
			default:
				throw new IllegalArgumentException("No such month exists: " + month);
		}

		if (isLeapYear(year) && date > 31) {
			date += 1;
		}

		return date;
	}

	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0);
	}

}