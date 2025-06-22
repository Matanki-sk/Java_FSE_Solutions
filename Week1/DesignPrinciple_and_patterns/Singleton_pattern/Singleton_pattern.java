public class Singleton_pattern{

    // Singleton Logger class
    static class Logger{
        private static Logger instance;

        private Logger(){
            System.out.println("Logger initialized.");
        }
        public static Logger getInstance(){
            if(instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        public void log(String message){
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton pattern
    public static void main(String[] args){
        // Accessing the Singleton Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first message");
        logger2.log("This is the second message");

        if(logger1 == logger2){
            System.out.println("Both logger1 and logger2 are same");
        } 
        else{
            System.out.println("Different instances exist");
        }
    }
}
