package promo;

import java.util.List;

public interface PromotionType {

    /**
     * This will have Logic to calculate amount based on type of PromotionType
     * This will provide extensibility when new Promotion are to be added
     * @param units
     * @return
     */
    public double calculateValue(List<ProductUnit> units);
}
