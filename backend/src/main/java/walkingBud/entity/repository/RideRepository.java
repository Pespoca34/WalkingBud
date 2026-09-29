package walkingBud.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import walkingBud.entity.RideEntity;

public interface RideRepository extends JpaRepository<RideEntity, String> {
}
