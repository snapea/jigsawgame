package com.snap.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    int[][] data;
    Random random = new Random();
    int[][] ints = randomData();

    int x = 0;
    int y = 0;

    public GameJFrame() {
        // 初始化界面
        initJFrame();

        // 初始化菜单
        initMenu();

        // 初始化图片
        initImage();


        // 显示游戏界面
        this.setVisible(true);
    }

    private void initImage() {
        this.getContentPane().removeAll();
        this.setLayout(null);



        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int num = ints[i][j];

                if (num == 0) {
                    System.out.println(i + "  " + j);
                    x = i;
                    y = j;
                }
                // 创建一个图片ImageIcon对象
                ImageIcon imageIcon = new ImageIcon("image/girl/girl1/" + num + ".jpg");
                // 创建一个JLabel对象
                JLabel jLabel = new JLabel(imageIcon);
                jLabel.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(0));
                // 管理器内容添加到界面中
                Container contentPane = this.getContentPane();
                contentPane.add(jLabel);
            }
        }
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();

    }

    private void initMenu() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        JMenuItem replayMenuItem = new JMenuItem("重新游戏");
        JMenuItem reLoginMenuItem = new JMenuItem("重新登录");
        JMenuItem closeMenuItem = new JMenuItem("关闭游戏");

        JMenuItem accountMenuItem = new JMenuItem("公众号");

        functionMenu.add(replayMenuItem);
        functionMenu.add(reLoginMenuItem);
        functionMenu.add(closeMenuItem);

        aboutMenu.add(accountMenuItem);

        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图单机版 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addKeyListener(this);
    }


    private int[][] randomData() {
        int[] newArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};


        for (int i = 0; i < newArr.length; i++) {
            int index = random.nextInt(newArr.length);

            int temp = newArr[i];
            newArr[i] = newArr[index];
            newArr[index] = temp;
        }

        data = new int[4][4];

        for (int i = 0; i < newArr.length; i++) {

            data[i / 4][i % 4] = newArr[i];

        }
        return data;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // W：87    S：83    A：65    D：68
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 87:
                System.out.println("W");
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
            case 83:
                System.out.println("S");
            case 65:
                System.out.println("A");
            case 68:
                System.out.println("D");
        }
        initImage();



    }
}
