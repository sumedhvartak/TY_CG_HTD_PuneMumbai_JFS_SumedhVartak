package com.capg.DAO;

import com.capg.BeanClass.Bean;

public interface UserDAO 
{
	public Bean getall();
	
	public Bean getorder(int item_code);

}
