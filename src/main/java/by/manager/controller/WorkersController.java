package by.manager.controller;

import by.manager.model.Workers;
import by.manager.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorkersController {
    private WorkersService workersService;

    @Autowired(required = true)
    @Qualifier(value = "workersService")
    public void setWorkersService(WorkersService workersService) {
        this.workersService = workersService;
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String listWorkers(Model model) {
        model.addAttribute("workers", new Workers());
        model.addAttribute("listWorkers", this.workersService.listWorkers());

        return "workers";
    }

    @RequestMapping(value = "/workers/add", method = RequestMethod.POST)
    public String addWorkers(@ModelAttribute("workers") Workers workers) {
        if (workers.getId() == 0) {
            this.workersService.addWorkers(workers);
        } else {
            this.workersService.updateWorkers(workers);
        }
        return "redirect:/workers";
    }

    @RequestMapping("/remove/{id}")
    public String removeWorkers(@PathVariable("id") int id){
        this.workersService.removeWorkers(id);

        return "redirect:/workers";
    }

    @RequestMapping("/update/{id}")
    public String updateWorkers(@PathVariable("id") int id, Model model){
        model.addAttribute("workers", this.workersService.getWorkersById(id));
        model.addAttribute("listWorkers", this.workersService.listWorkers());

        return "workers";
    }

    @RequestMapping("workersdata/{id}")
    public String workerData(@PathVariable("id") int id, Model model){
        model.addAttribute("workers", this.workersService.getWorkersById(id));

        return "workersdata";
    }
}

