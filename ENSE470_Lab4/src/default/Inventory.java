/**
 * Inventory.java version 1.0 Jan 20, 2011
 * @author Trevor Douglas
 *
 * @version
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author tdouglas
 *
 */
public class Inventory {
    //private int milk;
    //private int coffee;
    //private int sugar;
    private List<Reservoir> reservoirs;


    /**
     * Constructor
     */
    public Inventory(){
    	
    	//milk =0;
    	//coffee =0;
    	//sugar = 0;
        reservoirs = new ArrayList<>();
    }

    public void addReservoir(String name, double price, int capacity)
    {
        for(Reservoir reservoir:reservoirs)
        {
            if(reservoir.getName().equals(name))
            {
                return;
            }
        }
        
        Reservoir res = new Reservoir();
        res.setName(name);
        res.setCapacity(capacity);
        res.setPrice(price);
        reservoirs.add(res);
    }
    
    public void editReservoir(String name, String newName, double newPrice, int newCapacity)
    {
        for(Reservoir res: reservoirs)
        {
            if(res.getName().equals(name))
            {
                res.setName(newName);
                res.setPrice(newPrice);
                res.setCapacity(newCapacity);
            }
        }
    }
    
    public void deleteReservoir(String name)
    {
         Iterator<Reservoir> i = reservoirs.iterator();
         
         while(i.hasNext())
         {
             Reservoir res = i.next();
             
             if(res.getName().equals(name))
             {
                 i.remove();
             }
         }
    }
    
    public List<Reservoir> getReservoirs()
    {
        return reservoirs;
    }
    

}
