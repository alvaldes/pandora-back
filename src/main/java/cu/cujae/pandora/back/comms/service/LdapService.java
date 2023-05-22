package cu.cujae.pandora.back.comms.service;

import cu.cujae.pandora.back.comms.client.LdapClient;
import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LdapService {
    @Autowired
    private LdapClient ldapClient;

    public LdapLoginResponse getLogin(LdapLoginRequest request){
        return ldapClient.login(request);
    }

    public LdapFullLoginResponse getFullLogin(LdapLoginRequest request){
        return ldapClient.fullLogin(request);
    }
}
