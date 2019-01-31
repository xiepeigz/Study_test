package collection;

import java.util.Scanner;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 15:05 2018/12/27
 */
public class ScannerTest {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
