package com.example.toranj.ApplicationService.QueryHandlers;

import com.example.toranj.Core.Queries.GetProductQuery;
import com.example.toranj.Core.Queries.Handlers.IQueryHandler;
import com.example.toranj.ReadDomain.ViewModels.Product.ProductView;
import org.springframework.stereotype.Service;

@Service
public class GetProductQueryHandler implements IQueryHandler<GetProductQuery, ProductView> {
    @Override
    public ProductView handle(GetProductQuery query) {
        // Handle the get product query (read logic)
        return new ProductView(/* product details */);
    }
}
