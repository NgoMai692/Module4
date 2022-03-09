package cg.controller;

import cg.model.ClassRoom;
import cg.model.Student;
import cg.service.IClassRoomService;
import cg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassRoomService classRoomService;

    @GetMapping("/students")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("students",studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreat(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("classRooms",classRoomService.findAll());

        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute(value = "student") Student student, @RequestParam long idClassRoom, @RequestParam MultipartFile upImg){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(idClassRoom);
        student.setClassRoom(classRoom);
        studentService.save(student);
//        String nameFile = upImg.getOriginalFilename();
//
//        try {
//            FileCopyUtils.copy(upImg.getBytes(),new File("D:/4. Outlook sync/OneDrive/Desktop/module4/repository_student/src/main/webapp/img/" + nameFile));
//            student.setImg("i/img/"+nameFile);
//            studentService.save(student);
//        } catch (IOException e) {
//            student.setImg("");
//            studentService.save(student);
//            e.printStackTrace();
//        }
        return "redirect:/students";
    }
}
