import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class CalculatorCore {
    private double memory;
    private List<String> history;
    public CalculatorCore() {
        this.memory = 0.0;
        this.history = new ArrayList<>();
    }
    // Evaluate expressions using BODMAS rule
    public double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", "");
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>(); 
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(num.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(numbers, operators.pop());
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    performOperation(numbers, operators.pop());
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            performOperation(numbers, operators.pop());
        }
        double result = numbers.pop();
        history.add(expression + " = " + result);
        return result;
    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    private int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return 0;
        }
    }
    private void performOperation(Stack<Double> numbers, char op) {
        double b = numbers.pop();
        double a = numbers.pop();
        switch (op) {
            case '+': numbers.push(a + b); break;
            case '-': numbers.push(a - b); break;
            case '*': numbers.push(a * b); break;
            case '/': if (b == 0) throw new ArithmeticException("Division by zero"); numbers.push(a / b); break; //error handling also
            case '^': numbers.push(Math.pow(a, b)); break;
        }
    }
    // Scientific calculations
    public double squareRoot(double a) {
        if (a < 0) throw new IllegalArgumentException("Cannot compute sqrt of negative");
        double result = Math.sqrt(a);
        history.add("sqrt(" + a + ") = " + result);
        return result;
    }
    public double sine(double a) {
        double result = Math.sin(Math.toRadians(a));
        history.add("sin(" + a + ") = " + result);
        return result;
    }
    public double cosine(double a) {
        double result = Math.cos(Math.toRadians(a));
        history.add("cos(" + a + ") = " + result);
        return result;
    }
    public double tangent(double a) {
        double result = Math.tan(Math.toRadians(a));
        history.add("tan(" + a + ") = " + result);
        return result;
    }
    public double naturalLog(double a) {
        if (a <= 0) throw new IllegalArgumentException("Ln undefined for non-positive");
        double result = Math.log(a);
        history.add("ln(" + a + ") = " + result);
        return result;
    }
    public double logBase10(double a) {
        if (a <= 0) throw new IllegalArgumentException("Log undefined for non-positive");
        double result = Math.log10(a);
        history.add("log(" + a + ") = " + result);
        return result;
    }
    // Memory functions
    public void memoryAdd(double value) {
        memory += value;
    }
    public double memoryRecall() {
        return memory;
    }
    public void memoryClear() {
        memory = 0.0;
    }
    // History
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}