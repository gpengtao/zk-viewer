package com.gpengtao.web.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.gpengtao.service.ZkService;
import com.gpengtao.web.vo.ZkViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gpengtao on 15/10/11.
 */
@Controller
public class ZkViewController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ZkService zkService;

    @RequestMapping("/view")
    public ModelAndView view(String path) {
        if (Strings.isNullOrEmpty(path)) {
            path = "/";
        }
        logger.info("view path {}", path);

        ModelAndView modelAndView = new ModelAndView("view");

        try {
            ZkViewModel view = zkService.view(path);
            modelAndView.addObject("view", view);
        } catch (Throwable e) {
            logger.error("view error", e);
            modelAndView.addObject("errMsg", e);
        }

        return modelAndView;
    }

}
