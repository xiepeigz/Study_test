import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 13:52 2018/12/20
 */
public class TestOther {
    public static void main ( String[] args ) {
        TestOther testOther = new TestOther();
        //testOther.testList2Array();
        testOther.testList();
    }

    @Test
    public   void testSplit(){
        String string  ="A,B,C,,";
        String[] strings = string.split(",");
        System.out.println(strings.length);
        for ( String s : strings){
            System.out.println( s );
            System.out.println(" 1 ");
            System.out.println();
        }
    }
    @Test
    public  void  testList2Array(){
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
    }
    public void testList(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list.toString());
    }
    public void testList1(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
    }
}
