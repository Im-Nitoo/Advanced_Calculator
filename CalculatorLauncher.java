import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class CalculatorLauncher {
    public static void main(String[] args) {
        String[] options = { "Console", "GUI" };
        int choice = JOptionPane.showOptionDialog(null, "Choose calculator interface:",
                "Calculator Launcher", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if (choice == 0) {
            new AdvancedCalculator().run();
        } else if (choice == 1) {
            SwingUtilities.invokeLater(() -> new AdvancedCalculatorGUI());
        } else {
            System.out.println("No selection made. Exiting.");
        }
    }
}