import java.util.concurrent.Callable;

public class Task1 {
    public static void main(String[] args) {
//        TaskMain main = new TaskMain();

        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("CALLED");
                Thread.sleep(500);
                //throw new RuntimeException("!!!");
                return 10;
            }
        };
        Task<Integer> t = new Task<>(c);
        for (int i = 0; i < 11; i++) {
            Thread tr = new Thread(() -> {
                try {
                    System.out.println(t.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            tr.start();
        }
    }
}
