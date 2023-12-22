package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class CalculateAverage implements CommandValidator, Command {

    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
            double average = findAverage(numbers);
            return Result.builder().message("average of given numbers is: ").value(average).build();
        }
        return Result.builder().message("invalid attribute").build();
    }
    private double findAverage(String[] numbers) {
//        avg 2 3 4
        double sum=0.0;
        double count=0.0;
        for( int i=1;i<numbers.length;i++)
        {
            double currentNum= Double.valueOf(numbers[i]);
            sum +=currentNum;
            count++;
        }
        return sum/ count;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" to calculate average required at least two numbers");
        }
        return true;
    }

}
