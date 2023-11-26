package com.example.toranj.Core.Commands.Handlers;

import com.example.toranj.Core.Commands.ICommand;
import com.example.toranj.Core.Utils.ServiceResult;

public interface ICommandHandler <T extends ICommand> {
    ServiceResult<T> handle(T command);

}
