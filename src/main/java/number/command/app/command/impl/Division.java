package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Division implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        //div 45 4
        if(validate(numbers))
      {
          double div = Double.parseDouble(numbers[1]);
         for(int i=2;i<numbers.length;i++)
         {
            double num = Double.parseDouble(numbers[i]);
            div /= num ;
         }
          return Result.builder().message("Division of given numbers is: ").value(div).build();
       }
        return Result.builder().message("attributes are invalid").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>2))
        {
            throw new Exception(" division required at least two numbers");
        }
        return true;
    }
}
