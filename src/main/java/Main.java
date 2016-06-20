import bean.Student;
import sun.misc.Unsafe;
import util.UnsafeUtils;

/**
 * Created by Shannon,chen on 16/6/20.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setName("shannon");
        Unsafe unsafe = UnsafeUtils.getUnsafe();
        long nameOffSet = unsafe.objectFieldOffset(Student.class.getDeclaredField("name"));
        System.out.println("stunde name is " + unsafe.getObject(student, nameOffSet));
    }
}
