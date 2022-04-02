package view;

//继承JDialog，用对话框视图显示试题中的图像
import java.awt.*;
import javax.swing.*;
public class ShowImageDialog extends JDialog{
    Image img;
    ShowImageDialog(Image img) { //构造方法
        /*
        setSize(Dimension d)调整组件的大小，使其宽度为 d.width，高度为 d.height。
        setTitle(String title)设置 Dialog的标题。
        setModal(boolean modal)指定此 dialog 是否应该是有模式的。
         */
        setTitle("显示图像对话框");
        this.img = img;
        setSize(500,470);
        GiveImage image = new GiveImage();
        add(image);
        setModal(true);//模式对话框
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class GiveImage extends JPanel{//内部类，专门为该对话框提供图片
        /*
        Graphics类是所有图形上下文的抽象基类，允许应用程序在组件（已经在各种设备上实现）以及闭屏图像上进行绘制。
        printComponent(Graphics g):在打印操作期间调用此方法。(回调方法)
        drawImage(Image img, int x, int y, int width, int height, ImageObserver observer):
        绘制指定图像中已缩放到适合指定矩形内部的图像。
         */
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getBounds().width,getBounds().height,this);
        }
    }
}
