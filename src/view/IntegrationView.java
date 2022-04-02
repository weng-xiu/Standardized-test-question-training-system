package view;

//继承JFrame，使用JTabbedPane将各个视图集成到当前IntegrationView窗体中

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class IntegrationView extends JFrame{//集成视图
    JTabbedPane tabbedPane; //用选项卡集成TestPaperView视图

    public IntegrationView(JTabbedPane tabbedPane){
        this.tabbedPane=tabbedPane;
        tabbedPane= new JTabbedPane(JTabbedPane.LEFT);//卡在左侧
        tabbedPane.validate();//validate()验证此容器及其所有子组件。
        add(tabbedPane,BorderLayout.CENTER);
        setBounds(100,100,1200,560);
        //setDefaultCloseOperation(int operation)设置用户在此窗体上发起 "close" 时默认执行的操作。
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭时执行
        setVisible(true);
    }

    public void addTestPaperView(String cardName,TestPaperView view){
        tabbedPane.add(cardName,view);
        validate();//validate()验证此容器及其所有子组件。
    }
}
