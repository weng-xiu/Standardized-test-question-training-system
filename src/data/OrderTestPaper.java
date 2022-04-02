package data;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
/*
按顺序从题库中获得若干试题
 */
public class OrderTestPaper implements GiveTestPaper{
    static int TESTPAPER=1;
    TestPaper testPaper=new TestPaper();//试卷
    File fileExcel;
    Problem [] problem;//组成试卷的一套题（problem的单元存放一道试题即一个Problem对象）
    //InputStream:此抽象类是表示字节输入流的所有类的超类。
    InputStream in = null;
    Workbook wb = null;//封装 Excel,Workbook是jxl包中的类(工作簿)
    Sheet sheet = null;//封装 Excel中的sheet，Sheet是jxl包中的类(工作表)

    //实现所有可选的列表(链表)操作，并且允许所有元素（包括 null）。
    LinkedList<Integer> list= new LinkedList<Integer>();//随机抽取试题时用

    @Override
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

    private void randomGiveProblem(int amount) {//随机给出amount道试题,放入problem数组中
        list.clear();//每次考完后再次考获取试卷时clear()从此列表中移除所有元素。
        if(wb==null) {//wb在判断setExcel时已经获取
            JOptionPane.showMessageDialog
                    (null,"没有预备题库Excel","消息对话框",JOptionPane.WARNING_MESSAGE);
            return ;
        }

        //getSheet(int index)获取此工作簿中的指定工作表 如随附的技术说明中所述，每次调用 getSheet 都会强制重新读取工作表（出于内存原因）。
        sheet = wb.getSheet(0);//得到 Excel中的第一个sheet（索引从0开始）

        int rowsAmount = sheet.getRows();//getRows返回此工作表中的行数

        //注意原始 Excel表中 sheet中第 0行不是试题，是用户输入的说明
        //min(int a, int b)返回两个 int 值中较小的一个。
        int realAmount = Math.min(amount,rowsAmount-1);//实际抽取的试题数量

        problem = new Problem[realAmount];//用于存放试题的数组problem

        for(int i=0;i<rowsAmount-1;i++){//将1至rowsAmount-1数字放入链表
            list.add(i+1);
        }


        for(int i=0;i<problem.length;i++) {

            //Cell:代表工作表中的单个单元格。可以查询其类型和内容
            Cell[] cell = sheet.getRow(i+1);//返回 sheet中的第i行
            /*
            注意原始 Excel表中sheet中第 0行不是试题，是用户输入的说明(表头)
            cell的第 0列是试题内容，索引从 0开始
             */
            problem[i] = new Problem();
            int number = i+1;
            /*
            getContents():该函数以字符串形式返回单元格的内容。
            trim()返回字符串的副本，忽略前导空白和尾部空白。
             */
            problem[i].setContent("第"+number+"题."+cell[0].getContents());//试题的内容
            problem[i].setCorrectAnswer(cell[1].getContents().trim());//试题的答案
            problem[i].setGiveChoiceA(cell[2].getContents().trim());//试题的 A选择
            problem[i].setGiveChoiceB(cell[3].getContents().trim());//试题的 B选择
            problem[i].setGiveChoiceC(cell[4].getContents().trim());//试题的 C选择
            problem[i].setGiveChoiceD(cell[5].getContents().trim());//试题的 D答案

            String typeStr = cell[6].getContents().trim();//试题的类型（判断或选择）

            //注意，因为试题有图像，所以typeStr有四种：p,p#,x,x#:
            //equalsIgnoreCase(String anotherString)将此 String 与另一个 String 比较，不考虑大小写。
            if(typeStr.equalsIgnoreCase("p")){
                problem[i].setIsJudge(true);
                problem[i].setIsChoice(false);
                problem[i].setImageName("havenot.jpg");
            }
            if(typeStr.equalsIgnoreCase("x")) {
                problem[i].setIsJudge(false);
                problem[i].setIsChoice(true);
                problem[i].setImageName("havenot.jpg");
            }

            //startsWith(String prefix)测试此字符串是否以指定的前缀开始。
            if(typeStr.startsWith("p#")||typeStr.startsWith("P#")) {
                problem[i].setIsJudge(true);
                problem[i].setIsChoice(false);
                /*
                indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引。
                substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。
                 */
                String imageName = typeStr.substring(typeStr.indexOf("#")+1);
                problem[i].setImageName(imageName);
            }
            if(typeStr.startsWith("x#")||typeStr.startsWith("X#")) {
                problem[i].setIsJudge(false);
                problem[i].setIsChoice(true);
                String imageName = typeStr.substring(typeStr.indexOf("#")+1);
                problem[i].setImageName(imageName);
            }
        }
    }

    public int getShiTi() {
        return TESTPAPER;
    }
}
