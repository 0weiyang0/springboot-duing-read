package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.model.Book;
import com.duing.service.BookService;
import com.duing.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
//    @ResponseBody
    public String search(@RequestParam("keyword") String keyword, Model model){
        System.out.println(keyword);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name",keyword);
        List<Book> bookList = bookService.list();
        List<BookVo> bookVoList = new ArrayList<>();
        for (Book book : bookList) {
            BookVo vo = new BookVo();
            vo.setName(book.getName());
            vo.setAuthor(book.getAuthor());
            vo.setDesc(book.getDescription());
            vo.setImgPath(book.getId()+".png");
            bookVoList.add(vo);
        }
//        System.out.println(bookList);
        model.addAttribute("bookVoList",bookVoList);
        System.out.println();
        return "list";
    }
}
