package cn.fire.controlelr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author zhangle
 * @CreateTime 2021-11-05 11:45:49
 * @Description
 */
@Controller
public class DockerController {

    @ResponseBody
    @RequestMapping("/ss")
    public String test() {
        return "hello docker";

    }

    @RequestMapping("/")
    public String to_index(Model model){
        model.addAttribute("username","赵云");
        model.addAttribute("userId","01");
        return "index";
    }



}
