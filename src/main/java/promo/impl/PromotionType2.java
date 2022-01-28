package promo.impl;


import promo.ProductUnit;
import promo.PromotionType;

import java.util.List;

/**
 * Second Promotion Type
 * buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 )
 */
public class PromotionType2 implements PromotionType {
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

        double totalA = countA * ProductUnit.A.getPrice();
        double totalB = countB * ProductUnit.B.getPrice();
        int min  = Math.min(countC,countD);
        double totalOfCD = min * 30 ;
        if(countC-min>0){
            totalOfCD += (countC-min) * ProductUnit.C.getPrice();
        }else if(countD-min>0) {
            totalOfCD += (countD-min) * ProductUnit.D.getPrice();
        }

        return totalA + totalB + totalOfCD;

    }
}
