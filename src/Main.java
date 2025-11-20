import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Gabriel Cordero del Toro
 * @version 1.0
 * Code translated from Spanish to English with the assistance of Copilot
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Calculator> calculators = new ArrayList<>();
        Calculator c1 = new Calculator("Calculadora 1");
        Calculator c2 = new Calculator("Calculadora 2");
        Calculator c3 = new Calculator("Calculadora 3");

        calculators.add(c1);
        calculators.add(c2);
        calculators.add(c3);




        chooseOption(chooseCalculator(calculators));

    }

    /**
     * This method is used to choose what operation to perform
     *
     * @param calculator is the calculator object we are going to use
     * @return TODO y compobar datos que se insertan y try catch
     */
    public static double chooseOption(Calculator calculator) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        double num1;
        double num2;
        String operator;
        String calculation;

        Calculator.showOptionsMenu();

        System.out.print("Enter an expression (e.g. 1 + 2): ");
        System.out.println("Examples: " + "1 + 2" + " 1 - 2" + " 1 * 2" + " 1 / 2");
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
                num1 += num2;
                calculator.setCache(num1);
                break;
            case "-":
                num1 -= num2;
                calculator.setCache(num1);
                break;
            case "*":
                num1 *= num2;
                calculator.setCache(num1);
                break;
            case "/":
                num1 /= num2;
                calculator.setCache(num1);
                break;
            default:
        }
        return result;
    }

    /**
     * This method shows the available calculators
     * @param calculators ArrayList of calculators
     */
    public static void showCalculators(ArrayList<Calculator> calculators) {
        for (Calculator calculator : calculators) {
            System.out.println(calculator);
        }
    }

    /**
     * This method allows you to choose which calculator to use
     * @param calculators ArrayList of calculators
     * @return a specific calculator
     */
    public static Calculator chooseCalculator(ArrayList<Calculator> calculators) {
        Scanner sc = new Scanner(System.in);
        Calculator userCalculator = null; // Calculator that will be used
        String option;
        showCalculators(calculators);
        System.out.print("Type the name of the calculator (e.g. Calculator1): ");
        option = sc.nextLine();
        for (Calculator calculator : calculators) {
            if (option.equals(calculator.getName())) {
                userCalculator = calculator;
            }
        }
        return userCalculator;
    }

}
/*TODO
  1- Traducción con Copilot
  2- Try-catch-finally
  3- Hacer calculadoras por defecto, cada una guarda en caché el resultado anterior
  5- Usar el caché para algo
  6- Fichero log
  7- Comentarios
  8- Arreglar return
  9- Readme de funcionamiento
  10- Crear anti errores
  11- Menú de opciones para elegir calculadoras y salir
  12- Limpiar cache metodo
 */