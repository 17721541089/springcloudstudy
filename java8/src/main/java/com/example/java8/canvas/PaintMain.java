package com.example.java8.canvas;

import javax.swing.JFrame;

    public class PaintMain {
        JFrame jFrame;
        public static void main(String[] args) {
            // TODO 自动生成的方法存根
            PaintMain paintMain=new PaintMain();
            paintMain.initView();
        }

        public void initView() {
            jFrame = new JFrame();
            jFrame.setBounds(500, 500, 500, 500);
            jFrame.setLayout(null);

            MyCanvas myCanvas = new MyCanvas();//画布
            myCanvas.setBounds(0, 0, 500, 500);
            jFrame.add(myCanvas);
            jFrame.setVisible(true);
        }
}
