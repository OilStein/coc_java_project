package coc.ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    public UserInterface(Scanner scanner){
        this.scanner = scanner;
    }

    public void start(){
        printTitle();
    }

    public void printTitle(){
        System.out.println("** Call of Cthulhu - Character Book **");
    }
}
