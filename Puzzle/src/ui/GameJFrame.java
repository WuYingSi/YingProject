package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    // 继承接口KeyListener--键盘监听事件    监听整个游戏界面
    // GameJFrame 作为游戏主界面

    // 成员变量
    // 二维数组：存放图片的位置
    int[][] data = new int[4][4];

    // 存放空白图片的xy值
    int x = 0;
    int y = 0;

    // 图片地址
    String path = "image/girl/girl1/";
    // 判断是否胜利
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    // 统计步数
    int step = 0;

    // 构造方法：设置游戏界面的属性等
    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据
        initData();

        // 初始化拼图
        initImage();

        this.setVisible(true);// 界面是否显示
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 获取随机值
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取到随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //给二维数组添加数据-- 拼图使用二维数组比较实用
        //遍历一维数组tempArr得到每一个元素，把每一个元素依次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
            // 定位空白拼图位置
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            // i / 4 每列：第一列 1/4=0、2/4=0；到第二列时：5/4=1、6/4=1
            // 1 % 4 每行：第一行 1%4=1、2%4=2；到第二行时：5%4=1 ....
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    // 初始化游戏内容
    private void initImage() {
        // 格式化图片内容
        this.getContentPane().removeAll();
        // 细节
        // 先加载图片位于顶层，后加载的图片位于底层

        // 是否胜利
        if (victory()) {
            // 胜利
            JLabel winJLabel = new JLabel(new ImageIcon("image/win.png"));
            // 设置大小位置
            winJLabel.setBounds(203, 283, 197, 73);
            // 把图片放到隐藏容器中
            this.getContentPane().add(winJLabel);
        }

        // 统计步数模块
        JLabel stepCount =new JLabel("步数："+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        // 拼图
        // 循环：用于加载每一张图片的位置以及大小
        // 每列的图片
        for (int i = 0; i < 4; i++) {
            // 每行的图片
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                // 创建一个管理容器的对象--JLabel存放ImageIcon
                JLabel jlabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                // 设置容器放置的位置
                jlabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 给拼图设置边框
                jlabel.setBorder(new BevelBorder(1));// BevelBorder:边框类型 斜型边框；0：突起；1：凹陷
                // 把jlabel的容器放置在获取到的隐藏容器中
                this.getContentPane().add(jlabel);
            }
        }

        // 背景图片
        // 创建一个容器-background用来存放图片的对象-ImageIcon
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        // 设置背景图片的大小位置
        background.setBounds(40, 40, 508, 560);
        // 把图片放到隐藏容器中
        this.getContentPane().add(background);

        // 刷新图片
        this.getContentPane().repaint();
    }

    // 初始化菜单
    private void initJMenuBar() {
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上面的选项的对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于");

        // 创建选项下面的条目对象
        // 选项1
        JMenuItem rePlaceItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
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
        this.setSize(603, 680);// 界面宽高
        this.setTitle("拼图游戏单机版 v5.2");// 界面标题
        this.setAlwaysOnTop(true);// 界面置顶
        this.setLocationRelativeTo(null);// 界面居中
        // 界面设置关闭模式点击叉就能关闭主程序 WindowConstants.EXIT_ON_CLOSE
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置-- 只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        // 给界面添加监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下
    @Override
    public void keyPressed(KeyEvent e) {
        // 查看完整图片
        int code = e.getKeyCode();// 获取按下的按键值
        if (code == 65) {
            // 重新加载图片
            this.getContentPane().removeAll();
            // 加载完整拼图
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);// 设置完整拼图位置大小
            this.getContentPane().add(all);// 把图片放到隐藏容器中
            // 背景图片
            // 创建一个容器-background用来存放图片的对象-ImageIcon
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            // 设置背景图片的大小位置
            background.setBounds(40, 40, 508, 560);
            // 把图片放到隐藏容器中
            this.getContentPane().add(background);
            // 刷新
            this.getContentPane().repaint();
        }
    }

    // 松开
    @Override
    public void keyReleased(KeyEvent e) {
        // 当游戏胜利时，不能再次移动拼图--即结束该方法
        if (victory()) {
            return;
        }
        // 即把空白拼图相邻的图片往它移动
        // 左 37；上 38；右 39；下 40
        int code = e.getKeyCode();// 获取按键信息
        switch (code) {
            case 37 -> {
                // 当拼图已经到边界的情况
                if (y == 3) {
                    return;
                }
                // 空白拼图右方 y+1 y 向左走
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                step++;
                // 重新加载拼图
                initImage();
            }
            case 38 -> {
                // 当拼图已经到边界的情况
                if (x == 3) {
                    return;
                }
                // 空白拼图下方 x+1 y 向上走
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                step++;
                // 重新加载拼图
                initImage();
            }
            case 39 -> {
                // 当拼图已经到边界的情况
                if (y == 0) {
                    return;
                }
                // 空白拼图左方 y-1 y 向右走
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                step++;
                // 重新加载拼图
                initImage();
            }
            case 40 -> {
                // 当拼图已经到边界的情况
                if (x == 0) {
                    return;
                }
                // 空白拼图上方 x-1 y 向下走
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                step++;
                // 重新加载拼图
                initImage();
            }
            // 按键A
            case 65 -> {
                initImage();
            }
            // 按键W
            case 87 -> {
                // 设置已经完成拼图的二维数组
                data = new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 0}
                };
                initImage();
            }
            default -> {
            }
        }
    }

    // 判断拼图是否完成--判断data和win是否相同
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            // data[i] 每一列一维数组
            for (int j = 0; j < data[i].length; j++) {
                // 当有一个拼图对不上直接返回
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;// 全部判断完输出胜利
    }
}
