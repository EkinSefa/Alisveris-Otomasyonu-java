
package Model;

import javax.swing.Icon;


public class ModelItem {

    /**
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the ItemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param ItemName the ItemName to set
     */
    public void setItemName(String ItemName) {
        this.itemName = ItemName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the bradName
     */
    public String getBradName() {
        return brandName;
    }

    /**
     * @param bradName the bradName to set
     */
    public void setBradName(String bradName) {
        this.brandName = bradName;
    }

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
    }
      public ModelItem(int itemID, String itemName, String description, double price, String brandName, Icon image) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.brandName = brandName;
        this.image = image;
    }
    private int itemID;
    private String  itemName;
    private String description;
    private double price;
    private String brandName;
    private Icon image;
    
}
