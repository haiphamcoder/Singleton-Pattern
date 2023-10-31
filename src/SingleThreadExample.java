import com.example.singletonpattern.singlethread.LazyInitializedSingleton;

public class SingleThreadExample {
    public static void main(String[] args) throws Exception {
        LazyInitializedSingleton instance1 = LazyInitializedSingleton.getInstance(10);
        instance1.showMessage();
    }
}
