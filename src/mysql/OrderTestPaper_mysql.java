package mysql;

import data.GiveTestPaper;
import data.Problem;
import data.SetExcel;
import data.TestPaper;

public class OrderTestPaper_mysql implements GiveTestPaper {
    static int TESTPAPER=2;
    TestPaper testPaper=new TestPaper();
    Problem[] userOne;

    @Override
    public TestPaper getTestPaper(String excelFileName,int amount){
        try {
            SetExcel setExcel_mysql = new SetExcel(excelFileName,amount);
            userOne = setExcel_mysql.getUserProblemOne();
//            testPaper.setMysqlSource(excelFileName);
            for(int i=0;i<amount;i++){
                //userOne[i] = new Problem();
                /*userOne[i].setContent(userOne[i].getContent());//试题的内容
                userOne[i].setCorrectAnswer(userOne[i].getCorrectAnswer());//试题的答案
                userOne[i].setGiveChoiceA(userOne[i].getGiveChoiceA());//试题的 A选择
                userOne[i].setGiveChoiceB(userOne[i].getGiveChoiceB());//试题的 B选择
                userOne[i].setGiveChoiceC(userOne[i].getGiveChoiceC());//试题的 C选择
                userOne[i].setGiveChoiceD(userOne[i].getGiveChoiceD());//试题的 D答案*/

                String typeStr = userOne[i].getIsNotKown();//试题的类型（判断或选择）

                //注意，因为试题有图像，所以typeStr有四种：p,p#,x,x#:
                //equalsIgnoreCase(String anotherString)将此 String与另一个String比较，不考虑大小写。
                if(typeStr.equalsIgnoreCase("p")){
                    userOne[i].setIsJudge(true);
                    userOne[i].setIsChoice(false);
                    userOne[i].setImageName("havenot.jpg");
                }

                if(typeStr.equalsIgnoreCase("x")) {
                    userOne[i].setIsJudge(false);
                    userOne[i].setIsChoice(true);
                    userOne[i].setImageName("havenot.jpg");
                }

                //startsWith(String prefix)测试此字符串是否以指定的前缀开始。
                if(typeStr.startsWith("p#")||typeStr.startsWith("P#")) {
                    userOne[i].setIsJudge(true);
                    userOne[i].setIsChoice(false);
                /*
                indexOf(String str):返回指定子字符串在此字符串中第一次出现处的索引。
                substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。
                 */
                    String imageName = typeStr.substring(typeStr.indexOf("#")+1);
                    userOne[i].setImageName(imageName);
                }
                if(typeStr.startsWith("x#")||typeStr.startsWith("X#")) {
                    userOne[i].setIsJudge(false);
                    userOne[i].setIsChoice(true);
                    String imageName = typeStr.substring(typeStr.indexOf("#")+1);
                    userOne[i].setImageName(imageName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        testPaper.setProblem(userOne);

        testPaper.setMysqlSource(excelFileName);

        return testPaper;
    }

    public int getShiTi() {
        return TESTPAPER;
    }
}
