package Jay.dev.PCCAPITEST.repositories;

import Jay.dev.PCCAPITEST.entities.SsoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SsoUserRepository extends JpaRepository<SsoUserEntity, LocalDateTime> {
}
