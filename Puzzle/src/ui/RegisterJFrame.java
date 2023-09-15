package ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    // RegisterJFrame 作为注册主界面

    // 构造方法：设置注册界面的属性等
    public RegisterJFrame() {
        this.setSize(488,500);// 界面宽高
        this.setTitle("拼图游戏单机版 v5.2 -- 注册");// 界面标题
        this.setAlwaysOnTop(true);// 界面置顶
        this.setLocationRelativeTo(null);// 界面居中
        // 界面设置关闭模式点击叉就能关闭主程序 WindowConstants.EXIT_ON_CLOSE = 3
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.setVisible(true);// 界面是否显示
    }
}
