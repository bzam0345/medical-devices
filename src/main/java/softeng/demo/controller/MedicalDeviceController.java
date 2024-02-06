package softeng.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import softeng.demo.model.MedicalDevice;
import softeng.demo.service.MedicalDeviceService;

import java.util.List;

@RestController
@RequestMapping("/api/medical-devices")
public class MedicalDeviceController {
    @Autowired // automatic dependency injection
    private MedicalDeviceService service;

    @GetMapping
    public List<MedicalDevice> listAllDevices() {
        return service.listAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDevice(@RequestBody MedicalDevice device) {
        service.addOrUpdateDevice(device);
    }

    @PostMapping("/{id}/purchase")
    public void purchaseDevice(@PathVariable Long id) {
        service.purchaseDevice(id);
    }

    @PostMapping("/{id}/increment")
    public void incrementDevice(@PathVariable Long id) {
        service.incrementDevice(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        service.deleteDevice(id);
    }
}
