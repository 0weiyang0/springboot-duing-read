package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.mapper.AuthorMapper;
import com.duing.model.Author;
import com.duing.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
                                implements AuthorService {
}
