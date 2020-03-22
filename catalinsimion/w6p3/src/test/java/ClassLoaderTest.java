import org.junit.Test;
import w6p3.file.Factory;

import static org.junit.Assert.assertEquals;
import static w6p3.file.Factory.createObject;

public class ClassLoaderTest {

    @Test
    public void testLoaded() {
        String loaded = createObject(Factory.ObjectType.LOADED).getName();
        assertEquals(loaded, "MyClass");
    }

    @Test(expected = ClassCastException.class)
    public void testReloaded() {
        createObject(Factory.ObjectType.RELOADED).getName();
    }

    @Test
    public void testSubClass() {
        String loaded = createObject(Factory.ObjectType.SUBCLASS).getName();
        assertEquals(loaded, "MySubClass");
    }
}
