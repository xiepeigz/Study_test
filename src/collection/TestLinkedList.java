package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 10:29 2018/12/27
 */
public class TestLinkedList {
    public void test1(){

    }

    public static void main ( String[] args ) {
        LinkedList<String> staff = new LinkedList<String>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        Iterator iterator = staff.iterator();
        String first = (String)iterator.next();
        String second = (String)iterator.next();
    }

}
