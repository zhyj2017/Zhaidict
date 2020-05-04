package com.example.zhaidict.controller;

import com.example.zhaidict.pojo.Book;
import com.example.zhaidict.pojo.User;
import com.example.zhaidict.service.BookService;
import com.example.zhaidict.service.UserService;
import com.example.zhaidict.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    /**
     * TODO 获取用户配置信息
     */
    @RequestMapping(value = "/config",produces = "application/json;charset=utf-8",method= RequestMethod.GET)
    @ResponseBody
    public String getConfig(@RequestParam("id")int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = userService.get(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("countPerDay",user.getPlan());
        map.put("bookId",user.getBookid());
        map.put("image",user.getAvatar());
        String str = mapper.writeValueAsString(map);
        return str;
    }

    /**
     * TODO 获取用户数据
     */
    @RequestMapping(value = "/data",produces = "application/json;charset=utf-8",method= RequestMethod.GET)
    @ResponseBody
    public String getData(@RequestParam("id")int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = userService.get(id);
        Book book = bookService.get(user.getBookid());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("bookId",user.getBookid());
        map.put("bookName",book.getName());
        map.put("bookImage",book.getAddress());
        map.put("totalWords",book.getNum());
        map.put("learnedWords",user.getLearned());
        String str = mapper.writeValueAsString(map);
        return str;
    }
}
