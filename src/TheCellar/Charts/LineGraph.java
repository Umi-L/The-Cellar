package TheCellar.Charts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// LineGraph class
// maybe change Y axis to be vertical
// https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java

public class LineGraph  extends JPanel {
    protected ArrayList<Double> values;

    protected String xAxis;
    protected String yAxis;

    private final int bgValue = 220;
    protected Color backgroundColor = new Color(bgValue, bgValue, bgValue, 255);

    public LineGraph(String xAxis, String yAxis, ArrayList<Double> values) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        this.values = values;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int x = 0;
        int y = 0;

        int padding = 20;
        int dotSize = 8;

        // get max value in values
        double max = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
            }
        }

        // draw y axis as large as within bounds
        Rectangle bounds = this.getBounds();

        // set color to light gray for background
        g2.setColor(backgroundColor);

        // draw background box
        g2.fillRect(padding, padding, bounds.width - 2*padding, bounds.height - 2*padding);

        // set color to black
        g2.setColor(Color.black);

        // draw y axis
        g2.drawLine(padding, padding, padding, bounds.height - padding);

        // draw y axis label
        g2.drawString(yAxis, padding, padding - 10);

        // draw x axis
        g2.drawLine(padding, bounds.height - padding, bounds.width - padding, bounds.height - padding);

        // draw x axis label
        g2.drawString(xAxis, bounds.width/2, bounds.height - padding + 20);


        for (int i = 0; i < values.size(); i++) {
            // x is bounds / values.size() * i
            x = (int) (padding + (bounds.width - 2*padding) * ((double) i / (double) values.size()));
            y = (int) (bounds.height - padding - (bounds.height - 2*padding) * (values.get(i) / max));

            g2.setColor(Color.gray);
            // draw line
            if (i != 0) {
                // get previous point
                int prevX = (int) (padding + (bounds.width - 2*padding) * ((double) (i - 1) / (double) values.size()));
                int prevY = (int) (bounds.height - padding - (bounds.height - 2*padding) * (values.get(i - 1) / max));

                g2.drawLine(prevX, prevY, x, y);
            }

            g2.setColor(Color.black);

            // draw point
            g2.fillOval(x - dotSize/2, y - dotSize/2, dotSize, dotSize);

            // draw value
            g2.drawString(values.get(i).toString(), x, y);
        }
    }
}
