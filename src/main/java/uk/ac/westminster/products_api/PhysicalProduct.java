// A PhysicalProduct IS-A Product because it inherits the name, id and price properties.
// A PhysicalProduct HAS-A weight and dimensions because these describe the physical item.


package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product  implements Discountable{

    // Fields
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    // 1. Empty no-argument constructor
    public PhysicalProduct() {

    }

    // 2. Full constructor
    public PhysicalProduct(long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    // 3. Getters
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + "| weightKg: " + getWeightKg();
    }

    @Override
    public void applyDiscount(double rate) {
        double cappedRate = Math.min(rate,0.20);
        discountedPrice = getPrice() * (1-cappedRate);

    }
    @Override
    public double getDiscountedPrice() {
       return  discountedPrice;
    }

}



