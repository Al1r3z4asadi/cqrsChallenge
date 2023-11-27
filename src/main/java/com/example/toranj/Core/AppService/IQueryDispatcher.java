package com.example.toranj.Core.AppService;

import com.example.toranj.Core.Queries.Handlers.IQueryHandler;
import com.example.toranj.Core.Queries.IQuery;

public interface IQueryDispatcher {
    <Q extends IQuery<R>, R> R dispatch(Q query) ;
}
