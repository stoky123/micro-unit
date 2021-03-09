package microunit;

import example.ExampleTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class for running unit tests without support for expected exceptions
 */
public class BasicTestRunner extends TestRunner {

    /**
     * Creates a {@code BasicTestRunner} object for executing the test
     * methods of the class specified.
     *
     * @param testClass
     */
    public BasicTestRunner(Class<?> testClass) {
        super(testClass);
    }

    @Override
    public void runTestMethods() {
        try {
            int numberOfTests = 0, numberOfFailures = 0, numberOfErrors = 0;
            for (Method method : getAnnotatedMethods(Test.class)) {
                System.out.println(method);
                Object instance = testClass.getDeclaredConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof AssertionError) {
                        numberOfFailures++;
                    } else {
                        numberOfErrors++;
                    }
                }
                numberOfTests++;
            }
            System.out.printf("Number of tests: %d\n", numberOfTests);
            System.out.printf("Number of failures: %d\n", numberOfFailures);
            System.out.printf("Number of errors: %d", numberOfErrors);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BasicTestRunner(ExampleTest.class).runTestMethods();
    }

}
