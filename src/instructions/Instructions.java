package instructions;

import memory.Sequence;

import java.util.HashMap;
import java.util.Map;

public class Instructions {
    private final Map<Integer, Instruction> instructionSet = new HashMap<>();

    public Instructions() {
       register( 99, new HaltInstruction() );
       register( 1, new AddInstruction() );
       register( 2, new MultiplyInstruction() );
    }

    private void register(int opcode, Instruction instruction) {
        instructionSet.put(opcode, instruction);
    }

    public Instruction fetch(Sequence sequence) {
        Instruction instruction = instructionSet.get(sequence.getOpcode());

        if ( instruction == null ){
            throw new IllegalArgumentException("Unsupported Opcode: " + sequence.getOpcode());
        }

        instruction.bindValues(sequence);
        return instruction ;
    }
}
