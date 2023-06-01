package cu.cujae.pandora.back.comms.client;

import cu.cujae.pandora.back.comms.dto.LdapFullLoginResponse;
import cu.cujae.pandora.back.comms.dto.LdapLoginRequest;
import cu.cujae.pandora.back.comms.dto.LdapLoginResponse;
import cu.cujae.pandora.back.comms.dto.LdapWrapFullLoginResponse;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.exception.ServerSideException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    private WebClient getWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(ldapUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString((ldapUsername + ":" + ldapPassword).getBytes()))
                .build();
        return webClient;
    }

    public LdapWrapFullLoginResponse fullLogin(LdapLoginRequest request) {
        WebClient webClient = getWebClient();
        return webClient.post().uri("/full-login")
                .body(Mono.just(request), LdapLoginRequest.class)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.UNAUTHORIZED)) {
                        return Mono.error(new InvalidClientRequestException("LDAP: Username or Password incorrect", ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode()));
                    } else {
                        return Mono.error(new ServerSideException("LDAP: Unknown error", ErrorCodes.SERVER_UNKNOWN_ERROR.getErrorCode()));
                    }
                })
                .bodyToMono(LdapWrapFullLoginResponse.class).block();
    }

    public LdapLoginResponse login(LdapLoginRequest request) {
        WebClient webClient = getWebClient();
        return webClient.post().uri("/login")
                .body(Mono.just(request), LdapLoginRequest.class)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.UNAUTHORIZED)) {
                        return Mono.error(new InvalidClientRequestException("LDAP: Username or Password incorrect", ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode()));
                    } else {
                        return Mono.error(new ServerSideException("LDAP: Unknown error", ErrorCodes.SERVER_UNKNOWN_ERROR.getErrorCode()));
                    }
                })
                .bodyToMono(LdapLoginResponse.class).block();
    }

}
