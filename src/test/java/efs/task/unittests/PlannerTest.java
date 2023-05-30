package efs.task.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlannerTest {

    private Planner plan;

    @BeforeEach
    void initializate(){
        plan = new Planner();
    }

    @Test
    void shouldCalculateDailyCaloriesDemand(){
        for(ActivityLevel lvl : ActivityLevel.values()){
            int correct = TestConstants.CALORIES_ON_ACTIVITY_LEVEL.get(lvl);
            int calculated = plan.calculateDailyCaloriesDemand(TestConstants.TEST_USER,lvl);
            assertEquals(correct, calculated);
        }
    }
    @Test
    void shouldCalculateDailyIntakeForTEST_USER(){
        DailyIntake correct = TestConstants.TEST_USER_DAILY_INTAKE;
        DailyIntake calculated = plan.calculateDailyIntake(TestConstants.TEST_USER);
        assertEquals(correct.getCalories(), calculated.getCalories());
        assertEquals(correct.getCarbohydrate(), calculated.getCarbohydrate());
        assertEquals(correct.getFat(), calculated.getFat());
        assertEquals(correct.getProtein(), calculated.getProtein());
    }
}
