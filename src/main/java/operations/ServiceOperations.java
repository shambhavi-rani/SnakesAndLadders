package operations;

import input.CommandLineInputMode;
import input.FileInputMode;
import input.Input;
import input.InputMode;

public class ServiceOperations {
    public static Input processFileOrCommandInput(String[] args){
        InputMode inputMode;
        if(args.length == 0){
            inputMode = new CommandLineInputMode();
        }
        else{
            inputMode = new FileInputMode();
        }
        return inputMode.processInput();
    }
}
