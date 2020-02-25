package Mini;
public class Product2 {

    private int P_ID;
    private String P_Name;
    private int Qty;
    private double Price;
    private int Category;
    private byte[] P_Image;
    private String Description;
    
    public Product2(){}
    
    public Product2(int P_ID, String P_Name, double Price, int Qty,byte[] P_Image , String Description , int Category){
    
        this.P_ID = P_ID;
        this.P_Name = P_Name;
        this.Qty = Qty;
        this.Price = Price;
        this.P_Image = P_Image;
        this.Category = Category;
        this.Description = Description;
    }
    
    
    public int getID(){
      return P_ID;
    }
    
    public void setID(int P_ID){
        this.P_ID = P_ID;
    }
    
    public String getName(){
        return P_Name;
    }
    
    public void setName(String Name){
        this.P_Name = Name;
    }
    
    public int getQte(){
        return Qty;
    }
    
    public void setQte(int Qte){
        this.Qty = Qte;
    }
    
    public double getPrice(){
        return Price;
    }
    
    public void setPrice(double Price){
        this.Price = Price;
    }
    
    public int getCatID(){
        return Category;
    }
    
    public void setCatID(int CatID){
        this.Category = CatID;
    }
    
    public byte[] getMyImage(){
        return P_Image;
    }
    
    public void setDesc(String Desc){
    	this.Description = Desc;
    }
    public String getDesc(){
    	return Description;
    }
}
