package org.example;
import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Wrong login");
    }

    public WrongLoginException(String message) {
        super("Wrong login: " + message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Wrong password");
    }

    public WrongPasswordException(String message) {
        super("Wrong password: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        try {
            boolean result = validateUser(login, password, confirmPassword);
            System.out.println("User validation result: " + result);
        } catch (WrongLoginException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Login length should be less than 20 characters");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Password length should be less than 20 characters");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password do not match");
        }

        return true;
    }
}