package TheCellar.Charts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LineGraph  extends JPanel {
    ArrayList<String> labels;
    ArrayList<Double> values;

    public LineGraph(ArrayList<String> labels, ArrayList<Double> values) {
        this.labels = labels;
        this.values = values;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;

        int padding = 2;

        // get max value in values
        double max = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
            }
        }

        // draw y axis as large as within bounds
        Rectangle bounds = this.getBounds();

        // draw y axis
        g2.drawLine(padding, padding, padding, bounds.height - padding);

        // draw x axis
        g2.drawLine(padding, bounds.height - padding, bounds.width - padding, bounds.height - padding);

        for (int i = 0; i < values.size(); i++) {
            // calculate next point
            x = (int) (padding + (bounds.width - 100) * ((double) i / (double) values.size()));
            y = (int) (bounds.height - padding - (bounds.height - 100) * (values.get(i) / max));

            // draw point
            g2.fillOval(x - 2, y - 2, 4, 4);

            // draw line
            if (i != 0) {
                // get previous point
                int prevX = (int) (padding + (bounds.width - 100) * ((double) (i - 1) / (double) values.size()));
                int prevY = (int) (bounds.height - padding - (bounds.height - 100) * (values.get(i - 1) / max));

                g2.drawLine(prevX, prevY, x, y);
            }

            // draw label
            g2.drawString(labels.get(i), x, y);

            // draw value
            g2.drawString(values.get(i).toString(), x, y + 20);


        }
    }
}
