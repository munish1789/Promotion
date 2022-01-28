package promo;

import java.util.ArrayList;
import java.util.List;

/**
 * PromotionService
 * Actual Api that will be exposing the Promotion engine functionality to end users.
 * @author Munish
 */

public class PromotionService {
    /**
     * type is used as class variable becasue it is mutually exclusive
     * For this coding exercise you can assume that the promotions will be mutually exclusive;
     */
    private PromotionType type;

    public PromotionService(PromotionType type){
        this.type = type;
    }
    public double applyPromotion(String input){
        return type.calculateValue(convertToProductUnits(input));
    }

    private List<ProductUnit> convertToProductUnits(String input) throws  RuntimeException{

        if(input.isEmpty())
            throw new RuntimeException("Input string is blank ");

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
