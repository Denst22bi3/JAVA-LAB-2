import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату: ");
        String data = in.nextLine();
            String condition = "^[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]"; //общая проверка на формат xx/xx/xxxx
            String februarycondition = "^[3-9][0-9]/02/[0-9][0-9][0-9][0-9]"; //проверка на 30 и 31 числа февраля
            String februarycondition29 = "^29/02/[0-9][0-9][0-9][0-9]"; //проверка 29 числа невисокосного года
            Pattern check = Pattern.compile(condition);
            Pattern check1 = Pattern.compile(februarycondition);
            Pattern check2 = Pattern.compile(februarycondition29);
            Matcher match = check.matcher(data);
            Matcher match1 = check1.matcher(data);
            Matcher matchf = check2.matcher(data);
            if (!(match.matches())) {
                System.out.println("Введенное выражение не является датой");
                System.exit(0);
            }
            String years = data.substring(6,10); //вывод года в отдельную переменную
            int year = Integer.parseInt(years);
            String datecondition = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19[0-9][0-9]|[2-9][0-9][0-9][0-9])";
            Pattern condition2 = Pattern.compile(datecondition);
            Matcher match2 = condition2.matcher(data);
            if ((!(year%4==0))&(matchf.matches() == true)){ //если год делиться на 4 - то он високосный
                System.out.println("Введенное выражение не является датой - год не високосный");
                System.exit(0);
            }
            if (match2.matches()) {
                if(match1.matches() == false) {
                System.out.println("Введенное выражение является датой");
            }
            else {
                System.out.println("Введенное выражение не является датой");
            }
        } else {
            System.out.println("Введенное выражение не является датой");
        }
    }
}