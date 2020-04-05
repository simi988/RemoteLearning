import org.junit.Test;
import w6p3.file.ObjectType;

import static org.junit.Assert.assertEquals;
import static w6p3.file.Factory.createObject;

public class ClassLoaderTest {

    @Test
    public void testLoaded() {
        String loaded = createObject(ObjectType.LOADED).getName();
        assertEquals(loaded, "MyClass");
    }

    @Test(expected = ClassCastException.class)
    public void testReloaded() {
        createObject(ObjectType.RELOADED).getName();
    }

    @Test
    public void testSubClass() {
        String loaded = createObject(ObjectType.SUBCLASS).getName();
        assertEquals(loaded, "MySubClass");
    }
}
