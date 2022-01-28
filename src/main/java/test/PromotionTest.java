package test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import promo.PromotionService;
import promo.PromotionType;
import promo.impl.PromotionType1;
import   org.junit.platform.commons.JUnitException;

public class PromotionTest {

    @ParameterizedTest
    @CsvSource({"ABC,100",
            "AAAAABBBBBC,370",
            "AAABBBBBD,265"})
    public void test2(ArgumentsAccessor argumentsAccessor){

        PromotionType promotionType = new PromotionType1();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertEquals(argumentsAccessor.getDouble(1), service.applyPromotion(argumentsAccessor.getString(0)));
    }

}
