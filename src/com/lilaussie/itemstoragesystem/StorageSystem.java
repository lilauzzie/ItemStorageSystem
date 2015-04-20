package com.lilaussie.itemstoragesystem;

import com.lilaussie.itemstoragesystem.references.Reference;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Anthony on 19/04/2015.
 */
public class StorageSystem extends JFrame {

    // Instance attributes used in this example
    private	JPanel      leftPanel;
    private	JTable		table;
    private JTable      buttonTable;
    private	JScrollPane scrollPane;
    private JPanel      rightPanel;
    private JTextArea   titleTextPane;

    private int colCount;
    private String columnNames[];
    private	String dataValues[][];

    public StorageSystem() {
        setTitle(Reference.STRING_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Reference.INT_WINDOW_WIDTH, Reference.INT_WINDOW_HEIGHT);
        setBackground(Color.GRAY);

        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(leftPanel);

        CreateColumns();
        CreateData();

        table = new JTable(dataValues, Reference.STRING_COLUMN_NAMES);

        table.setShowHorizontalLines(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        table.setSelectionForeground(Color.WHITE);
        table.setSelectionBackground(Color.RED);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(Reference.INT_WINDOW_WIDTH / 2, Reference.INT_WINDOW_HEIGHT - 150));
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        //buttonTable = new JTable();
        //leftPanel.add(buttonTable);
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(Reference.INT_WINDOW_WIDTH / 2, Reference.INT_WINDOW_HEIGHT - 150));

        titleTextPane = new JTextArea("title");
        titleTextPane.setPreferredSize(new Dimension(150, 24));
        titleTextPane.setAlignmentY(Component.TOP_ALIGNMENT);
        rightPanel.add(titleTextPane);
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

    public static void main(String args[]) {
        StorageSystem mainFrame = new StorageSystem();
        mainFrame.setVisible(true);
    }

}
