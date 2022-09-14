package com.duing.controller;

import com.duing.model.Book;
import com.duing.model.User;
import com.duing.service.BookService;
import com.duing.service.UserService;
import com.duing.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "hello springboot";
    }

    @RequestMapping("/theme")
    public String theme(){
        return "hello";
    }

    @Autowired
    private UserService userService;
    @RequestMapping("/mybatis")
    @ResponseBody
    public List<User> getUsers(){
       return userService.list();
    }

    @Autowired
    private BookServiceImpl bookService;

//    @RequestMapping("/addBook")
//    @ResponseBody
//    public Book addBook(){
//        Book book = new Book(1L,"夜的命名术","会说话的肘子","蓝与紫的霓虹中，浓密的钢铁苍穹下，数据洪流的前端，是科技革命之后的世界，也是现实与虚幻的分界。\n" +
//                "　　钢铁与身体，过去与未来。\n" +
//                "　　这里，表世界与里世界并存，面前的一切，像是时间之墙近在眼前。\n" +
//                "　　黑暗逐渐笼罩。\n" +
//                "　　可你要明白啊我的朋友，我们不能用温柔去应对黑暗，要用火。",2259300,1,"连载中");
//        bookService.save(book);
//        return book;
//    }
}
