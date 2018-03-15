package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model){
        Actor a= new Actor();
        a.setName("Sarojinee Rathor");
        a.setRealname("The Coolest Ever");
        actorRepository.save(a);

        Movie movie = new Movie();
        movie.setTitle("The SpringBoot Movie");
        movie.setYear(2018);
        movie.setDescription("During Spring Break");
        movieRepository.save(movie);

        a.addMovie(movie);
        actorRepository.save(a);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}

