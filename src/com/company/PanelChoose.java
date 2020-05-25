package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelChoose extends JPanel{
    private JPanel textPanel;
    private JTextField name;
    private JTextField minTitle;
    private JTextField maxTitle;
    private JComboBox<String> typeSport;
    private JComboBox<String> category;

    PanelChoose(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();
    }
    private void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));
        final int WIDTH = 100;
        final int HEIGHT = 20;

        String[] type = new String[]{"All","Футбол", "Волейбол", "Шашки", "Шахматы","Борьба"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for(String s : type){
            comboBoxModel.addElement(s);
        }
        typeSport = new JComboBox<>(comboBoxModel);

        String[] categor = new String[]{"All","1", "2", "3", "КМС","Мастер спорта"};
        DefaultComboBoxModel<String> comboBoxModel1 = new DefaultComboBoxModel<>();
        for(String s : categor){
            comboBoxModel1.addElement(s);
        }
        category = new JComboBox<>(comboBoxModel1);

        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        minTitle = new JTextField();
        minTitle.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        maxTitle = new JTextField();
        maxTitle.setMaximumSize(new Dimension(WIDTH, HEIGHT));


        typeSport.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        category.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(minTitle);
        textPanel.add(maxTitle);
        textPanel.add(typeSport);
        textPanel.add(category);
        add(textPanel);
    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
        JLabel name = new JLabel("имя");
        JLabel minTitle = new JLabel("min титул");
        JLabel maxTitle = new JLabel("max титул");
        JLabel typeSport = new JLabel("тип спорта");
        JLabel category = new JLabel("категория");

        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(minTitle);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(maxTitle);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(typeSport);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(category);

        add(labelPanel);
    }

    public String getfieldName() {
        return name.getText();
    }

    public String getMinTitle() {
        return minTitle.getText();
    }

    public String getMaxTitle() {
        return maxTitle.getText();
    }

    public String getTypeSport() {
        return (String)typeSport.getSelectedItem();
    }

    public String getCategory() {
        return (String)category.getSelectedItem();
    }

    public List<String> getStudent(){
        List<String> result = new ArrayList<>();
        result.add(getfieldName());
        int min = 0;
        int max = 0;
        if(!getMinTitle().equals("")){
            min = Integer.parseInt(getMinTitle());
        }
        if(!getMaxTitle().equals("")){
            max = Integer.parseInt(getMaxTitle());
        }
        result.add(String.valueOf(min));
        result.add(String.valueOf(max));
        result.add(getTypeSport());
        result.add(getCategory());
        return result;
    }

}
