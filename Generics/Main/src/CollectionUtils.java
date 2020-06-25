import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> list = new ArrayList<>(source.subList(0, size));
        return list;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> range = new ArrayList<>();
        for (T e : list) {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0) {
                range.add(e);
            }
        }
        return range;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> range = new ArrayList<>();
        for (T e : list) {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0) {
                range.add(e);
            }
        }
        return range;
    }
}
