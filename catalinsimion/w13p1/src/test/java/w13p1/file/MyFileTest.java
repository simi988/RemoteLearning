package w13p1.file;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyFileTest {

    @Test
    public void readLambdaTest(){
            MyFile myFile=new MyFile();
            File file = new File(MyFileTest.class.getClassLoader().getResource("").getFile());
            List<String> actualFile = myFile.readLambda(file);
            List<String> expectedFile= Arrays.asList("test1","test2","w13p1");
            assertEquals(3,actualFile.size());
            assertEquals(expectedFile,actualFile);
        }
    @Test
    public void readAnonymousTest(){
        MyFile myFile=new MyFile();
        File file = new File(MyFileTest.class.getClassLoader().getResource("").getFile());
        List<String> actualFile = myFile.readAnonymous(file);
        List<String> expectedFile= Arrays.asList("test1","test2","w13p1");
        assertEquals(3,actualFile.size());
        assertEquals(expectedFile,actualFile);
    }
}
