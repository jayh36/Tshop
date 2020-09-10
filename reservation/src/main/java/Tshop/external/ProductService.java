
package Tshop.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

//@FeignClient(name="product", url="http://product:8080")
@FeignClient(name="Product", url="${api.url.product}")
public interface ProductService {

    @RequestMapping(method= RequestMethod.GET, path="/products/check",produces = "application/json")
    //public @ResponseBody String checkProductQuantity(@RequestBody Product product);
    @ResponseBody String checkProductQuantity(@RequestParam("productId") String productId);

}