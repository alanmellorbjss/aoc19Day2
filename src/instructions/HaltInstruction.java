package instructions;

import memory.Memory;
import program.Program;

public class HaltInstruction extends Instruction {
    @Override
    public void execute(Program program, Memory memory) {
        program.stop();
    }
}
