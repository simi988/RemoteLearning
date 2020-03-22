import com.iquestgroup.remotelearning.domain.Employee;
import com.iquestgroup.remotelearning.domain.Engine;
import com.iquestgroup.remotelearning.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.factory.EngineFactory;
import com.iquestgroup.remotelearning.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private EngineFactory engineFactory;
    private EmployeeService employeeService;

    private Employee employeeOne;
    private Employee employeeTwo;
    private Employee employeeThird;
    private Employee employeeFour;

    @Before
    public void setUp() {

        engineFactory = new EngineFactory(employeeService);
        employeeOne = new Employee("John");
        employeeTwo = new Employee("Daniel");
        employeeThird = new Employee("Michel");
        employeeFour = new Employee("Bond");
    }
    EmployeeService employeeServiceMock = niceMock(EmployeeService.class);
    EngineFactory engineFactoryMock = niceMock(EngineFactory.class);

    @Test
    public void testForEngineFactoryObjectShouldThrowException() {
        expect(engineFactoryMock.manufactureEngines(3, null)).andStubThrow(new NullPointerException());
        replay(engineFactoryMock);
        Exception expectedException = null;
        try {
            engineFactoryMock.manufactureEngines(3, null);
        } catch (Exception ex) {
            expectedException = ex;
        }
        verify(engineFactoryMock);
        assertEquals(NullPointerException.class, expectedException.getClass());
    }

    @Test
    public void testReturnForManufactureEngineMethod() {
        expect(employeeServiceMock.isAssemblyLineWorker(employeeTwo)).andReturn(true);
        replay(employeeServiceMock);
        EngineFactory engineFactory = new EngineFactory(employeeServiceMock);
        int numberOfEngines = 3;
        List<Engine> engines = engineFactory.manufactureEngines(numberOfEngines, employeeTwo);
        Engine engine = new Engine(EngineArchitecture.L4, 2.0, 210);
        verify(employeeServiceMock);
        assertEquals(engines.size(), numberOfEngines);
        assertEquals(engines.get(0).getEngineArchitecture(), engine.getEngineArchitecture());
        assertEquals(engines.get(0).getDisplacement(), engine.getDisplacement(), 0);
        assertEquals(engines.get(0).getHorsePower(), engine.getHorsePower());
    }

    @Test
    public void testUnqualifiedEmployeeException() {
        expect(employeeServiceMock.isAssemblyLineWorker(employeeThird)).andReturn(false);
        replay(employeeServiceMock);
        EngineFactory engineFactory = new EngineFactory(employeeServiceMock);
        Exception exception = null;
        try {
            engineFactory.manufactureEngines(2, employeeThird);

        } catch (Exception ex) {
            exception = ex;
        }
        verify(employeeServiceMock);
        assertEquals(UnqualifiedEmployeeException.class, exception.getClass());
    }
}
