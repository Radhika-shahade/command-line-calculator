package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Multiplication implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        double mul = 1.0;
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                Double number = Double.parseDouble( numbers[i]);
                mul *= number;
            }
            return Result.builder().message("Multiplication of given numbers is: ").value(mul).build();
        }
        return Result.builder().message("please write integer numbers").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        //        mul 10 20 30 -2 34 545

        if(!(attributes.length>2))
        {
            throw new Exception(" multiplication required at least two numbers");
        }
        return true;
    }

}
