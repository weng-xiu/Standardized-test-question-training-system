package data;
import jxl.Sheet;
import jxl.Workbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/*
链接读取题库
 */
public class SetExcel {
    /*
    读Excel用
     */
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

    /*
    读数据库
     */
    Problem[] userProblemOne;
    private static final String URI
            = "jdbc:mysql://localhost:3306/shop?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection connectDB() throws Exception {
        //1、加载数据库驱动
        Class.forName(DRIVER);
        //2、获取数据库连接
//        Connection conn = DriverManager.getConnection(URI);
        Connection conn= DriverManager.getConnection(URI,"root","root");
        return conn;
    }
    public SetExcel(String excelFileName,int amaot) throws Exception {

        //Connection:与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。
        Connection conn = SetExcel.connectDB();

        String sql = "SELECT*FROM "+excelFileName;

        //Statement:对象表示基本语句，其中将单个方法应用于某一目标和一组参数，以返回结果，比如 "a.setFoo(b)"。
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //ResultSet:表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
        ResultSet rs = stmt.executeQuery(sql);
//        PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//        ResultSet rs=pst.executeQuery();

/*        rs.last();
        //int lastOne=rs.getRow();
        //first()将光标移动到此 ResultSet对象的第一行。*/
        rs.first();
        userProblemOne=new Problem[amaot];
        for (int i = 0; i < amaot; i++){
            rs.next();
            userProblemOne[i]=new Problem();
            userProblemOne[i].setContent("数据库"+"第"+(i+1)+"题:"+rs.getString("question"));
            //System.out.println(rs.getString("question"));
            userProblemOne[i].setCorrectAnswer(rs.getString("answer"));
            userProblemOne[i].setGiveChoiceA(rs.getString("a"));
            userProblemOne[i].setGiveChoiceB(rs.getString("b"));
            userProblemOne[i].setGiveChoiceC(rs.getString("c"));
            userProblemOne[i].setGiveChoiceD(rs.getString("d"));
            userProblemOne[i].setIsNotKown(rs.getString("type"));
        }

    }
    public Problem[] getUserProblemOne() {
        return userProblemOne;
    }
    public void setUserProblemOne(Problem[] userProblemOne) {
        this.userProblemOne = userProblemOne;
    }
}
