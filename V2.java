import java.util.InputMismatchException;
import java.util.Scanner;
public class calc {

    public static void main(String[] args) {
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);
        while (cont) {
        System.out.print("Select the formula you would like to use: \n 1. interest formula: (Simple/Compound) \n 2. quadratic formula: (ax^2 + bx + c) \n 3. Arithmetic Sum formula: ((n/2) * (2a + (n-1)d)) \n 4. Mean formula: (sum of elements / number of elements) \n 5. geometric formulas: (area of circle/tringle, volume of sphere):  \n");
        int formula;
        try {
            formula = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.nextLine();
            continue;
        }
        
        scanner.nextLine();
        switch (formula) {
            case 1 -> interest();
            case 2 -> quadratic();
            case 3 -> arithmeticSum();
            case 4 -> mean();
            case 5 -> geometric();
            default -> System.out.println("Invalid choice!");
        }
        boolean cont2 = true;
        while(cont2){
        System.out.print("Do you want to use another formula? (Y/N): ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("N")) {
            cont = false;
            cont2 = false;
            System.out.println("Goodbye!");
            System.exit(0);
        } else if (!choice.equalsIgnoreCase("Y")) {
            System.out.println("Invalid choice!");
            continue; // Restart the loop
        } else if (choice.equalsIgnoreCase("Y")) {
            cont2 = false;
        }
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

        System.out.println("Interest: $" + Math.round(interest*100.0)/100.0);
        System.out.println("Total amount: $" + Math.round(amount*100.0)/100.0);
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
        float r1 = (float)Math.round(root1*100)/100;
        float r2 = (float)Math.round(root2*100)/100;
        if (r1 == 0 && r2 == 0) {
            System.out.println("No real roots!");
            return;
        }
        System.out.println("Root 1: " + r1);
        System.out.println("Root 2: " + r2);
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
    public static void geometric() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the geometric formula you would like to use: \n 1. Area of a Circle \n 2. Area of a Triangle \n 3. Volume of a Sphere \n");
        int formula;
        try {
            formula = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.nextLine();
            return;
        }
        
        scanner.nextLine();
        switch (formula) {
            case 1 -> areaOfCircle();
            case 2 -> areaOfTriangle();
            case 3 -> volumeOfSphere();
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void areaOfCircle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius;
        try {
            radius = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear the input buffer
            return; // Exit the method
        }
        scanner.nextLine();
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle: " + area);
    }

    public static void areaOfTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base length of the triangle: ");
        double base;
        try {
            base = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine();
            return; 
        }
        scanner.nextLine();
        System.out.print("Enter the height of the triangle: ");
        double height;
        try {
            height = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();
        double area = 0.5 * base * height;
        System.out.println("Area of the triangle: " + area);
    }

    public static void volumeOfSphere() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the sphere: ");
        double radius;
        try {
            radius = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        System.out.println("Volume of the sphere: " + volume);
    }

}
