import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    
    JPanel[] row = new JPanel[6];
    JButton[] button = new JButton[23];
	String[] buttonString = {"7", "8", "9", "+", "+/-", "C",
			 				 "4", "5", "6", "-", "x^2", "√",
			 				 "1", "2", "3", "*", "x^3", "x^y",
			 				 "0", ".", "/", "1/x", "="};
    int[] dimW = {300,50,100};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[2], dimH[1]);
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    
    Calculator() {
        super("TechEd Calculator");
        setDesign();
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,6);
        setLayout(grid);
        
        for(int i = 0; i < 4; i++)
            function[i] = false;
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
        row[0].setLayout(f1);
        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);
        
        for(int i = 0; i < 23; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);
        for(int i = 0; i < 22; i++)
            button[i].setPreferredSize(regularDimension);
        button[22].setPreferredSize(zeroButDimension);
        
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
        for(int i = 19; i < 23; i++)
            row[4].add(button[i]);
        add(row[4]);
        
        setVisible(true);
    }
    
    public void clear() {
        try {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        } catch(NullPointerException e) {  
        }
    }
    
    public void getSqrt() {
        try {
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));
        } catch(NumberFormatException e) {
        }
    }
    
    public void getSquare() {
    	try {
    		
    	} catch (NumberFormatException e) {
    	}
    }
    
    public void getCube() {
    	try {
    		
    	} catch (NumberFormatException e) {
    	}
    }
    
    public void getPower() {
    	try {
    		
    	} catch (NumberFormatException e) {
    	}
    }
    
    public void getReciprocal() {
    	try {
    		
    	} catch (NumberFormatException e) {
    	}
    }
    
    public void getPosNeg() {
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
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[3]) {
            //add function[0]
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() == button[4])
        	// +/- function
        	getPosNeg();
        if(ae.getSource() == button[5])
        	clear();
        if(ae.getSource() == button[6])
            display.append("4");
        if(ae.getSource() == button[7]) 
        	display.append("5");
        if(ae.getSource() == button[8])
            display.append("6");
        if(ae.getSource() == button[9]) {
            //subtract function[1]
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() == button[10])
        	// x^2 function
        	getSquare();
        if(ae.getSource() == button[11]) 
        	// sqrt function 
        	getSqrt();
        if(ae.getSource() == button[12])
            display.append("1");
        if(ae.getSource() == button[13]) 
        	display.append("2");
        if(ae.getSource() == button[14])
        	display.append("3");
        if(ae.getSource() == button[15]) {
            //multiply function[2]
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() == button[16])
            // x^3 function
        	getCube();
        if(ae.getSource() == button[17])
        	// x^y function
        	getPower();
        if(ae.getSource() == button[18])
            display.append("0");
        if(ae.getSource() == button[19])
        	display.append(".");
        if(ae.getSource() == button[20]) {
            //divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() == button[21])
        	// 1/x function
        	getReciprocal();
        if(ae.getSource() == button[22])
        	// = sign
        	getResult();
    }
    
    public static void main(String[] arguments) {
        Calculator c = new Calculator();
    }
}

