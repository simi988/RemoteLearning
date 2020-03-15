import org.junit.Test;
import w6p3.file.MyClassLoader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ClassLoaderTest extends MyClassLoader {

    MyClassLoader myClassLoader;


    @Test
    public void testClassIsNull() throws Exception {
        assertThat(myClassLoader, is(myClassLoader));
    }

    @Test
    public void testClassIsLoad() throws Exception {

        assertThat(myClassLoader, is(myClassLoader));
    }

    @Test
    public void testClassIsReload() throws Exception {

        assertThat(myClassLoader, is(myClassLoader));
    }

    @Test
    public void testClassIsLoadIsASubClass() throws Exception {

        assertThat(myClassLoader, is(myClassLoader));
    }


}

