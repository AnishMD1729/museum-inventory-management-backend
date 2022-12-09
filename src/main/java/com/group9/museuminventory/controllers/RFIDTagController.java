package com.group9.museuminventory.controllers;

import com.group9.museuminventory.models.Person;
import com.group9.museuminventory.models.RFIDTag;
import com.group9.museuminventory.repository.PersonRepository;
import com.group9.museuminventory.repository.RFIDTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/rfid_tag")
public class RFIDTagController {

    @Autowired
    private RFIDTagRepository rfidTagRepository;
    @Autowired
    private NotificationController notificationController;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public RFIDTag getRFIDTag(@PathVariable UUID id) {
        return rfidTagRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<RFIDTag> getAllRFIDTags() {
        return rfidTagRepository.findAll();
    }

    @PostMapping
    public RFIDTag createRFIDTag(@RequestBody RFIDTag rfidTag) {
        return rfidTagRepository.save(rfidTag);
    }

    @PutMapping
    public RFIDTag updateRFIDTag(@RequestBody RFIDTag rfidTag) {
        return rfidTagRepository.save(rfidTag);
    }

    @DeleteMapping("/{id}")
    public void deleteRFIDTag(@PathVariable UUID id) {
        rfidTagRepository.deleteById(id);
    }

    @PutMapping("/{id}/update-storage-coordinates")
    public ResponseEntity<RFIDTag> updateStorageCoordinates(@RequestParam String storageCoordinates,
                                                            @PathVariable UUID id) {
        Optional<RFIDTag> rfidTagOptional = rfidTagRepository.findById(id);
        if (rfidTagOptional.isPresent()) {
            RFIDTag rfidTag = rfidTagOptional.get();
            rfidTag.setStorageCoordinates(storageCoordinates);
            rfidTag = rfidTagRepository.save(rfidTag);

            notificationController.sendEmail(storageCoordinates);
            return ResponseEntity.ok(rfidTag);
        }

        return ResponseEntity.notFound().build();
    }
}
