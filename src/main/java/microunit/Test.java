package microunit;

import java.lang.annotation.*;

/**
 * Indicates that the annotated method is intended to be a test method.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

    /**
     * The execution of the test method succeeds if and only if an exception
     * of this class is thrown.
     *
     * @return the class of the exception expected to be thrown
     */
    Class<? extends Throwable> expected() default None.class;

    /**
     * Represents that no exception are expected.
     */
    class None extends Throwable {}

}
