import item.Application;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class Text_demo_10cases {
    @BeforeClass
    public static void beforeTest(){
        System.out.println("TEXT IS READY TO START");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("TEXT END");
    }

    //输入的文件路径存在错误示例
    @Test
    public void case_01(){
        String [] test={"D:/test1/test1/void.txt","",""};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //输入的文件为空白文件示例
    @Test
    public void case_02(){
        String [] test={"D:/test1/test1/void.txt","D:/test1/test1/orig_0.8_add.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //输入文件的存放路径出错示例
    @Test
    public void case_03(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_add.txt","D:/test1"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为添加内容的文本示例
    @Test
    public void case_04(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_add.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为删除内容的文本示例
    @Test
    public void case_05(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_del.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为调换内容前后顺序的文本示例-01
    @Test
    public void case_06(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_dis_1.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为调换内容前后顺序的文本示例-02
    @Test
    public void case_07(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_dis_10.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为调换内容前后顺序的文本示例-03
    @Test
    public void case_08(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig_0.8_dis_15.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为相同内容的文本示例-01
    @Test
    public void case_09(){
        String [] test={"D:/test1/test1/orig.txt","D:/test1/test1/orig.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    //测试类型为相同内容的文本示例-02
    @Test
    public void case_10(){
        String [] test={"D:/test1/test1/orig_0.8_dis_15.txt","D:/test1/test1/orig_0.8_dis_15.txt","D:/test1/test1/output.txt"};
        try {
            new Application().main(test);
        } catch (IOException e) {
            Assert.fail();
        }
    }
}
