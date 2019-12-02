package memory;

import java.util.List;

public class Sequence {
    private final int opcode;
    private final int value1;
    private final int value2;
    private final int value3;

    public Sequence(int opcode, int value1, int value2, int value3) {
        this.opcode = opcode;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public void appendTo(List<Integer> words) {
        words.add(opcode);
        words.add(value1);
        words.add(value2);
        words.add(value3);
    }

    public int getOpcode() {
        return opcode;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getValue3() {
        return value3;
    }
}
