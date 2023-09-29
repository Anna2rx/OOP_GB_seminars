import java.util.Scanner;
import java.util.logging.*;

class ComplexNumber {
    private double realPart;
    private double imaginaryPart;


    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    
    @Override
    public String toString() {
        if (imaginaryPart == 0) {
            return realPart + "";
        }
        if (realPart == 0) {
            return imaginaryPart + "i";
        }
        if (imaginaryPart < 0) {
            return realPart + " - " + (-imaginaryPart) + "i";
        }
        return realPart + " + " + imaginaryPart + "i";
}


}


class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());


    public double add(double num1, double num2) {
        LOGGER.log(Level.INFO, "Real number addition operation completed.");
        return num1 + num2;
    }

    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getRealPart() + num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() + num2.getImaginaryPart();
        LOGGER.log(Level.INFO, "Complex number addition operation completed.");
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public double subtract(double num1, double num2) {
        LOGGER.log(Level.INFO, "Real number substraction operation completed.");
        return num1 - num2;
    }

    public ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getRealPart() - num2.getRealPart();
        double imaginaryPart = num1.getImaginaryPart() - num2.getImaginaryPart();
        LOGGER.log(Level.INFO, "Complex number substraction operation completed.");
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public double multiply(double num1, double num2) {
        LOGGER.log(Level.INFO, "Real number multiplication operation completed.");
        return num1 * num2;
    }

    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double realPart = (num1.getRealPart() * num2.getRealPart()) - (num1.getImaginaryPart() * num2.getImaginaryPart());
        double imaginaryPart = (num1.getRealPart() * num2.getImaginaryPart()) + (num1.getImaginaryPart() * num2.getRealPart());
        LOGGER.log(Level.INFO, "Complex number multiplication operation completed.");
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public double divide(double num1, double num2) {
        LOGGER.log(Level.INFO, "Real number division operation completed.");
        return num1 / num2;
    }

    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        double realPart = ((num1.getRealPart() * num2.getRealPart()) + (num1.getImaginaryPart() * num2.getImaginaryPart())) / 
                          (Math.pow(num2.getRealPart(), 2) + Math.pow(num2.getImaginaryPart(), 2));
        double imaginaryPart = ((num1.getImaginaryPart() * num2.getRealPart()) - (num1.getRealPart() * num2.getImaginaryPart())) / 
                               (Math.pow(num2.getRealPart(), 2) + Math.pow(num2.getImaginaryPart(), 2));
        LOGGER.log(Level.INFO, "Complex number division operation completed.");
        return new ComplexNumber(realPart, imaginaryPart);
    }
}


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose number type:");
                    System.out.println("1. Real");
                    System.out.println("2. Complex");
                    System.out.print("Enter your choice: ");
                    int numTypeAdd = scanner.nextInt();
                    
                    if (numTypeAdd == 1) {
                        System.out.print("Enter first real: ");
                        double num1Add = scanner.nextDouble();
                        System.out.print("Enter second real: ");
                        double num2Add = scanner.nextDouble();
                        double resultAdd = calculator.add(num1Add, num2Add);
                        System.out.println("Addition: " + num1Add + " + " + num2Add + " = " + resultAdd);
                    } else if (numTypeAdd == 2) {
                        System.out.print("Enter real part of first complex number: ");
                        double real1Add = scanner.nextDouble();
                        System.out.print("Enter imaginary part of first complex number: ");
                        double imaginary1Add = scanner.nextDouble();
                        ComplexNumber num1Add = new ComplexNumber(real1Add, imaginary1Add);
                        
                        System.out.print("Enter real part of second complex number: ");
                        double real2Add = scanner.nextDouble();
                        System.out.print("Enter imaginary part of second complex number: ");
                        double imaginary2Add = scanner.nextDouble();
                        ComplexNumber num2Add = new ComplexNumber(real2Add, imaginary2Add);
                        
                        ComplexNumber resultAdd = calculator.add(num1Add, num2Add);
                        System.out.println("Addition: " + num1Add + " + " + num2Add + " = " + resultAdd);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    
                    break;
                case 2:
                    System.out.println("Choose number type:");
                    System.out.println("1. Real");
                    System.out.println("2. Complex");
                    System.out.print("Enter your choice: ");
                    int numTypeSub = scanner.nextInt();
                    if (numTypeSub == 1) {
                        System.out.print("Enter first real: ");
                        double num1Sub = scanner.nextDouble();
                        System.out.print("Enter second real: ");
                        double num2Sub = scanner.nextDouble();
                        double resultSub = calculator.subtract(num1Sub, num2Sub);
                        System.out.println("Subtraction: " + num1Sub + " - " + num2Sub + " = " + resultSub);
                    } else if (numTypeSub == 2) {
                        System.out.print("Enter real part of first complex number: ");
                        double real1Sub = scanner.nextDouble();
                        System.out.print("Enter imaginary part of first complex number: ");
                        double imaginary1Sub = scanner.nextDouble();
                        ComplexNumber num1Sub = new ComplexNumber(real1Sub, imaginary1Sub);
                        
                        System.out.print("Enter real part of second complex number: ");
                        double real2Sub = scanner.nextDouble();
                        System.out.print("Enter imaginary part of second complex number: ");
                        double imaginary2Sub = scanner.nextDouble();
                        ComplexNumber num2Sub = new ComplexNumber(real2Sub, imaginary2Sub);
                        
                        ComplexNumber resultSub = calculator.subtract(num1Sub, num2Sub);
                        System.out.println("Subtraction: " + num1Sub + " - " + num2Sub + " = " + resultSub);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    
                    break;
                case 3:
                    System.out.println("Choose number type:");
                    System.out.println("1. Double");
                    System.out.println("2. Complex");
                    System.out.print("Enter your choice: ");
                    int numTypeMul = scanner.nextInt();
                    
                    if (numTypeMul == 1) {
                        System.out.print("Enter first real: ");
                        double num1Mul = scanner.nextDouble();
                        System.out.print("Enter second real: ");
                        double num2Mul = scanner.nextDouble();
                        double resultMul = calculator.multiply(num1Mul, num2Mul);
                        System.out.println("Multiplication: " + num1Mul + " * " + num2Mul + " = " + resultMul);
                    } else if (numTypeMul == 2) {
                        System.out.print("Enter real part of first complex number: ");
                        double real1Mul = scanner.nextDouble();
                        System.out.print("Enter imaginary part of first complex number: ");
                        double imaginary1Mul = scanner.nextDouble();
                        ComplexNumber num1Mul = new ComplexNumber(real1Mul, imaginary1Mul);
                System.out.print("Enter real part of second complex number: ");
                        double real2Mul = scanner.nextDouble();
                        System.out.print("Enter imaginary part of second complex number: ");
                        double imaginary2Mul = scanner.nextDouble();
                        ComplexNumber num2Mul = new ComplexNumber(real2Mul, imaginary2Mul);
                        
                        ComplexNumber resultMul = calculator.multiply(num1Mul, num2Mul);
                        System.out.println("Multiplication: " + num1Mul + " * " + num2Mul + " = " + resultMul);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    
                    break;
                case 4:
                    System.out.println("Choose number type:");
                    System.out.println("1. Double");
                    System.out.println("2. Complex");
                    System.out.print("Enter your choice: ");
                    int numTypeDiv = scanner.nextInt();
                    
                    if (numTypeDiv == 1) {
                        System.out.print("Enter first real: ");
                        double num1Div = scanner.nextDouble();
                        System.out.print("Enter second real: ");
                        double num2Div = scanner.nextDouble();
                        
                        if (num2Div == 0) {
                            System.out.println("Cannot divide by zero.");
                        } else {
                            double resultDiv = calculator.divide(num1Div, num2Div);
                            System.out.println("Division: " + num1Div + " / " + num2Div + " = " + resultDiv);
                        }
                    } else if (numTypeDiv == 2) {
                        System.out.print("Enter real part of first complex number: ");
                        double real1Div = scanner.nextDouble();
                        System.out.print("Enter imaginary part of first complex number: ");
                        double imaginary1Div = scanner.nextDouble();
                        ComplexNumber num1Div = new ComplexNumber(real1Div, imaginary1Div);
                        
                        System.out.print("Enter real part of second complex number: ");
                        double real2Div = scanner.nextDouble();
                        System.out.print("Enter imaginary part of second complex number: ");
                        double imaginary2Div = scanner.nextDouble();
                        ComplexNumber num2Div = new ComplexNumber(real2Div, imaginary2Div);
                        
                        ComplexNumber resultDiv = calculator.divide(num1Div, num2Div);
                        System.out.println("Division: " + num1Div + " / " + num2Div + " = " + resultDiv);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    
                    break;

                    
            }

            System.out.println();
        }

        scanner.close();
    }
}