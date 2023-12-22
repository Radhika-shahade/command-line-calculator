package number.command.app.command;

import number.command.app.model.Result;

public interface Command {
    public Result execute (String [] numbers) throws Exception;
}
