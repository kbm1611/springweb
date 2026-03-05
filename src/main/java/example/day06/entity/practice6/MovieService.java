package example.day06.entity.practice6;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<MovieDto> moviePrt(){

        List<MovieEntity> movieEntityList = movieRepo.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();

        movieEntityList.forEach(movieEntity -> {
            movieDtoList.add( movieEntity.toDto() );
        });
        return movieDtoList;

    }

    public boolean movieSav(MovieDto movieDto){
        MovieEntity movieEntity = movieDto.toEntity();

        return movieRepo.save(movieEntity).getMovie_id() > 0;
    }

    public boolean movieDel(Integer movie_id){
        movieRepo.deleteById( movie_id );

        return true;
    }

    public boolean movieUpd(MovieDto movieDto){

        Optional<MovieEntity> optional = movieRepo.findById( movieDto.getMovie_id() );

        if(optional.isPresent()){
            MovieEntity movieEntity = optional.get();
            movieEntity.setTitle( movieDto.getTitle() ); movieEntity.setDirector( movieDto.getDirector() );
            movieEntity.setReleasedate( movieDto.getReleasedate() );  movieEntity.setRating( movieDto.getRating() );
            return true;
        }else{
            return false;
        }
    }

}
