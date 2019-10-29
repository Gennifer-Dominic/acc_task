package acc.acc_task.payload;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class filenotfound extends RuntimeException {
	
	 public filenotfound(String message) {
	        super(message);
	    }

	    public filenotfound(String message, Throwable cause) {
	        super(message, cause);
	    }

}
