package example.day06.entity.practice6;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieSvc;

    @GetMapping
    public List<MovieDto> moviePrt(){
        return movieSvc.moviePrt();
    }

    @PostMapping
    public boolean movieSav(@RequestBody MovieDto movieDto){
        return movieSvc.movieSav(movieDto);
    }

    @DeleteMapping
    public boolean movieDel(@RequestBody Integer movie_id){
        return movieSvc.movieDel(movie_id);
    }

    @PutMapping
    public boolean movieUpd(@RequestBody MovieDto movieDto){
        return movieSvc.movieUpd(movieDto);
    }
}
