package com.example.toranj.API.Models.Requests;

import com.example.toranj.Core.Commands.CreateCustomerCommand;
import com.example.toranj.Core.Commands.ICommand;

public class AddCustomerRequest {
    private String phoneNumber;

    public ICommand ToCommand() {
        var command = new CreateCustomerCommand() ;
        command.setPhoneNumber(this.phoneNumber);
        return command ;
    }

}
