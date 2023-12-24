package number.command.app;

import number.command.app.command.Command;
import number.command.app.command.impl.*;
import number.command.app.model.Result;

import java.util.Scanner;

public class CommandLineCalculatorApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Command Line Calculator!");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("You are free to enter any command!");
        System.out.println("To add number: ex add 2 3 4");
        System.out.println("To subtract number ex: sub 2 3 4");
        System.out.println("To Multiply number ex: mul 2 3 4");
        System.out.println("To Divide number ex: div 2 3 4");
        System.out.println("To Find Factorial  ex: fact 2 3 4");
        System.out.println("To find palindrome number ex: palindrome 2 3 4");
        System.out.println("To Find Prime Number ex: prime 2 3 4");
        System.out.println("To Find power ex: pow 2 3 ");
        System.out.println("To Find square ex: square 2 3 4");
        System.out.println("To Find square ex: square 2 3 4");
        System.out.println("To Find even number ex: even 2 3 4");
        System.out.println("To Find odd number ex: odd 2 3 4");
        System.out.println("To Find average ex: avg 2 3 4");
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Enter command");
            System.out.println("-------------------------------------------------------------------------------------------------");

            String commandStr = sc.nextLine();

            String[] commandWithAttrs = commandStr.split(" ");

            Command command = findCommand(commandWithAttrs[0]);
            if(command == null) {
                System.err.println("Enter valid Command");
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
            case "mul" -> new Multiplication();
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
