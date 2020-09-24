package item;

import opreate.Article_cleaner;
import opreate.Output_to_file;
import method.Cosin_caculate;


import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class Application {


    private static Article_cleaner articleUtil=new Article_cleaner();
    private static Cosin_caculate calculate=new Cosin_caculate();



    public static void main(String[] args) throws IOException {
        if(args.length!=3){
            System.out.println("命令行参数错误，输入文件正确路径");
            return;
        }
        File original=new File(args[0]);
        File copy=new File(args[1]);
        if(original.length()==0||copy.length()==0){
            System.out.println("禁止输入空文件");
            return;
        }
        List<String> originalDivision = articleUtil.divisionArticle(original);
        List<String> copyDivision = articleUtil.divisionArticle(copy);
        double max=0;
        double sum=0;
        //逐句对比
        for (String s : copyDivision) {
            for (String s1 : originalDivision) {
                double calculation = calculate.calculation(s1, s);
                if(calculation>max)
                    max=calculation;
            }
            sum+=max;
            max=0;
        }
        //计算平均相似度
        Double result=sum/copyDivision.size();
        DecimalFormat df=new DecimalFormat("######0.00");
        if(!Output_to_file.writeIntoFile(df.format(result),args[2])){
            System.out.println("输出文件错误");
            return;
        }

    }


}
