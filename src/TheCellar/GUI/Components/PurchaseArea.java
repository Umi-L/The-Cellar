package TheCellar.GUI.Components;

import javax.swing.*;

// class to abstract the purchase areas of the shop page

public class PurchaseArea extends JPanel {
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private boolean hasQuantity = false;

    private JButton purchaseButton;

    public PurchaseArea(String name, int price, String tooltip) {
        super();

        nameLabel = new JLabel(name);
        priceLabel = new JLabel("$" + price);

        purchaseButton = new JButton("Purchase");

        this.add(nameLabel);
        this.add(priceLabel);
        this.add(purchaseButton);

        this.setToolTipText(tooltip);
    }

    // owned
    public PurchaseArea(String name, String tooltip){
        super();

        nameLabel = new JLabel(name);
        priceLabel = new JLabel("Owned");

        this.add(nameLabel);
        this.add(priceLabel);

        this.setToolTipText(tooltip);
    }

    public PurchaseArea(String name, int price, int quantity, String tooltip) {
        super();

        nameLabel = new JLabel(name);
        priceLabel = new JLabel("$" + price);
        quantityLabel = new JLabel("x" + quantity);
        hasQuantity = true;

        purchaseButton = new JButton("Purchase");

        this.add(nameLabel);
        this.add(priceLabel);
        this.add(quantityLabel);
        this.add(purchaseButton);

        this.setToolTipText(tooltip);
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }
}
