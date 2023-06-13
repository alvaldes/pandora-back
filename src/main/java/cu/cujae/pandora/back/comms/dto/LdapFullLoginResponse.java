package cu.cujae.pandora.back.comms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LdapFullLoginResponse {
    private String primaryGroup;
    private String accountExpires;
    private String badPasswordTime;
    private String badPwdCount;
    private String cUJAEDataProvider;
    private String cUJAEPersonDNI;
    private String cUJAEPersonExternal;
    private String cUJAEPersonType;
    private String cUJAEWorkerTeacher;
    private String cn;
    private String codePage;
    private String countryCode;
    private String department;
    private String displayName;
    private String distinguishedName;
    private String givenName;
    private String instanceType;
    private String lastLogoff;
    private int lastLogon;
    private double lastLogonTimestamp;
    private String logonCount;
    private String mail;
    private List<String> memberOf = new ArrayList<>();
    private String name;
    private String objectCategory;
    private List<String> objectClass = new ArrayList<>();
    private String objectGUID;
    private String objectSid;
    private List<String> otherMailbox = new ArrayList<>();
    private String pager;
    private String primaryGroupID;
    private double pwdLastSet;
    private String sAMAccountName;
    private int sAMAccountType;
    private String sn;
    private String streetAddress;
    private String telephoneNumber;
    private String title;
    private int uSNChanged;
    private int uSNCreated;
    private String userAccountControl;
    private String userPrincipalName;
}
