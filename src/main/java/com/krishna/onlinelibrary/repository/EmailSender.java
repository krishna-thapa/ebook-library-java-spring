package com.krishna.onlinelibrary.repository;

public interface EmailSender {
  void send(String to, String email);
}
