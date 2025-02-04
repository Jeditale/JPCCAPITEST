package Jay.dev.PCCAPITEST.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sso_user_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SsoUserEntity {

    @Id
    @Column(name = "request_date", nullable = false, updatable = false)
    private LocalDateTime requestDate;

    @Column(name = "ssotype")
    private String ssoType;

    @Column(name = "systemid")
    private String systemId;

    @Column(name = "systemname")
    private String systemName;

    @Column(name = "systemtransactions")
    private String systemTransactions;

    @Column(name = "systemprivileges")
    private String systemPrivileges;

    @Column(name = "systemusergroup")
    private String systemUserGroup;

    @Column(name = "systemlocationgroup")
    private String systemLocationGroup;

    @Column(name = "userid")
    private String userId;

    @Column(name = "userfullname")
    private String userFullName;

    @Column(name = "userrdofficecode")
    private String userRdOfficeCode;

    @Column(name = "userofficecode")
    private String userOfficeCode;

    @Column(name = "clientlocation")
    private String clientLocation;

    @Column(name = "locationmachinenumber")
    private String locationMachineNumber;

    @Column(name = "tokenid")
    private String tokenId;

    @PrePersist
    public void setRequestDate() {
        if (this.requestDate == null) {
            this.requestDate = LocalDateTime.now();
        }
    }
}
