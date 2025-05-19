package com.example.controller;

import com.example.domain.Item;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(Model model){
        @SuppressWarnings("unchecked")
        List<Item> productList = (List<Item>) application.getAttribute("productList");

        if (application.getAttribute("productList") == null){
            Item item1 = new Item();
            item1.setName("手帳ノート");
            item1.setPrice(1000);

            Item item2 = new Item();
            item2.setName("文房具セット");
            item2.setPrice(1500);

            Item item3 = new Item();
            item3.setName("ファイル");
            item3.setPrice(2000);

            productList = new ArrayList<>();

            productList.add(item1);
            productList.add(item2);
            productList.add(item3);

            application.setAttribute("productList", productList);
        }

        if (session.getAttribute("shoppingCartList") == null){
            List<Item> shoppingCartList = new LinkedList<>();
            session.setAttribute("shoppingCartList", shoppingCartList);
        }

        @SuppressWarnings("unchecked")
        List<Item> shoppingCartList = (List<Item>) session.getAttribute("shoppingCartList");

        int sumPrice = 0;

        for (Item item : shoppingCartList){
            sumPrice += item.getPrice();
        }

        model.addAttribute("sumPrice", sumPrice);
        application.setAttribute("productList", productList);
        session.setAttribute("shoppingCartList", shoppingCartList);

        return "item-and-cart";
    }

    @PostMapping("/inCart")
    public String inCart(String index){
        @SuppressWarnings("unchecked")
        List<Item> shoppingCartList = (List<Item>) session.getAttribute("shoppingCartList");

        @SuppressWarnings("unchecked")
        List<Item> productList = (List<Item>) application.getAttribute("productList");

        System.out.println("index：" + index);

        shoppingCartList.add(productList.get(Integer.parseInt(index)));

        System.out.println("shoppingCartList：" + shoppingCartList);

        session.setAttribute("shoppingCartList", shoppingCartList);

        return "redirect:/exam06";
    }

    @PostMapping("/delete")
    public String delete(String index){
        @SuppressWarnings("unchecked")
        List<Item> shoppingCartList = (List<Item>) session.getAttribute("shoppingCartList");

        if (shoppingCartList == null) {
            shoppingCartList = new LinkedList<>();
        }

        if (index != null) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < shoppingCartList.size()) {
                shoppingCartList.remove(i);
            }
        }

        session.setAttribute("shoppingCartList", shoppingCartList);

        return "redirect:/exam06";
    }

}
