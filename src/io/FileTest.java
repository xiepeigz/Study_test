package io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 16:21 2018/12/19
 */
public class FileTest {
    public  static void  main(String[] args){
        File file=new File("D:/");//指定文件目录
        String[] str=file.list();//获取指定目录下的所有文件或者文件夹的名称数组
        for(String s : str) {//加强for循环遍历输出
            System.out.println(s);
        }
        System.out.println("第一步完成");
        //File file1 = new File("D:/");
        String[] strings = file.list(new FilenameFilter() {//FilenameFilter内部匿名类，该类为接口
            @Override
            public boolean accept ( File dir , String name ) {
                File f= new File(dir, name);
                return f.isFile() && f.getName().endsWith(".txt");
            }
        });
        for(String s : strings){
            System.out.println(s);
        }

    }
    public void FileStreamTest() {
        System.out.println("qqq");
    }

}
