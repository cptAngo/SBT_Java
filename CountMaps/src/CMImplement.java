import java.util.HashMap;
import java.util.Map;

public class CMImplement<O> implements CountMap<O>{

    private Map<O, Integer> map;

    public CMImplement(){
        this.map = new HashMap<>();
    }

    @Override
    public void add(O element) {
        if (map.containsKey(element))
            map.put(element, map.get(element) + 1);
        else
            map.put(element, 1);
    }

    @Override
    public int getCount(O element) {
        if (map.get(element) != null)
            return map.get(element);
        else
            return 0;
    }

    @Override
    public int remove(O element) {
        Integer count = map.get(element);
        map.remove(element);
        if (count != null)
            return count;
        else
            return 0;
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<O> source) {
        for (Map.Entry<O, Integer>entry:source.toMap().entrySet()){
            Integer count = entry.getValue();
            if (map.containsKey(entry)){
                map.put(entry.getKey(), map.get(entry) + count);
            }
            else
                map.put(entry.getKey(), count);
        }

    }

    @Override
    public Map<O, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<O, Integer> destination) {
        destination.putAll(map);
    }
}
