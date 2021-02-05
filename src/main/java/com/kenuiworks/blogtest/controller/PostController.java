package com.kenuiworks.blogtest.controller;

import com.kenuiworks.blogtest.model.Post;
import com.kenuiworks.blogtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by daniel on 01/02/21.
 */
@Controller
public class PostController {


    @Autowired
    private PostService service;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> allPosts = service.findAll();
        modelAndView.addObject("posts", allPosts);
        return modelAndView;
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = service.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }


    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes atriAttributes){
        if(result.hasErrors()){
            atriAttributes.addFlashAttribute("mensagem","Verifique campos obrigatórios");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        service.save(post);
        return "redirect:/posts";
    }


}
