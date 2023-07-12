package com.ying.util;

import java.awt.*;

/*
 * 游戏中的常量属性在这个类中
 * */
public class Constant {
    // 窗口常量

    // 标题常量
    public static final String GAME_TITLE = "坦克大战";// 窗口标题

    // 宽高常量
    public static final int FRAME_WIDTH = 900;// 窗口宽度
    public static final int FRAME_HEIGHT = 700;// 窗口高度

    //获取屏幕大小
    static Toolkit kit = Toolkit.getDefaultToolkit();
    //获取屏幕大小（int类型）
    static Dimension screenSize = kit.getScreenSize();
    //通过屏幕大小获取宽度和长度
    static int screenw = screenSize.width;
    static int screenh = screenSize.height;

    // 窗口左上角坐标常量
    public static final int FRAME_X = screenw - FRAME_WIDTH >> 1;
    public static final int FRAME_Y = screenh - FRAME_HEIGHT >> 1;
    // 菜单常量

    // 菜单选项
    public static final int START_MENU=0;// 菜单页
    public static final int START_HELP=1;// 帮助页
    public static final int START_ABOUT=2;// 关于页
    public static final int START_RUN=3;// 游戏内容
    public static final int START_OVER=4;// 退出游戏

    // 菜单内容
    public static final String[] MENUS={
            "开始游戏",
            "继续游戏",
            "游戏帮助",
            "开发人员",
            "退出游戏",
    };

    // 菜单选项的字体
    public static final Font GAME_FONT =new Font("楷体",Font.BOLD,30);// 字体对象：属性有字体名，字体格式，字体大小

}
