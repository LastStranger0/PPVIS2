package com.company.View.Frames;

import com.company.Control.ControlOfData;
import com.company.View.Panels.PanelChoose;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameDel extends JFrame {
    private ControlOfData control;
    private PanelChoose panelChoose = new PanelChoose();
    private JButton del;

    private void start(){
        del = new JButton("Удалить");
        del.setMaximumSize(new Dimension(100,20));
        add(del);
        add(panelChoose);
    }

    public ControlOfData getControl(){
        return control;
    }

    public  PanelChoose getPanelChoose(){
        return panelChoose;
    }

    public JButton getDel(){
        return del;
    }

    public int DelStudent(){
        List<String> list = panelChoose.getStudent();
        return this.control.DeleteStudents(list.get(0),Integer.parseInt(list.get(1)),
                Integer.parseInt(list.get(2)), list.get(3), list.get(4));
    }

    public FrameDel(ControlOfData control){
        super("Delete");
        this.control = control;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        start();
        setSize(500,100);
        setResizable(false);
    }

}
