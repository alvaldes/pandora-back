package cu.cujae.pandora.back.auth.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthResponseDto {
    @NonNull
    private String accessToken;
    private String tokenType = "Bearer ";
}
