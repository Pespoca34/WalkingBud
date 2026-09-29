package walkingBud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import walkingBud.api.RideApi;
import walkingBud.entity.dto.RideRequest;
import walkingBud.entity.dto.RideResponse;
import walkingBud.service.RideService;

@RestController
@RequiredArgsConstructor
public class RideController implements RideApi {

    private final RideService rideService;

    @Override
    public ResponseEntity<RideResponse> requestRide(@RequestBody RideRequest ride){
        try{
            RideResponse rideResponse = rideService.requestRide(ride);
            return ResponseEntity.ok(rideResponse);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
