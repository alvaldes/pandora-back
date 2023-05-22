package cu.cujae.pandora.back.comms.client;

import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LdapClient {
    @Value("${ldap.url}")
    private String ldapUrl;
    @Value("${ldap.username}")
    private String ldapUsername;
    @Value("${ldap.password}")
    private String ldapPassword;

    private WebClient getWebClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl(ldapUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString((ldapUsername +":"+ldapPassword).getBytes()))
                .build();
        return webClient;
    }
    public LdapFullLoginResponse getFullLogin(LdapLoginRequest request) {
        WebClient webClient = getWebClient();
        return webClient.post().uri("/full-login")
                .body(Mono.just(request), LdapLoginRequest.class)
                .retrieve()
                .bodyToMono(LdapFullLoginResponse.class).block();
    }

    public LdapLoginResponse getLogin(LdapLoginRequest request) {
        WebClient webClient = getWebClient();
        String user_pass =  ldapUsername +":"+ldapPassword;
        return webClient.post().uri("/login")
                .body(Mono.just(request), LdapLoginRequest.class)
                .retrieve()
                .bodyToMono(LdapLoginResponse.class).block();
    }

}
