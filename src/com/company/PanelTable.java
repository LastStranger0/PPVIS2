package com.company;

import javax.swing.*;
import java.util.*;

public class PanelTable extends JPanel{
    ControlOfData COD;
    JTable table;
    JPanel panel;
    JLabel count;
    JLabel page;

    int left, right, pagecounter;

    PanelTable(ControlOfData control){
        this.COD = control;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable(10, 6);
        createLabels();
        makeControlButton();
        add(table);
        add(panel);
    }

    public void createLabels() {
        JPanel labelPanel = new JPanel();
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
        add(labelPanel);
    }

    void makeControlButton(){
        left = 1;
        right = 10;
        pagecounter = 1;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        count = new JLabel("Студент" + left + " - " + right);
        page = new JLabel("Страница: " + pagecounter);
        JButton nextPage = new JButton("След");
        nextPage.addActionListener(e -> {
            if(COD.isExist(right+1)){
                left += 10;
                right += 10;
                pagecounter++;
                count.setText("Студенты " + left + " - " + right);
                page.setText("Страница: " + pagecounter);
                showTable(COD);
            }
        });
        JButton prevPage = new JButton("Пред");
        prevPage.addActionListener(e -> {
            if(pagecounter > 1){
                left -= 10;
                right -=10;
                pagecounter--;
                count.setText("Студенты " + left + " - " + right);
                page.setText("Страница: " + pagecounter);
                showTable(COD);
            }
        });

        panel.add(count);
        panel.add(Box.createHorizontalGlue());
        panel.add(page);
        panel.add(Box.createHorizontalGlue());
        panel.add(prevPage);
        panel.add(nextPage);
    }

    private void addStudent(int i, StudentData student){
        table.setValueAt(student.getName(),i,0);
        table.setValueAt(student.getStruct(), i, 1);
        table.setValueAt(student.getPosition(), i , 2);
        table.setValueAt(student.getTitle(), i, 3);
        table.setValueAt(student.getTypeSport(), i, 4);
        table.setValueAt(student.getCategory(), i ,5);
    }

    private void addEmpty(int i){
        table.setValueAt(" ",i,0);
        table.setValueAt(" ", i, 1);
        table.setValueAt(" ", i , 2);
        table.setValueAt(" ", i, 3);
        table.setValueAt(" ", i, 4);
        table.setValueAt(" ", i ,5);
    }

    public void setStudent(ControlOfData data){
        COD = data;
    }

    public void showTable(ControlOfData COD){
        int index = 0;
        for(int i = left-1; i < right; i++){
            if(COD.isExist(i)){
                addStudent(index, COD.Index(i));
            } else {
                addEmpty(index);
            }
            index++;
        }
    }
}
