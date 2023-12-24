package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Subtraction implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        double sub = Double.valueOf(numbers[1]);
        if (validate(numbers)) {
            for (int i = 2; i < numbers.length; i++) {
                int num = Integer.valueOf(numbers[i]);
                sub-= num;
            }
            return Result.builder().message("subtraction of the given number is:").value(sub).build();
        }
        return Result.builder().message("provide valid attributes").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" subtraction required at least two numbers");
        }
        return true;
    }
}
