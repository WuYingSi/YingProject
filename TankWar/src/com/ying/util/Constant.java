package com.ying.util;

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

    // 窗口左上角坐标常量
    //public static final int FRAME_X = 1920 - FRAME_WIDTH >> 1;
    //public static final int FRAME_Y = 1080 - FRAME_HEIGHT >> 1;

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

}
