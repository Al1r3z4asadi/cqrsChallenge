package com.example.toranj.API.Controllers.v1;

import com.example.toranj.API.Models.Requests.AddProductRequest;
import com.example.toranj.API.Models.Response.Envelope;
import com.example.toranj.Core.AppService.ICommandDispatcher;
import com.example.toranj.Core.AppService.IQueryDispatcher;
import com.example.toranj.Core.Queries.GetProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductConctroller {

    private final ICommandDispatcher _commandDispatcher;
    private final IQueryDispatcher _queryDispatcher ;
    @PostMapping
    public ResponseEntity<Envelope> CreateProduct(@RequestBody AddProductRequest request) {
        var result = _commandDispatcher.dispatch(request.ToCommand()); ;
        return ResponseEntity.ok(
                Envelope.builder().timeStamp(now())
                        .message("product created successfully")
                        .status(result.isSuccess() ? OK : BAD_REQUEST)
                        .statusCode(result.isSuccess() ? OK.value() : BAD_REQUEST.value())
                        .build()
        ) ;
    }
    @GetMapping
    public ResponseEntity<Envelope> GetProducts() {
        var result = _queryDispatcher.dispatch(new GetProductQuery());
        return ResponseEntity.ok(
                Envelope.builder().timeStamp(now())
                        .message("product created successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(Map.of("data",result))
                        .build()
        ) ;
    }
}
