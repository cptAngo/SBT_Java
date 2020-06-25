import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // doRun(arg -> arg.length() + 10);
    }
}


    //private static void doRun(Function function) {
      //  function.doAction("Hello");
    //}

    private static List<Field> collectcFields(Class<?> class, String suffix) {
        List<Field> result = new ArrayList<>();
        Class<Object> clazz;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.getName().startsWith(suffix)) {
                result.add(field);
            }
        }
        return result;
    }

    private static<T extends Member