import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		SqlOperations operations = new SqlOperations();
		do {
			System.out.println("Enter an operation to perform: \n"
					+ "(1)   Describe Operation 1\n"
					+ "(2)   Describe Operation 2\n"
					+ "(3)   Display the information from both the author and problem tables\n"
					+ "(4)   Quit Application");
			userInput = scanner.nextLine();
			switch (userInput) {//Finish implementing these
				case "1":
					operations.operation1();
					break;
				case "2":
					operations.operation2();
					break;
				case "3":
					operations.operation3();
					break;
				case "4":
					System.out.println("Closing application...");
					break;
			}
		} while (!userInput.equals("4"));
	}

}
