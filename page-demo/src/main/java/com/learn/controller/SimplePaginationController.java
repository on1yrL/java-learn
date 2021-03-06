package com.learn.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.learn.bean.Pager;
import com.learn.form.UserForm;
import com.learn.service.UserSerivce;
/**
 * simplePagination.js实现分页效果
 * 
 * @author Ben.
 *
 */
@Controller
@RequestMapping("/simplePagination")
public class SimplePaginationController {
    @Resource
    private UserSerivce userSerivce;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(UserForm userForm, Pager pager, ModelMap modelMap, HttpServletRequest request) {
        return "simplePagination/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(UserForm userForm, Pager pager, ModelMap modelMap, HttpServletRequest request) {
        pager = this.userSerivce.findList(userForm, pager);
        return "simplePagination/index";
    }
}
