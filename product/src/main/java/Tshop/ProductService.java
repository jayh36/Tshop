package Tshop;

import Tshop.Product;
import Tshop.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public String checkQuantityByProductId(String productId) {

        Optional<Product> optionalProduct = productRepository.findById(Long.parseLong(productId));
        Product product = optionalProduct.orElseGet(Product::new);
        // 상품이 없을경우 재고0으로 전달
        if(product.getQuantity() == null) product.setQuantity(0);
        // 상품재고가 있는 경우 재고 -1 하고 할당으로 이벤트 전달
        if( product.getQuantity() > 0 ){
            product.setQuantity(product.getQuantity()-1);
            productRepository.save(product);
            product.pulishQuantityChecked();
        }
        return product.getQuantity().toString() ;
    }
}
