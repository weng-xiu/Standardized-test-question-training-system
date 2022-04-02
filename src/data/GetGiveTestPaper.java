package data;


public class GetGiveTestPaper {
    static GiveTestPaper initTestPaper;

    public static GiveTestPaper getInitTestPaper() {
        return initTestPaper;
    }

    public static void setInitTestPaper(GiveTestPaper initTestPaper) {
        GetGiveTestPaper.initTestPaper = initTestPaper;
    }
}
