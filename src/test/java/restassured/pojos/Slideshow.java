package restassured.pojos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@ToString
public class Slideshow {
    private String author;
    private String date;
    private List<Slide> slides;
    private String title;
}
