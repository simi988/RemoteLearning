import com.iquestgroup.remotelearning.domain.Employee;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class EmployeeMatcher extends TypeSafeMatcher<Employee> {
    Employee giveEmployee;
    public EmployeeMatcher(Employee giveEmployee){
        this.giveEmployee=giveEmployee;
    }

    protected boolean matchesSafely(Employee expectedEmployee) {
        if (giveEmployee.getName().equalsIgnoreCase(expectedEmployee.getName())){
            return true;
        }
        return false;
    }

    public void describeTo(Description description) {
    }
}
