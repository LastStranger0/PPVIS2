package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameFind extends JFrame{
    private ControlOfData COD;
    private JButton find;
    private PanelTable table;
    private PanelChoose choose = new PanelChoose();

    FrameFind(ControlOfData COD) {
        super("Find");
        this.COD = COD;
        setSize(500,300);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        find = new JButton("Find");
        find.addActionListener(e->{
            List<String> list = choose.getStudent();
            ControlOfData temp = new ControlOfData();
            temp.setStudent(this.COD.StudentsFind(list.get(0), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)), list.get(3), list.get(4)));
            table.setStudent(temp);
            table.showTable(temp);
        });
        table = new PanelTable(COD);
        JPanel p = new JPanel();
        p.add(find);
        add(choose);
        add(p);
        add(table);
    }

    public ControlOfData getCOD(){
        return COD;
    }

    public  JButton getFind(){
        return find;
    }

    public PanelTable getPanelTable(){
        return table;
    }

    public PanelChoose getChoose() {
        return choose;
    }
}
