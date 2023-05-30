package efs.task.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlannerTest {
    private Planner plan;
    @BeforeEach
    void initializate(){
        plan = new Planner();
    }
    @ParameterizedTest
    @EnumSource(ActivityLevel.class)
    void checkDailyCaloriesDemand(ActivityLevel lvl){
        //given
        User test_user = TestConstants.TEST_USER;
        Map<ActivityLevel, Integer> CaloriesDemandOnLevel = TestConstants.CALORIES_ON_ACTIVITY_LEVEL;
        //when
        int calories = plan.calculateDailyCaloriesDemand(test_user, lvl);
        //then
        assertEquals(CaloriesDemandOnLevel.get(lvl),calories);

    }
    @Test
    void checkDailyIntakeForTEST_USER(){
        //given
        User test_user = TestConstants.TEST_USER;
        DailyIntake demand = TestConstants.TEST_USER_DAILY_INTAKE;
        //when
        DailyIntake calculate = plan.calculateDailyIntake(test_user);
        //then
        assertEquals(demand.getCalories(), calculate.getCalories());
        assertEquals(demand.getCarbohydrate(), calculate.getCarbohydrate());
        assertEquals(demand.getFat(), calculate.getFat());
        assertEquals(demand.getProtein(), calculate.getProtein());
    }
}
