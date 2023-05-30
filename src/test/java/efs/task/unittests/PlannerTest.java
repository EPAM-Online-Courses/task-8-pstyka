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
        for(ActivityLevel lvl : ActivityLevel.values()){
            //then
            assertEquals(TestConstants.CALORIES_ON_ACTIVITY_LEVEL.get(lvl), this.plan.calculateDailyCaloriesDemand(TestConstants.TEST_USER,lvl));
        }
    }
    @Test
    void shouldCalculateDailyIntakeForTEST_USER(){
        
        //then
        assertEquals(TestConstants.TEST_USER_DAILY_INTAKE.getCalories(), this.plan.calculateDailyIntake(TestConstants.TEST_USER).getCalories());
        assertEquals(TestConstants.TEST_USER_DAILY_INTAKE.getCarbohydrate(), this.plan.calculateDailyIntake(TestConstants.TEST_USER).getCarbohydrate());
        assertEquals(TestConstants.TEST_USER_DAILY_INTAKE.getFat(), this.plan.calculateDailyIntake(TestConstants.TEST_USER).getFat());
        assertEquals(TestConstants.TEST_USER_DAILY_INTAKE.getProtein(), this.plan.calculateDailyIntake(TestConstants.TEST_USER).getProtein());
    }
}
