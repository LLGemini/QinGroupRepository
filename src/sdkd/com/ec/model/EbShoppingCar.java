package sdkd.com.ec.model;

/**
 * Created by qin on 2016-07-07.
 */
public class EbShoppingCar {
    public int esh_product_id;
    public String esh_product_name;
    public double esh_product_price;
    public int esh_product_quantity;
    public int esh_user_id;

    public int getEsh_product_id() {
        return esh_product_id;
    }

    public void setEsh_product_id(int esh_product_id) {
        this.esh_product_id = esh_product_id;
    }

    public double getEsh_product_price() {
        return esh_product_price;
    }

    public void setEsh_product_price(double esh_product_price) {
        this.esh_product_price = esh_product_price;
    }

    public String getEsh_product_name() {
        return esh_product_name;
    }

    public void setEsh_product_name(String esh_product_name) {
        this.esh_product_name = esh_product_name;
    }

    public int getEsh_product_quantity() {
        return esh_product_quantity;
    }

    public void setEsh_product_quantity(int esh_product_quantity) {
        this.esh_product_quantity = esh_product_quantity;
    }

    public int getEsh_user_id() {
        return esh_user_id;
    }

    public void setEsh_user_id(int esh_user_id) {
        this.esh_user_id = esh_user_id;
    }
}
