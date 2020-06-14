package com.company.View.Frames;

import com.company.Control.ControlOfData;
import com.company.Model.StudentData;

import javax.swing.*;
import java.awt.*;

public class FrameAdd extends JFrame {
    JPanel textPanel;
    JPanel labelPanel;
    JTextField name;
    JComboBox<String> struct;
    JTextField position;
    JTextField title;
    JComboBox<String> typeSport;
    JComboBox<String> category;
    public JButton add;

    ControlOfData COD;
    public FrameAdd(ControlOfData control){
        super("Add");
        this.COD = control;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        createField();
        createLabels();

        add(labelPanel);
        add(textPanel);
        add(add);
        setSize(600, 100);
        setResizable(false);
    }

    private void createField(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));
        final int WIDTH = 100;
        final int HEIGHT = 50;

        String[] type = new String[]{"Футбол", "Волейбол", "Шашки", "Шахматы","Борьба"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for(String s : type){
            comboBoxModel.addElement(s);
        }
        typeSport = new JComboBox<>(comboBoxModel);
        typeSport.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        String[] categor = new String[]{"1", "2", "3", "КМС","Мастер спорта"};
        DefaultComboBoxModel<String> comboBoxModel1 = new DefaultComboBoxModel<>();
        for(String s : categor){
            comboBoxModel1.addElement(s);
        }
        category = new JComboBox<>(comboBoxModel1);
        category.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        String[] structure = new String[]{"Основной", "Запасной", "n/a"};
        DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>();
        for(String s: structure){
            comboBoxModel2.addElement(s);
        }
        struct = new JComboBox<>(comboBoxModel2);
        struct.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        position = new JTextField();
        position.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        title = new JTextField();
        title.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        typeSport.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        category.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(struct);
        textPanel.add(position);
        textPanel.add(title);
        textPanel.add(typeSport);
        textPanel.add(category);
    }

    public void createLabels(){
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
        JLabel name = new JLabel("имя");
        JLabel struct = new JLabel("состав");
        JLabel position = new JLabel("позиция");
        JLabel title = new JLabel("титул");
        JLabel typeSport = new JLabel("тип спорта");
        JLabel category = new JLabel("категория");

        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(struct);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(position);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(title);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(typeSport);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(category);
    }

    public void addStudent(){
        String Name = name.getText();
        String Struct = String.valueOf(struct.getSelectedItem());
        String Position = position.getText();
        int Title = (title.getText().equals("") ? 0 : Integer.parseInt(title.getText()));
        String TypeSport = String.valueOf(typeSport.getSelectedItem());
        String Category = String.valueOf(category.getSelectedItem());
        COD.Add(new StudentData(Name, Struct, Position, Title, TypeSport, Category));
    }
}
