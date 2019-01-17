/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassroomListReport.java
 *
 * Created on Jun 18, 2017, 4:12:51 PM
 */
package view.reportforms;

import backend.Classroom;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import data.DataContainer;

/**
 *
 * @author Hoang Nguyen
 */
public class ClassroomListReport extends javax.swing.JFrame {

    /** Creates new form ClassroomListReport
     * @param data */
    public ClassroomListReport(DataContainer data) {
        initComponents();
        // Retrieve the list from the data model
        ArrayList<Classroom> listOfClassrooms = data.getListOfClassrooms();

        // Call method that will add all classrooms to the text area
        this.populateTextArea(listOfClassrooms);

        // Call method that will add all classrooms to the table
        this.populateTable(listOfClassrooms);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOfClassrooms = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOfClassrooms = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("List of Classroom At a Glance");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Tabular List of Classroom");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        textAreaOfClassrooms.setColumns(20);
        textAreaOfClassrooms.setRows(5);
        jScrollPane1.setViewportView(textAreaOfClassrooms);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tableOfClassrooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Room Number", "Room Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableOfClassrooms.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tableOfClassrooms);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(260, 260, 260))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(289, 289, 289))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_closeButtonActionPerformed
    /**
     * Private method that will add all classrooms to the text area
     */
    private void populateTextArea(ArrayList<Classroom> listOfClassrooms) {

        // Initialize the string which will hold the data for the text area
        // Start with labels
        String allClassroomsText = "Room Number\tRoom Type\n";

        // Loop through the list and add the classrooms to the text area,
        // Each time adding a cr/lf between items for readibility.
        for (int i = 0; i < listOfClassrooms.size(); i++) {
            Classroom aClassroom = listOfClassrooms.get(i);
            String roomNumber = aClassroom.getRoomNumber();
            String roomType = aClassroom.getTypeOfRoom().toString();
            allClassroomsText += roomNumber;
            allClassroomsText += "\t";
            allClassroomsText += roomType;
            allClassroomsText += "\n";
        }
        // Once all the data is in the string, set the text of the text area to the string value
        textAreaOfClassrooms.setText(allClassroomsText);

    }

    /**
     * Private method that will add all classrooms to the table
     */
    private void populateTable(ArrayList<Classroom> listOfClassrooms) {

        // A table model like this will hold the data for the JTable (this is the M in MVC)
        DefaultTableModel defaultTableModel = new DefaultTableModel();

        // add columns to table model
        defaultTableModel.addColumn("Room Number");
        defaultTableModel.addColumn("Room Type");

        // Link the data model to the table
        tableOfClassrooms.setModel(defaultTableModel);

        // Add the classrooms in the ArrayList to the table model
        for (Classroom aClassroom : listOfClassrooms) {

            // Create a vector that is one row in the table
            Vector aClassroomForTable = new Vector();

            // Add the data to the vector
            aClassroomForTable.add(aClassroom.getRoomNumber());
            aClassroomForTable.add(aClassroom.getTypeOfRoom());

            // Add the vector to the  data model that is connected to the JTable
            defaultTableModel.addRow(aClassroomForTable);

            tableOfClassrooms.setModel(defaultTableModel);
        }
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableOfClassrooms;
    private javax.swing.JTextArea textAreaOfClassrooms;
    // End of variables declaration//GEN-END:variables
}
