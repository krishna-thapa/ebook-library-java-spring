package com.krishna.onlinelibrary.service;

import com.krishna.onlinelibrary.request.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "Works";
    }
}
