package net.lowerytech.web.contollers;

import net.lowerytech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public void ProductController(ProductService productService){
        this.productService = productService;
    }

    //@GetMapping("/product")
    public String getProduct(){
        return "redirect:/index";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }
}
