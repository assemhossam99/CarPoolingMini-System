package carpooling_package;

/**
 * This exception will be used to determine if the age of a new passenger is
 * negative value it will display an error message and will not create the
 * the new passenger
 * @author tabarak
 */
class newException extends Exception
{
    public newException(String message)
    {
        super(message);
    }
}