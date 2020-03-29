import com.iquestgroup.remotelearning.domain.Employee;

import static org.junit.Assert.assertEquals;

public class EmployeeMatcher  {
    Employee giveEmployee;
    public EmployeeMatcher(Employee giveEmployee){
        this.giveEmployee=giveEmployee;
    }

    protected void matchesSafely(String name) {
        assertEquals(giveEmployee.getName(),name);
    }
}
