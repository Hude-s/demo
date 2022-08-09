package demo2.tcp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTow extends JFrame implements Runnable, ActionListener {

    Socket socket;
    ServerSocket serverSocket;
    DataInputStream in;
    DataOutputStream out;

    //组件
    JButton btn;
    JTextField jtf;
    JTextArea jta;
    JScrollPane jsp;

    public ServerTow() throws IOException {
        //创建组件
        btn = new JButton("发送");
        jtf = new JTextField(15);
        btn.addActionListener(this);
        this.setLayout(new BorderLayout());

        jta = new JTextArea();
        JPanel jp = new JPanel();
        jp.add(btn);
        jp.add(jtf);
        //创建滚动面板
        jsp = new JScrollPane();
        jsp.setViewportView(jta);

        this.setTitle("Server");
        this.add(BorderLayout.SOUTH, jp);
        this.add(jsp);
        this.setSize(300, 200);
        this.setVisible(true);

        //设置组件

        //设置窗体
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        serverSocket = new ServerSocket(9999);
        System.out.println("服务器启动...");
        socket = serverSocket.accept();
        System.out.println("有客户端连接...");

        //创建数据流
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

    }


    @Override
    public void run() {
        try {
            while (true) {
                jta.append("client:" + in.readUTF());
                jta.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            out.writeUTF(jtf.getText());
            out.flush();
            jta.append("me:" + jta.getText());
            jta.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Thread t = new Thread(new ServerTow());
        t.start();
    }
}
