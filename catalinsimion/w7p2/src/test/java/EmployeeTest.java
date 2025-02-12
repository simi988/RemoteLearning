import com.iquestgroup.remotelearning.domain.Employee;
import com.iquestgroup.remotelearning.domain.Engine;
import com.iquestgroup.remotelearning.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.exception.UnauthorizedEmployeeException;
import com.iquestgroup.remotelearning.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.factory.EngineFactory;
import com.iquestgroup.remotelearning.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    EmployeeService employeeServiceMock = niceMock(EmployeeService.class);
    private EngineFactory engineFactory;
    private Employee employeeOne;
    private Employee employeeTwo;
    private Employee employeeThird;
    private Employee employeeFour;

    @Before
    public void setUp() {

        engineFactory = new EngineFactory(employeeServiceMock);
        employeeOne = new Employee("John");
        employeeTwo = new Employee("Daniel");
        employeeThird = new Employee("Michel");
        employeeFour = new Employee("Bond");
    }



    @Test(expected = NullPointerException.class)
    public void testForEngineFactoryObjectShouldThrowException() {
        expect(engineFactory.manufactureEngines(3, null)).andStubThrow(new NullPointerException());
        replay(engineFactory);
        engineFactory.manufactureEngines(3, null);
        verify(engineFactory);

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
        EmployeeMatcher employeeMatcher = new EmployeeMatcher(engines);
        employeeMatcher.matchesSafely(engine);
    }

    @Test(expected = UnqualifiedEmployeeException.class)
    public void testUnqualifiedEmployeeException() {
        expect(employeeServiceMock.isAssemblyLineWorker(employeeThird)).andReturn(false);
        replay(employeeServiceMock);
        EngineFactory engineFactory = new EngineFactory(employeeServiceMock);
        Exception exception = null;
        engineFactory.manufactureEngines(2, employeeThird);
        verify(employeeServiceMock);
        assertEquals(UnqualifiedEmployeeException.class, exception.getClass());
    }

    @Test(expected = UnauthorizedEmployeeException.class)
    public void testUnauthorizedEmployeeException() {
        expect(employeeServiceMock.isAdministrator(employeeOne)).andStubThrow(new UnauthorizedEmployeeException("not authorized"));
        replay(employeeServiceMock);
        employeeServiceMock.isAdministrator(employeeOne);
        verify(employeeServiceMock);
    }
}
