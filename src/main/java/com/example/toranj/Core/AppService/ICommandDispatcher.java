package com.example.toranj.Core.AppService;
import com.example.toranj.Core.Commands.ICommand;
import com.example.toranj.Core.Utils.ServiceResult;

public interface ICommandDispatcher {
    <T extends ICommand> ServiceResult dispatch(T command);
}
