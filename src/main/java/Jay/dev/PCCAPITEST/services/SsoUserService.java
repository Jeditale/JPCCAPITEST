package Jay.dev.PCCAPITEST.services;

import Jay.dev.PCCAPITEST.entities.SsoUserEntity;
import Jay.dev.PCCAPITEST.repositories.SsoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SsoUserService {

    @Autowired
    private SsoUserRepository ssoUserRepository;

    public List<SsoUserEntity> getAllUsers() {
        return ssoUserRepository.findAll();
    }


    public SsoUserEntity createUser(SsoUserEntity ssoUserEntity) {
        try {
            // Set the tokenId to some value, for example, generate or assign one
            if (ssoUserEntity.getTokenId() == null || ssoUserEntity.getTokenId().trim().isEmpty()) {
                // Assign a default tokenId or generate one here
                ssoUserEntity.setTokenId("");  // Replace with actual token logic
            }

            // Set the request date if it's not set
            if (ssoUserEntity.getRequestDate() == null) {
                ssoUserEntity.setRequestDate(LocalDateTime.now());
            }

            return ssoUserRepository.save(ssoUserEntity);
        } catch (Exception e) {
            // Handle exceptions, e.g., database connection failure
            return null;
        }
    }


}
