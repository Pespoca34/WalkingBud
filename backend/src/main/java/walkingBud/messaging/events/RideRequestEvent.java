package walkingBud.messaging.events;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record RideRequestEvent(
        String rideId
//        String userId,
//        String startingPosition,
//        String destinationPosition,
//        BigDecimal price,
//        OffsetDateTime requestedAt
) {}
