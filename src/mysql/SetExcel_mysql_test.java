package mysql;

import data.Problem;
import java.sql.*;
/*
数据库读取试题
 */
public class SetExcel_mysql_test {
    Problem[] userProblemOne;
    private static final String URI
            = "jdbc:mysql://localhost:3306/shop?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection connectDB() throws Exception {
        //1、加载数据库驱动
        Class.forName(DRIVER);
        //2、获取数据库连接
//        Connection conn = DriverManager.getConnection(URI);
        Connection conn=DriverManager.getConnection(URI,"root","root");
        return conn;
    }

    public SetExcel_mysql_test(String excelFileName, int amaot) throws Exception {

        //Connection:与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。
        Connection conn = SetExcel_mysql_test.connectDB();

        String sql = "SELECT * FROM "+excelFileName;

        //Statement:对象表示基本语句，其中将单个方法应用于某一目标和一组参数，以返回结果，比如 "a.setFoo(b)"。
        //Statement stmt = conn.createStatement();
        //ResultSet:表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
        //ResultSet rs = stmt.executeQuery(sql);
        PreparedStatement pst = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=pst.executeQuery();

        rs.last();
        //int lastOne=rs.getRow();
        //first()将光标移动到此 ResultSet对象的第一行。
        rs.first();
        userProblemOne=new Problem[amaot];
        for (int i = 0; i < amaot; i++){
            userProblemOne[i]=new Problem();
            userProblemOne[i].setContent("数据库"+"第"+(i+1)+"题:"+rs.getString("question"));
            //System.out.println(rs.getString("question"));
            userProblemOne[i].setCorrectAnswer(rs.getString("answer"));
            userProblemOne[i].setGiveChoiceA(rs.getString("a"));
            userProblemOne[i].setGiveChoiceB(rs.getString("b"));
            userProblemOne[i].setGiveChoiceC(rs.getString("c"));
            userProblemOne[i].setGiveChoiceD(rs.getString("d"));
            userProblemOne[i].setIsNotKown(rs.getString("type"));
            rs.next();
        }
    }
    public Problem[] getUserProblemOne() {
        return userProblemOne;
    }
    public void setUserProblemOne(Problem[] userProblemOne) {
        this.userProblemOne = userProblemOne;
    }
}