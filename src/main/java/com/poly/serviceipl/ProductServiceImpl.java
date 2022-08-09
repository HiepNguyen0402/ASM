package com.poly.serviceipl;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO pDao;

    @Override
    public List<Product> findAll() {
        return pDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pDao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(Integer cid) {
        return pDao.findByCategoryId(cid);
    }

}
