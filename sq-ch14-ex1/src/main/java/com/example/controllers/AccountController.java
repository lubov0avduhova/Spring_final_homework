package com.example.controllers;

import com.example.services.FileGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.TransferRequest;
import com.example.model.Account;
import com.example.services.TransferService;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

  private final TransferService transferService;
  @Autowired
  private FileGateway fileGateway;


  @PostMapping("/transfer")
  public void transferMoney(
      @RequestBody TransferRequest request
      ) {
    transferService.transferMoney(
        request.getSenderAccountId(),
        request.getReceiverAccountId(),
        request.getAmount());
  }

  @GetMapping("/accounts")
  public Iterable<Account> getAllAccounts(
      @RequestParam(required = false) String name
  ) {
    if (name == null) {
      return transferService.getAllAccounts();
    } else {
      return transferService.findAccountsByName(name);
    }
  }


  @PostMapping("addAccount")
  public ResponseEntity<Account> addAccount(@RequestBody Account account) {
    fileGateway.writeToFile(account.getName() +".txt", account.toString());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
