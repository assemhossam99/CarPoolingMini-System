package carpooling_package;

//import static carpooling_package.Passenger.numberOfPassengers;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;
import static carpooling_package.Passenger.numberOfPassengers;
import java.util.*;

public class CarPoolingMiniSystem
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // HardCode Data
        ArrayList<Route> routeArray = new ArrayList<Route>();
        routeArray.add(new Route("Maadi", "Dokki"));
        routeArray.add(new Route("Ain Shams", "Nasr city"));
        routeArray.add(new Route("Zamalek", "Abbasya"));
        routeArray.add(new Route("Nasr city", "Maadi"));
       
        ArrayList<Passenger> passengersArray = new ArrayList<Passenger>();
        try
        {
            passengersArray.add(new SubscriberPassenger(1000, 22, 0));
            passengersArray.add(new UnsubscriberPassenger(1001, 15, 0));
            passengersArray.add(new SubscriberPassenger(1002, 41, 0));
            passengersArray.add(new UnsubscriberPassenger(1003, 38, 0));
            passengersArray.add(new SubscriberPassenger(1004, 59, 0));
            passengersArray.add(new UnsubscriberPassenger(1005, 26, 0));
            passengersArray.add(new SubscriberPassenger(1006, 29, 0));
            passengersArray.add(new UnsubscriberPassenger(1007, 19, 0));
            passengersArray.add(new SubscriberPassenger(1008, 30, 0));
            passengersArray.add(new UnsubscriberPassenger(1009, 23, 0));
            passengersArray.add(new UnsubscriberPassenger(1009, -2, 0));
        }
        catch(newException e)
        {
            System.out.println(e.getMessage());
        }
        
        
        int ii = 0;
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(100, 2, routeArray.get(ii), 1, "Ahmed"));
        ii += 1;
        cars.add(new Car(101, 3, routeArray.get(ii), 12, "Hassan"));
        ii += 1;
        cars.add(new Car(102, 6, routeArray.get(ii), 13, "Eslam"));
        ii += 1;
        cars.add(new Car(103, 3, routeArray.get(ii), 10, "Mohamed"));
        ii += 1;
        
        
        // Run Time
        
            while(true)
            {
                int passengerPlace = 0;
                System.out.println("Welcome To The Carpooling Mini System");
                System.out.println("Enter 1 tou use as a user, or 2 to use as an admin, 3 to register");
                int choose = in.nextInt();
                if(choose == 1)
                {
                    System.out.println("Please enter your ID");
                int id = in.nextInt();
                Passenger curPassenger = null;
                for(int j = 0; j < passengersArray.size(); j++)
                {
                    if(passengersArray.get(j).ID == id)
                    {
                        curPassenger = passengersArray.get(j);
                        passengerPlace = j;
                    }
                }
                if(curPassenger == null)
                    System.out.println("There is no passenger with this ID");
                else
                {
                    System.out.println("Welcome " + curPassenger.ID);
                    while(true)
                    {

                        System.out.println("You can do one of the following operations:");
                        System.out.println("1. Search for route");
                        System.out.println("2. Subscribe a frequent Passenger(get 50% discount)");
                        System.out.println("3. Unsubscribe a frequent Passenger");
                        System.out.println("4. Add Review");
                        System.out.println("5. Add Complain");
                        System.out.println("6. Display Your Information");
                        System.out.println("7. Exit");
                        System.out.println("Please enter the number of operation you want to preform: ");
                        
                        
                            int op = in.nextInt();
                            in.nextLine();
                            System.out.println(op);
                            if(op == 1)
                            {
                                System.out.println("Enter the starting point: ");
                                String start = in.next();
                                System.out.println("Enter destination pint: ");
                                String end = in.next();
                                boolean found = false;
                                for(int i = 0; i < cars.size(); i++)
                                {
                                     //if(cars.get(i).getStartPoint() != start)System.out.println(cars.get(i).getStartPoint() + start);
                                    if(cars.get(i).getStartPoint().equals(start) && cars.get(i).getEndPoint().equals(end))
                                    {
                                        found = true;
                                        System.out.println("There's a trip with remaiming " + cars.get(i).getCapcaity() + " seats in this route on car of ID " + cars.get(i).getCarID() + ", Driver name: " + cars.get(i).getDreiverName());
                                        if(cars.get(i).getCapcaity() == 0)
                                        {
                                            System.out.println("There's no seats on this car");
                                        }
                                        else
                                        {
                                            System.out.println("If you want to reserve it enter 1, if you want to skip it enter 2");
                                            
                                            int res = in.nextInt();
                                            in.nextLine();
                                            if(res == 1)
                                            {
                                                if(curPassenger.getTicket(cars.get(i).getCarID()) == true)
                                                {
                                                    System.out.println("You reserved the trip successfully");
                                                    cars.get(i).decCapacity();
                                                }
                                            }
                                            else break;
                                        }
                                    }
                                }
                                if(!found)
                                    System.out.println("Sorry, There's no route between these two places right now");
                            }
                            else if(op == 2)
                            {
                                System.out.println("How many trips do you want to reserve");
                                int reserveTrips = in.nextInt();
                                if(curPassenger.subscriber == true)
                                    curPassenger.subscribe(reserveTrips);
                                else
                                {
                                    int curId = curPassenger.getID();
                                    int curAge = curPassenger.getAge();
                                    int curTrips = curPassenger.getReservedTrips();
                                    curPassenger.subscribe(reserveTrips);
                                    try
                                    {
                                        curPassenger = new SubscriberPassenger(curId, curAge, curTrips);
                                        passengersArray.set(passengerPlace, curPassenger);
                                    }
                                    catch(newException e)
                                    {
                                        System.out.println(e.getMessage());
                                    }
                                    
                                }
                            }
                            else if(op == 3)
                            {
                                System.out.println("Are you sure you want to unsubscribe? (you want be able to use the discount in the following trips you reserve)");
                                System.out.println("1. yes   2. no");
                                int choice = in.nextInt();
                                if(choice == 2)
                                {
                                    break;
                                }
                                else
                                {
                                    int curId = curPassenger.getID();
                                    int curAge = curPassenger.getAge();
                                    int curTrips = curPassenger.getReservedTrips();
                                    try
                                    {
                                        curPassenger = new UnsubscriberPassenger(curId, curAge, curTrips);
                                        passengersArray.set(passengerPlace, curPassenger);
                                        System.out.println("You unsubsribed successfully");
                                    }
                                    catch(newException e)
                                    {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            else if(op == 4)
                            {
                                System.out.println("Enter your review: ");
                                String r = in.nextLine();
                                curPassenger.AddReview(r);
                                System.out.println("Thanks for adding this review");
                            }
                            else if(op == 5)
                            {
                                System.out.println("Enter your report: ");
                                String r = in.nextLine();
                                curPassenger.AddReport(r);
                                System.out.println("Thanks for adding this report");
                            }
                            else if(op == 6)
                            {
                                curPassenger.PrintPassengerInfo();
                            }
                            else if(op == 7)
                                break;
                            else
                                System.out.println("Please Enter Valid Number");
                        
                    }
                }
                }
                else if (choose == 2)
                {
                    System.out.println("You are using as admin");
                    while(true)
                    {
                        System.out.println("Enter the operation you want to preform");
                        System.out.println("1. get all tickets");
                        System.out.println("2. get the totl number of registered passenger");
                        System.out.println("3. get the total number of available routes");
                        System.out.println("4. get the total number of cars");
                        System.out.println("5. add new route");
                        System.out.println("6. exit");
                        int opp = in.nextInt();
                        in.nextLine();
                        if(opp == 1)
                            Passenger.getTickets();
                        if(opp == 2)
                            System.out.println(Passenger.getTotalBumberOfPassengers());
                        if(opp == 3)
                            System.out.println(Route.getTotalNumberOfRoutes());
                        if(opp == 4)
                            System.out.println(Car.getTotalNumberOfCars());
                        if(opp == 5)
                        {
                            System.out.println("Enter the start point: ");
                            String start = in.nextLine();
                            System.out.println("Enter the destination: ");
                            String dest = in.nextLine();
                            routeArray.add(new Route(start, dest));
                            System.out.println("You Added The Route Successfully!");
                        }
                        if(opp == 6)
                            break;
                    }
                }
                else
                {
                    System.out.println("Please enter a valid number");
                }

                System.out.println("Press 1 to log in again, or 2 to exit ");
                int choice = in.nextInt();
                if(choice == 2) break;
            }
    }
        
}   