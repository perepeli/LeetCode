import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();

        System.out.println('a' + 1);

    }
}


class Singleton {

    private Singleton() {}

    private static class SingletonHelper {
        private static final Singleton uniqueInstance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.uniqueInstance;
    }
}




