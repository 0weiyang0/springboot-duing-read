package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.model.Book;
import com.duing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }



    @RequestMapping("/search")
    @ResponseBody
    public List<Book> search(@RequestParam("keyword") String keyword){
        System.out.println(keyword);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name",keyword);
        List<Book> bookList = bookService.list();
        System.out.println(bookList);
        return bookList;
    }
}
