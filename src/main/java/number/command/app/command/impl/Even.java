package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Even implements Command, CommandValidator {

    @Override
    public Result execute(String[] numbers) throws Exception {
        // even or odd 1 2 3 4 5 6
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                boolean res = findEvenOrOdd(Double.valueOf(numbers[i]));
                if (res) {
                    System.out.println(Double.valueOf(numbers[i])+" number is even "+ res);
                }
            }
            return Result.builder().message("even number result is displayed").build();
        }
        return Result.builder().message("Invalid argument").build();
    }


    private boolean findEvenOrOdd(double num) {
            if (num % 2 == 0) {
                return true;
            }
     return  false;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" To calculate Even number required at least one numbers");
        }
        return true;
    }
}
