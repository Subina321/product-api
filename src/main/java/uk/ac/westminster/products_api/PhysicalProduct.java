// A PhysicalProduct IS-A Product because it inherits the name, id and price properties.
// A PhysicalProduct HAS-A weight and dimensions because these describe the physical item.


package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {

    // Fields
    private double weightKg;
    private String dimensions;

    // 1. Empty no-argument constructor
    public PhysicalProduct() {

    }

    // 2. Full constructor
    public PhysicalProduct(long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    // 3. Getters
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}