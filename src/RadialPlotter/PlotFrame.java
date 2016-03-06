package RadialPlotter;

import javax.swing.*;

public class PlotFrame extends javax.swing.JFrame {
    
    /** Creates new form PlotFrame
     * @param data */
    public PlotFrame(Data data) {
        super("Output");
        try {
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            plotpanel = new PlotPanel(data);
            this.add(plotpanel);
            this.pack();
        } catch (Exception e){
            if (Data.debugmode){e.printStackTrace(System.out);}
        }
    }

    public Plot getPlot() throws Exception {
        return plotpanel.getPlot();
    }

    public void refresh(Data data) throws Exception {
        plotpanel.refresh(data);
        this.pack();
    }

    public PlotPanel getPlotPanel(){
        return this.plotpanel;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    protected PlotPanel plotpanel;
}