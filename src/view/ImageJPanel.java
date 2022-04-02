package view;

/*
继承Jpanel，显示试题中的图像，用户可以在该视图中看到图像，
如果需要，用户可以单击图像，弹出一个可以仔细观察图像的对话框
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
JPanel 是一般轻量级容器。
MouseListener:用于接收组件上“感兴趣”的鼠标事件（按下、释放、单击、进入或离开）的侦听器接口。
 */
public class ImageJPanel extends JPanel implements MouseListener{//侦听器
    Image image;
    ImageJPanel(){
        /*
        setOpaque(boolean isOpaque)如果为 true，则该组件绘制其边界内的所有像素。
        setBorder(Border border)设置此组件的边框。
        setToolTipText(String text)注册要在工具提示中显示的文本。
        addMouseListener(MouseListener l)添加指定的鼠标侦听器，以接收发自此组件的鼠标事件。
         */
        setOpaque(false);
        setBorder(null);
        setToolTipText("单击图像单独调整观看");
        addMouseListener(this);
    }

    public void setImage(Image img){
        image = img;
    }

    /*
    Graphics类是所有图形上下文的抽象基类，允许应用程序在组件（已经在各种设备上实现）以及闭屏图像上进行绘制。
    printComponent(Graphics g):在打印操作期间调用此方法。
    drawImage(Image img, int x, int y, int width, int height, ImageObserver observer):
    绘制指定图像中已缩放到适合指定矩形内部的图像。
     */
    public void paintComponent(Graphics g){//画图组件，画出图形
        super.paintComponent(g);
        g.drawImage(image,0,0,getBounds().width,getBounds().height,this);
    }

    public void mousePressed(MouseEvent e){//鼠标按下 用对话框视图显示试题中的图像
        ShowImageDialog showImageDialog = new ShowImageDialog(image);
        showImageDialog.setVisible(true);
    }
    public void mouseReleased(MouseEvent e){}//mouseReleased:鼠标释放
    public void mouseEntered(MouseEvent e){}//mouseEntered鼠标输入
    public void mouseExited(MouseEvent e){}//mouseExited鼠标退出
    public void mouseClicked(MouseEvent e){}//mouseClicked鼠标点击
}
