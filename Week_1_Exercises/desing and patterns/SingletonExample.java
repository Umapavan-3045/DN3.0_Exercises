class LogManager {
    private static LogManager uniqueInstance;

    private LogManager() {
        // Initialization
    }

    public static LogManager getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LogManager();
        }
        return uniqueInstance;
    }

    public void logMessage(String msg) {
        System.out.println("Log: " + msg);
    }
}

class SingletonExample {
    public static void main(String[] args) {
        LogManager log1 = LogManager.getUniqueInstance();
        log1.logMessage("This is the first log message.");

        LogManager log2 = LogManager.getUniqueInstance();
        log2.logMessage("This is the second log message.");

        if (log1 == log2) {
            System.out.println("Both log1 and log2 are the same instance.");
        } else {
            System.out.println("Logger instances are different.");
        }
    }
}
