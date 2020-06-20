package carpooling_package;

/**
 * This class extends the Passenger class, that's because unsubscriber passenger
 * is a passenger having some more functions, the class has some overriden
 * functions from and some of its own functions
 */
public class UnsubscriberPassenger extends Passenger
{
    /**
     * An empty constructor
     */
    public UnsubscriberPassenger()
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
    public UnsubscriberPassenger(int id, int age, int trips) throws newException
    {
        if(age < 0)
            throw new newException("The age can't be negative value!");
        numberOfPassengers += 1;
        this.age = age;
        this.ID = id; // passengeer ID
        this.NumberOfReservedTrips = trips;
        this.subscriber = false;
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
            this.NumberOfReservedTrips += TripsToBeReserved;
            return true;
        }
        else
        {
            System.out.println("Sorry, You can't use this subscription");
            return false;
        }
    }
    
    /**
     * A method that overrides the one in the parent class Passenger, this
     * method is responsible for reserving a ticket on a car for a passenger
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
        }
        else
        {
            Ticket t = new Ticket();
            t.SetPrice(100);
            t.SetCarID(carID);
            this.tickets.add(t);
        }
        return true;
    }
    
}