package com.learn.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.learn.bean.BootstrapTable;
import com.learn.bean.Pager;
import com.learn.form.UserForm;
import com.learn.mapper.UserMapper;
import com.learn.service.UserSerivce;
@Service
public class UserServiceImpl implements UserSerivce {
    @Resource
    private UserMapper userMapper;

    @Override
    public Pager findList(UserForm userForm, Pager pager) {
        pager.setList(this.userMapper.findList(userForm, pager));
        Long totalCount = this.userMapper.findListTotalCount(userForm);
        pager.setTotalCount(totalCount == null ? 0 : totalCount.intValue());
        return pager;
    }

    @Override
    public BootstrapTable bootstrapTable(UserForm userForm, Pager pager) {
        BootstrapTable bootstrapTable = new BootstrapTable();
        bootstrapTable.setRows(this.userMapper.findList(userForm, pager));
        Long totalCount = this.userMapper.findListTotalCount(userForm);
        bootstrapTable.setTotal(totalCount == null ? 0 : totalCount.longValue());
        return bootstrapTable;
    }
}
