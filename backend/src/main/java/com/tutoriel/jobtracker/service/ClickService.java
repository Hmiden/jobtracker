package com.tutoriel.jobtracker.service;

import com.tutoriel.jobtracker.entity.Click;
import com.tutoriel.jobtracker.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClickService {

    private final ClickRepository repo;

    public void saveClick(String email, String name) {
        Click click = new Click();
        click.setEmail(email);
        click.setName(name);
        click.setClickedAt(LocalDateTime.now());
        repo.save(click);
    }
}
