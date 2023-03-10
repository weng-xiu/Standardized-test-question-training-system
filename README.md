# Standardized-test-question-training-system
标准化试题训练系统
一.课程设计目的**

1. 通过一个小项目——标准化试题训练系统，考察并提高这一段时间以来Java的学习成果。
2. 体验面向对象，图形化界面开发的过程，体验开发过程中的排错过程。
3. 体会MVC-Model View Control设计思想。

**二.课程设计的内容与设计思路**

1. 设计内容：
   ![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825337603-7a30c2e7-af89-4e60-bb2f-6c51286c9f0b.png#averageHue=%23fafafa&id=pBYcP&originHeight=1522&originWidth=1266&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
2. 设计思路：
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825338202-07128993-6d78-414c-82aa-0e305415d433.jpeg#averageHue=%23fefefe&id=ik58l&originHeight=794&originWidth=1123&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

**三.程序实现过程与细节**

1. 界面设计
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825338967-db2bba48-5d74-4d5a-967b-8e050743a623.jpeg#averageHue=%23fdfdfd&id=eGqKs&originHeight=794&originWidth=1123&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
2. UML类图
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825339953-10477c8a-1a7b-4079-a883-031561b6e234.jpeg#averageHue=%23e3dfd5&id=vhMjy&originHeight=1936&originWidth=1509&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   3.UML类体其中一个main的关系
   .![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825340557-f1634e3e-4880-4863-8124-1f5397bab18d.jpeg#averageHue=%23fafafa&id=awDJ6&originHeight=842&originWidth=1265&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

3. 模拟人答题：
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825340915-4ced866d-b6a1-4dce-9ccb-08b9ea7c79f4.jpeg#averageHue=%23fcfcfc&id=Xris9&originHeight=794&originWidth=1123&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)





5. 具体写法
   5.1. 由于出卷与改卷有多种不同的方式故出卷与改卷的类定义为接口，出卷给出出卷方法和题库类型，改卷给出改卷方法。
   5.2.定义一个封装了一个题目的所有属性（题目，答案，选项，题型，题目所含图片名）的类用于封装一个题目，并给出所有属性的get和set方法。
   5.3.写出几个实现出卷和改卷的类，由于出卷中读数据的代码重复，抽出单独写一个类。
   5.4.写一个测试类，模拟出试卷，答题，改试卷，给出分数及错误全过程；测试之前的类是否有问题。
   5.5.写一个提供视图的类，并为它添加计时器。
   5.6.写一个处理事件的类，处理各种事件。
   5.7.写一个显示图像的类。
   5.8.写一个图片弹框类，单独查看图片。































6. AppWindow运行时序图
   ![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825341366-cb3bd9e4-f065-4d16-9089-371685c133d6.png#averageHue=%23f9f8f7&id=ok2vY&originHeight=1698&originWidth=754&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   **四.运行效果**
   1.开始界面
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825341924-2b9cb58e-fe9b-462b-9bc1-9fa4f9e2f983.jpeg#averageHue=%23f5f5f1&id=F4GDw&originHeight=554&originWidth=1190&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   2.开始答题
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825342432-014b2426-da30-42c2-8d5d-39c15ed36f84.jpeg#averageHue=%23b3aa4a&id=MYa9p&originHeight=554&originWidth=1190&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   3.查看答案
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825342905-2b13c20a-4a92-40f6-b45d-132dde912135.jpeg#averageHue=%23aa7e61&id=d93DP&originHeight=554&originWidth=1187&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   4.提醒交卷
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825343177-dab97a34-b04f-4952-9d4b-130e8c967d49.jpeg#averageHue=%23a97d5f&id=XQ9um&originHeight=552&originWidth=1188&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   5.交卷之后
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825343466-cbbff157-4eef-4314-955c-dd96ced712de.jpeg#averageHue=%23ab7f62&id=TUyVJ&originHeight=554&originWidth=1187&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   6.再来一次
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825343712-38aa9fb9-1208-454f-aafe-577da79601a1.jpeg#averageHue=%23d3e5c6&id=DAdTa&originHeight=554&originWidth=1187&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   7.切换题型
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825344226-6880144a-dc14-43fa-b484-042975717eb5.jpeg#averageHue=%23bd9f85&id=Ip5Cv&originHeight=551&originWidth=1189&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
   8.数据库作为数据源开始界面
   ![](https://cdn.nlark.com/yuque/0/2022/jpeg/22782459/1641825344731-8d49e734-10d9-406f-9927-5cd72b85bb7d.jpeg#averageHue=%23a7795b&id=wGzgn&originHeight=555&originWidth=1187&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)



**五.设计小结**
1.碰到的问题以及解决方案











（1）将重复代码抽出
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825345273-d7e72395-1498-42b9-95ba-c1452c681510.png#averageHue=%23f9f9f8&id=e94Mv&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
**改前：**
public TestPaper getTestPaper(String excelFileName,int amount) {
      boolean b =setExcel(excelFileName);  //设置用户存放试题的电子表格
      if(b) {
        try {
           randomGiveProblem(amount);//随机给出amount道试题，见类后面的randomGiveProblem方法
        }
        catch(ArrayIndexOutOfBoundsException e){
           System.out.println("试题必须有类型，请检查题库");
           System.exit(0);
        }
        testPaper.setProblem(problem);//试卷上设置的一套试题是problem
        return testPaper;//返回试卷
      }
      else {
        JOptionPane.showMessageDialog
        (null,"没有预备题库","消息对话框",JOptionPane.WARNING_MESSAGE);
        return null;
      }
   }
**改后：**
public TestPaper getTestPaper(String excelFileName,int amount){
        wb = SetExcel.setExcel(excelFileName,testPaper,fileExcel,problem,in,wb,sheet);//设置用户存放试题的电子表格
        if(wb!=null){
            try {
                randomGiveProblem(amount);//随机给出amount道试题，见类后面的randomGiveProblem方法
            }
            catch(ArrayIndexOutOfBoundsException e){//用非法索引访问数组时抛出的异常。
                System.out.println("试题必须有类型，请检查题库");
                System.exit(0);//exit(int status)终止当前正在运行的 Java 虚拟机。
            }
            testPaper.setProblem(problem);//试卷上设置的一套试题是problem
            return testPaper;//返回试卷
        }
        else {
            JOptionPane.showMessageDialog
                    (null,"没有预备题库","消息对话框",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
**重复代码单独**
package data;
import jxl.Sheet;
import jxl.Workbook;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
设置用户存放试题的电子表格,并且读取
 */
public class SetExcel {
    public static Workbook setExcel
            (String excelFileName,TestPaper testPaper, File fileExcel, Problem[] problem, InputStream in, Workbook wb, Sheet sheet){//判断题库 Excel是否存在
        try {
            //File(String pathname)通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
            fileExcel =new File(excelFileName);
            //FileInputStream:从文件系统中的某个文件中获得输入字节
            in =new FileInputStream(fileExcel);
            //getAbsolutePath()返回此抽象路径名的绝对路径名字符串。
            testPaper.setProblemSource(fileExcel.getAbsolutePath());//试卷设置题库来源
        }
        catch(IOException exp){
            JOptionPane.showMessageDialog
                    (null,"没有预备题库Excel","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        try {
            //getWorkbook:接收一个excel文件并读入内容
            wb=Workbook.getWorkbook(in);
            //close()关闭此输入流并释放与该流关联的所有系统资源。
            in.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
        return wb;
    }
}
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825345762-27660f5c-517a-4d51-b2ac-8a1e10a313e2.png#averageHue=%23f3f3f3&id=aTUFv&originHeight=207&originWidth=741&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
（2）读取数据库中的数据
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825346125-5f81177a-ec54-4fb7-a88d-7b0dc3382041.png#averageHue=%23f9f7f6&id=SgyNS&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825346725-ad7e291f-e250-4266-80ae-f2cc1cd42742.png#averageHue=%23f8f5f4&id=Iatlo&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825347176-db186b28-2631-4b49-bb2b-c7f3a2a1887a.png#averageHue=%23f9f8f7&id=cv21m&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
删除_GiveTestPaper_mysql接口_,_GiveTestPaper接口_所增加两个抽象方法
1.public TestPaper getTestPaper(int amount)
2.public int getShiTi();_//返回试题来源_
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825347741-c1ebe50c-01fb-4e8f-bf08-d4ce97d5ff92.png#averageHue=%23f7f6f5&id=rOBmJ&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
（3）导出jar包版本不匹配问题
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825348185-f4479299-8f43-4e80-847c-53b4e3fbec7f.png#averageHue=%23232323&id=fx4Mb&originHeight=511&originWidth=981&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
Microsoft Windows [版本 10.0.19042.1348]
(c) Microsoft Corporation。保留所有权利。
E:\java_study\软件发布_04_mysql>
E:\java_study\软件发布_04_mysql>java -jar kechensheji.jar
java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver
        at java.net.URLClassLoader.findClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
        at java.lang.ClassLoader.loadClass(Unknown Source)
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Unknown Source)
        at mysql.SetExcel_mysql.connectDB(SetExcel_mysql.java:15)
        at mysql.SetExcel_mysql.<init>(SetExcel_mysql.java:25)
        at mysql.OrderTestPaper_mysql.getTestPaper(OrderTestPaper_mysql.java:20)
        at gui.AppWindow_test.main(AppWindow_test.java:22)
E:\java_study\软件发布_04_mysql>java -jar kechensheji.jar
**之前导入的jar包为 mysql-connector-java-5.1.37-bin 不适配 MySQL Server 8.0**
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825348711-119b811f-ef80-407e-a637-a0b76ee7d28b.png#averageHue=%23fcfcfb&id=khBiu&originHeight=680&originWidth=1130&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
**IDEA打包jar包含第三方jar包（自测正确步骤）**
[https://blog.csdn.net/xiaokui9/article/details/105244775](https://blog.csdn.net/xiaokui9/article/details/105244775)
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825349270-1879d1b5-bd49-4a8c-8e12-61f0761ed684.png#averageHue=%23f6f5f4&id=CSJIh&originHeight=714&originWidth=1268&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

2.课设的心得、体会
2.1 加深了面向对象程序设计的思想的体会。
2.2 遇到问题时的解决办法，以及虚心大胆请教同学和老师，以及百度查找。
2.3 编码能力的不足，要吸取教训多练习。
2.4 对类中的值传递有一定的自己的理解。
2.5 在编码中加深了对Java面向对象的封装，继承，多态的理解。
2.6 在设计的时候多方面考虑对后续编写的重要性。
2.7 学习了一些画图（UML类图，流程图）。画完之后发现IDEA可以自动生成
IDEA生成时序图的插件为
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825349722-d6fb20d1-7bd8-4277-9a2a-1d08b468b681.png#averageHue=%23efeeed&id=tlchE&originHeight=85&originWidth=368&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
IDEA生成UML类图地方为
![](https://cdn.nlark.com/yuque/0/2022/png/22782459/1641825349925-9cffea15-9aea-41e1-bdaa-a4d05bec41f7.png#averageHue=%23eeeded&id=Pjsj2&originHeight=35&originWidth=452&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
2.8 敢于，乐于帮助同学，同时也能提升自己。
