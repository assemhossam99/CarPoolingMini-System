package carpooling_package;

/** This class have all the information of each car and apply some functions
 * needed for reach car, like getting different information of a specific car.
 */
public class Car
{
    /**
     * A static integer to count the total number of car objects
     */
    private static int numberOfCars = 0;
    /**
     * The carID variable is final because it can't be changed
     */
    private final int carID;
    private int tripsPerDay;
    private Route route;
    private int capacity;
    private String driverName;
    
    /**
     * This constructor takes only the car id, if it will just register
     * @param id 
     */
    public Car(int id)
    {
        numberOfCars += 1;
        this.carID = id;
    }
    
    /**
     * This constructor have all the needed information about a car to start 
     * making trips
     * @param carID
     * @param tripsPerDay
     * @param route
     * @param capacity
     * @param driverName 
     */
    public Car(int carID, int tripsPerDay, Route route, int capacity, String driverName)
    {
        numberOfCars += 1;
        this.carID = carID;
        this.tripsPerDay = tripsPerDay;
        this.driverName = driverName;
        this.route = route;
        this.capacity = capacity;
    }
    
    /**
     * A static function to return the total number of car objects
     * @return 
     */
    public static int getTotalNumberOfCars()
    {
        return numberOfCars;
    }
    
    /**
     * A function that returns the starting point of the route the car will
     * have its trip on
     * @return 
     */
    public String getStartPoint()
    {
        return route.getStart();
    }
    
    /**
     * A function that returns the end point of the route the car will
     * have its trip on
     * @return 
     */
    public String getEndPoint()
    {
        return route.getEnd();
    }
    
    /**
     * A function that returns the total left seat in a car
     * @return 
     */
    public int getCapcaity()
    {
        return capacity;
    }
    
    /**
     * A function that returns the car ID
     * @return 
     */
    public int getCarID()
    {
        return carID;
    }
    
    /**
     * A function returns the driver name of the car
     * @return 
     */
    public String getDreiverName()
    {
        return driverName;
    }
    
    /**
     * A function to decrease the capacity of the car when someone successfully
     * reserve a trip on it
     */
    public void decCapacity()
    {
        capacity -= 1;
    }
}
