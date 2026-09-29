package walkingBud.messaging.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import walkingBud.messaging.events.RideRequestEvent;

@Component
public class RideRequestListener {

    @KafkaListener(topics = "ride")
    public void handle(RideRequestEvent event) {
        System.out.println("Recebi essa corrida: " + event.rideId());
    }
}
