package view;

//继承JPanel，提供试卷的视图，用户可以在该视图看到试卷内容并进行答题操作
import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import data.*;
public class TestPaperView extends JPanel implements ActionListener{
    /*
    JTextArea:是一个显示纯文本的多行区域。
    JCheckBox:复选框的实现，复选框是一个可以被选定和取消选定的项，它将其状态显示给用户。
     */
    TestPaper testPaper;//本视图需要显示的试卷
    public Teacher teacher;//批卷老师
    public JTextArea showContent;//显示试题内容
    public ImageJPanel showImage;//显示试题的图像
    public JCheckBox choiceA,choiceB,choiceC,choiceD;//显示选项内容

    public JButton viewAnswer;//查看答案

    JTabbedPane tabbedPane;

    //JButton:通过 Action 可配置按钮，并进行一定程度的控制。
    public JButton nextProblem,previousProblem;//选择上一题，下一题的按钮
    public JButton aProblemSubmit;//确认某道题的回答或选择
    public JButton renewJButton;//重新开始；
    public JButton submit;//交卷

    /*
    Timer:此类管理一个过期的计时器通知列表
    JLabel:用于短文本字符串或图像或二者的显示区。
     */
    HandleTestPaper handleTestPaper;//负责处理testPaper试卷中的数据
    public int totalTime = 0;//考试用时（单位分）
    public int usedTime = totalTime;

    public Timer time;//考试计时器

    public JLabel showUsedTime;//显示用时
    JLabel testName;//显示考试名称

    public TestPaperView(JTabbedPane tabbedPane){
        /*
        Timer:对应于每个Timer对象的是一个后台线程，用于按顺序执行所有计时器的任务。
        ActionListener:用于接收动作事件的侦听器接口。
         */
        time = new Timer(1000,this);//每隔1分钟计时一次（触发ActionEvent）本容器作为其监视器
        initView();//初始化视图,下面
        registerListener();//注册监听器,在下面
        this.tabbedPane=tabbedPane;
        tabbedPane.addChangeListener(handleTestPaper);
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void initView() {//初始化视图
        /*
        setLayout:设置用户界面上的屏幕组件的格式布局
        BorderLayout:这是一个布置容器的边框布局，它可以对容器组件进行安排，并调整其大小，使其符合下列五个区域：北、南、东、西、中。
         */
        setLayout(new BorderLayout());
        showImage = new ImageJPanel();//显示试题的图像
        /*
        setToolTipText(String text)注册要在工具提示中显示的文本。
        setForeground(Color fg)设置此组件的前景色
        setWrapStyleWord(boolean word)设置换行方式（如果文本区要换行）。
        setLineWrap(boolean wrap)设置文本区的换行策略。
        setFont(Font f)设置当前字体。
        BOLD:粗体样式常量。
         */
        showContent = new JTextArea(12,12);//显示试题内容
        showContent.setToolTipText("如果题中有图像，在图上单机鼠标可调整观看");
        showContent.setForeground(Color.blue);
        showContent.setWrapStyleWord(true);
        showContent.setLineWrap(true);//回行自动
        showContent.setFont(new Font("宋体",Font.BOLD,18));

        choiceA = new JCheckBox("A");
        choiceB = new JCheckBox("B");
        choiceC = new JCheckBox("C");
        choiceD = new JCheckBox("D");
        viewAnswer=new JButton("查看答案");
        //setVisible(boolean aFlag)使该组件可见或不可见。true 使该组件可见；false 使其不可见
        choiceA.setVisible(false);
        choiceB.setVisible(false);
        choiceC.setVisible(false);
        choiceD.setVisible(false);
        viewAnswer.setVisible(false);

        nextProblem = new JButton("下一题目");
        previousProblem = new JButton("上一题目");
        aProblemSubmit = new JButton("确认");
        aProblemSubmit.setVisible(false);
        renewJButton = new JButton("再来一次");
        renewJButton.setVisible(false);
        submit = new JButton("交卷");

        JPanel pNorth = new JPanel();//pNorth:北面
        //setBackground(Color bg)设置此组件的背景色。
        pNorth.setBackground(Color.cyan) ;
        showUsedTime = new JLabel();//显示用时
        testName = new JLabel();//显示考试名称
        testName.setFont(new Font("楷体",Font.BOLD,18));
        pNorth.add(testName);//add(Component comp)将指定组件追加到此容器的尾部。
        pNorth.add(new JLabel("单击下一题或上一题按钮开始考试"));
        pNorth.add(submit);//交卷按钮
        pNorth.add(renewJButton);//再来一次按钮
        pNorth.add(showUsedTime);//显示用时
        /*
        add(Component comp, int index)将指定组件添加到此容器的给定位置上。
        NORTH:北区域的布局约束（容器顶部）。
        BorderLayout 将容器分为 EAST 、SOUTH 、WEST 、NORTH 、CENTER五个区域
         */
        add(pNorth,BorderLayout.NORTH);

        JPanel pCenter = new JPanel();//pCenter：中央
        pCenter.setLayout(new GridLayout(1,2));//GridLayout:网格布局
        //JScrollPane提供轻量级组件的 scrollable 视图。JScrollPane 管理视口、可选的垂直和水平滚动条以及可选的行和列标题视口。
        pCenter.add(new JScrollPane(showContent));//showContent:JTextArea showContent 显示试题内容
        pCenter.add(showImage);
        add(pCenter,BorderLayout.CENTER);

        JPanel pSouth = new JPanel();//pSouth:南面
        pSouth.setLayout(new GridLayout(2,1));
        JPanel oneInPSouth = new JPanel();
        JPanel twoInPSouth = new JPanel();
        oneInPSouth.setBackground(Color.green);
        oneInPSouth.setBackground(Color.pink);
        oneInPSouth.add(choiceA);//显示选项内容
        oneInPSouth.add(choiceB);
        oneInPSouth.add(choiceC);
        oneInPSouth.add(choiceD);
        oneInPSouth.add(viewAnswer);//添加查看答案按钮到南面
        oneInPSouth.add(aProblemSubmit);//确认按钮
        twoInPSouth.add(nextProblem);//下一题的按钮
        twoInPSouth.add(previousProblem);//上一题的按钮
        pSouth.add(oneInPSouth);
        pSouth.add(twoInPSouth);
        add(pSouth,BorderLayout.SOUTH);
        //validate()验证此容器及其所有子组件。使用validate方法会使容器再次布置其子组件。
        validate();
    }

    public void registerListener(){//注册监听器
        handleTestPaper = new HandleTestPaper();
        /*
        addActionListener(ActionListener l)将一个 ActionListener 添加到按钮中
        ActionListener:用于接收操作事件的侦听器接口。
         */
        nextProblem.addActionListener(handleTestPaper);
        previousProblem.addActionListener(handleTestPaper);
        aProblemSubmit.addActionListener(handleTestPaper);
        submit.addActionListener(handleTestPaper);
        renewJButton.addActionListener(handleTestPaper);

        viewAnswer.addActionListener(handleTestPaper);

        handleTestPaper.setView(this);
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
        handleTestPaper.setTestPaper(testPaper);
    }

    /*
    已执行的动作后，时间减 1
     */
    public void actionPerformed(ActionEvent e){
        showUsedTime.setText("考试剩余时间:"+usedTime);
        if (usedTime==15){//剩余usedTime时间弹框提醒交卷
            JOptionPane.showMessageDialog
                    (null,"考试剩余时间:"+usedTime+"秒,请尽快交卷！","注意！！！",JOptionPane.WARNING_MESSAGE);
        }
        if(usedTime == 0){
            time.stop();//time:考试计时器
            showUsedTime.setText("请交卷");
            nextProblem.setVisible(false);
            previousProblem.setVisible(false);
        }
        usedTime--;
    }

    public void setTestName(String name){//传入显示考试名称
        testName.setText("【"+name+"】");
        handleTestPaper.setName(name.substring(0,1));
    }
    public void setTotalTime(int n) {//showUsedTime:显示用时
        totalTime = n;
        usedTime = n;
        showUsedTime.setText("考试剩余时间:"+usedTime);
    }
}

