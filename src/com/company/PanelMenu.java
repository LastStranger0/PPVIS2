package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;

    private JMenuItem find;
    private JMenuItem addInf;
    private JMenuItem remove;
    private JMenuItem save;
    private JMenuItem loadFile;

    PanelMenu(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        menuBar = new JMenuBar();
        menuBar.setMaximumSize(new Dimension(100, 20));
        createFileMenu();
        createEditMenu();
        add(menuBar);
        add(Box.createHorizontalGlue());
    }

    private void createFileMenu(){
        fileMenu = new JMenu("Файл");
        save = new JMenuItem("Сохранить");
        loadFile = new JMenuItem("Открыть");
        fileMenu.add(save);
        fileMenu.add(loadFile);
        menuBar.add(fileMenu);
    }

    private void createEditMenu(){
        editMenu = new JMenu("Изменить");
        find = new JMenuItem("Найти");
        addInf = new JMenuItem("Добавить");
        remove = new JMenuItem("Удалить");
        editMenu.add(find);
        editMenu.add(addInf);
        editMenu.add(remove);
        menuBar.add(editMenu);
    }

    public JMenuItem getFind() {
        return find;
    }

    public JMenuItem getAddInfo() {
        return addInf;
    }

    public JMenuItem getRemoveInfo() {
        return remove;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getLoadFile() {
        return loadFile;
    }
}
