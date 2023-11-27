package com.example.toranj.API.Controllers.v1;

import com.example.toranj.API.Models.Requests.AddProductRequest;
import com.example.toranj.API.Models.Response.Envelope;
import com.example.toranj.Core.AppService.ICommandDispatcher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ICommandDispatcher _commandDispatcher;
    @PostMapping
    public ResponseEntity<Envelope> CreateOrder(@RequestBody AddProductRequest request) {
        var result = _commandDispatcher.dispatch(request.ToCommand()); ;
        return ResponseEntity.ok(
                Envelope.builder().timeStamp(now())
                        .message("product created successfully")
                        .status(result.isSuccess() ? OK : BAD_REQUEST)
                        .statusCode(result.isSuccess() ? OK.value() : BAD_REQUEST.value())
                        .build()
        ) ;
    }
}
