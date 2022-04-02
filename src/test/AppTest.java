package test;

import data.*;
public class AppTest {
    public static void main(String []args){
        //父类的引用指向子类，多态
//        GiveTestPaper initTestPaper = new RamdomInitTestPaper();//创建初始试卷对象
        GiveTestPaper initTestPaper = new OrderTestPaper();//创建初始试卷对象

        //通过Excel获取题目
        TestPaper testPaper=
                initTestPaper.getTestPaper("题库/交通理论.xls",5);//得到有5个题目的试卷

        //通过数据库获取题目
        //TestPaper testPaperOne=

        Problem [] problem = testPaper.getAllProblem();//得到试卷中的全部试题

        for(int i = 0;i<problem.length;i++ ){
            int m = i+1;
            System.out.println("第"+m+"题.");

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
        problem[1].setUserAnswer("A");
        problem[2].setUserAnswer("C");
        problem[3].setUserAnswer("A");
        problem[0].setUserAnswer("B");
        problem[1].setUserAnswer("D");

//        testPaper.acceptTeacher(new TeacherOne()); //让老师TeacherTwe批卷
        testPaper.acceptTeacher(new TeacherTwe()); //让老师TeacherTwe批卷

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