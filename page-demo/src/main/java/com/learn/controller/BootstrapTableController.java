package com.learn.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.learn.bean.BootstrapTable;
import com.learn.bean.Pager;
import com.learn.form.UserForm;
import com.learn.service.UserSerivce;
/**
 * bootstrap table实现分页效果
 * 
 * @author Ben.
 *
 */
@Controller
@RequestMapping("/bootstrapTable")
public class BootstrapTableController {
    @Resource
    private UserSerivce userSerivce;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(UserForm userForm, Pager pager, ModelMap modelMap, HttpServletRequest request) {
        return "bootstrapTable/index";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public BootstrapTable list(UserForm userForm, Pager pager, ModelMap modelMap, HttpServletRequest request) {
        BootstrapTable bootstrapTable = this.userSerivce.bootstrapTable(userForm, pager);
        return bootstrapTable;
    }
}
