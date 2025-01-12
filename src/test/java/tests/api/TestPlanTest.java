package tests.api;

import dto.CreatePlanRq;
import dto.CreatePlanRs;
import dto.UpdatePlanRq;
import dto.UpdatePlanRs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static adapters.TestPlanAPI.*;

public class TestPlanTest {
    private int id;

    @Test
    public void checkCreatePlan() {
        List<Integer> testCases = new ArrayList<>();
        testCases.add(4);
        CreatePlanRq rq = CreatePlanRq.builder()
                .title("My Plan")
                .description("Test description")
                .cases(testCases)
                .build();
        CreatePlanRs rs = createPlan(rq);
        id = rs.getResult().getId();
        Assert.assertEquals(rs.getResult().getId(), id);
    }

    @Test
    public void checkUpdatePlan() {
        List<Integer> testCases = new ArrayList<>();
        testCases.add(4);
        UpdatePlanRq rq = UpdatePlanRq.builder()
                .title("Test Plan")
                .description("Test")
                .cases(testCases)
                .build();
        UpdatePlanRs rs = updatePlan(rq, id);
        Assert.assertEquals(rs.getStatus(), true);
    }

    @Test
    public void checkDeletePlan() {
        deletePlan(id);
    }
}
