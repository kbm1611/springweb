package example.day06.entity.practice6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table(name = "movie")
public class MovieEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "director", length = 50, nullable = false)
    private String director;

    @Column(length = 25)
    private String releasedate;

    private Integer rating;

    public MovieDto toDto(){
        return MovieDto.builder()
                .movie_id(movie_id).title(title).director(director).releasedate(releasedate).rating(rating)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
