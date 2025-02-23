import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class AdvancedCalculatorGUI extends JFrame {
    private CalculatorCore core;
    private JTextField display;
    private JTextArea historyArea;
    public AdvancedCalculatorGUI() {
        core = new CalculatorCore();
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Galactic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 450, 500, 20, 20)); // Adjusted size
        // main panel with space themed 
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradient = new GradientPaint(0, 0, new Color(10, 0, 50), 0, getHeight(), new Color(50, 10, 80));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(Color.WHITE);
                for (int i = 0; i < 50; i++) {
                    int x = (int) (Math.random() * getWidth());
                    int y = (int) (Math.random() * getHeight());
                    g2d.fillOval(x, y, 2, 2);
                }
            }
        };
        // ui
        display = new JTextField("0");
        display.setFont(new Font("Orbitron", Font.BOLD, 24));
        display.setForeground(new Color(0, 255, 255));
        display.setBackground(new Color(20, 20, 50, 200));
        display.setBorder(BorderFactory.createLineBorder(new Color(100, 255, 255), 2));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setCaretColor(Color.WHITE);
        mainPanel.add(display, BorderLayout.NORTH);
        // buttons
        JPanel buttonPanel = new JPanel(new GridLayout(7, 4, 8, 8)); 
        buttonPanel.setOpaque(false);
        String[] buttonLabels = {         //buttons panel
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "0", ".", "=", "/",
            "sqrt", "sin", "cos", "tan",  
            "(", ")", "^", "ln",
            "log", "M+", "MR", "MC",      
            "DEL", "HIST"                  
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label) {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    GradientPaint gp = new GradientPaint(0, 0, new Color(50, 50, 150), 0, getHeight(), new Color(100, 100, 200));
                    g2d.setPaint(gp);
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                    super.paintComponent(g);
                }
            };
            button.setFont(new Font("Orbitron", Font.PLAIN, 16));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setForeground(new Color(0, 255, 255));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setForeground(Color.WHITE);
                }
            });
            button.addActionListener(new ButtonListener());
            buttonPanel.add(button);
        }
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        // history area
        historyArea = new JTextArea(10, 20);
        historyArea.setFont(new Font("Orbitron", Font.PLAIN, 14));
        historyArea.setForeground(new Color(200, 255, 255));
        historyArea.setBackground(new Color(20, 20, 50, 200));
        historyArea.setBorder(BorderFactory.createLineBorder(new Color(100, 255, 255), 1));
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.EAST);
        add(mainPanel);
        setSize(450, 500); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            try {
                if (Character.isDigit(command.charAt(0)) || command.equals(".") || command.equals("(") || command.equals(")")) {
                    if (display.getText().equals("0")) {
                        display.setText(command);
                    } else {
                        display.setText(display.getText() + command);
                    }
                } else if (command.equals("DEL")) {
                    String current = display.getText();
                    if (current.length() > 1) {
                        display.setText(current.substring(0, current.length() - 1));
                    } else {
                        display.setText("0");
                    }
                } else if (command.equals("=")) {
                    double result = core.evaluateExpression(display.getText());
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("sqrt")) {
                    double result = core.squareRoot(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("sin")) {
                    double result = core.sine(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("cos")) {
                    double result = core.cosine(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("tan")) {
                    double result = core.tangent(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("ln")) {
                    double result = core.naturalLog(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("log")) {
                    double result = core.logBase10(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(result));
                    updateHistory();
                } else if (command.equals("M+")) {
                    core.memoryAdd(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(core.memoryRecall()));
                } else if (command.equals("MR")) {
                    display.setText(String.valueOf(core.memoryRecall()));
                } else if (command.equals("MC")) {
                    core.memoryClear();
                    display.setText("0");
                } else if (command.equals("HIST")) {
                    showHistoryDialog();
                } else {
                    display.setText(display.getText() + command); // Operators (+, -, *, /, ^)
                }
            } catch (Exception ex) {
                display.setText("Error: " + ex.getMessage());
            }
        }
    }
    private void updateHistory() {
        historyArea.setText("");
        for (String entry : core.getHistory()) {
            historyArea.append(entry + "\n");
        }
    }
    private void showHistoryDialog() {
        JDialog historyDialog = new JDialog(this, "Calculation History", true);
        historyDialog.setLayout(new BorderLayout());
        JTextArea dialogHistory = new JTextArea(15, 30);
        dialogHistory.setFont(new Font("Orbitron", Font.PLAIN, 14));
        dialogHistory.setForeground(new Color(200, 255, 255));
        dialogHistory.setBackground(new Color(20, 20, 50));
        dialogHistory.setEditable(false);
        for (String entry : core.getHistory()) {
            dialogHistory.append(entry + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(dialogHistory);
        historyDialog.add(scrollPane, BorderLayout.CENTER);
        historyDialog.pack();
        historyDialog.setLocationRelativeTo(this);
        historyDialog.setVisible(true);
    }
}