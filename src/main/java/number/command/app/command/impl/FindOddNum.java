package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

import javax.swing.plaf.basic.BasicComboBoxUI;

public class FindOddNum implements Command, CommandValidator {
    @Override
    public Result execute(String[] command) throws Exception {
        if(validate(command)){
            for(int i = 1; i < command.length; i++){
                if(!(Integer.parseInt(command[i])%2 == 0)){
                    System.out.println(command[i] + " is odd Number!");
                }else{
                    System.out.println(command[i] + " is even Number!");
                }
            }
            return Result.builder().message("Success!").build();
        }
        return Result.builder().message("Please enter valid input!").build();
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!attributes[0].equals("odd") || attributes.length < 1){
            throw new Exception("Minimum one number is required to find odd number!");
        }else {
            return true;
        }
    }

}
