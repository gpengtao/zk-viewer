package com.gpengtao.zkviewer.web.controller;

import com.google.common.base.Strings;
import com.gpengtao.zkviewer.service.ZkService;
import com.gpengtao.zkviewer.web.vo.ZkViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by gpengtao on 15/10/11.
 */
@Controller
public class ZkViewController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ZkService zkService;

    @RequestMapping("/")
    public ModelAndView view(String path) {
        if (Strings.isNullOrEmpty(path)) {
            path = "/";
        }
        logger.info("view path {}", path);

        ModelAndView modelAndView = new ModelAndView("zkView");
        modelAndView.addObject("zkAddress", zkService.getZkAddress());

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
