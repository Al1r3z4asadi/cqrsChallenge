package com.example.toranj.Core.Queries.Handlers;

import com.example.toranj.Core.Queries.IQuery;

public interface IQueryHandler<Q extends IQuery<R>, R> {
    R handle(Q query);
}