package com.example.toranj.Core.AppService;

import com.example.toranj.Core.Events.IEvent;

public interface IEventDispatcher {
    <T extends IEvent> void dispatch(T event);

}
