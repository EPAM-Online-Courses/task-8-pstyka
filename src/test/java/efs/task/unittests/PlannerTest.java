package efs.task.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlannerTest {

    private Planner plan;

    @BeforeEach
    void initializate(){
        this.plan = new Planner();
    }

    @Test
    void shouldCalculateDailyCaloriesDemand(){
        ActivityLevel[] value = ActivityLevel.values();
        for(int i = 0; i < value.length; ++i) {
            ActivityLevel lvl = value[i];
            //given
            int correct = TestConstants.CALORIES_ON_ACTIVITY_LEVEL.get(lvl);
            //when
            int calculated = this.plan.calculateDailyCaloriesDemand(TestConstants.TEST_USER,lvl);
            //then
            assertEquals(correct, calculated);
        }
    }
    @Test
    void shouldCalculateDailyIntakeForTEST_USER(){
        //given
        DailyIntake correct = TestConstants.TEST_USER_DAILY_INTAKE;
        //when
        DailyIntake calculated = this.plan.calculateDailyIntake(TestConstants.TEST_USER);
        //then
        assertEquals(correct.getCalories(), calculated.getCalories());
        assertEquals(correct.getCarbohydrate(), calculated.getCarbohydrate());
        assertEquals(correct.getFat(), calculated.getFat());
        assertEquals(correct.getProtein(), calculated.getProtein());
    }
}
