package book_management.config;

import book_management.exception.BookIdException;
import book_management.exception.BookNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler({BookIdException.class})
    public String showBorrowError() {
        return "bookIdError";
    }

    @ExceptionHandler({BookNullException.class})
    public String showBookNullError() {
        return "bookNullError";
    }


}
