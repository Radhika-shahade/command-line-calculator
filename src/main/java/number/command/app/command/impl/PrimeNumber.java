package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.command.validator.CommandValidator;
import number.command.app.model.Result;

public class PrimeNumber implements Command, CommandValidator {
    @Override
    public Result execute(String[] numbers) throws Exception {
        if (validate(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                double num = Double.valueOf(numbers[1]);
               boolean result = isPrimeNumber(num);
                if (result) {
                    System.out.println(num + "is palindrome number");
                } else {
                    System.out.println(num + "is not palindrome number");
                }
            }
            return Result.builder().message("prime number result calculated ").build();
        }
            return Result.builder().message("Provide valid attributes").build();
        }


    private boolean isPrimeNumber(double num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // Number is divisible, not a prime number
            }
        }
        return  true;
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

