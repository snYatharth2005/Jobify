package com.yatharth.jobportal.spring_boot_job_portal_app.interfaces;
import com.yatharth.jobportal.spring_boot_job_portal_app.model.JobPostModel;
import java.util.List;

public interface SearchRepository {
    List<JobPostModel> findByText(String text);
}
