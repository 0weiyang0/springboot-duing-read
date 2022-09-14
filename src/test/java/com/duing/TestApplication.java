package com.duing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.mapper.UserMapper;
import com.duing.model.Author;
import com.duing.model.Book;
import com.duing.model.User;
import com.duing.service.AuthorService;
import com.duing.service.UserService;
import com.duing.service.impl.BookServiceImpl;
import com.duing.vo.GroupBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {
    @Autowired
    private BookServiceImpl bookService;
    @Test
    public void testBook(){
      List<Book> bookList = bookService.list();
        System.out.println(bookList);
    }




    @Autowired
    private AuthorService authorService;

    @Test
    public void test(){
        System.out.println("查看是否可以启动");
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name","说话");
      List<Author> authorList =   authorService.list(wrapper);
        System.out.println(authorList);
    }


    @Autowired
    private UserService userService;
    @Test
    public void test3(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name","atuo");
        List<User>  user = userService.list(wrapper);
        System.out.println(user.toString());
        System.out.println("====================================");
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.gt("age","20");
        List<User>  user1 = userService.list(wrapper1);
        System.out.println(user1.toString());
        System.out.println("====================================");
        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.le("age","18");
        List<User>  user2 = userService.list(wrapper2);
        System.out.println(user2.toString());
        System.out.println("====================================");
        QueryWrapper wrapper3 = new QueryWrapper();
        wrapper3.between("age",18,80);
        List<User>  user3 = userService.list(wrapper3);
        System.out.println(user3 .toString());
    }

    @Test
    public void test4(){
        QueryWrapper wrapper3 = new QueryWrapper();
        wrapper3.groupBy("age");
        wrapper3.select("COUNT(name) as cnt","age");
        List<User>  user3 = userService.list(wrapper3);
        System.out.println(user3 .toString());
    }
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test5(){
       List<GroupBean> list =  userMapper.selectGroup();
        System.out.println();
    }

}
