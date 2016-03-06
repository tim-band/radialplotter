package RadialPlotter;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RadialOptions extends javax.swing.JPanel {
    
    /** Creates new form AxesOptions
     * @param p */
    public RadialOptions(Main p) {
        try {
            this.parent = p;
            this.plot = parent.getPlotFrame().getPlotPanel().getRadialPlot();
            this.prefs = plot.data.preferences;
            initComponents();
            myInit();
        } catch(Exception e) {
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }
    
    private void myInit() throws Exception {
        ButtonGroup units = new ButtonGroup();
        units.add(this.aButton);
        units.add(this.kaButton);
        units.add(this.MaButton);
        if (prefs.fissiontracks()){
            this.jLabel1.setText("min age");
            this.jLabel2.setText("central age");
            this.jLabel3.setText("max age");
            this.aButton.setVisible(true);
            this.kaButton.setVisible(true);
            this.MaButton.setVisible(true);
            this.MaButton.setSelected(plot.unit == Data.MA);
            this.kaButton.setSelected(plot.unit == Data.KA);
            this.aButton.setSelected(plot.unit == Data.A);
        } else {
            this.jLabel1.setText("min");
            this.jLabel2.setText("center");
            this.jLabel3.setText("max");
            this.aButton.setVisible(false);
            this.kaButton.setVisible(false);
            this.MaButton.setVisible(false);
        }
        this.SavePrefsCheckBox.setSelected(prefs.saveprefs());
        this.Xlabel.setText((String)prefs.xlabel());
        this.Ylabel.setText((String)prefs.ylabel());
        this.Zlabel.setText((String)prefs.zlabel());
        this.labelbox.setSelected(prefs.datalabels());
        this.sigmabox.setVisible(true);
        this.sigmabox.setSelected(prefs.sigmalines());
        if (!plot.fixedaxes){
            plot.data2rxry();
        }
        this.showAgeBounds();
        this.setAbanico(prefs.abanico());
        this.MarkerBox.setText(plot.markers);
    }

    public void setDefaultValues() throws Exception {
        plot.data2rxry(); //refresh the plot
        plot.setMinMaxAge();
        double[] z = ToolBox.convertDoubles(plot.data.z);
        plot.autoBandwidth = true;
        plot.kde.setBandwidth(z, plot.autoBandwidth);
        this.showAgeBounds();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maxAge = new javax.swing.JTextField();
        minAge = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        DefaultButton = new javax.swing.JButton();
        centralAge = new javax.swing.JTextField();
        kaButton = new javax.swing.JRadioButton();
        MaButton = new javax.swing.JRadioButton();
        Xlabel = new javax.swing.JTextField();
        Zlabel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Ylabel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        labelbox = new javax.swing.JCheckBox();
        sigmabox = new javax.swing.JCheckBox();
        aButton = new javax.swing.JRadioButton();
        SavePrefsCheckBox = new javax.swing.JCheckBox();
        abanicoBox = new javax.swing.JCheckBox();
        bandWidthBox = new javax.swing.JTextField();
        bwLabel = new javax.swing.JLabel();
        MarkerBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("min age");

        jLabel2.setText("central value");

        jLabel3.setText("max age");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        DefaultButton.setText("Default");
        DefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultButtonActionPerformed(evt);
            }
        });

        kaButton.setText("ka");
        kaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaButtonActionPerformed(evt);
            }
        });

        MaButton.setText("Ma");
        MaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("X label");

        jLabel5.setText("Y label");

        jLabel6.setText("Z label");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        labelbox.setText("data labels");
        labelbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelboxActionPerformed(evt);
            }
        });

        sigmabox.setText("2 sigma lines");
        sigmabox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigmaboxActionPerformed(evt);
            }
        });

        aButton.setText("a");
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });

        SavePrefsCheckBox.setText("save preferences for next time");

        abanicoBox.setText("abanico");
        abanicoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abanicoBoxActionPerformed(evt);
            }
        });

        bwLabel.setText("bandwidth");

        jLabel7.setText("markers");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(MarkerBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 189, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Zlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(Xlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(abanicoBox))
                            .add(layout.createSequentialGroup()
                                .add(minAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(MaButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(kaButton)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(aButton))
                    .add(layout.createSequentialGroup()
                        .add(centralAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(sigmabox))
                    .add(layout.createSequentialGroup()
                        .add(maxAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(labelbox))
                    .add(layout.createSequentialGroup()
                        .add(Ylabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(bwLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(bandWidthBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(DefaultButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(CancelButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(OKButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(SavePrefsCheckBox)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {CancelButton, DefaultButton, OKButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {Xlabel, Ylabel, Zlabel, centralAge, maxAge, minAge}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel1)
                    .add(minAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(MaButton)
                    .add(kaButton)
                    .add(aButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel2)
                    .add(centralAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(sigmabox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel3)
                    .add(maxAge, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelbox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel4)
                    .add(Xlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, abanicoBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel5)
                    .add(Ylabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bandWidthBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(bwLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Zlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(MarkerBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(CancelButton)
                    .add(OKButton)
                    .add(DefaultButton)
                    .add(SavePrefsCheckBox))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {Xlabel, Ylabel, Zlabel, centralAge, maxAge, minAge}, org.jdesktop.layout.GroupLayout.VERTICAL);

    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        SwingUtilities.getWindowAncestor(this).dispose();
}//GEN-LAST:event_CancelButtonActionPerformed
        
    private void DefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultButtonActionPerformed
        try {
            plot.fixAxes(false);
            this.setDefaultValues();
            this.showAgeBounds();
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_DefaultButtonActionPerformed

    private void kaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaButtonActionPerformed
        try{
            plot.setUnit(Data.KA);
            this.showAgeBounds();
            plot.fixUnits(true);
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_kaButtonActionPerformed

    private void MaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaButtonActionPerformed
        try{
            plot.setUnit(Data.MA);
            this.showAgeBounds();
            plot.fixUnits(true);
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_MaButtonActionPerformed

    private void showAgeBounds(){
        try {
            this.minage = this.age2string(plot.getMinMaxAge()[0]);
            this.maxage = this.age2string(plot.getMinMaxAge()[1]);
            this.centralage = this.age2string(plot.getCentralAge());         
            this.minAge.setText(this.minage);
            this.centralAge.setText(this.centralage);
            this.maxAge.setText(this.maxage);
            this.bandWidthBox.setText(plot.getBandWidth());
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        try {
            String foo;
            foo = this.minAge.getText();
            boolean changedmin = !foo.equals(minage) & ToolBox.isNumeric(foo);
            if (changedmin) {
                minage = foo;
            }
            foo = this.centralAge.getText();
            boolean changedcentral = (!foo.equals(centralage) & ToolBox.isNumeric(foo));
            if (changedcentral){
                centralage = foo;
            }
            foo = this.maxAge.getText();
            boolean changedmax = (!foo.equals(maxage) & ToolBox.isNumeric(foo));
            if (changedmax) {
                maxage = foo;
            }            
            if (changedmin | changedcentral | changedmax){
                plot.fixAxes(true);
                this.setCustomAxes();
            }
            this.checkLabels();
            foo = this.bandWidthBox.getText();
            plot.checkBandWidth(foo);
            plot.markers = this.MarkerBox.getText();
            prefs.saveprefs(SavePrefsCheckBox.isSelected());
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        } finally {
            SwingUtilities.getWindowAncestor(this).dispose();
        }
}//GEN-LAST:event_OKButtonActionPerformed

    private void labelboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelboxActionPerformed
        try {
            prefs.datalabels(labelbox.isSelected());
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
}//GEN-LAST:event_labelboxActionPerformed

    private void sigmaboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigmaboxActionPerformed
        try {
            prefs.sigmalines(sigmabox.isSelected());
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_sigmaboxActionPerformed
    
    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        try{
            plot.setUnit(Data.A);
            this.showAgeBounds();
            plot.fixUnits(true);            
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_aButtonActionPerformed

    private void abanicoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abanicoBoxActionPerformed
        try{
            setAbanico(abanicoBox.isSelected());
        } catch (Exception e){
            if (Data.DEBUGMODE){e.printStackTrace(System.out);}
        }
    }//GEN-LAST:event_abanicoBoxActionPerformed

    private void setAbanico(boolean abanico) throws Exception {
        prefs.abanico(abanico);
        double bw = plot.kde.getBandwidth();
        if (abanico){
            if (prefs.linear()){
                bw = bw/plot.unit;
            }
            bandWidthBox.setText(ToolBox.num2string(bw, 2));
            plot.rightmargin = plot.ABANICORIGHTMARGIN;
        } else {
            plot.rightmargin = plot.RIGHTMARGIN;
        }
        abanicoBox.setSelected(abanico);
        bandWidthBox.setVisible(abanico);
        bwLabel.setVisible(abanico);
    }
    
    // set minAge, maxAge and z0 based on the AxesForm values
    public void setCustomAxes() throws Exception {
        double mint = Double.parseDouble(minage)*plot.unit;
        double maxt = Double.parseDouble(maxage)*plot.unit;
        double centralt = Double.parseDouble(centralage)*plot.unit;
        plot.setMinMaxAge(mint, maxt);
        plot.setCentralAge(centralt);
    }
    
    private void checkLabels() throws Exception {
        String Xlab = Xlabel.getText(),
               Ylab = Ylabel.getText(),
               Zlab = Zlabel.getText();
        if (!plot.data.preferences.xlabel().equals(Xlab) |
            !plot.data.preferences.ylabel().equals(Ylab) |
            !plot.data.preferences.zlabel().equals(Zlab)){
            parent.setXlabel(Xlab);
            parent.setYlabel(Ylab);
            parent.setZlabel(Zlab);
            parent.repaint();
        }
    }
    
    private String age2string(double t) throws Exception {
        double unit = Data.A;
        if (this.MaButton.isSelected()) {
            unit = Data.MA;
        } else if (this.kaButton.isSelected()) {
            unit = Data.KA;
        }
        return age2string(t,2,unit);
    }
    
    private String age2string(double t, int n, double unit) throws Exception {
        return ToolBox.num2string(t/unit,n);
    }   
    
    public static void createAndShowGUI(Main parent) throws Exception {
        //Create and set up the window.
        JFrame frame = new JFrame("Set Scale and Labels");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new RadialOptions(parent);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DefaultButton;
    private javax.swing.JRadioButton MaButton;
    private javax.swing.JTextField MarkerBox;
    private javax.swing.JButton OKButton;
    private javax.swing.JCheckBox SavePrefsCheckBox;
    private javax.swing.JTextField Xlabel;
    private javax.swing.JTextField Ylabel;
    private javax.swing.JTextField Zlabel;
    private javax.swing.JRadioButton aButton;
    private javax.swing.JCheckBox abanicoBox;
    private javax.swing.JTextField bandWidthBox;
    private javax.swing.JLabel bwLabel;
    private javax.swing.JTextField centralAge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton kaButton;
    private javax.swing.JCheckBox labelbox;
    private javax.swing.JTextField maxAge;
    private javax.swing.JTextField minAge;
    private javax.swing.JCheckBox sigmabox;
    // End of variables declaration//GEN-END:variables
    private RadialPlot plot;
    private Main parent;
    private Preferences prefs;
    private String minage, centralage, maxage;

}