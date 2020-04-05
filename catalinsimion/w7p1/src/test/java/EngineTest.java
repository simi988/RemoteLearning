import com.iquestgroup.remotelearning.domain.Employee;
import com.iquestgroup.remotelearning.domain.Engine;
import com.iquestgroup.remotelearning.domain.EngineComponent;
import com.iquestgroup.remotelearning.exception.InsufficientStockException;
import com.iquestgroup.remotelearning.exception.UnauthorizedEmployeeException;
import com.iquestgroup.remotelearning.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.factory.EngineFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class EngineTest {

    private List<Employee> employee;
    private List<Engine> engines;
    private List<EngineComponent> engineComponents;
    private EngineFactory engineFactory;

    private EngineComponent piston;
    private EngineComponent valve;
    private EngineComponent engineBlock;
    private EngineComponent electromotive;

    private Employee employeeOne;
    private Employee employeeTwo;
    private Employee employeeThird;
    private Employee employeeFour;

    @Before
    public void setUp() {
        employee = new ArrayList<>();
        engineComponents = new ArrayList<>();
        engines = new ArrayList<>();
        employeeOne = new Employee("Michael", true, true);
        employeeTwo = new Employee("John", true, false);
        employeeThird = new Employee("Bond", false, true);
        employeeFour = new Employee("Stephan", false, true);

        piston = new EngineComponent("piston", 9.1);
        valve = new EngineComponent("valve", 4.7);
        engineBlock = new EngineComponent("engineBlock", 17.8);
        electromotive = new EngineComponent("electromotive", 13);

        employee.add(employeeTwo);
        employee.add(employeeThird);
        employee.add(employeeFour);

        engineComponents.add(piston);
        engineComponents.add(valve);
        engineComponents.add(engineBlock);
        engineComponents.add(electromotive);
        engineFactory = new EngineFactory(employee, engineComponents);

    }

    @Test(expected = UnauthorizedEmployeeException.class)
    public void TestUnauthorizedEmployeeException() {
        engineFactory.manufactureEngines(1, employeeOne);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void TestUnqualifiedEmployeeException() {
        engineFactory.manufactureEngines(1, employeeTwo);
    }

    @Test(expected = InsufficientStockException.class)
    public void TestInsufficientStockException() {
        engineFactory.manufactureEngines(2, employeeThird);
    }

    @Test
    public void TestManufactureEngines() {
        engines = engineFactory.manufactureEngines(1, employeeFour);
            assertTrue(!engines.isEmpty());
    }

    @Test
    public void TestGetComponentsPerEngine() {
        assertEquals(3, EngineFactory.getComponentsPerEngine());
    }

    @Test
    public void testEmployee() {
      assertThat(employeeOne,new EmployeeMatcher(employeeOne));
    }
}
