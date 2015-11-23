import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    
    JPanel[] row = new JPanel[6];
    JButton[] button = new JButton[24];
    String[] buttonString = {"7", "8", "9", "+", "x!", "C",
                             "4", "5", "6", "-", "x^2", "√",
                             "1", "2", "3", "*", "x^3", "x^y",
                             "0", ".", "+/-", "/", "1/x", "="};
    String lastOperatorSelected = "";
    boolean isLastButtonOperator = false;
    int[] dimW = {300,50,100};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[2], dimH[1]);
    // Array for storing temporary values
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    
    Calculator() {
        //Initialize GUI
        super("TechEd Calculator");
        setDesign();
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,6);
        setLayout(grid);
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);
        
        for(int i = 0; i < 24; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        
        display.setFont(font);
        display.setEditable(false);
        display.setPreferredSize(displayDimension);
        display.setText("0");
        for(int i = 0; i < 24; i++)
            button[i].setPreferredSize(regularDimension);
        
        row[0].add(display);
        add(row[0]);
        
        for(int i = 0; i < 6; i++)
            row[1].add(button[i]);
        add(row[1]);
        
        for(int i = 6; i < 12; i++)
            row[2].add(button[i]);
        add(row[2]);
        
        for(int i = 12; i < 18; i++)
            row[3].add(button[i]);
        add(row[3]);
        
        row[4].add(button[18]);
        for(int i = 19; i < 24; i++)
            row[4].add(button[i]);
        add(row[4]);
        
        setVisible(true);
    }
    
    public void clear() {
        // Clear button
        try {
            display.setText("0");
            lastOperatorSelected = "";
            isLastButtonOperator = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e) {  
        }
    }
    
    public void getAdd() {
        // Add button
        try {
            temporary[0] = Double.parseDouble(display.getText());
            lastOperatorSelected = "+";
        } catch(NumberFormatException e) {
            display.setText("Invalid Input");
        }
    }
    
    public void getSubtract() {
        // TODO: Group 1: Subtract: Set the first input and the operator selected. 
        // Calculate and display result in getResult().
        try {
            temporary[0] = Double.parseDouble(display.getText());
            lastOperatorSelected = "-";
        } catch(NumberFormatException e) {
        }
    }
    
    public void getMultiply() {
        // TODO: Group 2: Multiply: Set the first input and the operator selected. 
        // Calculate and display result in getResult().
        try {
            temporary[0] = Double.parseDouble(display.getText());
            lastOperatorSelected = "*";
        } catch(NumberFormatException e) {
        }
    }
    
    public void getDivide() {
        // TODO: Group 3: Divide: Set the first input and the operator selected. 
        // Calculate and display result in getResult().
        try {
            temporary[0] = Double.parseDouble(display.getText());
            lastOperatorSelected = "/";
        } catch(NumberFormatException e) {
        }
    }
    
    public void getSqrt() {
        // TODO: Group 4: Square Root: Calculate and display the square root after user hits √.
        try {
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }
    
    public void getSquare() {
        // TODO: Group 5: Square: Calculate and display the square after user hits x^2.
        try {
            double value = Double.parseDouble(display.getText()) 
                * Double.parseDouble(display.getText());
            display.setText(Double.toString(value));
        } catch (NumberFormatException e) {
        }
    }
    
    public void getCube() {
        // TODO: Group 6: Cube: Calculate and display the cube after user hits x^3.
        try {
            double value = Double.parseDouble(display.getText()) 
                * Double.parseDouble(display.getText())
                * Double.parseDouble(display.getText());
            display.setText(Double.toString(value));
        } catch (NumberFormatException e) {
        }
    }
    
    public void getPower() {
        // TODO: Group 7: Power: Set the first input and the operator selected. 
        // Calculate and display result in getResult().
        try {
            temporary[0] = Double.parseDouble(display.getText());
            lastOperatorSelected = "x^y";
        } catch (NumberFormatException e) {
        }
    }
    
    public void getFactorial() {
        // TODO: Group 8: Factorial: Calculate and display the factorial after user hits !. 
        // Fact(0) = 1. Display "Invalid Input" if input is not an integer.
        try {
            int input = Integer.parseInt(display.getText());
            long value = 1;
            for (int i = input; i > 0; i--) {
                value *= i;
            }
            display.setText(Long.toString(value));
        } catch (NumberFormatException e) {
            display.setText("Invalid Input");
        }
    }
    
    public void getReciprocal() {
        // TODO: Group 9: Reciprocal: Calculate and display the reciprocal after user hits 1/x.
        try {
            double value = 1/Double.parseDouble(display.getText());
            display.setText(Double.toString(value));
        } catch (NumberFormatException e) {
        }
    }
    
    public void getPosNeg() {
        // TODO: Group 10: Negative Sign: Add/Remove the negative sign after user hits +/-.
        try {
            double value = Double.parseDouble(display.getText());
            if(value != 0) {
                value = value * (-1);
                display.setText(Double.toString(value));
            }
            else {
            }
        } catch(NumberFormatException e) {
        }
    }
    
    public void getResult() {
        // Get the result of the calculation
        double result = 0;
        
        // Handle negatives
        try {
            temporary[1] = Double.parseDouble(display.getText());
            String temp0 = Double.toString(temporary[0]);
            String temp1 = Double.toString(temporary[1]);
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        } catch(NumberFormatException e){
        
        }
        try {
            // Handle 2 parameter operators
            switch(lastOperatorSelected)
            {
            case "+":
            {
                result = temporary[0] + temporary[1];
                break;
            }
            case "-":
            {
                result = temporary[0] - temporary[1];
                break;
            }
            case "*":
            {
                result = temporary[0] * temporary[1];
                break;
            }
            case "/":
            {
                result = temporary[0] / temporary[1];
                break;
            }
            case "x^y":
            {
                result = Math.pow(temporary[0], temporary[1]);
                break;
            }
            default:
                break;
            }
            display.setText(Double.toString(result));
            lastOperatorSelected = "";
        } catch(NumberFormatException e) {
        }
    }
    
    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {   
        }
    }
    
    @Override
    // Handle key press
    public void actionPerformed(ActionEvent ae) {
        while (display.getText().startsWith("0") && display.getText().length() > 1) {
            display.setText(display.getText().substring(1, display.getText().length()));
            }
        if(ae.getSource() == button[0]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("7");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[1]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("8");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[2]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("9");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[3]) {
            // add function
            getAdd();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[4]) {
            // factorial function
            getFactorial();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[5])
            clear();
        if(ae.getSource() == button[6]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("4");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[7]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("5");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[8]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("6");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[9]) {
            // subtract function
            getSubtract();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[10]) {
            // x^2 function
            getSquare();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[11]) { 
            // sqrt function 
            getSqrt();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[12]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("1");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[13]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("2");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[14]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("3");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[15]) {
            // multiply function
            getMultiply();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[16]) {
            // x^3 function
            getCube();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[17]) {
            // x^y function
            getPower();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[18]) {
            if(isLastButtonOperator || display.getText().equals("0"))
                display.setText("");
            display.append("0");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[19]) {
            if(isLastButtonOperator)
                display.setText("");
            display.append(".");
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[20]) {
            if(isLastButtonOperator)
                display.setText("0");
            // +/- function
            getPosNeg();
            isLastButtonOperator = false;
        }
        if(ae.getSource() == button[21]) {
            // divide function
            getDivide();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[22]) {
            // 1/x function
            getReciprocal();
            isLastButtonOperator = true;
        }
        if(ae.getSource() == button[23]) {
            // = sign
            getResult();
            isLastButtonOperator = true;
        }
    }
    
    public static void main(String[] arguments) {
        Calculator c = new Calculator();
    }
}

