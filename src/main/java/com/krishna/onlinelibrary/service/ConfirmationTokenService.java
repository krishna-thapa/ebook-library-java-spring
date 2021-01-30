package com.krishna.onlinelibrary.service;

import com.krishna.onlinelibrary.models.ConfirmationToken;
import com.krishna.onlinelibrary.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

  private final ConfirmationTokenRepository confirmationTokenRepository;

  public void saveConfirmationToken(ConfirmationToken token) {
    confirmationTokenRepository.save(token);
  }
}
