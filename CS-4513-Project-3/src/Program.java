import java.util.Scanner;

/*
 * This program takes in user input to perform operations
 * on an azure sql server database.
 */
public class Program {

	/*
	 * Main program loop with user input is executed here.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		SqlOperations operations = new SqlOperations();
		do {
			System.out.println("Enter an operation to perform: \n"
					+ "(1)   Enter a new problem\n"
					+ "(2)   Increase Compensation\n"
					+ "(3)   Display the information from both the author and problem tables\n"
					+ "(4)   Quit Application");
			userInput = scanner.nextLine();
			switch (userInput) {
				case "1":
					System.out.print("Enter pid : ");
					int pid = scanner.nextInt();
					System.out.println("Enter pname: ");
					String pname = scanner.next();
					System.out.println("Enter aid: ");
					int new_aid = scanner.nextInt();
					operations.operation1(pid, pname, new_aid);
					break;
				case "2":
					System.out.println("Enter an aid");
					int aid = scanner.nextInt();
					operations.operation2(aid);
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
