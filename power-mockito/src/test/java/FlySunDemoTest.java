import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * 如果你的测试用例里没有使用注解@PrepareForTest，
 * 那么可以不用加注解@RunWith(PowerMockRunner.class)，
 * 反之亦然。
 */
//告诉JUnit使用PowerMockRunner进行测试
@RunWith(PowerMockRunner.class)
public class FlySunDemoTest {
    //将@Mock注解的示例注入进来
    @InjectMocks
    private Object object;

    //
    @Mock
    private Object object1;

    /**
     *普通Mock： Mock参数传递的对象
     */
    @Test
    public void callArgumentInstanceTest(){
        File file = PowerMockito.mock(File.class);
        FlySunDemo demo = new FlySunDemo();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(demo.callArgumentInstance(file));
    }

    /**
     * Mock方法内部new出来的对象
     */
    @Test
    //所有需要测试的类列在此处，适用于模拟final类或有final, private, static, native方法的类
    @PrepareForTest(FlySunDemo.class)
    public void callArgumentInstanceTest2(){
        File file = PowerMockito.mock(File.class);
        try {
//            Mockito.anyString()
            PowerMockito.whenNew(File.class).withArguments(Mockito.anyString()).thenReturn(file);
            FlySunDemo demo = new FlySunDemo();
            PowerMockito.when(file.exists()).thenReturn(true);
            Assert.assertTrue(demo.callArgumentInstance("bbb"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Mock普通对象的final方法
     */
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testCallFinalMethod() {
        ClassDependency refer = PowerMockito.mock(ClassDependency.class);
        PowerMockito.when(refer.isAlive()).thenReturn(true);
        FlySunDemo demo = new FlySunDemo();
        Assert.assertTrue(demo.callFinalMethod(refer));
    }

    /**
     * Mock普通类的静态方法
     */
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testStaticMethod() {
        PowerMockito.mockStatic(ClassDependency.class);
        PowerMockito.when(ClassDependency.isAlive2()).thenReturn(true);
        FlySunDemo demo = new FlySunDemo();
        Assert.assertTrue(demo.callStaticMethod());
    }

    /**
     *  Mock 私有方法
     * @throws Exception
     */
    @Test
    @PrepareForTest(FlySunDemo.class)
    public void testCallPrivateMethod() throws Exception {
        FlySunDemo demo = PowerMockito.mock(FlySunDemo.class);
        PowerMockito.when(demo.callPrivateMethod()).thenCallRealMethod();
        PowerMockito.when(demo, "isAlive").thenReturn(true);
        Assert.assertTrue(demo.callPrivateMethod());
    }

    /**
     * Mock系统类的静态和final方法
     */
    @Test
    @PrepareForTest(FlySunDemo.class)
    public void testCallSystemStaticMethod(){
        FlySunDemo demo = new FlySunDemo();
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        Assert.assertEquals("bbb", demo.callSystemStaticMethod("aaa"));
    }

}
