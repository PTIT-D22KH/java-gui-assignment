/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

/**
 *
 * @author P51
 */
public class Product implements Comparable<Product>{
    private String id, name;
    private int price, warrantyMonths;

    public Product(String id, String name, int price, int warrantyMonths) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
    }
    public Object[] toRowTable(){
        return new Object[]{
          id, name, price, warrantyMonths
        };
    }

    @Override
    public int compareTo(Product o) {
        if (this.price == o.price) {
            return this.id.compareTo(o.id);
        } 
        return Integer.compare(o.price, this.price);
    }
}
