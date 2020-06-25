public class Main {
    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        /*
        int count = map.getCount(5); // 2
        int count = map.getCount(6); // 1
        int count = map.getCount(10); // 3*/
    }
}
