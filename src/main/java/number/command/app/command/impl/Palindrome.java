package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class Palindrome implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                boolean result = isPalindrome(Double.valueOf(numbers[1]));
                if (result) {
                    System.out.println(result + "is palindrome number");
                } else {
                    System.out.println(result + "is not palindrome number");
                }
            }
            return Result.builder().message("Exit").build();
        }
        return Result.builder().message("Provide valid attributes").build();
    }
    private boolean isPalindrome(double num){
        double original =num;
        double rev = 1.0;
        while(num!=0)
        {
            double last = num%10;
             rev = rev *10+last;
             num/=num;
        }
        return original==rev;
    }

    @Override
    public boolean validate(String[] attributes) throws Exception {
        if(!(attributes.length>1))
        {
            throw new Exception(" palindrome required at least one numbers");
        }
        return true;
    }

}
