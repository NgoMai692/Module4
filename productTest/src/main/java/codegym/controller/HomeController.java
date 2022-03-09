package codegym.controller;


import codegym.model.Category;
import codegym.model.Product;
import codegym.service.ICategoryService;
import codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/product")
public class HomeController {

    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showAll(@PageableDefault(3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Product> products = productService.findAll(pageable);
        if(products.isEmpty()){
            modelAndView.addObject("message","khong co san pham");
        }
        modelAndView.addObject("products",products);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView createGet(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        List<Category> categories = categoryService.selectAll();
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createPost(@ModelAttribute("product")Product product){
        ModelAndView modelAndView = new ModelAndView("create");
        MultipartFile file = product.getFile();
        String fileName = file.getOriginalFilename();
        List<Category> categories = categoryService.selectAll();
        modelAndView.addObject("categories",categories);
        try{
            FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        product.setImage("image/"+fileName);
        Product product1 = productService.save(product);
        if(product1 !=null){
            modelAndView.addObject("message","thanh cong");
        }
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editGet(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.selectById(id);
        List<Category> categories = categoryService.selectAll();
        modelAndView.addObject("categories",categories);
        if(product != null){
            modelAndView.addObject("product",product);
        }else {
            modelAndView.addObject("message","Id invalid");
        }
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editPost(@ModelAttribute Product product,@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        product.setId(id);
        if(product.getFile().getSize() !=0){
            MultipartFile file = product.getFile();
            String fileName = file.getOriginalFilename();
            try{
                FileCopyUtils.copy(product.getFile().getBytes(), new File(fileUpload + fileName));
            }catch (Exception e){
                e.printStackTrace();
            }
            product.setImage("image/"+fileName);
        }else {
            product.setImage(productService.selectById(id).getImage());
        }
        Product productEdit = productService.save(product);
        if(productEdit !=null){
            modelAndView.addObject("message", "Update successfully");
        }
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("product",productService.selectById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("list");
        productService.delete(id);
        List<Product> products = productService.selectAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("search") String name){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.searchByName(name);
        modelAndView.addObject("products",products);
        return modelAndView;
    }
}
