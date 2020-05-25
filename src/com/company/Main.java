package com.company;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {

    private ControlOfData control;

    private FrameAdd add;
    private FrameFind find;
    private FrameDel del;

    private PanelTable table;

    private class FindListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            find.setVisible(!find.isVisible());
        }
    }

    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            add.setVisible(!add.isVisible());
        }
    }

    private class DelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            del.setVisible(!del.isVisible());
        }
    }

    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Special xml file", "xml");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                control.Write(path);
            }
        }
    }

    private class LoadListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Special xml file", "xml");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(chooser);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                try {
                    control.Read(path);
                    table.showTable(control);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    Main(ControlOfData COD) {
        super("PPVIS2");
        this.control = COD;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(layout);

        add = new FrameAdd(this.control);
        del = new FrameDel(this.control);
        find = new FrameFind(this.control);

        FindListener findListener = new FindListener();
        AddListener addListener = new AddListener();
        DelListener delListener = new DelListener();

        PanelMenu menuPanel = new PanelMenu();
        menuPanel.getFind().addActionListener(findListener);
        menuPanel.getAddInfo().addActionListener(addListener);
        menuPanel.getRemoveInfo().addActionListener(delListener);
        menuPanel.getSave().addActionListener(new SaveListener());
        menuPanel.getLoadFile().addActionListener(new LoadListener());
        panel.add(menuPanel);

        table = new PanelTable(this.control);
        panel.add(table);

        PanelControl controlPanel = new PanelControl();
        controlPanel.del.addActionListener(delListener);
        controlPanel.find.addActionListener(findListener);
        controlPanel.add.addActionListener(addListener);
        panel.add(controlPanel);

        del.getDel().addActionListener(actionEvent -> {
            int amount = del.DelStudent();
            JOptionPane.showMessageDialog(this, "Deleted: " + amount);
            table.showTable(this.control);
        });

        add.add.addActionListener(actionEvent -> {
            add.addStudent();
            table.showTable(this.control);
        });

        add(panel);
        setSize(500, 300);

        setVisible(true);
    }



    public static void main(String[] args) {
        ControlOfData data = new ControlOfData();
        new Main(data);

    }
}
