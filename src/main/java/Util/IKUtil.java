package Util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IKUtil {

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
        List<String> division1 = division(str1);//将str1文字串分词后用list列表装起来
        List<String> division2 = division(str2);
        HashSet<String> hashSet=new HashSet<String>();//new一个hashset对象
        division1.forEach(str->{hashSet.add(str);});//对division1的每一个分词都引入hashset对象
        division2.forEach(str->{hashSet.add(str);});
        return Arrays.asList(hashSet.toArray(new String[0]));//以数组形式返回合并去重的词
    }
}
