/*
 * ColourBanner.java
 *
 * Created on 03 June 2008, 16:11
 */

package RadialPlotter;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author  pvermees
 */
public class ColourBanner extends javax.swing.JPanel {
    
    /** Creates new form ColourBanner
     * @param plot
     * @throws java.lang.Exception */
    public ColourBanner(RadialPlot plot) throws Exception {
        initComponents();
        this.plot = plot;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            this.fillTheBanner(g);
        } catch (Exception e){
            if (Data.debugmode){e.printStackTrace(System.out);}
        }
    }

    public void setDefaults() throws Exception {
        plot.data.preferences.minbarcolour(Preferences.MINBARCOLOUR);
        plot.data.preferences.maxbarcolour(Preferences.MAXBARCOLOUR);
        plot.getColourScale().initColours();
        this.repaint();
    }
    
    private void fillTheBanner(Graphics g) throws Exception {
        Color c;
        int[][] colours = plot.getColourScale().getColours();
        int x = 0,
            numcolours = plot.getColourScale().getNumColours(),
            w = (int)(this.getWidth()/numcolours),
            h = (int)(this.getHeight());
        for (int i=0; i<numcolours; i++){
            c = new Color(colours[0][i],colours[1][i],colours[2][i]);
            g.setColor(c);
            g.fillRect(x, 0, w, h);
            x += w;
            if (i+1<numcolours){
                w = (int)((this.getWidth()-x)/(numcolours-i-1));
            }
        }
        g.setColor(Color.BLACK);
        w = (int)(this.getWidth());
        g.drawRect(0,0,w,h);
    }
    
    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 238, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 31, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    RadialPlot plot;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
