package com.ying.game;

import javax.swing.text.html.CSS;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// 静态导入常量类
import static com.ying.util.Constant.*;

/*
 * 游戏的主窗口类
 * 游戏的内容在这个类中实现
 * */
public class GameFrame extends Frame implements Runnable{
    // 声明游戏现处的状态
    public static int gameState;// 全局变量

    // 菜单选项指向
    private int menuIndex;// 全局变量

    /*
     * 对窗口进行初始化
     * */
    public GameFrame() {
        initFrame();// 初始化窗口
        initEventListener();// 添加监听事件
        initGame();// 初始化游戏
        new Thread(this).start();// 启动重绘线程
    }

    /*
     * 对游戏进行初始化
     * */
    private void initGame() {
        gameState = START_MENU;
    }

    /*
     * 对属性进行初始化
     * */
    private void initFrame() {
        // 设置窗口标题
        setTitle(GAME_TITLE);// 常量类中的标题常量属性
        // 设置窗口可见
        setVisible(true);
        // 设置窗口宽高属性
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // 窗口居中
        //setLocationRelativeTo(null);
        setLocation(FRAME_X, FRAME_Y);
        // 窗口大小不可变
        setResizable(false);
    }

    /*
     * Frame的方法，继承下来
     * 该方法负责了所有的绘制的内容、所有需要在屏幕中显示的内容
     * 都要在该方法内调用，但该方法不能主动调用，必须通过调用repaint(); 去回调该方法
     * @param g
     * */
    public void update(Graphics g) {
        // 设置游戏内所有对象字体
        g.setFont(GAME_FONT);
        // 使用switch使其能够进入相对应的绘制模块进行绘制状态
        switch (gameState) {
            case START_MENU -> drawMenu(g);
            case START_HELP -> drawHelp(g);
            case START_ABOUT -> drawAbout(g);
            case START_RUN -> drawRun(g);
            case START_OVER -> drawOver(g);
        }
    }

    /*
     * 绘制初始退出页面
     * @param g : 系统提供的画笔对象
     * */
    private void drawOver(Graphics g) {
    }

    /*
     * 绘制初始游戏页面
     * @param g : 系统提供的画笔对象
     * */
    private void drawRun(Graphics g) {
    }

    /*
     * 绘制初始关于页面
     * @param g : 系统提供的画笔对象
     * */
    private void drawAbout(Graphics g) {
    }

    /*
     * 绘制初始帮助页面
     * @param g : 系统提供的画笔对象
     * */
    private void drawHelp(Graphics g) {
    }

    /*
     * 绘制初始菜单页面
     * @param g : 系统提供的画笔对象
     * */
    private void drawMenu(Graphics g) {
        // 利用画笔对象绘制黑色背景
        g.setColor(Color.BLACK);// 设置画笔颜色黑色
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);// 画笔绘制范围

        // 绘制菜单选项

        final int STR_WIDTH = 124;// 字符串选项的宽度
        int x = FRAME_WIDTH - STR_WIDTH >> 1;// 选项左侧坐标
        int y = FRAME_HEIGHT / 3;// 选项上侧坐标 上下空白区域占三分之一
        final int DIS = 60;// 行间距

        // 循环绘制选项
        for (int i = 0; i < MENUS.length; i++) {
            if (i == menuIndex) {
                // 当绘制所选的菜单选项时改变其对象属性
                g.setColor(Color.YELLOW);// 设置画笔颜色黄色色
            } else {
                g.setColor(Color.white);// 设置画笔颜色白色
            }
            g.drawString(MENUS[i], x, y + DIS * i);
            // y为上侧的起始坐标，每绘制一个项目就需要添加相对应的行间距DIS
        }
    }


    /*
     * 窗口的事件监听
     * */
    private void initEventListener() {
        // 添加窗口监听事件
        addWindowListener(new WindowAdapter() {
            // 点击关闭按钮时，会执行下面的方法
            @Override
            public void windowClosing(WindowEvent e) {
                // 结束进程，即关闭窗口
                System.exit(0);
            }
        });
        // 添加按键监听事件
        addKeyListener(new KeyAdapter() {
            // 按下按键事件
            @Override
            public void keyPressed(KeyEvent e) {
                // getKeyCode: 获得按下键的键值
                int keyCode = e.getKeyCode();
                // 处于不同游戏状态时，按键所对应的方法是不相同的
                switch (gameState) {
                    case START_MENU -> KeyEventMenu(keyCode);
                    case START_HELP -> KeyEventHelp(keyCode);
                    case START_ABOUT -> KeyEventAbout(keyCode);
                    case START_RUN -> KeyEventqRun(keyCode);
                    case START_OVER -> KeyEventOver(keyCode);
                }
            }

            // 释放按键事件
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    // 退出状态下的按键方法
    private void KeyEventOver(int keyCode) {

    }
    // 关于页状态下的按键方法
    private void KeyEventAbout(int keyCode) {

    }
    // 游戏状态下的按键方法
    private void KeyEventqRun(int keyCode) {

    }
    // 帮助页状态下的按键方法
    private void KeyEventHelp(int keyCode) {

    }

    // 首页菜单状态下的按键方法
    private void KeyEventMenu(int keyCode) {
        // 判断按键的键值，使用VK进行整数型的转换在进行判断
        switch (keyCode) {
            // 按下方向键上和W的作用相同
            case KeyEvent.VK_UP, KeyEvent.VK_W -> {
                // --menuIndex: 先--再运算
                if (--menuIndex < 0) {
                    menuIndex = MENUS.length - 1;
                }
            }
            // 按下方向键下和S的作用相同
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {
                if (++menuIndex >= MENUS.length) {
                    menuIndex = 0;
                }
            }
            case KeyEvent.VK_ENTER ->{
                // 游戏内容
                newGame();
            }
        }
    }

    /*
    * 游戏内容
    * */
    private void newGame() {
        // 改变现处的游戏状态
        gameState=START_RUN;

    }

    // 用于重绘刷新
    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(REPAINT_INTERVAL);// 间隔
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
