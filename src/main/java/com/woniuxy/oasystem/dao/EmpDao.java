package com.woniuxy.oasystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oasystem.entity.Emp;
/**
 * 
 * @Description 职工相关操作接口
 * @author 陈一玮
 * @changeLog 1.创建 (2020年4月23日 下午2:55:27 [陈一玮]
 */
public interface EmpDao {
	
	/**
	 * 展示在职员工信息
	 * TODO
	 * @return
	 * @changeLog 	1. 创建 (2020年4月23日 下午2:28:32 [王培霖])  </br>
	 *                      	2.
	 */
	List<Emp> displayEmp();
	/**
	 * 通过工号查询职工信息
	 * @param empId 输入的工号
	 * @return 返回职工信息
	 * @changeLog 1.创建 (2020年4月23日 下午2:54:07 [陈一玮]
	 */
	Emp getEmpId(Integer empId);
	/**
	 * 通过手机号查询职工信息
	 * @param empTel 输入的手机号
	 * @return 返回职工信息
	 * @changeLog 1.创建 (2020年4月23日 下午2:54:07 [陈一玮]
	 */
	Emp getEmpCellNumber(String empTel);
	/**
	 * 通过邮箱查询职工信息
	 * @param empEmail 输入的邮箱
	 * @return 返回职工信息
	 * @changeLog 1.创建 (2020年4月23日 下午2:54:07 [陈一玮]
	 */
	Emp getEmpEmail(String empEmail);
	/**
	 * 修改密码
	 * @param newPwd 输入的新密码
	 * @changeLog 1.创建 (2020年4月23日 下午5:23:27 [陈一玮]
	 */
	void changeNewPwd(Integer empId,String newPwd);
	/**
	 * 绑定邮箱
	 * @param empId 职工工号
	 * @param bindTel 输入的绑定手机号
	 * @changeLog 1.创建 (2020年4月23日 下午8:23:07 [陈一玮]
	 */
	void bindTel(Integer empId,String bindTel);
	/**
	 * 绑定邮箱
	 * @param empId 职工工号
	 * @param bindEmail 输入的绑定邮箱
	 * @changeLog 1.创建 (2020年4月23日 下午8:23:07 [陈一玮]
	 */
	void bindEmail(Integer empId,String bindEmail);
	
	//查询群体员工
     List<Emp> getEmps();
     
     /**
      * 模糊查询职员信息
      * @param parameter
      * @param departmentId
      * @param intervieweeGender
      * @param educationBackground
      * @return
      * @changeLog 	1. 创建 (2020年4月30日 下午2:30:53 [王培霖])  </br>
      */
    List<Emp> searchEmp(String parameter, 
    				@Param("departmentId")Integer departmentId,
    				@Param("empGender")String empGender,
    				@Param("educationBackground")String educationBackground,
    				@Param("emp")Emp emp,
    				@Param("pageIndex")int pageIndex,
    				@Param("pageSize")int pageSize);
    
    /**
     *  查询满足条件的数据条数
     * @param emp
     * @param parameter
     * @param departmentId
     * @param educationBackground
     * @return
     * @changeLog 	1. 创建 (2020年4月30日 下午4:12:04 [王培霖])  </br>
     */
    int countByPage(@Param("emp")Emp emp,
			@Param("parameter")String parameter,
			@Param("departmentId")Integer departmentId, 
			@Param("empGender")String empGender,
			@Param("educationBackground")String educationBackground);
     
     /**
      * 分页展示职工信息
      * @param emptyPosition
      * @param pageIndex
      * @param pageSize
      * @return
      * @changeLog 	1. 创建 (2020年4月30日 下午2:36:21 [王培霖])  </br>
      */
     List<Emp> selectEmpByPage(
    		 @Param("emp")Emp emp,
 			 @Param("pageIndex")int pageIndex,
 			 @Param("pageSize")int pageSize);
     
     /**
      * 修改员工个人信息
      * @param emp
      * @changeLog 	1. 创建 (2020年4月30日 下午11:02:01 [王培霖])  </br>
      *                      	2.
      */
     void modifyEmp(Emp emp);
     
     /**
 	 * 根据员工工号查询此员工对象是否存在
 	 * TODO
 	 * @param empIdNumber
 	 * @return
 	 * @changeLog 	1. 创建 (2020年4月24日 下午9:54:30 [王培霖])  </br>
 	 *                      	2.
 	 */
 	Emp verifyEmpIdNumber(String empIdNumber);
}
