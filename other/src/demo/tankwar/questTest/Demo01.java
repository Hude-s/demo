package demo.tankwar.questTest;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
//启动类
public class Demo01 {
    public static void main(String[] args) {
        new Test();
    }
}

class Test extends Frame {
    //用来存放鼠标的坐标位置
    ArrayList points;
    public Test(){
        //设置窗口属性
        super("画笔");
        setBounds(500,200,600,600);
        setVisible(true);
        points = new ArrayList<>();
        //给窗口设置监听
        addMouseListener(new MyMouseListener());
    }

    @Override
    public void paint(Graphics g) {
        //迭代points集合
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            //对每个坐标进行绘制
            g.setColor(Color.YELLOW);
            g.fillRect(point.x,point.y,10,10);
        }
    }
    //将监听得到的鼠标坐标添加进points集合
    public void addPaint(Point point){
        points.add(point);
    }



    private class MyMouseListener extends MouseAdapter{
        @Override
        //对鼠标点击事件进行重写
        public void mousePressed(MouseEvent e) {
            //获得鼠标的坐标资源并添加进集合
            Test frame = (Test) e.getSource();
            frame.addPaint(new Point(e.getX(),e.getY()));
            //对frame进行repain（）操作
            frame.repaint();
        }
    }



}


