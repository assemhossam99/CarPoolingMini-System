package carpooling_package;

public class Ticket
{
    private int carID;
    private int price;
    
    /**
     * A method that assign the id value to the car ID variable
     * @param id 
     */
    public void SetCarID(int id)
    {
        carID = id;
    }
    
    /**
     * A method that assigns the price of the ticket to the price variable
     * @param price 
     */
    public void SetPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * A method that returns the ID of the car
     * @return 
     */
    public int getCarID()
    {
        return this.carID;
    }
    
    /**
     * A method that returns the Price of the ticket
     * @return 
     */
    public int getPrice()
    {
        return this.price;
    }
}