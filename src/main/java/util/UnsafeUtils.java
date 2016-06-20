package util;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * The helper class for get unsafe instance
 */
public class UnsafeUtils {

    /**
     * Retrieve the unsafe instance, the direct method invocation will throw {@link SecurityException}
     */
    public static Unsafe getUnsafe() {
        try {

            // Retrieve the "theUnsafe" field
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");

            // set access
            unsafeField.setAccessible(true);

            return (Unsafe) unsafeField.get(null);

        } catch (IllegalArgumentException
                | SecurityException
                | NoSuchFieldException
                | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
