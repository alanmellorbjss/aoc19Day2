package program;

import instructions.Instruction;
import instructions.Instructions;
import memory.Memory;

public class Program {
    private final Memory memory ;
    private final Instructions instructions;
    private boolean stopExecution;

    public Program(Memory memory, Instructions instructions) {
        this.memory = memory;
        this.instructions = instructions;
    }

    public void execute(ProgramCounter programCounter) {
        while(!stopExecution) {
            Instruction instruction = memory.fetchInstruction(programCounter, instructions);
            instruction.advance(programCounter);

            instruction.execute(this, memory);
        }
    }

    public void stop() {
        stopExecution = true ;
    }
}
