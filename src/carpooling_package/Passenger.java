package carpooling_package;
import java.util.ArrayList;

/**
 * This abstract class have almost all the functions that a passenger can do, and it
 * holds all the data of the passenger, including his information, his trips,
 * if he is a subscriber or not, and all the reviews and complains he has
 * submitted
 */
public abstract class Passenger implements PassengerFunctionalities
{
    /**
     * A static integer that counts the total number of passenger objects
     */
    protected static int numberOfPassengers = 0;
    protected int ID;
    protected int age;
    protected int NumberOfReservedTrips;
    protected boolean subscriber;
    /**
     * a static array list that stores all the reserved tickets by all passengers
     */
    protected static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private ArrayList<String> Reviews = new ArrayList<String>();
    private ArrayList<String> Reports = new ArrayList<String>();
    
    /**
     * A static function that returns the total number of Passengers
     * @return 
     */
    public static int getTotalBumberOfPassengers()
    {
        return numberOfPassengers;
    }
    
    /**
     * A boolean function that overrides the one in the interface 
     * PassengerFunctionalities that search for a route if it exists or not
     * @param list
     * @param start
     * @param end
     * @return 
     */
    @Override
    public boolean SearchRoute(ArrayList<Route> list, String start, String end)
    {
       for(int i = 0; i < list.size(); i++)
       {
           if(list.get(i).getStart().equals(start) && list.get(i).getEnd().equals(end))
               return true;
       }
       return false;
    }
    
    /**
     * A final method that overrides the one in the interface
     * PassengerFunctionalities to allow the user to add new review
     * @param review 
     */
    @Override
    public final void AddReview(String review)
    {
        Reviews.add(review);
    }
    
    /**
     * A final method that overrides the one in the interface
     * PassengerFunctionalities to allow the user to add new complain
     * @param report 
     */
    @Override
    public final void AddReport(String report)
    {
        Reports.add(report);
    }
    
    /**
     * A final method that gets all the reviews by the user
     */
    public final void getReports()
    {
        for(int i = 0; i < Reports.size(); i++)
        {
            System.out.println(Reports.get(i) + '\n');
        }
    }
    
    /**
     * A final method to get all the complains made by the user 
     */
    public final void getReviews()
    {
        for(int i = 0; i < Reviews.size(); i++)
        {
            System.out.println(Reviews.get(i));
        }
    }
    
    /**
     * A method that returns the passenger ID
     * @return 
     */
    public int getID()
    {
        return ID;
    }
    
    /**
     * A method returns the age of the passenger
     * @return 
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Method that returns the number the passenger is reserving
     * @return 
     */
    public int getReservedTrips()
    {
        return NumberOfReservedTrips;
    }
   
    /**
     * A method that display all the needed information about the passenger
     */
    public void PrintPassengerInfo()
    {
        System.out.println("Passenger ID is: " + ID);
        System.out.println("Passenger Age is: " + age);
        System.out.print("This Passenger is ");
        if(subscriber == true)
            System.out.print("subscribing ");
        else
            System.out.print("not subscribing ");
        System.out.println("one of the offers");
        System.out.println("This Passenger have " + NumberOfReservedTrips + " trips reserved");
        System.out.println("The reviews that the passenger submitted:");
        for(int i = 0; i < Reviews.size(); i++)
        {
            System.out.println((i + 1) + ". " + Reviews.get(i));
        }
        System.out.println("The reports that the passenger submitted:");
        for(int i = 0; i < Reports.size(); i++)
        {
            System.out.println((i + 1) + ". " + Reports.get(i));
        }
    }
    /**
     * A static method that displays all the reserved tickets by all passengers
     */
    public static void getTickets()
    {
        for(int i = 0; i < tickets.size(); i++)
        {
            System.out.println("This ticket is on car of ID " + tickets.get(i).getCarID() + ", and the trip price is " + tickets.get(i).getPrice());
        }
    }
    
    /**
     * Declaration of an abstract method that get the tickets of the passenger that expected to be overriden in the
     * child methods
     * @param carID
     * @return 
     */
    public abstract boolean getTicket(int carID);
    /**
     * Declaration of an abstract method that subscribe an offer that expected to be overriden in the
     * child methods
     * @param reipsToBeReserved
     * @return 
     */
    public abstract boolean subscribe(int reipsToBeReserved);
}