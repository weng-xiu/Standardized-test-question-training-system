package data;
//GiveTestPaper接口：抽取试题，形成试卷
public interface GiveTestPaper{
    public TestPaper getTestPaper(String excelFileName,int amount);
    public int getShiTi();//返回试题来源
}
