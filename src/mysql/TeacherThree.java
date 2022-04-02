package mysql;

import data.Problem;
import data.Teacher;
import data.TestPaper;

import javax.swing.*;

public class TeacherThree implements Teacher {
    int amount;
    @Override
    //重写giveTestPaparScore抽象方法
    public void giveTestPaparScore(TestPaper testPaper){
        int correctAmount=0;//百分比计分
        if(testPaper==null){//空试卷弹出警告消息框
            /*
            JOptionPane:有助于方便地弹出要求用户提供值或向其发出通知的标准对话框
            showInputDialog(Component parentComponent, Object message, String title, int messageType):
            显示请求用户输入内容的对话框，它以 parentComponent 为父级，该对话框的标题为 title，消息类型为 messageType。
            WARNING_MESSAGE:用于警告消息。
             */
            JOptionPane.showMessageDialog
                    (null,"没有题目可答","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }

        Problem p[] = testPaper.getAllProblem();
        if(p==null||p.length==0){
            JOptionPane.showMessageDialog
                    (null,"没有题目可答","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }

        for(int i=1;i<p.length;i++){
            //getUserAnswer:获得用户答案 getCorrectAnswer:获得正确答案
            boolean b = compare(p[i].getUserAnswer(),p[i].getCorrectAnswer());
            if(b) {
                correctAmount++;
            }
        }

        double result = (double)correctAmount/(double)p.length;
        int r =(int)(result*100);
        String s ="共有:"+p.length+"道题."+ "您做对了"+correctAmount+"题,"+ "正确率大约"+r+"%";
        //JLabel(String text)创建具有指定文本的 JLabel实例。
        JLabel mess = new JLabel(s);
        /*
        showInputDialog(Component parentComponent, Object message, String title, int messageType):
        显示请求用户输入内容的对话框，它以 parentComponent 为父级，该对话框的标题为 title，消息类型为 messageType。
         */
        JOptionPane.showMessageDialog(null,mess,"成绩",JOptionPane.PLAIN_MESSAGE );
    }

    /*
    比较用户答案与正确答案是否相同
    UserAnswer:用户答案 CorrectAnswer:正确答案
     */
    private boolean compare(String UserAnswer,String CorrectAnswer) {
        boolean isTrue = true;
        for(int i=0;i<UserAnswer.length();i++) {
            //charAt(int index)返回指定索引处的char值。
            String temp = ""+UserAnswer.charAt(i);
            //contains(CharSequence s)当且仅当此字符串包含指定的 char值序列时，返回 true。
            if(!(CorrectAnswer.contains(temp)))
                isTrue = false;
        }
        for(int i=0;i<CorrectAnswer.length();i++) {
            String temp = ""+CorrectAnswer.charAt(i);
            if(!(UserAnswer.contains(temp)))
                isTrue = false;
        }
        return isTrue;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
