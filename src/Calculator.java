import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Java 계산기 ===");

        while (running) {
            double num1 = 0;
            double num2 = 0;

            // 첫 번째 숫자 입력
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
                continue;
            }

            // 연산자 입력
            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            String operator = sc.nextLine();

            // 두 번째 숫자 입력
            try {
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요!");
                sc.nextLine();
                continue;
            }

            double result = 0;
            boolean valid = true;

            // 연산 처리
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
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        valid = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;

                default:
                    System.out.println("지원하지 않는 연산자입니다. (+, - , *, /) 중 하나를 선택해주세요");
                    valid = false;
            }

            // 결과 출력
            if (valid) {
                System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
            }

            // 계속 계산 여부
            System.out.print("\n계속 계산하시겠습니까? (y/n): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                running = false;
                System.out.println("계산기를 종료합니다.");
            }
        }

        sc.close();
    }
}