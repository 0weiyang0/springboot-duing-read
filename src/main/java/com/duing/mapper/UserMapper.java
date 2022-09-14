package com.duing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.model.User;
import com.duing.vo.GroupBean;

import java.security.acl.Group;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<GroupBean> selectGroup();
}
