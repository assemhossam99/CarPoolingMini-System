package carpooling_package;

import java.util.ArrayList;

/**
 * This interface have the main functionalities that the passenger will need to do, the class "Passenger" is implementing this interface, to apply the functions in it.
 * @author tabarak
 */
interface PassengerFunctionalities
{
    /**
     * Declaration of a boolean abstract method that search for a route that expected to be overriden in the
     * child methods
     * @param list
     * @param start
     * @param end
     * @return 
     */
    public abstract boolean SearchRoute(ArrayList<Route> list, String start, String end);
    /**
     * Declaration of an abstract method that allow passenger to add new review that expected to be overriden in the
     * child methods
     * @param review 
     */
    public abstract void AddReview(String review);
    /**
     * Declaration of an abstract method that allow passenger to add new complain that expected to be overriden in the
     * child methods
     * @param report
     */
    public abstract void AddReport(String report);
}