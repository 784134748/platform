package com.yalonglee.platform.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 *
 * @author listener
 */
@Controller
@RequestMapping("/")
@Api(value = "多级目录")
public class GetViewController {

    private static final Logger logger = LogManager.getLogger(GetViewController.class);

    /**
     * goURL: 1级目录
     *
     * @param file
     * @return
     * @author listener
     */
    @ApiOperation(value = "一级目录")
    @RequestMapping(value = "/{file}", method = RequestMethod.GET)
    public String goURL(@PathVariable String file) {
        return "/" + file;
    }

    /**
     * goURL: 2级目录
     *
     * @param folder
     * @param file
     * @return
     * @author listener
     */
    @ApiOperation(value = "二级目录")
    @RequestMapping(value = "/{folder}/{file}", method = RequestMethod.GET)
    public String goURL2(@PathVariable String folder, @PathVariable String file) {
        return "/" + folder + "/" + file;
    }

    /**
     * goURL3:3级目录
     *
     * @param folder
     * @param file
     * @return
     * @author listener
     */
    @ApiOperation(value = "三级目录")
    @RequestMapping(value = "/{folder}/{model}/{file}", method = RequestMethod.GET)
    public String goURL3(@PathVariable String folder, @PathVariable String model, @PathVariable String file) {
        return "/" + folder + "/" + model + "/" + file;
    }

}
