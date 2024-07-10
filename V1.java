import java.util.Scanner;

public class calc {

    public static void main(String[] args) {
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);
        while (cont) {
        System.out.print("Select the formula you would like to use: \n 1. interest formula: (Simple/Compound) \n 2. quadratic formula: (ax^2 + bx + c) \n 3. Arithmetic Sum formula: ((n/2) * (2a + (n-1)d)) \n 4. Mean formula: (sum of elements / number of elements) \n");
        int formula = scanner.nextInt();
        
        scanner.nextLine();
        switch (formula) {
            case 1 -> interest();
            case 2 -> quadratic();
            case 3 -> arithmeticSum();
            case 4 -> mean();
            default -> System.out.println("Invalid choice!");
        }
    
        System.out.print("Do you want to use another formula? (Y/N): ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("N")) {
            cont = false;
        }
        }
    }

    public static void interest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter interest rate (in %): ");
        double rate = scanner.nextDouble() / 100;
        scanner.nextLine();
        System.out.print("Enter time period (in decimal years): ");
        double time = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter 1 for simple interest or 2 for compound interest: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        double interest = 0;

        if (choice == 1) {
            // Calculate simple interest
            interest = (principal * rate * time);
        } else if (choice == 2) {
            System.out.print("Enter number of times interest is compounded: ");
            int n = scanner.nextInt();
            interest = principal * Math.pow(1 + rate / n, n * time) - principal;
        } else {
            System.out.println("Invalid choice!");
            System.exit(0);
        }

        double amount = principal + interest;

        System.out.println("Interest: " + interest);
        System.out.println("Total amount: " + amount);
    }
    public static void quadratic() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        scanner.nextLine();

        double d = b * b - 4 * a * c;
        double root1, root2;
        root1 = (d > 0) ? (-b + Math.sqrt(d)) / (2 * a) : (d == 0) ? -b / (2 * a) : 0;
        root2 = (d > 0) ? (-b - Math.sqrt(d)) / (2 * a) : 0;
        System.out.println("Root 1: " + root1);
        System.out.println("Root 2: " + root2);
    }
    public static void arithmeticSum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first term: ");
        double a = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter common difference: ");
        double d = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter number of terms: ");
        double n = scanner.nextDouble();
        scanner.nextLine();
        double sum = (n / 2) * (2 * a + (n - 1) * d);
        System.out.println("Sum: " + sum);
    }
    public static void mean() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        double[] arr = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextDouble();
            sum += arr[i];
        }
        double mean = sum / n;
        float m = (float)mean;
        System.out.println("Mean: " + m);

    }
}
