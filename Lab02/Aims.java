package Java.OOP.Lab02;

class DigitalVideoDisc{
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    } 

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost){
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }
}
class Cart{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc "+(i+1)+" has been removed");
                break; 
            }
        }
    }

    public float totalCost(){
        float total = 0.0f;
        for(int i=0;i<qtyOrdered;i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
public class Aims {
    public static void main(String[] args) {
        //Create a new Cart
        Cart anOrder =  new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        //remove dvd3
        anOrder.removeDigitalVideoDisc(dvd3);

        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
