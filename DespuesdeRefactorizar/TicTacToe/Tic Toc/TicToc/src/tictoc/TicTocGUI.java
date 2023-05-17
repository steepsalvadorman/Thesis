package tictoc;

import java.awt.Button;
import java.util.Arrays;

public class TicTocGUI extends java.awt.Frame {

    int pno = 2;
    int psc1 = 0, psc2 = 0;
    static int con[] = new int[9];

    public TicTocGUI() {
        Arrays.fill(con, 2);
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        panel1 = new java.awt.Panel();
        a1 = new java.awt.Button();
        a2 = new java.awt.Button();
        a3 = new java.awt.Button();
        a6 = new java.awt.Button();
        a5 = new java.awt.Button();
        a4 = new java.awt.Button();
        a9 = new java.awt.Button();
        a8 = new java.awt.Button();
        a7 = new java.awt.Button();
        label1 = new java.awt.Label();
        pnm1 = new java.awt.Label();
        ps1 = new java.awt.Label();
        pnm2 = new java.awt.Label();
        ps2 = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        label = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        popupMenu1.setLabel("Change Name");
        popupMenu1.setName("namepop");

        setBackground(new java.awt.Color(102, 102, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(102, 102, 255));

        a1.setBackground(new java.awt.Color(0, 51, 0));
        a1.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a1MouseExited(evt);
            }
        });
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });

        a2.setBackground(new java.awt.Color(0, 51, 0));
        a2.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a2MouseExited(evt);
            }
        });
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });

        a3.setBackground(new java.awt.Color(0, 51, 0));
        a3.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a3MouseExited(evt);
            }
        });
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });

        a6.setBackground(new java.awt.Color(0, 51, 0));
        a6.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a6MouseExited(evt);
            }
        });
        a6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a6ActionPerformed(evt);
            }
        });

        a5.setBackground(new java.awt.Color(0, 51, 0));
        a5.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a5MouseExited(evt);
            }
        });
        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });

        a4.setBackground(new java.awt.Color(0, 51, 0));
        a4.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a4MouseExited(evt);
            }
        });
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });

        a9.setBackground(new java.awt.Color(0, 51, 0));
        a9.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a9MouseExited(evt);
            }
        });
        a9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a9ActionPerformed(evt);
            }
        });

        a8.setBackground(new java.awt.Color(0, 51, 0));
        a8.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a8MouseExited(evt);
            }
        });
        a8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a8ActionPerformed(evt);
            }
        });

        a7.setBackground(new java.awt.Color(0, 51, 0));
        a7.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        a7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                a7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                a7MouseExited(evt);
            }
        });
        a7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(51, 0, 51));
        label1.setFont(new java.awt.Font("Dialog", 3, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 204, 0));
        label1.setName(""); // NOI18N
        label1.setText("Tic-Toc-Tic");

        pnm1.setAlignment(java.awt.Label.CENTER);
        pnm1.setBackground(new java.awt.Color(102, 0, 153));
        pnm1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnm1.setForeground(new java.awt.Color(255, 255, 255));
        pnm1.setText("Player 1(x)");

        ps1.setAlignment(java.awt.Label.CENTER);
        ps1.setBackground(new java.awt.Color(0, 204, 51));
        ps1.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N

        pnm2.setAlignment(java.awt.Label.CENTER);
        pnm2.setBackground(new java.awt.Color(102, 0, 153));
        pnm2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pnm2.setForeground(new java.awt.Color(255, 255, 255));
        pnm2.setText("Player 2(o)");

        ps2.setAlignment(java.awt.Label.CENTER);
        ps2.setBackground(new java.awt.Color(0, 204, 51));
        ps2.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N

        button1.setBackground(new java.awt.Color(0, 255, 102));
        button1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        button1.setForeground(new java.awt.Color(51, 0, 51));
        button1.setLabel("New Game");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(0, 255, 102));
        button2.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        button2.setForeground(new java.awt.Color(51, 0, 51));
        button2.setLabel("Reset");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(0, 255, 102));
        button3.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        button3.setForeground(new java.awt.Color(51, 0, 51));
        button3.setLabel("Exit");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        label.setAlignment(java.awt.Label.CENTER);
        label.setBackground(new java.awt.Color(102, 102, 255));
        label.setFont(new java.awt.Font("Ebrima", 1, 38)); // NOI18N
        label.setForeground(new java.awt.Color(0, 0, 0));

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(51, 0, 51));
        label2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 0));
        label2.setText("||||");

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(51, 0, 51));
        label3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 0));
        label3.setName(""); // NOI18N
        label3.setText("||||");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnm2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(ps2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ps1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnm1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(ps1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(pnm2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(ps2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    void reset() {
        Button[] buttons = {a1, a2, a3, a4, a5, a6, a7, a8, a9};
        for (Button button : buttons) {
            button.setLabel("");
            button.setEnabled(true);
            button.setBackground(new java.awt.Color(0, 51, 0));
        }

        label.setText("");
        pno = 2;
        win = 0;

        for (int i = 0; i < 9; i++) {
            con[i] = 2;
        }

    }

    void chal(Button b) {
        String label = (pno % 2 == 0) ? "x" : "o";
        b.setLabel(label);
        condition();
        pno++;
        b.setEnabled(false);
    }

    int win = 0;

    void win() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
        };

        for (int[] condition : winConditions) {
            int a = condition[0];
            int b = condition[1];
            int c = condition[2];

            if (con[a] == con[b] && con[b] == con[c]) {
                setBackground(new java.awt.Color(51, 255, 0), a, b, c);
                win = 1;
                return;
            }
        }
    }

    void setBackground(java.awt.Color color, int... indexes) {
        for (int index : indexes) {
            switch (index) {
                case 0:
                    a1.setBackground(color);
                    break;
                case 1:
                    a2.setBackground(color);
                    break;
                case 2:
                    a3.setBackground(color);
                    break;
                case 3:
                    a4.setBackground(color);
                    break;
                case 4:
                    a5.setBackground(color);
                    break;
                case 5:
                    a6.setBackground(color);
                    break;
                case 6:
                    a7.setBackground(color);
                    break;
                case 7:
                    a8.setBackground(color);
                    break;
                case 8:
                    a9.setBackground(color);
                    break;
            }
        }
    }

    void condition() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
        };

        for (int[] condition : winConditions) {
            int a = condition[0];
            int b = condition[1];
            int c = condition[2];

            if (con[a] == 0 && con[b] == 0 && con[c] == 0) {
                label.setText("Player 1 won!");
                psc1++;
                ps1.setText(String.valueOf(psc1));
                win();
                stop();
                return;
            } else if (con[a] == 1 && con[b] == 1 && con[c] == 1) {
                label.setText("Player 2 won!");
                psc2++;
                ps2.setText(String.valueOf(psc2));
                win();
                stop();
                return;
            }
        }
    }

    void stop() {
        Button[] botones = {a1, a2, a3, a4, a5, a6, a7, a8, a9};
        for (Button boton : botones) {
            boton.setEnabled(false);
        }
    }

    void conVal(int i) {
        if (pno % 2 == 0) {
            con[i] = 0;
        } else {
            con[i] = 1;
        }
    }


    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        reset();
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        reset();
        psc1 = 0;
        psc2 = 0;
        ps1.setText("" + psc1);
        ps2.setText("" + psc2);
    }//GEN-LAST:event_button1ActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
        conVal(0);
        chal(a1);
// TODO add your handling code here:
    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
        conVal(1);
        chal(a2);
        // TODO add your handling code here:
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
        conVal(2);
        chal(a3);
        // TODO add your handling code here:
    }//GEN-LAST:event_a3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
        conVal(3);
        chal(a4);
        // TODO add your handling code here:
    }//GEN-LAST:event_a4ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5ActionPerformed
        conVal(4);
        chal(a5);         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_a5ActionPerformed

    private void a6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a6ActionPerformed
        conVal(5);
        chal(a6);
        // TODO add your handling code here:
    }//GEN-LAST:event_a6ActionPerformed

    private void a7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a7ActionPerformed
        conVal(6);
        chal(a7);
        // TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_a7ActionPerformed

    private void a8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a8ActionPerformed
        conVal(7);
        chal(a8);         // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_a8ActionPerformed

    private void a9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a9ActionPerformed
        conVal(8);
        chal(a9);
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_a9ActionPerformed

    private void mouseEnter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEnter
        a1.setBackground(new java.awt.Color(0, 51, 51));        // TODO add your handling code here:
    }//GEN-LAST:event_mouseEnter

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void a1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseExited
        if (win == 0)
            a1.setBackground(new java.awt.Color(0, 51, 0));        // TODO add your handling code here:
    }//GEN-LAST:event_a1MouseExited

    private void a2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseEntered
        a2.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a2MouseEntered

    private void a3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseEntered
        a3.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a3MouseEntered

    private void a4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseEntered
        a4.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a4MouseEntered

    private void a5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseEntered
        a5.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a5MouseEntered

    private void a6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseEntered
        a6.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a6MouseEntered

    private void a7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseEntered
        a7.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a7MouseEntered

    private void a8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseEntered
        a8.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a8MouseEntered

    private void a9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseEntered
        a9.setBackground(new java.awt.Color(0, 51, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_a9MouseEntered

    private void a2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseExited
        if (win == 0)
            a2.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a2MouseExited

    private void a3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseExited
        if (win == 0)
            a3.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a3MouseExited

    private void a4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseExited
        if (win == 0)
            a4.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a4MouseExited

    private void a5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseExited
        if (win == 0)
            a5.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a5MouseExited

    private void a6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a6MouseExited
        if (win == 0)
            a6.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a6MouseExited

    private void a7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a7MouseExited
        if (win == 0)
            a7.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a7MouseExited

    private void a8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a8MouseExited
        if (win == 0)
            a8.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a8MouseExited

    private void a9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a9MouseExited
        if (win == 0)
            a9.setBackground(new java.awt.Color(0, 51, 0));          // TODO add your handling code here:
    }//GEN-LAST:event_a9MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTocGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button a1;
    private java.awt.Button a2;
    private java.awt.Button a3;
    private java.awt.Button a4;
    private java.awt.Button a5;
    private java.awt.Button a6;
    private java.awt.Button a7;
    private java.awt.Button a8;
    private java.awt.Button a9;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Label label;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Panel panel1;
    private java.awt.Label pnm1;
    private java.awt.Label pnm2;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.Label ps1;
    private java.awt.Label ps2;
    // End of variables declaration//GEN-END:variables
}
