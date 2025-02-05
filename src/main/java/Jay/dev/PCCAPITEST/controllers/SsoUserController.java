package Jay.dev.PCCAPITEST.controllers;

import Jay.dev.PCCAPITEST.entities.SsoUserEntity;
import Jay.dev.PCCAPITEST.services.SsoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
                // Return HTTP 400 for bad request if data is invalid
                return generateErrorResponse(ssoUserEntity, HttpStatus.BAD_REQUEST, "E000001", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
            }

            // Save user entity
            SsoUserEntity savedUser = ssoUserService.createUser(ssoUserEntity);

            // Ensure savedUser has valid data
            if (savedUser == null || savedUser.getUserId() == null) {
                // Return HTTP 500 for server errors (e.g., database issues)
                return generateErrorResponse(ssoUserEntity, HttpStatus.INTERNAL_SERVER_ERROR, "E000001", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
            }

            // Success response
            Map<String, Object> successResponse = new LinkedHashMap<>(); // Use LinkedHashMap to preserve order
            successResponse.put("responseCode", "I07000");
            successResponse.put("responseMessage", "ทำรายการเรียบร้อย");

            // Correctly mapping userId and tokenId in responseData
            Map<String, String> responseData = new LinkedHashMap<>(); // Use LinkedHashMap to preserve order
            responseData.put("userId", savedUser.getUserId());  // Correctly assign userId
            responseData.put("tokenId", savedUser.getTokenId() != null ? savedUser.getTokenId() : " ");  // Correctly assign tokenId

            successResponse.put("responseData", responseData);
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);

        } catch (Exception e) {
            // Return HTTP 500 if an exception occurs during database operations
            return generateErrorResponse(ssoUserEntity, HttpStatus.INTERNAL_SERVER_ERROR, "E000001", "ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
        }
    }
    private ResponseEntity<Object> generateErrorResponse(SsoUserEntity ssoUserEntity, HttpStatus status, String responseCode, String responseMessage) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("responseCode", responseCode);
        errorResponse.put("responseMessage", responseMessage);

        Map<String, String> responseData = new HashMap<>();
        responseData.put("userId", ssoUserEntity.getUserId() != null ? ssoUserEntity.getUserId() : " ");
        responseData.put("tokenId", ssoUserEntity.getTokenId() != null ? ssoUserEntity.getTokenId() : " ");

        errorResponse.put("responseData", responseData);
        return ResponseEntity.status(status).body(errorResponse);
    }
}




