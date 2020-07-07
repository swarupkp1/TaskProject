/*
 * package com.task.java.customvalidator;
 * 
 * import java.util.List;
 * 
 * 
 * import javax.transaction.Transactional; import
 * javax.validation.ConstraintValidator; import
 * javax.validation.ConstraintValidatorContext;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.task.java.dao.UserDao; import com.task.java.model.UserDTO;
 * 
 * @Transactional public class CustomerValidator implements
 * ConstraintValidator<Customer, UserDTO> {
 * 
 * @Autowired private UserDao userDao;
 * 
 * String msg="";
 * 
 * @Override public void initialize(Customer constraint) { msg =
 * constraint.message(); }
 * 
 * @Override public boolean isValid(UserDTO form, ConstraintValidatorContext
 * context) { System.out.println("form.getFamilyId():"+form.getPancard());
 * 
 * boolean flag=false;
 * 
 * long count = userDao.countByPancard(form.getPancard());
 * 
 * System.out.println("count:"+count); if(count>0) { flag=false;
 * context.disableDefaultConstraintViolation();
 * context.buildConstraintViolationWithTemplate(msg).addPropertyNode("familyId")
 * .addConstraintViolation(); }
 * 
 * else{ flag=true; }
 * 
 * 
 * System.out.println("pancard flag:"+flag); return flag; } }
 */