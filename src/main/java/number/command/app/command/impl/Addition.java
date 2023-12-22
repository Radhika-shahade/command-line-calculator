package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;




public class Addition implements Command, CommandValidator {
    //        add 10 20 30 -2 34 545
    public Result execute(String[] numbers) throws Exception {
        Double sum = 0.0;
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                String currentNumber = numbers[i];
                Double number = Double.parseDouble(currentNumber);
                sum += number;
            }
            return Result.builder().message("Addition of given numbers is: ").value(sum).build();
        }
        return Result.builder().message("please write integer numbers").build();
    }

    public boolean validate(String[] attributes) throws Exception {
//        add 10 20 30 -2 34 545
        if(!(attributes.length>2))
        {
           throw new Exception(" addition required at least two numbers");
        }
        return true;
    }


}
