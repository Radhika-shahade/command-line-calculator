package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class FindMinimum implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(validate(command)){
            double min = Double.parseDouble(command[1]);
            for(int i = 2; i < command.length; i++){
                if(min > Double.parseDouble(command[i])){
                    min = Double.parseDouble(command[i]);
                }
            }
            return Result.builder().message("The Minimum number among all is: ").value(min).build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!attributes[0].equals("min") || attributes.length < 3){
            throw new Exception("Minimum two number required to find minimum number!");
        }else {
            return true;
        }
    }
    }

