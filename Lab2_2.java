import java.util.Scanner;
import java.util.regex.*;
public class Lab2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        while (true) {
            if (scanner.hasNextLine()) {
                String password = scanner.nextLine();
                String condition = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[0-9a-zA-Z_]{8,})";
                Pattern pas = Pattern.compile(condition);
                Matcher match = pas.matcher(password);
                if (match.matches()) {
                    System.out.println("Пароль надёжен");
                    System.exit(0);
                } else {
                    System.out.println("Пароль ненадёжен или содержит недопустимые символы. Повторите ввод: ");
                }
            }
        }
    }
}