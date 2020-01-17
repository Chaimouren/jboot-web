package com.web.controller;

import com.jfinal.aop.Inject;
import com.web.generator.service.SysUserService;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

import java.util.Arrays;

@RequestMapping("/user")
public class UserController extends JbootController {

    @Inject
    private SysUserService userService;

    public void findAll() {
        renderText(Arrays.toString(userService.findAll().toArray()));
    }

}
