package com.krishna.onlinelibrary.service;

import com.krishna.onlinelibrary.helper.EmailValidator;
import com.krishna.onlinelibrary.models.AppUser;
import com.krishna.onlinelibrary.models.AppUserRole;
import com.krishna.onlinelibrary.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private final EmailValidator emailValidator;
  private final AppUserService appUserService;

  public String register(RegistrationRequest request) {
    boolean isValidEmail = emailValidator.test(request.getEmail());
    if (!isValidEmail) {
      throw new IllegalStateException("Email is not valid");
    }
    return appUserService.signUpUser(
            new AppUser(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getEmail(),
                    request.getPassword(),
                    AppUserRole.USER
            )
    );
  }
}
