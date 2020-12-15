package controller;

import component.Cart;
import entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ProductRepository;

@Controller
@Scope(value = "session")
public class CartController {
    @Autowired
    ProductRepository productRepo;

    @Autowired
    Cart cart;

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addNewItem(@PathVariable(value = "id")int id, Model model){
        ProductEntity product= (ProductEntity)productRepo.findById(id);
        cart.addItem(product);

        model.addAttribute("cart", cart);

        return "cart";
    }


}
