import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {
    private Map<E, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(E element) {
        if (map.containsKey(element)) {
            map.put(element, map.get(element) + 1);
        }
        else {
            map.put(element, 1);
        }
    }

    @Override
    public int getCount(E element) {
        if (map.containsKey(element)) {
            return map.get(element);
        }
        else {
            return 0;
        }
    }

    @Override
    public int remove(E element) {
        if (map.containsKey(element)) {
            Integer count = map.get(element);
            map.remove(element);
            return count;
        }
        else {
            return 0;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for (E element : source.toMap().keySet()) {
            this.add(element);
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return this.map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination.putAll(this.map);
    }
}
