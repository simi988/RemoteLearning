import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import w5p1.file.CustomException;
import w5p1.file.List;
import w5p1.file.StringList;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class MyListTest {
    
    private List<String> list;
    
    private Class<CustomException> exceptionType = CustomException.class;
    
    private String[] initData = {"12", "23", "34", "45"};
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.list = new StringList();
    }
    
    @Test
    public void testAddValuesToTheList() throws CustomException {
        initData();
    	assertEquals(initData.length, list.size());
        for (String data : initData) {
        	assertTrue(list.contains(data));
        }
    }

    private void initData() throws CustomException {
        for (String numberAsString : initData) {
            list.add(numberAsString);
        }
    }
    
    @Test
    public void testAddNonIntegerValue() throws CustomException {
        exception.expect(exceptionType);
        exception.expectMessage("Invalid number.");
        list.add("Hey, I'm not an integer.");
    }
    
    @Test
    public void testAddNonNullValue() throws CustomException {
        exception.expect(exceptionType);
        exception.expectMessage("Null");
        list.add(null);
    }
    
    @Test
    public void testIndexOutOfBounds() throws CustomException {
        initData();
        exception.expect(exceptionType);
        exception.expectMessage("Index out of bounds.");
        list.get(initData.length);
    }
}
