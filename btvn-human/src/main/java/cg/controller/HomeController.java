package cg.controller;

import cg.model.Human;
import cg.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value= "/human")
public class HomeController {

    @Autowired
    private IHumanService iHumanService;

    @GetMapping
    public ModelAndView showAll(@PageableDefault(value = 3)Pageable pageable, @RequestParam(value = "search")Optional<String> search){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Human> humans =iHumanService.findAll(pageable);;
//        if(search.isPresent()){
//            humans = iHumanService.findByName(pageable,search.get());
//            modelAndView.addObject("search",search.get());
//        }else {
//            humans = iHumanService.findAll(pageable);
//        }
        modelAndView.addObject("humans",humans);
        return modelAndView;
    }
}
