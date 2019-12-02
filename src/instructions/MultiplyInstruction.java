package instructions;

import memory.Memory;
import program.Program;

public class MultiplyInstruction extends Instruction {

    @Override
    public void execute(Program program, Memory memory) {
        int a = memory.read(value1);
        int b = memory.read(value2);

        int result = a * b;

        memory.write(value3, result);
    }
}
