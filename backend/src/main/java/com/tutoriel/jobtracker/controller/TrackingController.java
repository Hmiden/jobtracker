package com.tutoriel.jobtracker.controller;

import com.tutoriel.jobtracker.entity.Click;
import com.tutoriel.jobtracker.repository.ClickRepository;
import com.tutoriel.jobtracker.service.ClickService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allow all origins (update with your frontend URL in production)
public class TrackingController {

    private final ClickService clickService;
    private final ClickRepository clickRepository;

    @GetMapping("/track")
    public void trackClick(
            @RequestParam(value = "email", required = false, defaultValue = "unknown") String email,
            @RequestParam(value = "name", required = false, defaultValue = "unknown") String name,
            HttpServletResponse response) throws IOException {

        // Save click with email and name
        clickService.saveClick(email, name);

        // Redirect to CV
        response.sendRedirect("https://drive.google.com/file/d/1BpNf3XW3FBAuF_Ps4xlZvXAst1SF2VNo/view?usp=sharing");
    }

    @GetMapping("/clicks")
    public List<Click> getClicks() {
        return clickRepository.findAll();
    }
}
