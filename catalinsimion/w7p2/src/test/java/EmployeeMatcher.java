import com.iquestgroup.remotelearning.domain.Engine;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class EmployeeMatcher extends TypeSafeMatcher<Engine> {
    List<Engine> engines;
    public EmployeeMatcher( List<Engine> engines){
        this.engines=engines;
    }



    @Override
    protected boolean matchesSafely(Engine engine) {
        int numberOfEngines=3;
        return engines.size()==(numberOfEngines)&&
                engines.get(0).getEngineArchitecture().equals(engine.getEngineArchitecture()) &&
                engines.get(0).getDisplacement()==(engine.getDisplacement()) &&
                engines.get(0).getHorsePower()==(engine.getHorsePower());
    }

    @Override
    public void describeTo(Description description) {

    }
}
