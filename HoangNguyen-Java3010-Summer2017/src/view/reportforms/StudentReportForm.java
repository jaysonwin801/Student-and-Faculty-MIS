package view.reportforms;

import backend.Student;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import data.DataContainer;
import java.text.SimpleDateFormat;

/**
 * This class contains all the code for the view
 */
public class StudentReportForm extends javax.swing.JFrame {

    public StudentReportForm(DataContainer data) {
        // Initialize all the components on the form
        initComponents();
        // Retrieve the list from the data model
        ArrayList<Student> listOfStudents = data.getListOfStudents();

        // Call method that will add all classrooms to the text area
        this.populateTextArea(listOfStudents);

        // Call method that will add all classrooms to the table
        this.populateTable(listOfStudents);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOfStudents = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOfStudents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("List Of Students At A Glance");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(295, 20, 190, 14);

        textAreaOfStudents.setColumns(20);
        textAreaOfStudents.setRows(5);
        jScrollPane1.setViewportView(textAreaOfStudents);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 45, 650, 124);

        jLabel2.setText("List of Students");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 190, 270, 14);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton);
        closeButton.setBounds(300, 380, 120, 23);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tableOfStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Address", "SSN", "Date Of Birth", "Date of Graduation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOfStudents.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tableOfStudents);
        tableOfStudents.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 220, 650, 138);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Private method that will add all students to the text area
     */
    private void populateTextArea(ArrayList<Student> listOfStudents) {

        // Add all students to display list text area
        String studentListText = "";
        for (Student student : listOfStudents) {
            studentListText += student.getName();
            studentListText += "\n";
        }
        // Once all the data is in the string, set the text of the text area to the string value      
        textAreaOfStudents.setText(studentListText);
    }

    /**
     * Private method that will add all students to the table
     */
    private void populateTable(ArrayList<Student> listOfStudents) {

        // A table model like this will hold the data for the JTable (this is the M in MVC)
        DefaultTableModel defaultTableModel = new DefaultTableModel();

        // add columns to table model
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("SSN");
        defaultTableModel.addColumn("Date Of Birth");
        defaultTableModel.addColumn("Date Of Graduation");
        defaultTableModel.addColumn("GPA");
        // Link the data model to the table
        tableOfStudents.setModel(defaultTableModel);

        // Add the students in the ArrayList to the table model
        for (Student aStudent : listOfStudents) {

            // Create a vector that is one row in the table
            Vector aTableOfStudents = new Vector();

            // Add the data to the vector
            aTableOfStudents.add(aStudent.getName());
            aTableOfStudents.add(aStudent.getAddress());
            aTableOfStudents.add(aStudent.getSocialSecurityNumber());
            // Format the dates using a SimpleDateFormat object
            SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
            String stringdate = dateformatter.format(aStudent.getDateOfBirth().getTime());
            aTableOfStudents.add(stringdate);
            dateformatter = new SimpleDateFormat("MM/dd/yyyy");
            stringdate = dateformatter.format(aStudent.getDateOfGraduation().getTime());
            aTableOfStudents.add(stringdate);
            aTableOfStudents.add(aStudent.getCurrentGPA());
            // Add the vector to the  data model that is connected to the JTable
            defaultTableModel.addRow(aTableOfStudents);
            tableOfStudents.setModel(defaultTableModel);
                        
        }
    }
private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
// close button method
    this.dispose();
}//GEN-LAST:event_closeButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableOfStudents;
    private javax.swing.JTextArea textAreaOfStudents;
    // End of variables declaration//GEN-END:variables
}