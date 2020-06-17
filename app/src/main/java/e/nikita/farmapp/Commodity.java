package e.nikita.farmapp;
public class Commodity{
    private String city;
    private String commo;
    private String price;
    private String quantity;
    private String mobile;

    public Commodity() {
    }

    public Commodity(String city, String commo, String price, String quantity,String mobile) {
        this.city = city;
        this.commo = commo;
        this.price = price;
        this.quantity = quantity;
        this.mobile=mobile;
    }

    public String getCity() {
        return city;
    }

    public String getCommo() {
        return commo;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMobile() {
        return mobile;
    }
}

