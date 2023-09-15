package ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // LoginJFrame 作为登录主界面

    // 构造方法：设置登录界面的属性等
    public LoginJFrame() {
            this.setSize(488,430);// 界面宽高
        this.setTitle("拼图游戏单机版 v5.2 -- 登录");// 界面标题
        this.setAlwaysOnTop(true);// 界面置顶
        this.setLocationRelativeTo(null);// 界面居中
        // 界面设置关闭模式点击叉就能关闭主程序 WindowConstants.EXIT_ON_CLOSE = 3
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.setVisible(true);// 界面是否显示
    }
}
