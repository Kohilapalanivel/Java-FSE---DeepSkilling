public class TestSingleton {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        logger1.log("First message");
        logger2.log("Second message");
        logger3.log("Third message");
        System.out.println("\nChecking instances:");
        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());
        System.out.println("logger3 hashcode: " + logger3.hashCode());
        System.out.println("\nAre all instances same? " +(logger1 == logger2 && logger2 == logger3));
    }
}
