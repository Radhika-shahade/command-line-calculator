package number.command.app.command.impl;

import number.command.app.command.Command;
import number.command.app.model.Result;

public class Exit implements Command {
    @Override
    public Result execute(String[] command) throws Exception {
            System.exit(0);
            return null;
        }
    }

