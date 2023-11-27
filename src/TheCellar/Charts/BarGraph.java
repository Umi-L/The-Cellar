package TheCellar.Charts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// BarGraph class
// maybe change Y axis to be vertical
// https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java

public class BarGraph extends JPanel {
    protected ArrayList<Double> values;
    protected ArrayList<String> labels;

    protected String yAxis;

    private final int bgValue = 220;
    protected Color backgroundColor = new Color(bgValue, bgValue, bgValue, 255);

    public BarGraph(String yAxis, ArrayList<String > labels, ArrayList<Double> values) {
        this.yAxis = yAxis;

        this.labels = labels;
        this.values = values;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int x = 0;
        int y = 0;

        int padding = 25;
        int barPadding = 5;
        int numYLabels = 5;

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


        for (int i = 0; i < values.size(); i++) {
            // for each value, draw a bar
            double value = values.get(i);

            // get bar width as a fraction of the width of the graph given the number of values
            double barWidth = (bounds.width - 2*padding) / values.size() - barPadding*2;

            // get bar height as a fraction of the height of the graph given the max value
            double barHeight = (bounds.height - 2*padding) * (value / max);

            // get x position of bar
            x = (int) (padding + barWidth * i) + ((barPadding*2)*(i+1));

            // get y position of bar
            y = (int) Math.round(bounds.height - padding - barHeight);

            g2.setColor(Color.gray);

            // draw bar
            g2.fillRect(x, y, (int) barWidth, (int) barHeight);

            g2.setColor(Color.black);

            // draw label
            g2.drawString(labels.get(i), x, bounds.height - padding + 20);
        }

        // draw y axis labels
        for (int i = 0; i < numYLabels; i++) {
            // value is the percentage of the max value that the label represents
            double value = max * ((double) i / (double) numYLabels);

            // get y position of label
            y = (int) Math.round(bounds.height - padding - (bounds.height - 2*padding) * (value / max));

            String label = Integer.toString((int) value);

            // draw label
            g2.drawString(label, 0, y);
        }
    }
}
