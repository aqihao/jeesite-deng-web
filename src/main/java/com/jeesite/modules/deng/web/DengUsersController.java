package com.jeesite.modules.deng.web;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.EmpUser;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.*;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author deng
 * @Description: 用户注册,管理
 * @date 2019/2/28 11:45
 */
@Controller
@RequestMapping(value = "user_manage")
public class DengUsersController extends BaseController {

    @Autowired
    private EmpUserService empUserService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping({"save"})
    @ResponseBody
    public String save(@Validated EmpUser empUser, String oldLoginCode, String op, HttpServletRequest request) {
        if (User.isSuperAdmin(empUser.getUserCode())) {
            return this.renderResult("false", "非法操作，不能够操作此用户！");
        } else if (!"employee".equals(empUser.getUserType())) {
            return this.renderResult("false", "非法操作，不能够操作此用户！");
        } else if (!"true".equals(this.userService.checkLoginCode(oldLoginCode, empUser.getLoginCode()))) {
            return this.renderResult("false", text("保存用户失败，登录账号''{0}''已存在", new String[]{empUser.getLoginCode()}));
        } else {
            /*if (StringUtils.inString(op, new String[]{"add", "edit"}) && UserUtils.getSubject().isPermitted("sys:empUser:edit")) {
                this.empUserService.save(empUser);
            }

            if (StringUtils.inString(op, new String[]{"add", "auth"}) && UserUtils.getSubject().isPermitted("sys:empUser:authRole")) {
                this.userService.saveAuth(empUser);
            }*/
            this.empUserService.save(empUser);


            return this.renderResult("true", text("保存用户''{0}''成功", new String[]{empUser.getUserName()}));
        }
    }
}
