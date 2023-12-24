package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Square implements CommandValidator, Command {
    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                double num = Double.valueOf(numbers[1]);
                double result = calculateSquare(num);
                System.out.println(result + " is square of number "+num);
                }
            return Result.builder().message("square is calculated ").build();
            }
        return Result.builder().message("Invalid attributes ").build();
        }

    private Double calculateSquare(Double num) {
        return Math.pow(num,2);
    }


    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>1))
        {
            throw new Exception(" to find sqaure required at least one number");
        }
        return true;
    }

}
