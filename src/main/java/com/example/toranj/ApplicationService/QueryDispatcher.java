package com.example.toranj.ApplicationService;

import com.example.toranj.Core.AppService.IQueryDispatcher;
import com.example.toranj.Core.Queries.Handlers.IQueryHandler;
import com.example.toranj.Core.Queries.IQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class QueryDispatcher implements IQueryDispatcher {
    private final Map<Class<? extends IQuery<?>>, IQueryHandler<?, ?>> queryHandlers;

    @Autowired
    public QueryDispatcher(List<IQueryHandler<?, ?>> handlers) {
        this.queryHandlers = handlers.stream()
                .collect(Collectors.toMap(handler -> (Class<? extends IQuery<?>>) ResolvableType.forClass(handler.getClass())
                        .as(IQueryHandler.class).resolveGeneric(0), Function.identity()));
    }

    public <Q extends IQuery<R>, R> R dispatch(Q query) {
        IQueryHandler<Q, R> handler = (IQueryHandler<Q, R>) queryHandlers.get(query.getClass());
        if (handler == null) {
            throw new UnsupportedOperationException("No handler found for query: " + query.getClass());
        }
        return handler.handle(query);
    }
}
