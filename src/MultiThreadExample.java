import com.example.singletonpattern.multithread.ThreadSafeUpgradeSingleton;
import com.example.singletonpattern.singlethread.LazyInitializedSingleton;

public class MultiThreadExample {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 5; i++) {
            final int value = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance(value);
                    instance.showMessage();
                }
            });
        }

        for (int i = 5; i < 10; i++) {
            final int value = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadSafeUpgradeSingleton instance = ThreadSafeUpgradeSingleton.getInstance(value);
                    instance.showMessage();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("End of main thread!");
    }
}
