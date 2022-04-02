package gui;
import data.*;
import mysql.OrderTestPaper_mysql;
import mysql.TeacherThree;
import view.TestPaperView;//继承JPanel，提供试卷的视图，用户可以在该视图看到试卷内容并进行答题操作
import view.IntegrationView;//继承JFrame，使用JTabbedPane将各个视图集成到当前IntegrationView窗体中

import javax.swing.*;

public class AppWindow {
    public static void main(String []args){
        String testName="";

        JTabbedPane tabbedPane=new JTabbedPane();
        //IntegrationView:继承JPanel，提供试卷的视图，用户可以在该视图看到试卷内容并进行答题操作
        IntegrationView integrationView = new IntegrationView(tabbedPane);

        //RamdomInitTestPaper:实现GiveTestPaper接口，负责给出试卷
        GiveTestPaper initTestPaper = new RamdomInitTestPaper(); //创建初始试卷对象
        TestPaper testPaper=
                initTestPaper.getTestPaper("题库/交通理论.xls",5);//得到有5个题目的试卷
        //TestPaperView:封装试卷,从题库中获得若干个试题，组成一张试卷
        TestPaperView testView = new TestPaperView(tabbedPane);
        testView.setTestPaper(testPaper);//设置试卷
        testView.setTeacher(new TeacherOne());//设置阅卷老师
        testName = "1交通法训练";
        testView.setTestName(testName);
        testView.setTotalTime(60);//考试时间60秒
        integrationView.addTestPaperView(testName,testView);


        initTestPaper = new RamdomInitTestPaper(); //创建初始试卷对象
        testPaper= initTestPaper.getTestPaper("题库/java基础.xls",6);
        testView = new TestPaperView(tabbedPane);
        testView.setTestPaper(testPaper);
        testView.setTeacher(new TeacherTwe());
        testName = "1Java训练";
        testView.setTestName(testName);
        testView.setTotalTime(10);
        integrationView.addTestPaperView(testName,testView);

        initTestPaper=new OrderTestPaper_mysql();
        testPaper= initTestPaper.getTestPaper("transportation",5);//得到有 5个题目的试卷
        //TestPaperView:封装试卷,从题库中获得若干个试题，组成一张试卷
        testView = new TestPaperView(tabbedPane);
        testView.setTestPaper(testPaper);//设置试卷
        testView.setTeacher(new TeacherThree());//设置阅卷老师
        testName = "2交通法训练（数据库）";
        testView.setTestName(testName);
        testView.setTotalTime(60);//考试时间60秒
        integrationView.addTestPaperView(testName,testView);

        initTestPaper=new OrderTestPaper_mysql();
        testPaper= initTestPaper.getTestPaper("Java",5);//得到有 5个题目的试卷
        //TestPaperView:封装试卷,从题库中获得若干个试题，组成一张试卷
        testView = new TestPaperView(tabbedPane);
        testView.setTestPaper(testPaper);//设置试卷
        testView.setTeacher(new TeacherThree());//设置阅卷老师
        testName = "2Java训练（数据库）";
        testView.setTestName(testName);
        testView.setTotalTime(60);//考试时间60秒
        integrationView.addTestPaperView(testName,testView);
    }
}