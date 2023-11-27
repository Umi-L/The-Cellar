package TheCellar.Charts;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class PieChart extends JPanel {

    ArrayList<String> labels;
    ArrayList<Double> values;

    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK, Color.GRAY, Color.BLACK};

	public PieChart(ArrayList<String> labels, ArrayList<Double> values) {
        this.labels = labels;
        this.values = values;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);

        Rectangle bounds = this.getBounds();

        // get smallest dimension
        int smallest = bounds.width;
        if (bounds.height < smallest) {
            smallest = bounds.height;
        }

        // make bounds square
        bounds.width = smallest;

        // make x and y centered
        bounds.x = (this.getWidth() - bounds.width) / 2;

        // make arc fill bounds
        arc.setFrame(bounds);

        double total = 0.0D;
        for (int i = 0; i < values.size(); i++) {
            total += values.get(i);
        }

        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < values.size(); i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (values.get(i) * 360 / total);

            arc.setAngleStart(startAngle);
            arc.setAngleExtent(arcAngle);
            curValue += values.get(i);

            g2.setColor(colors[i % colors.length]);

            g2.fill(arc);

            String name = labels.get(i);

            // draw the legend right justified
            g2.fillRect(bounds.x + bounds.width + 20, bounds.y + i * 20, 10, 10);
            g2.drawString(name, bounds.x + bounds.width + 40, bounds.y + i * 20 + 10);


        }
    }
}