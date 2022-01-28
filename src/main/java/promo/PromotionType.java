package main.java.promo;

import java.util.List;

public interface PromotionType {

    /**
     * This will have Logic to calculate amount based on type of PromotionType
     * @param units
     * @return
     */
    public double calculateValue(List<ProductUnit> units);
}
