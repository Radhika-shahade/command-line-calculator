package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class FindPower implements Command,CommandValidator {

    @Override
    public Result execute(String[] numbers) throws Exception {

        if (validate(numbers)) {
                double num = Double.valueOf(numbers[1]);
            double index = Double.valueOf(numbers[2]);
                double power = calculatePower(num, index);
                System.out.println("power of " + num + " is " + power);
            return Result.builder().message("power calculated successfully.").build();
            }

        return Result.builder().message("invalid attribute").build();
        }


    private double calculatePower(double num, double index) {
        Double result=1.0;
        while (index!=0) {
          result *= num;
          index--;
        }
        return result;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" To calculate power required two numbers");
        }
        return true;
    }

}
