package calc;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Ввод: ");
            String line = scanner.nextLine();

            if (line.equals("выйти")) {
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Попробуйте еще раз");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Вывод: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        scanner.close();
    }

    public static void startCalc() {
        System.out.println("Калькулятор работает только с арабскими и римскими числами от 1 до 10");
        System.out.println("И работает только со следующими операциями:");
        System.out.println("+ - * /");
        System.out.println("Чтобы выйти, введите 'выйти'");
    }


}