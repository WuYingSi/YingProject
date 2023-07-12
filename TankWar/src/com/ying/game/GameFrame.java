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
public class GameFrame extends Frame {
    // 声明游戏现处的状态
    public static int gameState;

    // 菜单选项指向
    private int menuIndex;

    /*
     * 对窗口进行初始化
     * */
    public GameFrame() {
        initFrame();// 初始化窗口
        initEventListener();// 添加监听事件
        initGame();// 初始化游戏
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
        setLocation(FRAME_X,FRAME_Y);
        // 窗口大小不可变
        setResizable(false);
        repaint();
    }

    /*
    * Frame的方法，继承下来
    * 该方法负责了所有的绘制的内容、所有需要在屏幕中显示的内容
    * 都要在该方法内调用，但该方法不能主动调用，必须通过调用repaint(); 去回调该方法
    * @param g
    * */
    public void update(Graphics g){
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
            if (i==menuIndex){
                // 当绘制所选的菜单选项时改变其对象属性
                g.setColor(Color.YELLOW);// 设置画笔颜色黄色色
            }else {
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
            // 不同的游戏状态下，运行不同的方法
            // 按下按键事件
            @Override
            public void keyPressed(KeyEvent e) {
                switch (gameState){
                    case START_MENU -> KeyEventMenu();
                    case START_HELP -> KeyEventHelp();
                    case START_ABOUT -> KeyEventAbout();
                    case START_RUN -> KeyEventqRun();
                    case START_OVER -> KeyEventOver();
                }
            }
            // 释放按键事件
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

}
