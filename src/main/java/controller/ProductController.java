package controller;

import entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ProductRepository;

import java.util.List;

@Service
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    ProductRepository productRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String listProducts(Model model){
        List<ProductEntity> productList = (List<ProductEntity>)productRepo.findAll();
        model.addAttribute("productList", productList);
        return "productList";
    }
}
