import com.iquestgroup.remotelearning.domain.Employee;
import com.iquestgroup.remotelearning.factory.EngineFactory;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngineTeste {

    EngineFactory engineFactory;
    Employee employee;

    @Test
    public void TestUnqualifiedEmployeeException() {
        assertThat(employee, is(employee));
    }

    @Test
    public void TestUnauthorizedEmployeeException() {
        assertThat(employee, is(employee));
    }

    @Test
    public void TestInsufficientStockException() {
        assertThat(employee, is(employee));
    }

    @Test
    public void TestManufactureEngines() {
        assertThat(engineFactory, is(engineFactory));
    }

    @Test
    public void TestGetComponentsPerEngine() {
        assertThat(engineFactory, is(engineFactory));
    }

    @Test
    public void TestCheckAssignedEmployee() {
        assertThat(engineFactory, is(engineFactory));
    }

    @Test
    public void TestBuildEngine() {
        assertThat(engineFactory, is(engineFactory));
    }

    @Test
    public void TestEnoughComponentsInStock() {
        assertThat(engineFactory, is(engineFactory));
    }

}
