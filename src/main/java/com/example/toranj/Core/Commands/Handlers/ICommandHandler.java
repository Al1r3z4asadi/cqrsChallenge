package com.example.toranj.Core.Commands.Handlers;

import com.example.toranj.Core.Commands.ICommand;
import com.example.toranj.Core.Utils.ServiceResult;
import jakarta.transaction.Transactional;

public interface ICommandHandler <T extends ICommand> {
    @Transactional
    ServiceResult<T> handle(T command);

}
