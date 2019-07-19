package net.lowerytech.web.contollers;

import net.lowerytech.domain.Product;
import net.lowerytech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ProductService productService;

    public IndexController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping({"/", "index"})
    public String getIndex(Model model) {
        List<Product> products = productService.listProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("secured")
    public String secured(){
        return "secured";
    }

}
