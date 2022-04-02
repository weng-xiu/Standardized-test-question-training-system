package view;

/*
实现ActionListener接口，负责处理用户单击按钮触发的
AtionEvent(动作事件 ，当按钮、菜单项被单击，在 TextField 中按 Enter 键时触发)事件
1.当用户点击下一题或上一题时让视图显示相应的试题，
2.当用户点击确认某题目答案按钮时，将用户的答案保存到相应的Problem对象中，
3.当用户点击交卷按钮时，让Teather对象阅卷
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import data.*;
import mysql.OrderTestPaper_mysql;

public class HandleTestPaper implements ActionListener, ChangeListener {
    TestPaperView view;//提供试卷的视图
    TestPaper testPaper;//需要处理的试卷
    Problem problem;//当前的题目

    int i=0;
    String name="";

    /*
    Toolkit:此类是所有 Abstract Window Toolkit 实际实现的抽象超类。
     */
    Toolkit tool;//处理图像

    public HandleTestPaper(){
        //getDefaultToolkit():获取默认工具包。
        tool = Toolkit.getDefaultToolkit();
    }

    public void setView(TestPaperView view) {
        this.view = view;
    }

    public TestPaperView getView() {
        return view;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        i++;
    }
    //AtionEvent(动作事件 ，当按钮、菜单项被单击，在 TextField 中按 Enter 键时触发)事件
    public void actionPerformed(ActionEvent e){
        /*
        getSource()最初发生Event的对象。
        如果一开始点击下一题，则开始计时
         */
        if(e.getSource()==view.nextProblem){//动作事件==nextProblem:下一题
            view.viewAnswer.setVisible(false);
            view.time.start();//开始计时
            if(testPaper!=null){
                problem = testPaper.nextProblem();//nextProblem:下一题
                handleProblem(problem);//处理问题
            }
            else {
                JOptionPane.showMessageDialog
                        (view,"没有试题","消息对话框",JOptionPane.WARNING_MESSAGE);
            }
        }

        if(e.getSource()==view.previousProblem){//动作事件==previousProblem:上一题
            view.time.start(); //开始计时
            if(testPaper!=null){
                problem = testPaper.previousProblem();//previousProblem:上一题
                handleProblem(problem);//处理问题
            }
            else {
                JOptionPane.showMessageDialog
                        (view,"没有试题","消息对话框",JOptionPane.WARNING_MESSAGE);
            }
        }

        if(e.getSource()==view.aProblemSubmit){//动作事件==aProblemSubmit:确认答案
            view.viewAnswer.setVisible(true);
            String answer ="";
            /*
            isSelected()返回按钮的状态。如果选定了切换按钮，则返回 true，否则返回 false。
             */
            if(view.choiceA.isSelected()){
                answer = answer+"A";
            }
            if(view.choiceB.isSelected()){
                answer = answer+"B";
            }
            if(view.choiceC.isSelected()){
                answer = answer+"C";
            }
            if(view.choiceD.isSelected()){
                answer = answer+"D";
            }
            if(problem==null){
                JOptionPane.showMessageDialog
                        (view,"没有试题","消息对话框",JOptionPane.WARNING_MESSAGE);
                return;
            }
            problem.setUserAnswer(answer);
        }

        if (e.getSource()==view.viewAnswer){

            view.viewAnswer.setVisible(false);
            String xAnswer = problem.getCorrectAnswer();
            JOptionPane.showMessageDialog
                    (null,"正确答案："+xAnswer,null,JOptionPane.WARNING_MESSAGE);
            view.choiceA.setVisible(false);
            view.choiceB.setVisible(false);
            view.choiceC.setVisible(false);
            view.choiceD.setVisible(false);
            view.aProblemSubmit.setVisible(false);
        }

        if(e.getSource()==view.submit){//动作事件==submit:交卷
            testPaper.acceptTeacher(view.teacher);//试卷让老师批阅
            view.renewJButton.setVisible(true);//renewJButton:重新开始；
            view.submit.setVisible(false);
            view.time.stop();
            //setText(String text)定义此组件将要显示的单行文本。
            view.showUsedTime.setText("交卷了");
        }

        if(e.getSource()==view.renewJButton){//动作事件==renewJButton:再来一套题目
            view.showUsedTime.setText("");
            view.usedTime = view.totalTime;
            view.showUsedTime.setText("考试剩余时间:"+view.totalTime);
            view.showContent.setText(null);
            Image img = tool.getImage("图像管理/renew.jpg");
            handleImage(img);//见下
            view.showImage.repaint();//repaint()重绘此组件。
            view.nextProblem.setVisible(true);//nextProblem:下一题按钮
            view.previousProblem.setVisible(true);//previousProblem:上一题按钮

            GiveTestPaper initTestPaper;
            System.out.println(name);
            if ((name.valueOf(i+1)).equals("1")){
                initTestPaper=new RamdomInitTestPaper();
                System.out.println(66);
                String problemSource= testPaper.getProblemSource();//得到原始题库
//                System.out.println(problemSource);
                //getProlemAmount():返回问题数量
                testPaper=initTestPaper.getTestPaper(problemSource,testPaper.getProlemAmount());
            }else if ((name.valueOf(i+1)).equals("2")){
                initTestPaper=new OrderTestPaper_mysql();
                String excelFileName=testPaper.getMysqlSource();
//                testPaper=initTestPaper.getTestPaper("transportation",5);
                testPaper=initTestPaper.getTestPaper(excelFileName,5);
            }
            view.renewJButton.setVisible(false);
            view.submit.setVisible(true);
        }
        view.choiceA.setSelected(false);
        view.choiceB.setSelected(false);
        view.choiceC.setSelected(false);
        view.choiceD.setSelected(false);
    }

    private void handleProblem(Problem problem) {//处理问题
        if(problem==null) {
            JOptionPane.showMessageDialog
                    (view,"没有试题","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            /*
            aProblemSubmit:确认某道题的回答或选择(在上面)
            showContent:显示试题内容
            setVisible(boolean aFlag)使该组件可见或不可见。
            setText(String t)将此 TextComponent 文本设置为指定文本。
             */
            view.aProblemSubmit.setVisible(true);
            view.showContent.setText(problem.getContent());//getContent:返回题目内容
            view.showContent.setVisible(true);
            if(problem.getIsChoice()){
                handelChoice();//见下
            }
            else if(problem.getIsJudge()) {
                handelJudge();//见下
            }

            String imageName = problem.getImageName();
            /*
            用户将必须把图像存放到"图像管理"文件夹
            Image:抽象类 Image 是表示图形图像的所有类的超类。
            Toolkit tool:处理图像
            getImage(String filename)返回一幅图像，该图像从指定文件中获取像素数据，图像格式可以是 GIF、JPEG 或 PNG。
             */
            Image img = tool.getImage("图像管理/" +imageName);
            handleImage(img);
        }
    }

    private void handelJudge() {//处理判断
        /*
        setText(String text)设置按钮的文本。
         */
        view.choiceA.setText(problem.getGiveChoiceA());
        view.choiceB.setText(problem.getGiveChoiceB());
        view.choiceA.setVisible(true);
        view.choiceB.setVisible(true);
        view.choiceC.setVisible(false);
        view.choiceD.setVisible(false);
    }

    private void handelChoice() {//处理选择
        view.choiceA.setText(problem.getGiveChoiceA());
        view.choiceB.setText(problem.getGiveChoiceB());
        view.choiceC.setText(problem.getGiveChoiceC());
        view.choiceD.setText(problem.getGiveChoiceD());
        view.choiceA.setVisible(true);
        view.choiceB.setVisible(true);
        view.choiceC.setVisible(true);
        view.choiceD.setVisible(true);
    }

    private void handleImage(Image image) {
        view.showImage.setImage(image);//showImage:显示试题的图像
        view.showImage.repaint();//repaint()重绘此组件。
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = this.name+s;
    }


}
