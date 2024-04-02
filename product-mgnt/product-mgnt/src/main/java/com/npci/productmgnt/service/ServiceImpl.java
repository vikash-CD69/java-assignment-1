package com.npci.productmgnt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.npci.productmgnt.entity.Product;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
	
//	{
//		  "name" : "pen",
//		  "price" : 10,
//		  "quantity" : 10
//		}

	List<Product> products = new ArrayList();
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		int id=0;
		if(products.size()==0) {
			id=1;
		}
		else {
		id = products.get(products.size() - 1).getId();
		id++;
		}
		product.setId(id);
		products.add(product);
		return product;
	}

	@Override
	public Map<Object, Object> generateBills() {
//		Products        Collection having the products
//		Total           Price Total price without tax
//		CGST 9%         9% of total price
//		SGST 9%         9% of total price
//		Final Total     Value of Total Price + 18% GST
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("Products",products);
		double sum=0;
		for(Product p : products) {
			sum+=p.getPrice();
		}
		map.put("Price",sum);
		double cgst = sum*0.09;
		double sgst = sum*0.09;
		map.put("CGST 9%", cgst);
		map.put("SGST 9%", sgst);
		map.put("Final Total", sum+cgst+sgst);
		
		return map;
	}

	@Override
	public boolean deleteProduct(int id) {
		for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true; 
            }
        }
        return false;
	}

}
