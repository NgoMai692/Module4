package cg.controller;

import cg.model.ClassRoom;
import cg.model.Student;
import cg.service.IClassRoomService;
import cg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class HomeController {

    @Autowired
    private IClassRoomService classRoomService;

    @Autowired
    private IStudentService studentService;

    @ModelAttribute(name = "classes")
    private Iterable<ClassRoom> findAll(){
        return classRoomService.selectALL();
    }
    @GetMapping
    public ModelAndView showAll(@PageableDefault(3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Student> students = studentService.selectAll(pageable);
        if(students.isEmpty()){
            modelAndView.addObject("message","không có học sinh");
        }
        modelAndView.addObject("students",students);
        return modelAndView;
    }
}
