import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Gabriel Cordero del Toro
 * @version 1.0
 * Code translated from Spanish to English with the assistance of Copilot
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Calculator> calculators = new ArrayList<>();
        Calculator c1 = new Calculator("Calculator 1");
        Calculator c2 = new Calculator("Calculator 2");
        Calculator c3 = new Calculator("Calculator 3");

        calculators.add(c1);
        calculators.add(c2);
        calculators.add(c3);

// TODO pensando si meterlo en un método
// ------
        byte option;

        try {
            do {
                continueMenu();
                System.out.print("Option: ");
                option = sc.nextByte();
                sc.nextLine(); // clear input buffer

                switch (option) {
                    case 1:
                        chooseCalculate(chooseCalculator(calculators));
                        break;
                    case 2:
                        System.out.print("\n");
                        showCalculators(calculators);
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                        break;
                    case 3:
                        noCache(chooseCalculator(calculators));
                        break;
                    case 4:
                        // TODO ficheros
                        break;
                    case 5:
                        tipsList();
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 6);
        } catch (InputMismatchException e) {
            System.out.println("Invalid number");
        }
    }

    /**
     * This method is used to clear the calculator's value
     */
    public static void tipsList() {
        System.out.println("List of tips");
        System.out.println("1 - The maximum number of calculators is 3");
        System.out.println("2 - You must write the calculation in the following format \"1 + 2\".");
    }


    /**
     * Este método sirve para limpiar el valor de la calculadora
     *
     * @param calculator is the calculator object we are going to use
     */
    public static void noCache(Calculator calculator) {
        try {
            calculator.clearCache();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is used to choose what operation to perform
     *
     * @param calculator is the calculator object we are going to use
     */
    public static void chooseCalculate(Calculator calculator) {
        Scanner sc = new Scanner(System.in);
        double num1;
        double num2;
        double result = 0;
        String operator;
        String calculation;

        Calculator.showOptionsMenu();

        System.out.print("Calculation: ");
        calculation = sc.nextLine();

        // Split by spaces
        String[] parts = calculation.split(" ");

        // Store in variables
        num1 = Double.parseDouble(parts[0]);
        operator = parts[1];
        num2 = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
        }
        calculator.setCache(result);
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }

    /**
     * This method shows the available calculators
     *
     * @param calculators ArrayList of calculators
     */
    public static void showCalculators(ArrayList<Calculator> calculators) {
        for (Calculator calculator : calculators) {
            System.out.println(calculator);
        }
    }

    /**
     * This method allows you to choose which calculator to use
     *
     * @param calculators ArrayList of calculators
     * @return a specific calculator
     */
    public static Calculator chooseCalculator(ArrayList<Calculator> calculators) {
        Scanner sc = new Scanner(System.in);
        Calculator userCalculator = null; // Calculator that will be used
        String option = "";

        while (!option.matches("Calculator [1-3]")) {
            System.out.print("Type the name of the calculator (e.g. Calculator 1): ");
            option = sc.nextLine();
        }

        for (Calculator calculator : calculators) {
            if (option.equals(calculator.getName())) {
                userCalculator = calculator;
            }
        }
        return userCalculator;
    }


    /**
     * This method displays the options to choose from in the main logic
     */
    public static void continueMenu() {
        System.out.println("""
                Type the corresponding number to choose an option:
                1. Choose calculator and perform the calculation
                2. View calculators
                3. Clear cache
                4. View log file
                5. Tips List
                6. Exit""");
    }
}

/*TODO
  1- Traducción con Copilot ////HECHO
  2- Try-catch-finally
  3- Añadir javadoc a la clase Calculator y definición simple del main
  5- Usar el caché para algo
  6- Fichero log
  7- Comentarios
  9- Readme de funcionamiento
  10- Crear anti errores
  13- Cambiar nombres de métodos, para tener un estándar
  16- Hacer interacciones entre calculadoras (como por ejemplo sumarlas), eso quizás dentro de la clase Calculator
 */