import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        From from = new From(1, 2, 3);
        To to = new To(4,5,6);
        System.out.println(from.toString());
        System.out.println(to.toString());
        BeanUtils.assign(to, from);
        System.out.println(to.toString());
    }
}