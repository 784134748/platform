package com.yalonglee.platform.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * @author ylli6
 * @version 
 */
@Controller
@RequestMapping("/")
public class GetViewController {


    /**
     * goURL: 1级目录
     * @param file
     * @return
     * @author ylli6
     */
    @RequestMapping("/{file}")
    public String goURL(@PathVariable String file) {
        return "/"  + file;
    }
    
    /**
     * goURL: 2级目录
     * @param folder
     * @param file
     * @return
     * @author ylli6
     */
    @RequestMapping("/{folder}/{file}")
    public String goURL2(@PathVariable String folder, @PathVariable String file) {
        return "/" + folder + "/" + file;
    }
    
    /**
     * goURL3:3级目录
     * @param folder
     * @param file
     * @return
     * @author ylli6
     */
    @RequestMapping("/{folder}/{model}/{file}")
    public String goURL3(@PathVariable String folder, @PathVariable String model, @PathVariable String file) {
        return "/" + folder + "/" + model + "/" + file;
    }

}
