package com.boris.stuff_members.controller;

import com.boris.stuff_members.dto.WorkerClientDto;
import com.boris.stuff_members.service.WorkerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping("allWorkers")
    public ModelAndView findAllWorkers(){
        ModelAndView mav = new ModelAndView("allWorkers");
        mav.addObject("allWorkers",workerService.getAllWorkers());
        return mav;
    }

    @GetMapping("addWorker")
    public ModelAndView addWorker(){
        ModelAndView mav = new ModelAndView("addWorker");
        mav.addObject("WorkerDto",new WorkerClientDto());
        return mav;
    }
    @PostMapping("addWorker")
    public ModelAndView addWorkerToDatabase(@ModelAttribute("WorkerDto") WorkerClientDto workerClientDto, BindingResult bi, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:"+request.getContextPath() + "/allWorkers");
        if (bi.hasErrors()) {
            modelAndView.setViewName("addWorker");
        } else {
            workerService.addWorkerToDatabase(workerClientDto);
        }
        return modelAndView;
    }

    @GetMapping("getWorker/{id}")
    public ModelAndView getOneWorker(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("oneWorker");
        mav.addObject("Worker", workerService.getOneWorker(id));
        return mav;
    }

    @PostMapping("deleteWorker/{id}")
    public ModelAndView deleteWorker(@PathVariable("id") Long id, HttpServletRequest request){
        workerService.deleteWorker(id);
        ModelAndView mav = new ModelAndView("redirect:"+request.getContextPath() + "/allWorkers");
        System.out.println(mav.getView());
        return mav;
    }

    @GetMapping("updateWorker/{id}")
    public ModelAndView updateWorker(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("updateWorker");
        mav.addObject("WorkerDto", workerService.getOneWorker(id));
        return mav;
    }

    @PostMapping("updateWorker/{id}")
    public ModelAndView updateWorker_1(@PathVariable("id") Long id, @ModelAttribute("WorkerDto")WorkerClientDto workerClientDto, BindingResult bi, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("redirect:"+request.getContextPath() + "/allWorkers");
        if (bi.hasErrors()) {
            modelAndView.setViewName("updateWorker");
        } else {
            workerClientDto.setId(id);
            workerService.updateWorker(workerClientDto);
        }
        return modelAndView;
    }
}
