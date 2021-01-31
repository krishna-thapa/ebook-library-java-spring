package com.krishna.onlinelibrary.service;

import com.krishna.onlinelibrary.helper.EmailBuilder;
import com.krishna.onlinelibrary.helper.EmailValidator;
import com.krishna.onlinelibrary.models.AppUser;
import com.krishna.onlinelibrary.models.AppUserRole;
import com.krishna.onlinelibrary.models.ConfirmationToken;
import com.krishna.onlinelibrary.repository.EmailSender;
import com.krishna.onlinelibrary.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService implements EmailBuilder {

  private final EmailValidator emailValidator;
  private final AppUserService appUserService;
  private final ConfirmationTokenService confirmationTokenService;
  private final EmailSender emailSender;

  public String register(RegistrationRequest request) {

    boolean isValidEmail = emailValidator.test(request.getEmail());

    if (!isValidEmail) {
      throw new IllegalStateException("Email is not valid");
    }
    String token =  appUserService.signUpUser(
            new AppUser(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getEmail(),
                    request.getPassword(),
                    AppUserRole.USER
            )
    );

    String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;

    emailSender.send(
            request.getEmail(),
            buildEmail(request.getFirstName(), link)
    );
    return token;
  }

  @Transactional
  public String confirmToken(String token) {
    ConfirmationToken confirmationToken = confirmationTokenService
            .getToken(token)
            .orElseThrow(() ->
                    new IllegalStateException("Token not found"));

    if (confirmationToken.getConfirmedAt() != null){
      throw new IllegalStateException("email is already confirmed");
    }

    LocalDateTime expiredAt = confirmationToken.getExpiresAt();

    if(expiredAt.isBefore(LocalDateTime.now())) {
      throw new IllegalStateException("Token is expired");
    }

    confirmationTokenService.setConfirmedAt(token);
    appUserService.enableAppuser(
            confirmationToken.getAppUser().getEmail()
    );
    return "confirmed";
  }
}
