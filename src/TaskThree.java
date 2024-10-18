/**
 * @author 'Mukhtarov Sarvarbek' on 10/18/2024
 * @project Task
 * @contact @sarvargo
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Admin on 10/17/2024
 * @project Task
 * @package
 * @contact @sarvargo
 */
public class TaskThree {

    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Boolean> loggedInUsers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];

            switch (command) {
                case "register" -> register(username, input[2]);
                case "login" -> login(username, input[2]);
                case "logout" -> logout(username);
            }
        }
        scanner.close();
    }

    private static void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("fail: user already exists");
        } else {
            users.put(username, password);
            loggedInUsers.put(username, false);
            System.out.println("success: new user added");
        }
    }

    private static void login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("fail: no such user");
        } else if (!users.get(username).equals(password)) {
            System.out.println("fail: incorrect password");
        } else if (loggedInUsers.get(username)) {
            System.out.println("fail: already logged in");
        } else {
            loggedInUsers.put(username, true);
            System.out.println("success: user logged in");
        }
    }

    private static void logout(String username) {
        if (!users.containsKey(username)) {
            System.out.println("fail: no such user");
        } else if (!loggedInUsers.get(username)) {
            System.out.println("fail: already logged out");
        } else {
            loggedInUsers.put(username, false);
            System.out.println("success: user logged out");
        }
    }
}

