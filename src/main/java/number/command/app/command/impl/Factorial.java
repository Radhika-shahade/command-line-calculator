package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Factorial implements Command, CommandValidator {

    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                double fact = calculateFactorial( Double.valueOf(numbers[i]));
                System.out.println("Factorial of " + fact + " is " + fact);
            }

            return Result.builder().message("Factorials calculated successfully.").build();
        }

        return Result.builder().message("Provide valid attributes").build();
    }

    private double calculateFactorial(double num) {
        double fact =1.0;
        while(num!=1)
        {
            fact *= num;
            num--;
        }
        return fact;
    }


    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>1))
        {
            throw new Exception(" To calculate factorial required at least one numbers");
        }
        return true;
    }

}
