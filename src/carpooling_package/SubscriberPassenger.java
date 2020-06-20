package carpooling_package;

/**
 * This class extends the Passenger class, that's because subscriber passenger
 * is a passenger having some more functions, the class has some overriden
 * functions from and some of its own functions
 */
public class SubscriberPassenger extends Passenger
{
    /**
     * An empty constructor
     */
    public SubscriberPassenger()
    {
        numberOfPassengers += 1;
    }
    
    /**
     * A constructor that overload the empty constructor and store the needed
     * data of the passenger
     * @param id
     * @param age
     * @param trips
     * @throws newException 
     */
    public SubscriberPassenger (int id, int age, int trips)throws newException
    {
        if(age < 0)
            throw new newException("The age can't be negative value!");
        numberOfPassengers += 1;
        this.age = age;
        this.ID = id; // passenger id
        this.NumberOfReservedTrips = trips;
        this.subscriber = true;
    }
    
    /**
     * A method that overrides the one in the parent class Passenger, this
     * method is responsible for reserving a ticket on a car for a passenger
     * who is a subscriber
     * @param carID
     * @return 
     */
    @Override
    public boolean getTicket(int carID)
    {
        if(this.NumberOfReservedTrips > 0)
        {
            NumberOfReservedTrips -= 1;
            Ticket t = new Ticket();
            t.SetPrice(50);
            t.SetCarID(carID);
            this.tickets.add(t);
            return true;
        }
        else
        {
            System.out.println("You need to reserve trip to your account first to reserve using the discount");
            return false;
        }
    }
    
    /**
     * A method that overrides the one in the parent class Passenger, this
     * method is responsible for making the passenger subscribe an offer
     * @param TripsToBeReserved
     * @return 
     */
    @Override
    public boolean subscribe(int TripsToBeReserved)
    {
        if(age > 18 && TripsToBeReserved >= 5)
        {
            System.out.println("You subscribed successfully");
            this.NumberOfReservedTrips += TripsToBeReserved;
            return true;
        }
        else
        {
            System.out.println("Sorry, You can't use this subscription");
            return false;
        }
    }
    
}
