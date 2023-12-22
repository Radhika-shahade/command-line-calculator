package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class FindMax implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
                Double result = findMax(numbers);
            return Result.builder().message(" maximum number is: ").value(result).build();
            }
            return Result.builder().message("invalid attribute").build();
        }

    private Double findMax(String[] numbers) {
        double max = Double.parseDouble(numbers[1]); // max 12 a 4 5

        for (int i = 2; i < numbers.length; i++) {
            double currentNumber = Double.parseDouble(numbers[i]);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }

        return max;
    }



    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" To find max number required at least two numbers");
        }
        return true;
    }

}
