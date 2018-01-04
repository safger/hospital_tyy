package com.sn.entity.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Organize  {
	 
	
		private java.lang.String fuid;
		private java.lang.String parentid;
		private java.lang.Integer code;
		private java.lang.String fullname;
		private java.lang.Integer layer;
		private java.lang.Integer deletemark;
		private java.lang.Integer enabled;
		private java.lang.Integer sortcode;
		private java.lang.String description;
		private java.lang.String contact;
		private java.util.Date createdate;
		private java.util.Date modifydate;
		private java.lang.String zysy;
		private java.lang.String phone;
		private java.lang.String bqsy;
		private java.lang.String pingyin;
		private java.lang.String otype;
		
		private String id;
		private String text;
		private Boolean checked;
		private Boolean hasChild;
		private Map<String,Boolean> state;
		private String url;
		 private List<Object> children=new ArrayList<Object>();
		

		public void setFuid(java.lang.String value) {
			this.fuid = value;
		}
		
		public java.lang.String getFuid() {
			return this.fuid;
		}
		public void setParentid(java.lang.String value) {
			this.parentid = value;
		}
		
		public java.lang.String getParentid() {
			return this.parentid;
		}
		public void setCode(java.lang.Integer value) {
			this.code = value;
		}
		
		public java.lang.Integer getCode() {
			return this.code;
		}
		public void setFullname(java.lang.String value) {
			this.fullname = value;
		}
		
		public java.lang.String getFullname() {
			return this.fullname;
		}
		public void setLayer(java.lang.Integer value) {
			this.layer = value;
		}
		
		public java.lang.Integer getLayer() {
			return this.layer;
		}
		public void setDeletemark(java.lang.Integer value) {
			this.deletemark = value;
		}
		
		public java.lang.Integer getDeletemark() {
			return this.deletemark;
		}
		public void setEnabled(java.lang.Integer value) {
			this.enabled = value;
		}
		
		public java.lang.Integer getEnabled() {
			return this.enabled;
		}
		public void setSortcode(java.lang.Integer value) {
			this.sortcode = value;
		}
		
		public java.lang.Integer getSortcode() {
			return this.sortcode;
		}
		public void setDescription(java.lang.String value) {
			this.description = value;
		}
		
		public java.lang.String getDescription() {
			return this.description;
		}
		public void setContact(java.lang.String value) {
			this.contact = value;
		}
		
		public java.lang.String getContact() {
			return this.contact;
		}
		public void setCreatedate(java.util.Date value) {
			this.createdate = value;
		}
		
		public java.util.Date getCreatedate() {
			return this.createdate;
		}
		public void setModifydate(java.util.Date value) {
			this.modifydate = value;
		}
		
		public java.util.Date getModifydate() {
			return this.modifydate;
		}
		public void setZysy(java.lang.String value) {
			this.zysy = value;
		}
		
		public java.lang.String getZysy() {
			return this.zysy;
		}
		public void setPhone(java.lang.String value) {
			this.phone = value;
		}
		
		public java.lang.String getPhone() {
			return this.phone;
		}
		public void setBqsy(java.lang.String value) {
			this.bqsy = value;
		}
		
		public java.lang.String getBqsy() {
			return this.bqsy;
		}
		public void setPingyin(java.lang.String value) {
			this.pingyin = value;
		}
		
		public java.lang.String getPingyin() {
			return this.pingyin;
		}
		public void setOtype(java.lang.String value) {
			this.otype = value;
		}
		
		public java.lang.String getOtype() {
			return this.otype;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Boolean getChecked() {
			return checked;
		}

		public void setChecked(Boolean checked) {
			this.checked = checked;
		}

		public Boolean getHasChild() {
			return hasChild;
		}

		public void setHasChild(Boolean hasChild) {
			this.hasChild = hasChild;
		}

		public Map<String, Boolean> getState() {
			return state;
		}

		public void setState(Map<String, Boolean> state) {
			this.state = state;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<Object> getChildren() {
			return children;
		}

		public void setChildren(List<Object> children) {
			this.children = children;
		}
	

}	 

