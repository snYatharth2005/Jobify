package com.yatharth.jobportal.spring_boot_job_portal_app.controller;


import com.yatharth.jobportal.spring_boot_job_portal_app.interfaces.JobPostRepository;
import com.yatharth.jobportal.spring_boot_job_portal_app.interfaces.SearchRepository;
import com.yatharth.jobportal.spring_boot_job_portal_app.model.JobPostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobPostController {

    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository search_repo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/job-posts")
    public List<JobPostModel> getAllJobPosts(){
        return repo.findAll();
    }

    @GetMapping("/job-posts/{text}")
    public List<JobPostModel> search(@PathVariable String text){
        return search_repo.findByText(text);
    }

    @PostMapping("/create-job-post")
    public JobPostModel createJobPost(@RequestBody JobPostModel job_post){
        return repo.save(job_post);
    }
}
