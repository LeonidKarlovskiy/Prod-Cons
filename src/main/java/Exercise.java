import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * For the given value of seconds since midnight, return the electronic watch screen output.
 * Input value is given via System.in. Output value must be printed to System.out
 * It is guaranteed, that input number is non-negative.
 * Output format is h:mm:ss (possible values: [0:00:00; 23:59:59]).
 * Extra challenge: try to solve the task without using if statements or cycles.
 */


public class Exercise {

    public static void main(String[] args) {
        getNewTime();
    }

    private static void getNewTime() {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        if (seconds >= 1) {
            Calendar calendar = new GregorianCalendar(0, Calendar.JANUARY, 25, 0, 0, 0);
            calendar.set(Calendar.SECOND, seconds);
            Date date = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
            System.out.println(format.format(date));
            getNewTime();
        } else {
            System.out.println("input non-negative value");
            getNewTime();
        }
    }
}
