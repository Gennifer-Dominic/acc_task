package acc.acc_task.payload;

public class fileexception extends RuntimeException {
	
	public fileexception(String message) {
        super(message);
    }

    public fileexception(String message, Throwable cause) {
        super(message, cause);
    }

}
