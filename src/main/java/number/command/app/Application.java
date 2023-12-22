package number.command.app;

import number.command.app.command.Command;
import number.command.app.command.impl.*;
import number.command.app.model.Result;

import java.util.Scanner;

public class Application {
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
//            if(null == command || command instanceof ExitCommand){
//                break;
//            }
            try {
                Result result = command.execute(commandWithAttrs);
                System.out.println(result);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static Command findCommand(String cmd) {
        switch (cmd){
            case "add":
                Command command = new Addition();
                return command;
            case "sub":
                Command command2= new Subtraction();
                return command2;
            case "mul":
                Command command1=new Multiplication();
                return command1;
            case "div":
                Command command3= new Division();
                return command3;
            case "fact":
                Command command4= new Factorial();
                return command4;
            case "palindrome":
                Command command5= new Palindrome();
                return command5;
            case "power":
                Command command6= new FindPower();
                return command6;
            case "max":
                Command command7= new FindMax();
                return command7;
            case "avg":
                Command command8= new CalculateAverage();
                return command8;
            case "even" :
                    Command command9= new Even();
                return command9;
            default:
                return null;
        }
    }
}
