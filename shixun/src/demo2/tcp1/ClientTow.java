package demo2.tcp1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTow extends JFrame implements Runnable, ActionListener {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    //组件
    JButton btn;
    JTextField jtf;
    JTextArea jta;
    JScrollPane jsp;

    public ClientTow() throws IOException {
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
        this.setTitle("Client");
        this.add(BorderLayout.SOUTH, jp);
        this.add(jsp);
        this.setSize(300, 200);
        this.setVisible(true);


        socket = new Socket("localhost", 9999);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }


    @Override
    public void run() {
        try {
            while (true) {
                jta.append("server:" + in.readUTF());
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
        Thread t = new Thread(new ClientTow());
        t.start();
    }
}
