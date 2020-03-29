import com.iquestgroup.remotelearning.domain.Engine;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeMatcher  {
    List<Engine> engines;
    public EmployeeMatcher( List<Engine> engines){
        this.engines=engines;
    }

    protected void matchesSafely(List<Engine> engines, int numberOfEngines,Engine engine) {
        assertEquals(engines.size(), numberOfEngines);
        assertEquals(engines.get(0).getEngineArchitecture(), engine.getEngineArchitecture());
        assertEquals(engines.get(0).getDisplacement(), engine.getDisplacement(),0);
        assertEquals(engines.get(0).getHorsePower(), engine.getHorsePower());

    }

}
