package Util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IK_words_divider {

    public static void main(String[] args) throws IOException {

    }
    //分词
    public List<String> division(String str) throws IOException {
        StringReader stringReader=new StringReader(str);//将句子读成流
        IKSegmenter ikSegmenter=new IKSegmenter(stringReader,true);//将流形式的文字传入ik分词器
        Lexeme lex;//lex用来装起分好的词
        List<String> list=new ArrayList<String>();//定义一个数组用来存放分词
        while((lex=ikSegmenter.next())!=null){
            list.add(lex.getLexemeText());//将分好的词分装入数组
        }
        return list;
    }
    
    //引入句子
    public List<String> phrase(String str1,String str2) throws IOException {
        StringBuilder stringBuilder=new StringBuilder();//将str1于srt2合并一个字符流，调用一次division
        stringBuilder.append(str1);
        stringBuilder.append(str2);
        List<String> division = division(stringBuilder.toString());
        HashSet<String> hashSet=new HashSet<String>();//new一个hashset对象
        division.forEach(str->{hashSet.add(str);});
        return Arrays.asList(hashSet.toArray(new String[0]));//以数组形式返回合并去重的词
    }
    
}
