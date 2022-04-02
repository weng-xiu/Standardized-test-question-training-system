package test;

import data.*;
import mysql.OrderTestPaper_mysql;
import mysql.TeacherThree;

//数据库
public class AppTest_mysql{
    public static void main(String[] args){
        //父类的引用指向子类，多态
        GiveTestPaper initTestPaper = new OrderTestPaper_mysql();//创建初始试卷对象
//      GiveTestPaper initTestPaper = new OrderTestPaper();//创建初始试卷对象

        int amount=5;//题数

        //交通试题
        /*TestPaper testPaper=
                initTestPaper.getTestPaper("transportation",amount);//得到有5个题目的试卷*/
        TestPaper testPaper=
                initTestPaper.getTestPaper("transportation",amount);//得到有5个题目的试卷

        //通过数据库获取题目
        Problem [] problem = testPaper.getAllProblem();//得到试卷中的全部试题

        for(int i = 0;i<amount;i++ ){
            System.out.print("第"+(i+1)+"题:");
            System.out.println(problem[i].getContent());//problem[i].getContent():题目内容
            if(problem[i].getIsJudge()){//是否是判断题
                inputOne(problem[i]);
            }
            else if(problem[i].getIsChoice()){//是否是选择题
                inputTwo(problem[i]);
            }
            System.out.println();
        }

        //模拟用户答题：
        problem[0].setUserAnswer("B");//模拟用户给的答案是B
        problem[1].setUserAnswer("B");
        problem[2].setUserAnswer("B");
        problem[3].setUserAnswer("B");
        problem[4].setUserAnswer("B");

//        testPaper.acceptTeacher(new TeacherOne()); //让老师TeacherTwe批卷
//        testPaper.acceptTeacher(new TeacherTwe()); //让老师TeacherTwe批卷
        TeacherThree teacherThree = new TeacherThree();
        teacherThree.setAmount(amount);
        testPaper.acceptTeacher(teacherThree);
    }

    static void inputOne(Problem  problem){
        //上面传入了ABCD，这里取出打印
        System.out.printf("%s\t%s\n",problem.getGiveChoiceA(),problem.getGiveChoiceB());
        System.out.println("图像的名字"+problem.getImageName());
        System.out.println("正确答案："+problem.getCorrectAnswer());
    }
    static void inputTwo(Problem problem){
        System.out.printf("%s\t%s\n",problem.getGiveChoiceA(),problem.getGiveChoiceB());
        System.out.printf("%s\t%s\n",problem.getGiveChoiceC(),problem.getGiveChoiceD());
        System.out.println("图像的名字"+problem.getImageName());
        System.out.println("正确答案："+problem.getCorrectAnswer());
    }
}

