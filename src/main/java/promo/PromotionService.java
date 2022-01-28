package main.java.promo;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    PromotionType type;

    public void PromotionService(PromotionType type){
        this.type = type;
    }
    public double applyPromotion(String input){
        return type.calculateValue(convertToProductUnits(input));
    }

    private List<ProductUnit> convertToProductUnits(String input) throws  RuntimeException{

        List<ProductUnit> units = new ArrayList<>();

        for(char c : input.toCharArray()){

            switch(String.valueOf(c).toUpperCase()){
                case("A"):
                    units.add(ProductUnit.A);
                    break;

                case("B"):
                    units.add(ProductUnit.B);
                    break;

                case("C"):
                    units.add(ProductUnit.C);
                    break;

                case("D"):
                    units.add(ProductUnit.D);
                    break;

                default:
                    throw new RuntimeException("Not a valid input");

            }
        }
        return units;
    }
}
