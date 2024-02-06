package softeng.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeng.demo.model.MedicalDevice;

@Repository
public interface MedicalDeviceRepository extends JpaRepository<MedicalDevice, Long> {
}
