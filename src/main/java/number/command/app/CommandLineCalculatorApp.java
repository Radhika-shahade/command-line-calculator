package number.command.app;

import number.command.app.command.Command;
import number.command.app.command.impl.*;
import number.command.app.model.Result;

import java.util.Scanner;

public class CommandLineCalculatorApp {
    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("======================= Bootcoding Command Utility =================");
            System.out.println("To perform addition of integer numbers, command should be like ::: add 12 354 545 5");
            System.out.println("======================= Bootcoding Command Utility =================");

            System.out.println("You are free to enter any command!");

            String commandStr = sc.nextLine();

            String[] commandWithAttrs = commandStr.split(" ");

            Command command = findCommand(commandWithAttrs[0]);
            if(command == null) {
                System.err.println("Enter valid Command with proper arguments!");
                continue;
            }
            try {
                Result result = command.execute(commandWithAttrs);
                System.out.println(result);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static Command findCommand(String cmd) {
        return switch (cmd) {
            case "add" -> new Addition();
            case "sub" -> new Subtraction();
            case "multi" -> new Multiplication();
            case "div" -> new Division();
            case "fact" -> new Factorial();
            case "palindrome" -> new Palindrome();
            case "prime" -> new PrimeNumber();
            case "pow" -> new FindPower();
            case "square" -> new Square();
            case "max" -> new FindMax();
            case "min" -> new FindMinimum();
            case "avg" -> new CalculateAverage();
            case "even" -> new Even();
            case "odd" -> new FindOddNum();
            case "exit" -> new Exit();
            default -> null;
        };
    }
}
