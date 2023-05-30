package efs.task.unittests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FitCalculatorTest {

    @Test
    void shouldReturnTrue_whenDietRecommended() {
        //given
        double weight = 89.2;
        double height = 1.72;

        //when
        boolean recommended = FitCalculator.isBMICorrect(weight, height);

        //then
        assertTrue(recommended);
    }
    @Test
    void shouldReturnFalse_whenDietRecommended() {
        //given
        double weight = 69.5;
        double height = 1.72;
        //when
        boolean recommended = FitCalculator.isBMICorrect(weight, height);
        //then
        assertFalse(recommended);

    }
    @Test
    void shouldThrowException_whenHeightIsZero(){
        //given
        double weight = 75.3;
        double height = 0.0;

        //then
        //assertThrows()
        assertThrows(IllegalArgumentException.class, () -> FitCalculator.isBMICorrect(weight,height));

    }
    @ParameterizedTest(name = "weight={0}")
    @ValueSource(doubles = {90.0, 85.0, 110.0})
    void shouldReturnTrue_whenDifferentWeights(double weight) {
        // given
        double height = 1.70;
        // when
        boolean recommended = FitCalculator.isBMICorrect(weight, height);
        // then
        assertTrue(recommended);
    }

    @ParameterizedTest(name = "height={0}, weight={1}")
    @CsvSource({
            "1.85, 82.3",
            "1.55, 40.0",
            "1.80, 75.1"
    })
    void shouldReturnFalse_forDifferentDATA(double height, double weight) {
        // when
        boolean recommended = FitCalculator.isBMICorrect(weight,height);
        // then
        assertFalse(recommended);
    }
    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void shouldReturnFalse_FromCSV(double height, double weight) {
        // when
        boolean recommended = FitCalculator.isBMICorrect(weight, height);

        // then
        assertFalse(recommended);
    }
    @Test
    void shouldReturnUserWithWorstBMI(){
        //given
        double height = 1.79;
        double weight = 97.3;
        List<User> test_users = TestConstants.TEST_USERS_LIST;
        //when
        User worstBmiUser = FitCalculator.findUserWithTheWorstBMI(test_users);
        //then
        assertEquals(weight, worstBmiUser.getWeight());
        assertEquals(height, worstBmiUser.getHeight());
    }
    @Test
    void shouldReturnNullForEmptyList(){
        //given
        List<User> empty_test_users = new ArrayList<>();
        //when
        User worstBmiUser = FitCalculator.findUserWithTheWorstBMI(empty_test_users);
        //then
        assertNull(worstBmiUser);
    }
    @Test
    void shouldBeEqualToTEST_USERS_BMI_SCORE(){
        //given
        List<User> test_users = TestConstants.TEST_USERS_LIST;
        double[] correct = TestConstants.TEST_USERS_BMI_SCORE;
        //when
        double[] calculated = FitCalculator.calculateBMIScore(test_users);
        //then
        assertArrayEquals(correct, calculated);
    }
}