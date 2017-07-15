
import exception.DALException;
import gamer.*;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mysql.gamer.MySqlGamer;
import mysql.gamer.MySqlLeak;
import mysql.gamer.MySqlPicture;

public class GamerForm extends javax.swing.JPanel {

    public GamerForm() {
        initComponents();
        jLabelLeak1Gamer1.setVisible(false);
        jLabelLeak2Gamer1.setVisible(false);
        jLabelLeak3Gamer1.setVisible(false);
        jLabelLeak4Gamer1.setVisible(false);
        jLabelLeak5Gamer1.setVisible(false);
        jLabelLeak6Gamer1.setVisible(false);
        jLabelLeak7Gamer1.setVisible(false);
        jLabelLeak8Gamer1.setVisible(false);
        jLabelLeak9Gamer1.setVisible(false);
        jLabelLeak10Gamer1.setVisible(false);
        jLabelLeak11Gamer1.setVisible(false);
        jLabelLeak12Gamer1.setVisible(false);
        jLabelLeak13Gamer1.setVisible(false);
        jLabelLeak14Gamer1.setVisible(false);
        jLabelLeak15Gamer1.setVisible(false);
        jLabelLeak16Gamer1.setVisible(false);
        jButtonPic1Gamer1.setEnabled(false);
        jButtonPic2Gamer1.setEnabled(false);
        jButtonPic3Gamer1.setEnabled(false);
        jButtonPic4Gamer1.setEnabled(false);
        jButtonPic5Gamer1.setEnabled(false);
        jButtonPic6Gamer1.setEnabled(false);
        jButtonPic7Gamer1.setEnabled(false);
        jButtonPic8Gamer1.setEnabled(false);
        jButtonPic9Gamer1.setEnabled(false);
        jButtonPic10Gamer1.setEnabled(false);
        jButtonPic11Gamer1.setEnabled(false);
        jButtonPic12Gamer1.setEnabled(false);
    }
    String dbmsConnString = "jdbc:mysql://localhost:3306/notes_database";
    String userName = "root";
    String password = "SwiftTraining1";

    MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
    MySqlPicture mySqlPicture = new MySqlPicture(dbmsConnString, userName, password);
    MySqlLeak mySqlLeak = new MySqlLeak(dbmsConnString, userName, password);

    public void showGamerInfo(Gamer gamer) throws SQLException, DALException, IOException {
        int leakCount = 0;
        jLabelNameGamer1.setText(gamer.getGamerName());
        try {
            gamer.setGamerLeaks(mySqlLeak.getLeaks(gamer.getGamerId()));
        } catch (DALException ex) {
            Logger.getLogger(NoteTracker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NoteTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
        

            int counterPicture = 1;
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {

                // JLabel lPhoto = new JLabel();
                // lPhoto.setIcon(icon);
                switch (counterPicture) {
                    case 1:
                        jButtonPic1Gamer1.setEnabled(true);
                        break;
                        case 2:
                        jButtonPic2Gamer1.setEnabled(true);
                        break;
                        case 3:
                        jButtonPic3Gamer1.setEnabled(true);
                        break;
                        case 4:
                        jButtonPic4Gamer1.setEnabled(true);
                        break;
                        case 5:
                        jButtonPic5Gamer1.setEnabled(true);
                        break;
                        case 6:
                        jButtonPic6Gamer1.setEnabled(true);
                        break;
                        case 7:
                        jButtonPic7Gamer1.setEnabled(true);
                        break;
                        case 8:
                        jButtonPic8Gamer1.setEnabled(true);
                        break;
                        case 9:
                        jButtonPic9Gamer1.setEnabled(true);
                        break;
                        case 10:
                        jButtonPic10Gamer1.setEnabled(true);
                        break;
                        case 11:
                        jButtonPic11Gamer1.setEnabled(true);
                        break;
                        case 12:
                        jButtonPic12Gamer1.setEnabled(true);
                        break;
                }
                counterPicture++;
            }
        for (Leak leak : gamer.getGamerLeaks()) {

            leakCount++;
            switch (leakCount) {
                case 1:
                    jLabelLeak1Gamer1.setVisible(true);
                    jLabelLeak1Gamer1.setText(leak.getLeakName());
                    break;
                case 2:
                    jLabelLeak2Gamer1.setVisible(true);
                    jLabelLeak2Gamer1.setText(leak.getLeakName());
                    break;
                case 3:
                    jLabelLeak3Gamer1.setVisible(true);
                    jLabelLeak3Gamer1.setText(leak.getLeakName());
                    break;
                case 4:
                    jLabelLeak4Gamer1.setVisible(true);
                    jLabelLeak4Gamer1.setText(leak.getLeakName());
                    break;
                case 5:
                    jLabelLeak5Gamer1.setVisible(true);
                    jLabelLeak5Gamer1.setText(leak.getLeakName());
                    break;
                case 6:
                    jLabelLeak6Gamer1.setVisible(true);
                    jLabelLeak6Gamer1.setText(leak.getLeakName());
                    break;
                case 7:
                    jLabelLeak7Gamer1.setVisible(true);
                    jLabelLeak7Gamer1.setText(leak.getLeakName());
                    break;
                case 8:
                    jLabelLeak8Gamer1.setVisible(true);
                    jLabelLeak8Gamer1.setText(leak.getLeakName());
                    break;
                case 9:
                    jLabelLeak9Gamer1.setVisible(true);
                    jLabelLeak9Gamer1.setText(leak.getLeakName());
                    break;
                case 10:
                    jLabelLeak10Gamer1.setVisible(true);
                    jLabelLeak10Gamer1.setText(leak.getLeakName());
                    break;
                case 11:
                    jLabelLeak11Gamer1.setVisible(true);
                    jLabelLeak11Gamer1.setText(leak.getLeakName());
                    break;
                case 12:
                    jLabelLeak12Gamer1.setVisible(true);
                    jLabelLeak12Gamer1.setText(leak.getLeakName());
                    break;
                case 13:
                    jLabelLeak13Gamer1.setVisible(true);
                    jLabelLeak13Gamer1.setText(leak.getLeakName());
                    break;
                case 14:
                    jLabelLeak14Gamer1.setVisible(true);
                    jLabelLeak14Gamer1.setText(leak.getLeakName());
                    break;
                case 15:
                    jLabelLeak15Gamer1.setVisible(true);
                    jLabelLeak15Gamer1.setText(leak.getLeakName());
                    break;
                case 16:
                    jLabelLeak16Gamer1.setVisible(true);
                    jLabelLeak16Gamer1.setText(leak.getLeakName());
                    break;
            }
counterPicture++;
        }
        gamer.setGamerNote(mySqlGamer.getNotes(gamer.getGamerId()));
        String note = gamer.getGamerNote();
        jTextAreaNotesGamer1.setText(note);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jPanelGamer1 = new javax.swing.JPanel();
        jPanelLeaksGamer1 = new javax.swing.JPanel();
        jLabelLeak1Gamer1 = new javax.swing.JLabel();
        jLabelLeak2Gamer1 = new javax.swing.JLabel();
        jLabelLeak3Gamer1 = new javax.swing.JLabel();
        jLabelLeak4Gamer1 = new javax.swing.JLabel();
        jLabelLeak5Gamer1 = new javax.swing.JLabel();
        jLabelLeak6Gamer1 = new javax.swing.JLabel();
        jLabelLeak7Gamer1 = new javax.swing.JLabel();
        jLabelLeak8Gamer1 = new javax.swing.JLabel();
        jLabelLeak9Gamer1 = new javax.swing.JLabel();
        jLabelLeak10Gamer1 = new javax.swing.JLabel();
        jLabelLeak11Gamer1 = new javax.swing.JLabel();
        jLabelLeak12Gamer1 = new javax.swing.JLabel();
        jLabelLeak13Gamer1 = new javax.swing.JLabel();
        jLabelLeak14Gamer1 = new javax.swing.JLabel();
        jLabelLeak15Gamer1 = new javax.swing.JLabel();
        jLabelLeak16Gamer1 = new javax.swing.JLabel();
        jPanelPicsGamer1 = new javax.swing.JPanel();
        jButtonPic1Gamer1 = new javax.swing.JButton();
        jButtonPic2Gamer1 = new javax.swing.JButton();
        jButtonPic3Gamer1 = new javax.swing.JButton();
        jButtonPic5Gamer1 = new javax.swing.JButton();
        jButtonPic6Gamer1 = new javax.swing.JButton();
        jButtonPic7Gamer1 = new javax.swing.JButton();
        jButtonPic8Gamer1 = new javax.swing.JButton();
        jButtonPic9Gamer1 = new javax.swing.JButton();
        jButtonPic10Gamer1 = new javax.swing.JButton();
        jButtonPic11Gamer1 = new javax.swing.JButton();
        jButtonPic12Gamer1 = new javax.swing.JButton();
        jButtonPic4Gamer1 = new javax.swing.JButton();
        jPanelNoteGamer1 = new javax.swing.JPanel();
        jScrollPaneGamer1 = new javax.swing.JScrollPane();
        jTextAreaNotesGamer1 = new javax.swing.JTextArea();
        jPanelTitleGamer1 = new javax.swing.JPanel();
        jLabelNameGamer1 = new javax.swing.JLabel();
        jButtonCloseGamer1 = new javax.swing.JButton();
        jButtonMinimizeGamer1 = new javax.swing.JButton();
        jComboBoxColorsGamer1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanelGamer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelGamer1.setEnabled(false);

        jPanelLeaksGamer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelLeak1Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak1Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak1Gamer1.setText("Leak1");

        jLabelLeak2Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak2Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak2Gamer1.setText("Leak2");

        jLabelLeak3Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak3Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak3Gamer1.setText("Leak3");

        jLabelLeak4Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak4Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak4Gamer1.setText("Leak4");

        jLabelLeak5Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak5Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak5Gamer1.setText("Leak5");

        jLabelLeak6Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak6Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak6Gamer1.setText("Leak6");

        jLabelLeak7Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak7Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak7Gamer1.setText("Leak7");

        jLabelLeak8Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak8Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak8Gamer1.setText("Leak8");

        jLabelLeak9Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak9Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak9Gamer1.setText("Leak9");

        jLabelLeak10Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak10Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak10Gamer1.setText("Leak10");

        jLabelLeak11Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak11Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak11Gamer1.setText("Leak11");

        jLabelLeak12Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak12Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak12Gamer1.setText("Leak12");

        jLabelLeak13Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak13Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak13Gamer1.setText("Leak13");

        jLabelLeak14Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak14Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak14Gamer1.setText("Leak14");

        jLabelLeak15Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak15Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak15Gamer1.setText("Leak15");

        jLabelLeak16Gamer1.setBackground(new java.awt.Color(51, 0, 51));
        jLabelLeak16Gamer1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLeak16Gamer1.setText("Leak16");

        javax.swing.GroupLayout jPanelLeaksGamer1Layout = new javax.swing.GroupLayout(jPanelLeaksGamer1);
        jPanelLeaksGamer1.setLayout(jPanelLeaksGamer1Layout);
        jPanelLeaksGamer1Layout.setHorizontalGroup(
            jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLeak1Gamer1)
                    .addComponent(jLabelLeak5Gamer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                        .addComponent(jLabelLeak2Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLeak3Gamer1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLeak4Gamer1))
                    .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                        .addComponent(jLabelLeak6Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLeak7Gamer1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLeak8Gamer1)))
                .addGap(238, 238, 238))
            .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                        .addComponent(jLabelLeak9Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLeak10Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLeak11Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLeak12Gamer1))
                    .addGroup(jPanelLeaksGamer1Layout.createSequentialGroup()
                        .addComponent(jLabelLeak13Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLeak14Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLeak15Gamer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLeak16Gamer1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLeaksGamer1Layout.setVerticalGroup(
            jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLeaksGamer1Layout.createSequentialGroup()
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLeak1Gamer1)
                    .addComponent(jLabelLeak2Gamer1)
                    .addComponent(jLabelLeak3Gamer1)
                    .addComponent(jLabelLeak4Gamer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLeak5Gamer1)
                    .addComponent(jLabelLeak6Gamer1)
                    .addComponent(jLabelLeak7Gamer1)
                    .addComponent(jLabelLeak8Gamer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLeak9Gamer1)
                    .addComponent(jLabelLeak10Gamer1)
                    .addComponent(jLabelLeak11Gamer1)
                    .addComponent(jLabelLeak12Gamer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLeaksGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLeak13Gamer1)
                    .addComponent(jLabelLeak14Gamer1)
                    .addComponent(jLabelLeak15Gamer1)
                    .addComponent(jLabelLeak16Gamer1))
                .addGap(299, 299, 299))
        );

        jPanelPicsGamer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonPic1Gamer1.setText("Pic1");
        jButtonPic1Gamer1.setOpaque(false);
        jButtonPic1Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic1Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic2Gamer1.setText("Pic2");
        jButtonPic2Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic2Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic3Gamer1.setText("Pic3");
        jButtonPic3Gamer1.setActionCommand("Picture3");
        jButtonPic3Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic3Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic5Gamer1.setText("Pic5");
        jButtonPic5Gamer1.setActionCommand("Picture5");
        jButtonPic5Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic5Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic6Gamer1.setText("Pic6");
        jButtonPic6Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic6Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic7Gamer1.setText("Pic7");
        jButtonPic7Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic7Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic8Gamer1.setText("Pic8");
        jButtonPic8Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic8Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic9Gamer1.setText("Pic9");
        jButtonPic9Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic9Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic10Gamer1.setText("Pic10");
        jButtonPic10Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic10Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic11Gamer1.setText("Pic11");
        jButtonPic11Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic11Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic12Gamer1.setText("Pic12");
        jButtonPic12Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic12Gamer1ActionPerformed(evt);
            }
        });

        jButtonPic4Gamer1.setText("Pic4");
        jButtonPic4Gamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPic4Gamer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPicsGamer1Layout = new javax.swing.GroupLayout(jPanelPicsGamer1);
        jPanelPicsGamer1.setLayout(jPanelPicsGamer1Layout);
        jPanelPicsGamer1Layout.setHorizontalGroup(
            jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                .addComponent(jButtonPic10Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonPic11Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPic12Gamer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                .addGroup(jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                        .addComponent(jButtonPic1Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic2Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic3Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                        .addComponent(jButtonPic4Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic5Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic6Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                        .addComponent(jButtonPic7Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic8Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPic9Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPicsGamer1Layout.setVerticalGroup(
            jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPicsGamer1Layout.createSequentialGroup()
                .addGroup(jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPic1Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic2Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic3Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPic4Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic5Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic6Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPic7Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic8Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic9Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelPicsGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPic10Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic11Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPic12Gamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanelNoteGamer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaNotesGamer1.setColumns(20);
        jTextAreaNotesGamer1.setRows(5);
        jScrollPaneGamer1.setViewportView(jTextAreaNotesGamer1);

        javax.swing.GroupLayout jPanelNoteGamer1Layout = new javax.swing.GroupLayout(jPanelNoteGamer1);
        jPanelNoteGamer1.setLayout(jPanelNoteGamer1Layout);
        jPanelNoteGamer1Layout.setHorizontalGroup(
            jPanelNoteGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelNoteGamer1Layout.setVerticalGroup(
            jPanelNoteGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNoteGamer1Layout.createSequentialGroup()
                .addComponent(jScrollPaneGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelTitleGamer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNameGamer1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabelNameGamer1.setForeground(new java.awt.Color(0, 0, 204));
        jLabelNameGamer1.setText("Gamer Name1");

        jButtonCloseGamer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCloseGamer1.setForeground(new java.awt.Color(255, 0, 0));
        jButtonCloseGamer1.setText("x");
        jButtonCloseGamer1.setToolTipText("Close Gamer");
        jButtonCloseGamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseGamer1ActionPerformed(evt);
            }
        });

        jButtonMinimizeGamer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonMinimizeGamer1.setText("-");
        jButtonMinimizeGamer1.setToolTipText("Minimize Gamer");
        jButtonMinimizeGamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizeGamer1ActionPerformed(evt);
            }
        });

        jComboBoxColorsGamer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Green", "Blue" }));
        jComboBoxColorsGamer1.setToolTipText("Choise Color");
        jComboBoxColorsGamer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColorsGamer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTitleGamer1Layout = new javax.swing.GroupLayout(jPanelTitleGamer1);
        jPanelTitleGamer1.setLayout(jPanelTitleGamer1Layout);
        jPanelTitleGamer1Layout.setHorizontalGroup(
            jPanelTitleGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleGamer1Layout.createSequentialGroup()
                .addComponent(jLabelNameGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxColorsGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMinimizeGamer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCloseGamer1)
                .addContainerGap())
        );
        jPanelTitleGamer1Layout.setVerticalGroup(
            jPanelTitleGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelNameGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonCloseGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonMinimizeGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBoxColorsGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelGamer1Layout = new javax.swing.GroupLayout(jPanelGamer1);
        jPanelGamer1.setLayout(jPanelGamer1Layout);
        jPanelGamer1Layout.setHorizontalGroup(
            jPanelGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGamer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelTitleGamer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelGamer1Layout.createSequentialGroup()
                        .addGroup(jPanelGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelLeaksGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelPicsGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelNoteGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelGamer1Layout.setVerticalGroup(
            jPanelGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGamer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitleGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGamer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNoteGamer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelGamer1Layout.createSequentialGroup()
                        .addComponent(jPanelLeaksGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPicsGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGamer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGamer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    String gamerName;
    
    private void jButtonPic3Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic3Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 3){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic3Gamer1ActionPerformed

    private void jComboBoxColorsGamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColorsGamer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxColorsGamer1ActionPerformed

    private void jButtonCloseGamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseGamer1ActionPerformed
        // TODO add your handling code here:
        String note = jTextAreaNotesGamer1.getText();
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mySqlGamer.insertNewNote(gamer.getGamerId(), note);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mySqlGamer.deleteFromHystory(gamer.getGamerId());
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        

    }//GEN-LAST:event_jButtonCloseGamer1ActionPerformed

    private void jButtonPic1Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic1Gamer1ActionPerformed
        // TODO add your handling code here:
        //PictureForm pic = new PictureForm();
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 1){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic1Gamer1ActionPerformed

    private void jButtonPic2Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic2Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 2){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic2Gamer1ActionPerformed

    private void jButtonPic4Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic4Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 4){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic4Gamer1ActionPerformed

    private void jButtonPic5Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic5Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 5){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic5Gamer1ActionPerformed

    private void jButtonPic6Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic6Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 6){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic6Gamer1ActionPerformed

    private void jButtonPic7Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic7Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 7){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic7Gamer1ActionPerformed

    private void jButtonPic8Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic8Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 8){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic8Gamer1ActionPerformed

    private void jButtonPic9Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic9Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 9){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic9Gamer1ActionPerformed

    private void jButtonPic10Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic10Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 10){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic10Gamer1ActionPerformed

    private void jButtonPic11Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic11Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 11){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic11Gamer1ActionPerformed

    private void jButtonPic12Gamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPic12Gamer1ActionPerformed
        // TODO add your handling code here:
        gamerName = jLabelNameGamer1.getText();
        Gamer gamer = null;
        try {
           gamer = mySqlGamer.getGamer(gamerName);
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int count = 1;    
        try {
            for (Image image : mySqlPicture.getPictures(gamer.getGamerId())) {
                if(count == 12){
                    JFrame picture = new JFrame();
                    picture.setSize(200, 200);
                    ImageIcon icon = null;
                    icon = new ImageIcon(image);
                    picture.setVisible(true);
                    JLabel pic = new JLabel();
                    picture.add(pic);
                    pic.setIcon(icon);
                    break;
                }
                count++;
            }
        } catch (DALException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GamerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPic12Gamer1ActionPerformed

    private void jButtonMinimizeGamer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizeGamer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMinimizeGamer1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCloseGamer1;
    public javax.swing.JButton jButtonMinimizeGamer1;
    public javax.swing.JButton jButtonPic10Gamer1;
    public javax.swing.JButton jButtonPic11Gamer1;
    public javax.swing.JButton jButtonPic12Gamer1;
    public javax.swing.JButton jButtonPic1Gamer1;
    public javax.swing.JButton jButtonPic2Gamer1;
    public javax.swing.JButton jButtonPic3Gamer1;
    public javax.swing.JButton jButtonPic4Gamer1;
    public javax.swing.JButton jButtonPic5Gamer1;
    public javax.swing.JButton jButtonPic6Gamer1;
    public javax.swing.JButton jButtonPic7Gamer1;
    public javax.swing.JButton jButtonPic8Gamer1;
    public javax.swing.JButton jButtonPic9Gamer1;
    public javax.swing.JComboBox<String> jComboBoxColorsGamer1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    public javax.swing.JLabel jLabelLeak10Gamer1;
    public javax.swing.JLabel jLabelLeak11Gamer1;
    public javax.swing.JLabel jLabelLeak12Gamer1;
    public javax.swing.JLabel jLabelLeak13Gamer1;
    public javax.swing.JLabel jLabelLeak14Gamer1;
    public javax.swing.JLabel jLabelLeak15Gamer1;
    public javax.swing.JLabel jLabelLeak16Gamer1;
    public javax.swing.JLabel jLabelLeak1Gamer1;
    public javax.swing.JLabel jLabelLeak2Gamer1;
    public javax.swing.JLabel jLabelLeak3Gamer1;
    public javax.swing.JLabel jLabelLeak4Gamer1;
    public javax.swing.JLabel jLabelLeak5Gamer1;
    public javax.swing.JLabel jLabelLeak6Gamer1;
    public javax.swing.JLabel jLabelLeak7Gamer1;
    public javax.swing.JLabel jLabelLeak8Gamer1;
    public javax.swing.JLabel jLabelLeak9Gamer1;
    public javax.swing.JLabel jLabelNameGamer1;
    public javax.swing.JPanel jPanelGamer1;
    public javax.swing.JPanel jPanelLeaksGamer1;
    public javax.swing.JPanel jPanelNoteGamer1;
    public javax.swing.JPanel jPanelPicsGamer1;
    public javax.swing.JPanel jPanelTitleGamer1;
    private javax.swing.JScrollPane jScrollPaneGamer1;
    public javax.swing.JTextArea jTextAreaNotesGamer1;
    // End of variables declaration//GEN-END:variables
}
