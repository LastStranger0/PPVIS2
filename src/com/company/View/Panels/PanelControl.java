package com.company.View.Panels;

import javax.swing.*;
import java.awt.*;

public class PanelControl extends JPanel {
    final int WIDTH = 50;
    final int HEIGHT = 25;
    public JButton add;
    public JButton del;
    public JButton find;

    public PanelControl(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add = new JButton("Добавить");
        add.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(add);
        add(Box.createHorizontalGlue());
        del = new JButton("Удалить");
        del.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(del);
        add(Box.createHorizontalGlue());
        find = new JButton("Найти");
        find.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        add(find);
    }
}
