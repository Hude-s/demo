package demo.tankwar.tankwarGUI;

import javax.swing.*;
import java.awt.*;

public class TankWarGUI extends JFrame {

    public TankWarGUI() {
        JFrame mainMenu = new JFrame();
        mainMenu.setTitle("TankWar");
        mainMenu.setSize(700, 900);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainMenu.setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("beauty1.png");  // 图片的具体位置
        mainMenu.setIconImage(icon);   //设置窗口的logo
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 900);
        g.setColor(Color.GREEN);
        g.setFont(new Font("楷体", Font.HANGING_BASELINE, 20));
        g.drawString("TankWar", 80, 150);
    }

    public static void main(String[] args) {
        new TankWarGUI().setVisible(true);

    }
}
