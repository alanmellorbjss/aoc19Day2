package memory;

import instructions.Instruction;
import instructions.Instructions;
import program.ProgramCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Memory {
    private List<Integer> words = new ArrayList<>();

    public void addSequence(Sequence sequence) {
        sequence.appendTo(words);
    }

    public Instruction fetchInstruction(ProgramCounter programCounter, Instructions instructions) {
        Sequence sequence = getSequenceAt( programCounter.current() );
        return instructions.fetch(sequence);
    }

    private Sequence getSequenceAt(int programCounter) {
        return new Sequence(
                read(programCounter),
                read(programCounter+1),
                read(programCounter+2),
                read(programCounter+3));
    }

    public Integer read(int address){
        return words.get(address);
    }

    public void write(int address, Integer value) {
        words.set(address, value);
    }

    public String toString() {
        return words.stream()
                .map(value->Integer.toString(value))
                .collect(Collectors.joining(" "));
    }

    public void display() {
        System.out.println(toString());
    }

    public void load(int[] contents) {
        for (int word : contents) {
            words.add(word);
        }
    }
}
