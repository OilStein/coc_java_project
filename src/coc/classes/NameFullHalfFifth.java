package coc.classes;

public class NameFullHalfFifth {
    private String name;
    private int full;
    private int half;
    private int fifth;

    public NameFullHalfFifth(String name, int fifth) {
        this.name = name;
        this.full = fifth * 5;
        this.half = (int) ((fifth * 5) / 2);
        this.fifth = fifth;
    }
}
