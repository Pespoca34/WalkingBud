package walkingBud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import walkingBud.entity.RideEntity;
import walkingBud.entity.UserEntity;
import walkingBud.entity.dto.RideRequest;
import walkingBud.entity.dto.RideResponse;
import walkingBud.entity.repository.RideRepository;
import walkingBud.entity.repository.UserRepository;
import walkingBud.exceptions.UserDontExistException;
import walkingBud.messaging.producers.RideEventProducer;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RideService {

    private final RideRepository rideRepository;
    private final UserRepository userRepository;
    private final RideEventProducer rideEventProducer;

    public RideResponse requestRide(RideRequest ride) {
        UserEntity user = userRepository.findById(ride.getUserId())
                .orElseThrow(UserDontExistException::new);

        RideEntity rideEntity = new RideEntity();
        rideEntity.setUser(user);
        rideEntity.setStartingPosition(ride.getStartingPosition());
        rideEntity.setDestinationPosition(ride.getDestinationPosition());
        rideEntity.setPrice(ride.getPrice());
        rideEntity.setDate(Date.from(ride.getDate().toInstant()));

        RideEntity savedRide = rideRepository.save(rideEntity);
        rideEventProducer.publish(savedRide.getId());

        return new RideResponse()
                .rideId(savedRide.getId())
                .startingPosition(savedRide.getStartingPosition())
                .destinationPosition(savedRide.getDestinationPosition());
    }
}
