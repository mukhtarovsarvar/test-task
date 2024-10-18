import java.util.Scanner;

/**
 * @author Admin on 10/17/2024
 * @project Task
 * @package
 * @contact @sarvargo
 */
public class TaskOne {
    private static final byte MAX_EXAM = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] scores = new byte[MAX_EXAM];
        int count = 0;
        System.out.println("""
                Task Student
                0. Exit
                """);
        for (int i = 1; i <= MAX_EXAM; ) {
            System.out.printf("Enter score exam: %d\n", i);
            byte score = scanner.nextByte();
            if (score == 0) {
                if (count == 0) {
                    System.out.println("Please enter one more score!");
                    continue;
                }
                break;
            }
            if (score < 3 || score > 5) {
                System.out.println("Please enter valid score 3 <= score <= 5");
                continue;
            }
            scores[i - 1] = score;
            count = i;
            i++;
        }

        boolean none = true, named = true;
        float sum = 0;

        for (int i = 0; i < count; i++) {
            byte score = scores[i];
            ;
            if (score != 3) none = false;
            if (score != 5) named = false;
            sum += score;
        }

        if (none) System.out.println("None");
        else if (named) System.out.println("Named");
        else if (sum / count >= 4.5) System.out.println("High");
        else System.out.println("Common");
    }
}

