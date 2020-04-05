import com.iquestgroup.remotelearning.domain.Employee;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class EmployeeMatcher extends TypeSafeMatcher<Employee> {
    Employee giveEmployee;

    public EmployeeMatcher(Employee giveEmployee) {
        this.giveEmployee = giveEmployee;
    }

    @Override
     protected boolean matchesSafely(Employee employee) {
            return giveEmployee.getName().equalsIgnoreCase(employee.getName());

    }

    @Override
    public void describeTo(Description description) {

    }
}

