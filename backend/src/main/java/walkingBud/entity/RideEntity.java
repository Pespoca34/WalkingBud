package walkingBud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ride_info")
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="walker_id")
    private WalkingBudEntity walker;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity user;

    @Column(nullable=false)
    @NotBlank
    private String startingPosition;

    @Column(nullable=false)
    @NotBlank
    private String destinationPosition;

    @Column(nullable=false)
    @NotNull
    private BigDecimal price;

    @Column(nullable=false)
    @NotNull
    private Date date;
}
