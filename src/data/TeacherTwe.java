package data;

import javax.swing.*;

/*
1.编写几个实现Teacher接口的类，使得AppWindow可以使用这些类的实例评判试卷
写一个TeacherTwe，并指出错误题目给出答案
 */
public  class TeacherTwe implements Teacher {
    @Override
    public void giveTestPaparScore(TestPaper testPaper) {
        int correctAmount=0;//答对题数
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

        Problem p[] = testPaper.getAllProblem();//获取所有题目
        if(p==null||p.length==0){
            JOptionPane.showMessageDialog
                    (null,"没有题目可答","消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String t="";
        for(int i=0;i<p.length;i++){
            /*
            getUserAnswer:获得用户答案
            getCorrectAnswer:获得正确答案
             */
            boolean b = compare(p[i].getUserAnswer(),p[i].getCorrectAnswer());
            if(b) {
                correctAmount++;
            }else {
                t=t+"   第"+(i+1)+"题答错，正确答案是"+p[i].getCorrectAnswer();
            }
        }

        String s ="共有:"+p.length+"道题."+ "您做对了"+correctAmount+"题";
        /*
        showInputDialog(Component parentComponent, Object message, String title, int messageType):
        显示请求用户输入内容的对话框，它以 parentComponent 为父级，该对话框的标题为 title，消息类型为 messageType。
         */
        JOptionPane.showMessageDialog(null,s+t,"成绩",JOptionPane.PLAIN_MESSAGE );
    }

    private boolean compare(String UserAnswer,String CorrectAnswer) {
        boolean isTrue = true;
        if(!(CorrectAnswer.contains(UserAnswer))){
            isTrue = false;
        }
        return isTrue;
    }
}
