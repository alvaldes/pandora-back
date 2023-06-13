package cu.cujae.pandora.back.comms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LdapWrapFullLoginResponse {
    private LdapFullLoginResponse user;
}
