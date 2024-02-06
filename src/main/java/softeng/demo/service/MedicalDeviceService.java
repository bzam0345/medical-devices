package softeng.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softeng.demo.model.MedicalDevice;
import softeng.demo.repository.MedicalDeviceRepository;

import java.util.List;

@Service
public class MedicalDeviceService {
    @Autowired
    private MedicalDeviceRepository repository;
    public List<MedicalDevice> listAll() {
        return repository.findAll();
    }

    public void addOrUpdateDevice(MedicalDevice device) {
        repository.save(device);
    }

    public void purchaseDevice(Long id) {
        MedicalDevice device = repository.findById(id).get();
        if (device.getStock() > 0) {
            device.setStock(device.getStock() - 1);
            repository.save(device);
        }
    }

    public void incrementDevice(Long id) {
        MedicalDevice device = repository.findById(id).get();
        if (device.getStock() >= 0) {
            device.setStock(device.getStock() + 1);
            repository.save(device);
        }
    }
    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
