package com.lilaussie.itemstoragesystem;

import com.lilaussie.itemstoragesystem.references.Reference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anthony on 19/04/2015.
 */
public class StorageSystem extends JFrame {

    // Left Panel
    private JSplitPane  wrapPanel;
    private JPanel      leftPanel;
    private JTable      table;
    private JScrollPane scrollPane;

    // Right Panel
    private JPanel      rightPanel;
    private JTextArea   titleTextPane;
    private JTextArea   locationTextPane;
    private JButton     addButton;

    //Text Panel
    private JPanel      textPanel;

    // Variables
    private int colCount;
    private String columnNames[];
    private String dataValues[][];

    private int wWidth = Reference.INT_WINDOW_WIDTH, wHeight = Reference.INT_WINDOW_HEIGHT;

    public StorageSystem() {
        setTitle(Reference.STRING_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(wWidth, wHeight);
        setBackground(Color.GRAY);

        GridLayout grid = new GridLayout(4, 2, 10, 10);

        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        rightPanel = new JPanel();
        //rightPanel.setLayout(grid);
        rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightPanel.setPreferredSize(new Dimension((wWidth / 2) - 32, wHeight - 150));

        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        textPanel.setPreferredSize(new Dimension((wWidth / 2) - 128, wHeight - 150));

        CreateColumns();
        //CreateData();

        table = new JTable(dataValues, Reference.STRING_COLUMN_NAMES);
        table.setShowHorizontalLines(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.setSelectionForeground(Color.WHITE);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((wWidth / 2) - 32, wHeight - 150));
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        titleTextPane = new JTextArea("title");
        titleTextPane.setPreferredSize(new Dimension(wWidth/7, 24));
        titleTextPane.setAlignmentY(Component.TOP_ALIGNMENT);
        textPanel.add(titleTextPane);

        locationTextPane = new JTextArea("location");
        locationTextPane.setPreferredSize(new Dimension(wWidth/7, 24));
        locationTextPane.setAlignmentY(Component.TOP_ALIGNMENT);
        textPanel.add(locationTextPane);

        rightPanel.add(textPanel);

        addButton = new JButton("Apply");
        addButton.setSize(96, 32);
        addButton.setAlignmentY(Component.TOP_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //titleTextPane.getText();
            }
        });
        rightPanel.add(addButton);

        wrapPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        wrapPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(wrapPanel);
    }

    public void CreateColumns() {
        colCount = Reference.STRING_COLUMN_NAMES.length;
    }

    public void CreateData() {
        dataValues = new String[100][colCount];
        for (int iY = 0; iY < 100; iY++) {
            for (int iX = 0; iX < colCount; iX++) {
                dataValues[iY][iX] = "" + iX + "," + iY;
            }
        }
    }

    public void InsertData() {

    }

    public static void main(String args[]) {
        StorageSystem mainFrame = new StorageSystem();
        mainFrame.setVisible(true);
    }

}
