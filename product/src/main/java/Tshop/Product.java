package Tshop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;
    private String productName;
    private Integer quantity;

    @PostUpdate
    public void pulishQuantityChecked(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }

/*    @PrePersist
    public void onPrePersist(){
        QuantityChanged quantityChanged = new QuantityChanged();
        BeanUtils.copyProperties(this, quantityChanged);
        quantityChanged.publishAfterCommit();
    }*/

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}
