package calc;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("����: ");
            String line = scanner.nextLine();

            if (line.equals("�����")) {
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("���������� ��� ���");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("�����: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        scanner.close();
    }

    public static void startCalc() {
        System.out.println("����������� �������� ������ � ��������� � �������� ������� �� 1 �� 10");
        System.out.println("� �������� ������ �� ���������� ����������:");
        System.out.println("+ - * /");
        System.out.println("����� �����, ������� '�����'");
    }


}