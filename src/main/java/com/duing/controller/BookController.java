package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.model.Book;
import com.duing.service.BookService;
import com.duing.service.impl.BookServiceImpl;
import com.duing.service.impl.RankServiceImpl;
import com.duing.vo.BookDetailVo;
import com.duing.vo.BookVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private RankServiceImpl rankService;

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
            vo.setId(book.getId());
            vo.setAuthor(book.getAuthor());
            vo.setDesc(book.getDescription());
            vo.setImgPath(book.getId()+".png");
            //在搜索的同时其搜索的数量加1，用来表示受欢迎的程度
            rankService.recordSearchCount(book.getId());
            bookVoList.add(vo);
        }
//        System.out.println(bookList);
        model.addAttribute("bookVoList",bookVoList);
        System.out.println();
        return "list";
    }

//注意路径上有变量的写法
//这种变量的写法与
    @RequestMapping("/detail/{bookId}")
    public String detail(@PathVariable Long bookId,Model model){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",bookId);
        Book book = bookService.getOne(wrapper);
        BookDetailVo vo = new BookDetailVo();
        vo.setName(book.getName());
        vo.setAuthor(book.getAuthor());
        vo.setDesc(book.getDescription());
        vo.setImgPath(book.getId() + ".png");
        model.addAttribute("vo",vo);
        return "detail";
    }





}
