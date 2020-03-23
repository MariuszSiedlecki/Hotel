package mario.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String bad;
    private String capacity;

    @JsonIgnore
    @ManyToMany(mappedBy = "rooms")
    private List<Hotel> hotel;

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")

                .add("type='" + type + "'")
                .add("bad='" + bad + "'")
                .add("capacity='" + capacity + "'")
                .toString();
    }
}
