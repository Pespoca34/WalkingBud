package walkingBud.messaging.producers;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import walkingBud.messaging.events.RideRequestEvent;

@Service
@RequiredArgsConstructor
public class RideEventProducer {

    private final KafkaTemplate<String, RideRequestEvent> kafkaTemplate;

    public void publish(String rideId) {
        RideRequestEvent event = new RideRequestEvent(rideId);
        kafkaTemplate.send("ride", rideId, event);
    }
}
