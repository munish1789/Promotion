package test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import promo.PromotionService;
import promo.PromotionType;
import promo.impl.PromotionType1;
import   org.junit.platform.commons.JUnitException;
import promo.impl.PromotionType2;

/**
 * Test cases for TDD approach
 */
public class PromotionTest {

    @ParameterizedTest(name = "Testing Promotion type 1 Positive test cases")
    @CsvSource({"ABC,100",
            "ACB,100",
            "AAAAABBBBBC,370",
            "AAABBBBBD,265",
            "DBBAAABBB,265"})
    public void testType1Positive(ArgumentsAccessor argumentsAccessor){

        PromotionType promotionType = new PromotionType1();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertEquals(argumentsAccessor.getDouble(1), service.applyPromotion(argumentsAccessor.getString(0)));
    }


    @ParameterizedTest(name = "Testing Promotion type 1 Negative test cases")
    @ValueSource(strings = {"ABCDE", "X"})
    public void testType1Invalid(String input){

        PromotionType promotionType = new PromotionType1();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertThrows(RuntimeException.class, ()-> service.applyPromotion(input));
    }

    @ParameterizedTest(name = "Testing Promotion type 1 Null test cases")
    @NullSource
    @EmptySource
    public void testType1Null(String input){

        PromotionType promotionType = new PromotionType1();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertThrows(RuntimeException.class, ()-> service.applyPromotion(input));
    }

    @ParameterizedTest(name = "Testing Promotion type 2 Positive test cases")
    @CsvSource({"ABCD,110",
            "CDCD,60",
            "CCDD,60",
            "ABCDC,130",
            "ABCDCD,140"
    })
    public void test3(ArgumentsAccessor argumentsAccessor){

        PromotionType promotionType = new PromotionType2();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertEquals(argumentsAccessor.getDouble(1), service.applyPromotion(argumentsAccessor.getString(0)));
    }

    @ParameterizedTest(name = "Testing Promotion type 2 Negative test cases")
    @ValueSource(strings = {"ABCDE", "X"})
    public void testType2Invalid(String input){

        PromotionType promotionType = new PromotionType2();
        PromotionService service = new PromotionService(promotionType);

        Assertions.assertThrows(RuntimeException.class, ()-> service.applyPromotion(input));
    }

}
