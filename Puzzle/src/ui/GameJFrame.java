package ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    // GameJFrame 作为游戏主界面

    // 构造方法：设置游戏界面的属性等
    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化拼图
        initImage();

        this.setVisible(true);// 界面是否显示
    }
    
    // 初始化拼图
    private void initImage() {
    }

    // 初始化菜单
    private void initJMenuBar() {
        // 创建整个的菜单对象
        JMenuBar jMenuBar =new JMenuBar();

        // 创建菜单上面的选项的对象
        JMenu functionMenu =new JMenu("功能");
        JMenu aboutMenu =new JMenu("关于");

        // 创建选项下面的条目对象
        // 选项1
        JMenuItem rePlaceItem =new JMenuItem("重新游戏");
        JMenuItem reLoginItem =new JMenuItem("重新登录");
        JMenuItem closeItem =new JMenuItem("关闭游戏");
        // 选项2
        JMenuItem accountItem = new JMenuItem("联系人");

        // 将条目对象添加到选项中
        functionMenu.add(rePlaceItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        // 将选项对象添加到菜单中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        // 将菜单设置在页面中
        this.setJMenuBar(jMenuBar);
    }

    // 初始化界面
    private void initJFrame() {
        this.setSize(603,680);// 界面宽高
        this.setTitle("拼图游戏单机版 v5.2");// 界面标题
        this.setAlwaysOnTop(true);// 界面置顶
        this.setLocationRelativeTo(null);// 界面居中
        // 界面设置关闭模式点击叉就能关闭主程序 WindowConstants.EXIT_ON_CLOSE
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
