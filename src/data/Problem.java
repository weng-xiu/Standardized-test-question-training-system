package data;

import java.io.File;

//封装Sheet表的基本结构，即试题
public class Problem {

    boolean isChoice;//是否是选择题
    boolean isJudge;//是否是判断题
    String isNotKown;//数据库中的题型
    String  content;//题目内容
    String  giveChoiceA,giveChoiceB,giveChoiceC,giveChoiceD;//提供选择
    String  imageName;//题目所带的图像的名字
    String  correctAnswer="QWEQ@#$@!@#1QWEQ";//题目的正确答案
    //用户回答的初始答案和correctAnswer不同，防止出题人忘记给正确答案
    String  userAnswer =""  ; //用户答案初始值必须是不含任何字符的串

    public boolean getIsChoice() {//返回是否是选择题
        return isChoice;
    }
    public void setIsChoice(boolean b) {
        isChoice = b;
    }
    public boolean getIsJudge() {//返回是否是判断题
        return isJudge;
    }
    public void setIsJudge(boolean b) {
        isJudge = b;
    }
    public void setContent(String c) {
        content = c;
    }
    public String getContent() {//返回题目内容
        return content;
    }
    public void setCorrectAnswer(String a) {
        correctAnswer = a;
    }
    public String getCorrectAnswer() {//获得正确答案
        return correctAnswer;
    }
    public void setUserAnswer(String u) {
        userAnswer = u;
    }
    public String getUserAnswer() {
        return userAnswer;
    }
    public void setGiveChoiceA(String a) {
        giveChoiceA = a;
    }
    public String getGiveChoiceA() {
        return giveChoiceA;
    }
    public void setGiveChoiceB(String b) {
        giveChoiceB = b;
    }
    public String getGiveChoiceB() {
        return giveChoiceB;
    }
    public void setGiveChoiceC(String c) {
        giveChoiceC = c;
    }
    public String getGiveChoiceC() {
        return giveChoiceC;
    }
    public void setGiveChoiceD(String d) {
        giveChoiceD = d;
    }
    public String getGiveChoiceD() {
        return giveChoiceD;
    }
    public void setImageName(String c) {
        imageName = c;
    }
    public String getImageName() {
        return imageName;
    }
    /*
    数据库新加
     */
    public String getIsNotKown() {
        return isNotKown;
    }

    public void setIsNotKown(String isNotKown) {
        this.isNotKown = isNotKown;
    }
}