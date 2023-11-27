package com.example.toranj.Core.Commands;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateCustomerCommand implements ICommand {
    private String phoneNumber;
}
