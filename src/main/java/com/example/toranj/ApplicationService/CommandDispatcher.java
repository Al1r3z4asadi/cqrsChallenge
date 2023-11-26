package com.example.toranj.ApplicationService;

import com.example.toranj.Core.AppService.ICommandDispatcher;
import com.example.toranj.Core.Commands.Handlers.ICommandHandler;
import com.example.toranj.Core.Commands.ICommand;
import com.example.toranj.Core.Utils.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CommandDispatcher implements ICommandDispatcher {
    private final Map<Class<? extends ICommand>, ICommandHandler<?>> commandHandlers;

    @Autowired
    public CommandDispatcher(List<ICommandHandler<?>> handlers) {
        this.commandHandlers = handlers.stream()
                .collect(Collectors.toMap(handler -> (Class<? extends ICommand>) ResolvableType.forClass(handler.getClass())
                        .as(ICommandHandler.class).resolveGeneric(0), Function.identity()));
    }

    public <T extends ICommand> ServiceResult dispatch(T command) {
        ICommandHandler<T> handler = (ICommandHandler<T>) commandHandlers.get(command.getClass());
        if (handler == null) {
            throw new UnsupportedOperationException("No handler found for command: " + command.getClass());
        }
        return handler.handle(command);
    }
}
