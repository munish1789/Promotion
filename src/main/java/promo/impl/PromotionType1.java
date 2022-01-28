package promo.impl;


import promo.ProductUnit;
import promo.PromotionType;

import java.util.List;

/**
 * First Promotion Type where 3 A value is 130 and 2 B value is 45
 * 3 of A's for 130
 * 2 of B's for 45
 */
public class PromotionType1 implements PromotionType {
    @Override
    public double calculateValue(List<ProductUnit> units) {

        int countA=0;
        int countB=0;
        int countC=0;
        int countD=0;
        for(ProductUnit unit : units) {

            switch (unit) {
                case A:
                    countA++;
                    break;
                case B:
                    countB++;
                    break;
                case C:
                    countC++;
                    break;
                case D:
                    countD++;
                    break;
            }
        }
            double totalA = (countA / 3) * 130 + (countA % 3 * ProductUnit.A.getPrice());
            double totalB = (countB / 2) * 45 + (countA % 2 * ProductUnit.B.getPrice());
            double totalC = countC * ProductUnit.C.getPrice();
            double totalD = countD * ProductUnit.D.getPrice();

            return totalA + totalB + totalC + totalD;

    }
}
