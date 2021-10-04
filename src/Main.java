import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu()
    {
        int number = 0;

        do {

            try {
                System.out.print("Input a number of task: ");
                number = scanner.nextInt();
                System.out.println();

                switch (number) {
                    case 1:
                        Task_1.task_1();
                        break;
                    case 2:
                        Task_2.task_2();
                        break;
                    case 3:
                        System.out.println("You do not want to continue.");
                        break;
                    default:
                        System.out.println("Please enter correct number.");
                        Main.menu();
                        break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
        }while(number != 3);
        scanner.nextLine();
    }
    public static void main(String[] args)
    { Main.menu(); }
}
