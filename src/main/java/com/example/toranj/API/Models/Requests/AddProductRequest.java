package com.example.toranj.API.Models.Requests;


import com.example.toranj.Core.Commands.CreateProductCommand;
import com.example.toranj.Core.Commands.ICommand;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class AddProductRequest {
    private String name ;
    private BigDecimal price ;
    private int count_available ;

    public ICommand ToCommand() {
        var command = new CreateProductCommand() ;
        command.setName(this.name);
        command.setPrice(this.price);
        command.setCount_available(this.count_available);
        return command ;
    }
}
