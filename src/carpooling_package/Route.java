package carpooling_package;

/**
 * This class holds all needed information of different routes which mainly are
 * the starting point and the ending point of each route.
 */
public class Route
{
    /**
     * A static variables that count the total number of the Route object
     */
    private static int numberOfRoutes = 0; 
    private String start;
    private String end;
    
    /**
     * A constructor that stores the needed data of the new route objects
     * @param start
     * @param end 
     */
    public Route(String start, String end)
    {
        numberOfRoutes += 1;
        this.start = start;
        this.end = end;
    }
    
    /**
     * A static functions that returns the total number of routes
     * @return 
     */
    public static int getTotalNumberOfRoutes()
    {
        return numberOfRoutes;
    }

    /**
     * A method that returns the start point of the route
     * @return 
     */
    public String getStart()
    {
        return start;
    }

    /**
     * A method that returns the end point of the route
     * @return 
     */
    public String getEnd()
    {
        return end;
    }
}