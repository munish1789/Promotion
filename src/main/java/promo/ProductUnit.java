package promo;

/**
 * This will provide manageability in future when new SKU products are added. Extensible
 */
public enum ProductUnit {

    A("A",50),
    B("B",30),
    C("C",20),
    D("D",15);

    private final String name ;
    private final double price ;


    ProductUnit(String name , double price){
        this.name= name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


}
