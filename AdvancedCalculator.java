import java.util.List;
import java.util.Scanner;
public class AdvancedCalculator {
    private CalculatorCore core;
    private Scanner scanner;
    public AdvancedCalculator() {
        this.core = new CalculatorCore();
        this.scanner = new Scanner(System.in);
    }
    public void run() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Calculator shutting down.");
                break;
            }
            processChoice(choice);
        }
        scanner.close();
    }
    private void displayMenu() {
        System.out.println("\n--- Advanced Calculator (Console) ---");
        System.out.println("1. Normal Calculation (BODMAS)");
        System.out.println("2. sqrt");
        System.out.println("3. sin");
        System.out.println("4. cos");
        System.out.println("5. tan");         
        System.out.println("6. ln");
        System.out.println("7. log");     
        System.out.println("8. Memory Store (M+)");
        System.out.println("9. Memory Recall (MR)");
        System.out.println("10. Memory Clear (MC)");
        System.out.println("11. (HIST)");  
        System.out.println("Type 'exit' to quit");
        System.out.print("Enter your choice: ");
    }
    private void processChoice(String choice) {
        try {
            switch (choice) {
                case "1":
                    System.out.print("Enter expression (e.g., 3 + 5 * 2): ");
                    String expr = scanner.nextLine();
                    System.out.println("Result: " + core.evaluateExpression(expr));
                    break;
                case "2":
                    System.out.println("Result: " + core.squareRoot(getOneNumber()));
                    break;
                case "3":
                    System.out.println("Result: " + core.sine(getOneNumber()));
                    break;
                case "4":
                    System.out.println("Result: " + core.cosine(getOneNumber()));
                    break;
                case "5":
                    System.out.println("Result: " + core.tangent(getOneNumber()));
                    break;
                case "6":
                    System.out.println("Result: " + core.naturalLog(getOneNumber()));
                    break;
                case "7":
                    System.out.println("Result: " + core.logBase10(getOneNumber()));
                    break;
                case "8":
                    core.memoryAdd(getOneNumber());
                    System.out.println("Memory updated. Current memory: " + core.memoryRecall());
                    break;
                case "9":
                    System.out.println("Memory: " + core.memoryRecall());
                    break;
                case "10":
                    core.memoryClear();
                    System.out.println("Memory cleared.");
                    break;
                case "11":
                    displayHistory();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private double getOneNumber() {
        System.out.print("Enter a number: ");
        return Double.parseDouble(scanner.nextLine());
    }
    private void displayHistory() {
        List<String> history = core.getHistory();
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("\n--- Calculation History ---");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }
}