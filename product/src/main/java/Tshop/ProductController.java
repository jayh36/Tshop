package Tshop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService postsService;
    @GetMapping("/products/check")
    public String productCheck(@RequestParam String productId){
        return postsService.checkQuantityByProductId(productId);
    }

}
