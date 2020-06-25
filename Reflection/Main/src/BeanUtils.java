import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BeanUtils {

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        HashMap<Method, Method> map = new HashMap<>();
        map = getCorrMethods(to, from);
        for (Method methodFrom : map.keySet()) {
            map.get(methodFrom).invoke(to, methodFrom.invoke(from));
        }
    }

    public static HashMap<Method, Method> getCorrMethods(Object to, Object from) {

        HashMap<Method, Method> methods = new HashMap<>();
        Method[] methodsfrom = from.getClass().getMethods();
        Method[] methodsTo = to.getClass().getMethods();

        for (Method methodFrom : methodsfrom) {

            String nameMethodFrom = methodFrom.getName();

            if (nameMethodFrom.startsWith("get") && !nameMethodFrom.equals("getClass")) {

                for (Method methodTo : methodsTo) {

                    String nameMethodTo = methodTo.getName();

                    if (nameMethodTo.startsWith("set")) {

                        if (methodFrom.getReturnType().equals(methodTo.getParameterTypes()[0])) {

                            if (nameMethodFrom.substring(3).equals(nameMethodTo.substring(3))) {
                                methods.put(methodFrom, methodTo);
                            }
                        }
                    }
                }
            }
        }
        return methods;
    }
}
