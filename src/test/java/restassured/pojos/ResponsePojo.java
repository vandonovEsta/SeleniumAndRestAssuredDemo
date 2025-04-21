package restassured.pojos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@ToString
public class ResponsePojo {
    private Slideshow slideshow;
}
