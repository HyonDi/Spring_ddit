package com.groupware.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;

public class ModifyEmployeeRequest {
	private String id;//pk
	private String pwd;
	private String eno;//후보키
	private String name;
	private String[] email;//후보키
	private int enabled;
	private String phone_c;
	private String phone_p;
	
	private MultipartFile picture; //얘도파일 / inputType file 은 value를 지정할 수 없음.
	private String old_picture;
	private Date regDate;
	private String position;
	private String authority;
	private String deptName;
	private String postCode;
	private String address1;
	private String address2;
	
	private String[] ssn;
	private String remark;
	private String register;
	private Date recentLoginTime;
	private String posi_no;
	private String dept_no;
	private CareerVO[] careers;
	
	// inputType = file
	private MultipartFile licenseDoc;
	private MultipartFile graduDoc;
	private MultipartFile scoreDoc;

	// inputType = text / 수정시 위 file이 안들어오면 아래 old 들을 유지한다.
	private String old_licenseDoc;
	private String old_graduDoc;
	private String old_scoreDoc;

	
	@Override
	public String toString() {
		return "ModifyImployeeRequest [id=" + id + ", pwd=" + pwd + ", eno=" + eno + ", name=" + name + ", email="
				+ Arrays.toString(email) + ", enabled=" + enabled + ", phone_c=" + phone_c + ", phone_p=" + phone_p
				+ ", picture=" + picture + ", regDate=" + regDate + ", position=" + position + ", authority="
				+ authority + ", deptName=" + deptName + ", postCode=" + postCode + ", address1=" + address1
				+ ", address2=" + address2 + ", ssn=" + Arrays.toString(ssn) + ", remark=" + remark + ", register="
				+ register + ", recentLoginTime=" + recentLoginTime + ", posi_no=" + posi_no + ", dept_no=" + dept_no
				+ ", careers=" + Arrays.toString(careers) + ", licenseDoc=" + licenseDoc + ", graduDoc=" + graduDoc
				+ ", scoreDoc=" + scoreDoc + ", old_licenseDoc=" + old_licenseDoc + ", old_graduDoc=" + old_graduDoc
				+ ", old_scoreDoc=" + old_scoreDoc + "]";
	}


	public String getOld_picture() {
		return id;
	}
	public void setOld_picture() {
		this.old_picture = old_picture;
	}
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getEno() {
		return eno;
	}



	public void setEno(String eno) {
		this.eno = eno;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String[] getEmail() {
		return email;
	}



	public void setEmail(String[] email) {
		this.email = email;
	}



	public int getEnabled() {
		return enabled;
	}



	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}



	public String getPhone_c() {
		return phone_c;
	}



	public void setPhone_c(String phone_c) {
		this.phone_c = phone_c;
	}



	public String getPhone_p() {
		return phone_p;
	}



	public void setPhone_p(String phone_p) {
		this.phone_p = phone_p;
	}



	public MultipartFile getPicture() {
		return picture;
	}



	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}



	public Date getRegDate() {
		return regDate;
	}


	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public String getPostCode() {
		return postCode;
	}



	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}



	public String getAddress1() {
		return address1;
	}



	public void setAddress1(String address1) {
		this.address1 = address1;
	}



	public String getAddress2() {
		return address2;
	}



	public void setAddress2(String address2) {
		this.address2 = address2;
	}



	public String[] getSsn() {
		return ssn;
	}



	public void setSsn(String[] ssn) {
		this.ssn = ssn;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getRegister() {
		return register;
	}



	public void setRegister(String register) {
		this.register = register;
	}



	public Date getRecentLoginTime() {
		return recentLoginTime;
	}



	public void setRecentLoginTime(Date recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}



	public String getPosi_no() {
		return posi_no;
	}



	public void setPosi_no(String posi_no) {
		this.posi_no = posi_no;
	}



	public String getDept_no() {
		return dept_no;
	}



	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}



	public String getOld_licenseDoc() {
		return old_licenseDoc;
	}



	public void setOld_licenseDoc(String old_licenseDoc) {
		this.old_licenseDoc = old_licenseDoc;
	}



	public String getOld_graduDoc() {
		return old_graduDoc;
	}



	public void setOld_graduDoc(String old_graduDoc) {
		this.old_graduDoc = old_graduDoc;
	}



	public String getOld_scoreDoc() {
		return old_scoreDoc;
	}



	public void setOld_scoreDoc(String old_scoreDoc) {
		this.old_scoreDoc = old_scoreDoc;
	}



	public CareerVO[] getCareers() {
		return careers;
	}



	public ModifyEmployeeRequest() {}
	
	

	public void setCareers(CareerVO[] careers) {
		/*this.careers = careers;*/
		List<CareerVO> tempList = new ArrayList<CareerVO>();
		
		for(int i=0;i<careers.length;i++) {
			if(careers[i] == null) continue;
			tempList.add(careers[i]);
		}
		CareerVO[] temp = new CareerVO[tempList.size()]; // 인보커는 List를 인지하지못해 배열로사용한대.
		// List를겨냥해 파라미터를 저장할 수없다. 브라우저에는 List가 없기때문.
		// 하지만 불편해서 밑에 getCareerList() 메서드를 만들어 List로 받을 수 있도록 했다.
		for(int i = 0; i < tempList.size(); i ++) {
			temp[i] = tempList.get(i);
		}
		
		this.careers = temp;
	}

	public MultipartFile getLicenseDoc() {
		return licenseDoc;
	}

	public void setLicenseDoc(MultipartFile licenseDoc) {
		this.licenseDoc = licenseDoc;
	}

	public MultipartFile getGraduDoc() {
		return graduDoc;
	}

	public void setGraduDoc(MultipartFile graduDoc) {
		this.graduDoc = graduDoc;
	}

	public MultipartFile getScoreDoc() {
		return scoreDoc;
	}

	public void setScoreDoc(MultipartFile scoreDoc) {
		this.scoreDoc = scoreDoc;
	}

	public List<CareerVO> getCareerList(){
		if(careers==null) return null;
		List<CareerVO> careerList = new ArrayList<CareerVO>();
		
		for(int i=0; i<careers.length; i ++) {
			if(careers[i] == null) continue;
			careers[i].setId(this.id);
			careerList.add(careers[i]);
		}
		return careerList;
	}
	


	public EmployeeVO toEmployeeVO() {
		EmployeeVO employee = new EmployeeVO();
		employee.setId(id);
		employee.setName(name);
		employee.setDept_no(dept_no);
		employee.setPosi_no(posi_no);
		employee.setPostCode(postCode);
		employee.setAddress1(address1);
		employee.setAddress2(address2);
		
		System.out.println(email); //null
		
		employee.setEmail(email[0]+"@"+email[1]);
		
		employee.setEnabled(enabled);
		employee.setEno(eno);
		employee.setPhone_c(phone_c);
		employee.setPhone_p(phone_p);
		employee.setPwd(pwd);
		employee.setRegDate(regDate);
		employee.setRemark(remark);
		employee.setSsn(ssn[0]+ssn[1]);
		employee.setRegister(register);
		
		return employee;
	}
}
