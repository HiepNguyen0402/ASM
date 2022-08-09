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
		// TODO Auto-generated method stub
		return pDao.findAll();
	}

	@Override
	public List<Product> listAll(String keyword) {
		if (keyword != null) {
			return pDao.search(keyword);
		}
		return pDao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pDao.findById(id).get();
	}

	

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pDao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pDao.save(product);
	}


	@Override
	public List<Product> findByCategoryId(Integer cid) {
		// TODO Auto-generated method stub
		return pDao.findByCategoryId(cid);
	}

	@Override
	public void delete(Integer id) {
		pDao.deleteById(id);
	}


}
