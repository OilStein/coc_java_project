package coc.classes;

public class NameFullHalfFifth {
    private String name;
    private int full;
    private int half;
    private int fifth;

    public NameFullHalfFifth(String name, int full) {
        this.name = name;
        this.full = full;
        this.half = (full / 2);
        this.fifth =  (full / 5);
    }

    public NameFullHalfFifth(){

    }
}
