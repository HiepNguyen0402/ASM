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
	    public List<Product> findAll(){
	        return pDao.findAll();
	    }

	    @Override
	    public Product findById(Integer id) {
	        return pDao.findById(id).get();
	    }

	    @Override
	    public List<Product> findByCategoryId(String cid) {
	        return pDao.findByCategoryId(cid);
	    }

	    @Override
	    public Product create(Product product) {
	        return pDao.save(product);
	    }

	    @Override
	    public Product update(Product product) {
	        return pDao.save(product);
	    }

	    @Override
	    public void delete(Integer id) {
	        pDao.deleteById(id);
	    }
}
