package Jay.dev.PCCAPITEST.controllers;

import Jay.dev.PCCAPITEST.entities.SsoUserEntity;
import Jay.dev.PCCAPITEST.services.SsoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sso")
public class SsoUserController {

    @Autowired
    private SsoUserService ssoUserService;

    @GetMapping("")
    public List<SsoUserEntity> getAllUsers() {
        return ssoUserService.getAllUsers();
    }

    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody SsoUserEntity ssoUserEntity) {
        try {
            // Validate input (ensure userId and tokenId are present)
            if (ssoUserEntity.getUserId() == null || ssoUserEntity.getUserId().isBlank() ||
                    ssoUserEntity.getTokenId() == null || ssoUserEntity.getTokenId().isBlank()) {

                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("responseCode", "E000001");
                errorResponse.put("responseMessage", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");

                Map<String, String> responseData = new HashMap<>();
                responseData.put("userId", ssoUserEntity.getUserId() != null ? ssoUserEntity.getUserId() : "");
                responseData.put("tokenId", ssoUserEntity.getTokenId() != null ? ssoUserEntity.getTokenId() : "");

                errorResponse.put("responseData", responseData);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            // Save user entity
            SsoUserEntity savedUser = ssoUserService.createUser(ssoUserEntity);

            // Success response
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("responseCode", "I07000");
            successResponse.put("responseMessage", "ทำรายการเรียบร้อย");

            Map<String, String> responseData = new HashMap<>();
            responseData.put("userId", savedUser.getUserId());
            responseData.put("tokenId", savedUser.getTokenId());

            successResponse.put("responseData", responseData);
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);

        } catch (Exception e) {
            // Database error response
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("responseCode", "E000001");
            errorResponse.put("responseMessage", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");

            Map<String, String> responseData = new HashMap<>();
            responseData.put("userId", ssoUserEntity.getUserId() != null ? ssoUserEntity.getUserId() : "");
            responseData.put("tokenId", ssoUserEntity.getTokenId() != null ? ssoUserEntity.getTokenId() : "");

            errorResponse.put("responseData", responseData);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


}
