package com.example.toranj.Core.Commands;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class CreateProductCommand implements ICommand  {

    private String name ;
    private BigDecimal price ;
    private String count_available;
}
