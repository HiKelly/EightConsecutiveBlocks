import javax.swing.*;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("请输入大小n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        UI ui = new UI(n);
    }
}