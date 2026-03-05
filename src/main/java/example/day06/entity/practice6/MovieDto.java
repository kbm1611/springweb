package example.day06.entity.practice6;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDto {
    private Integer movie_id;
    private String title;
    private String director;
    private String releasedate;
    private Integer rating;

    private String createDate;
    private String updateDate;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .movie_id(movie_id).title(title).director(director).releasedate(releasedate).rating(rating)
                .build();
    }
}
