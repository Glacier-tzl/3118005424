package Util;

import java.io.*;
import java.nio.Buffer;
import java.util.List;

public class article_cleaner {

    public static void main(String[] args) throws IOException {
        divisionArticle(new File("D:/test/orig.txt"));
    }

    public static void divisionArticle(File file) throws IOException {
        FileReader fileReader=new FileReader(file);//将文件读成字符流
        BufferedReader bufferedReader=new BufferedReader(fileReader);//将字符流读成字节流
        String temp;
        StringBuilder stringBuilder=new StringBuilder();
        while ((temp=bufferedReader.readLine())!=null){//按行读取
            stringBuilder.append(temp);
        }
        String[] s = stringBuilder.toString()//清洗文章标点符号，按照句号分句
                .replace(" ", "")
                .replace("“", "")
                .replace("”", "")
                .replace("：", "，")
                .replace("？", "。")
                .split("。");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
