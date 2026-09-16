import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeeExpCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Date format: DD-MM-YYYY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter employee joining date (DD-MM-YYYY): ");
        String joiningDateInput = sc.nextLine();

        try {
            // Convert input string into LocalDate
            LocalDate joiningDate = LocalDate.parse(joiningDateInput, formatter);

            // Get today's date
            LocalDate today = LocalDate.now();

            // Check if joining date is in the future
            if (joiningDate.isAfter(today)) {
                System.out.println("Joining date cannot be in the future.");
            } else {

                // Calculate experience
                Period experience = Period.between(joiningDate, today);

                System.out.println("\nEmployee Experience:");
                System.out.println(experience.getYears() + " Years "
                        + experience.getMonths() + " Months "
                        + experience.getDays() + " Days");
            }

        } catch (Exception e) {
            System.out.println("Invalid date format!");
            System.out.println("Please enter the date in DD-MM-YYYY format.");
        }

        sc.close();
    }
}