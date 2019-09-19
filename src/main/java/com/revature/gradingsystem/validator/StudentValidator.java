package com.revature.gradingsystem.validator;


import com.revature.gradingsystem.dao.ValidatorDao;
import com.revature.gradingsystem.dao.ValidatorDaoImpl;
import com.revature.gradingsystem.exception.DBException;
import com.revature.gradingsystem.exception.ValidatorException;

public class StudentValidator {

	public void isRegnoUpdated(int regno) throws ValidatorException{

		int reg_no = 0;
		String status = "";
		ValidatorDao validator = new ValidatorDaoImpl();
		try {
			reg_no = validator.findRegNo(regno);
			status = validator.isMarkUpdated(regno);
		} catch (DBException e) {
			throw new ValidatorException(e.getMessage());
		}	
		
		if(regno != reg_no)
			throw new ValidatorException("Register Number doesn't Exist");
		if(status == "exist")
			throw new ValidatorException(regno+" already Updated..");
	}
	public void isRegnoExistService(int regno) throws ValidatorException{

		int reg_no = 0;
		ValidatorDao validator = new ValidatorDaoImpl();
		try {
			reg_no = validator.findRegNo(regno);
		} catch (DBException e) {
			throw new ValidatorException(e.getMessage());
		}	
		
		if(regno != reg_no)
			throw new ValidatorException("Register Number doesn't Exist");
		
	}
		

	public int ischangeInteger(String reg) throws ValidatorException {

		int regno = 0;
		
		try {
			regno = Integer.parseInt(reg);
		} catch (Exception e) {
			throw new ValidatorException("Invalid Reg-No, Please try again.");
		}
		return regno;
	}
}
