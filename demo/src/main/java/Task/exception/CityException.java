package Task.exception;

public class CityException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CityException(String message) {
        super(message);
    }

    public static String NotFoundException(String city) {
        return "city with "+city+" not found!";
    }

}
