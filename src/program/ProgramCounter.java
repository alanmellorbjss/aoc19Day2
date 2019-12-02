package program;

public class ProgramCounter {
    private int address = 0;

    public void branchForward(int addressOffset) {
        address += addressOffset;
    }

    public int current() {
        return address;
    }
}
