import com.iquestgroup.remotelearning.domain.Employee;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class EmployeeTest {

    Employee employee;

    @Test
    public void TestUnqualifiedEmployeeException() {
        assertThat(employee, is(employee));
    }

    @Test
    public void TestUnauthorizedEmployeeException() {
        assertThat(employee, is(employee));
    }

}
