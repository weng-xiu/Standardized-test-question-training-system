package data;

//封装试卷,从题库中获得若干个试题，组成一张试卷
public class TestPaper {//试卷
    private Problem [] problem=null;//数组每个单元存放一道试题（一个Problem对象）
    /*
    excel表格行标从0开始，故第一行表头index=-1
    因为problem[index]下标从0开始，而下面index++
     */
    int index = -1;
    String  problemSource;//试卷的题库；
    String mysqlSource;
    public void setProblem(Problem [] problem){
        this.problem = problem;
    }//传入试题

    public  Problem  getProblem(int i) {
        if(problem == null){
            return null;
        }
        if(problem.length==0){
            return null;
        }
        if(i>=problem.length||i<0) {
            return null;
        }
        return problem[i];
    }

    public  Problem  nextProblem() {//读到下一道题目
        index++;//行标向下移一位
        if(problem == null) {
            return null;
        }
        if(problem.length==0){
            return null;
        }
        if(index==problem.length){
            //因为第一行为表头,故最后一个题目，应是长度-1
            index = problem.length-1;//到最后一个题目，停止
        }
        return problem[index];
    }

    public  Problem  previousProblem(){//上一个问题
        index--;
        if(problem == null) {
            return null;
        }
        if(problem.length==0){
            return null;
        }
        if(index<0) {
            index =0;//到第一个题目，停止
        }
        return problem[index];
    }

    public  Problem [] getAllProblem(){//返回所有问题
        if(problem == null) {
            return null;
        }
        if(problem.length==0){
            return null;
        }
        return problem;
    }

    public int getProlemAmount(){//返回问题数量
        if(problem == null) {
            return 0;
        }
        return problem.length;
    }

    public void setProblemSource(String source){//传入试卷的题库来源
        problemSource = source;
    }

    public String getProblemSource(){//返回试卷的题库
        return problemSource;
    }

    public void acceptTeacher(Teacher teacher) {//让老师来批卷（访问者模式）
        //this:传入当前试卷
        teacher.giveTestPaparScore(this);//teacher批卷
    }

    public String getMysqlSource() {
        return mysqlSource;
    }

    public void setMysqlSource(String mysqlSource) {
        this.mysqlSource = mysqlSource;
    }
}