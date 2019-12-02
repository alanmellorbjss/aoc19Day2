package instructions;

import memory.Memory;
import memory.Sequence;
import program.Program;
import program.ProgramCounter;

public abstract class Instruction {
    protected int value1;
    protected int value2;
    protected int value3;

    void bindValues(Sequence sequence){
        value1 = sequence.getValue1();
        value2 = sequence.getValue2();
        value3 = sequence.getValue3();
    }

    public abstract void execute(Program program, Memory memory);

    public void advance(ProgramCounter programCounter) {
        programCounter.branchForward( 4 );
    }
}
