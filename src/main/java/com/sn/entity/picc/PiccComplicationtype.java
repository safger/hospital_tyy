package com.sn.entity.picc;


public class PiccComplicationtype  {
	 
	 
	 
		private java.lang.String fuid;
		private java.util.Date createdate;
		private java.lang.String name;
		private java.lang.String symptom;
		private java.lang.String process;
		private java.lang.String evaluation;
		
		
		private String cinfoId;
		private String ctypeId;
		private String InfusionTool;
		private String Parts;

		public void setFuid(java.lang.String value) {
			this.fuid = value;
		}
		
		public java.lang.String getFuid() {
			return this.fuid;
		}
		public void setCreatedate(java.util.Date value) {
			this.createdate = value;
		}
		
		public java.util.Date getCreatedate() {
			return this.createdate;
		}
		public void setName(java.lang.String value) {
			this.name = value;
		}
		
		public java.lang.String getName() {
			return this.name;
		}
		public void setSymptom(java.lang.String value) {
			this.symptom = value;
		}
		
		public java.lang.String getSymptom() {
			return this.symptom;
		}
		public void setProcess(java.lang.String value) {
			this.process = value;
		}
		
		public java.lang.String getProcess() {
			return this.process;
		}
		public void setEvaluation(java.lang.String value) {
			this.evaluation = value;
		}
		
		public java.lang.String getEvaluation() {
			return this.evaluation;
		}

		public String getCinfoId() {
			return cinfoId;
		}

		public void setCinfoId(String cinfoId) {
			this.cinfoId = cinfoId;
		}

		public String getCtypeId() {
			return ctypeId;
		}

		public void setCtypeId(String ctypeId) {
			this.ctypeId = ctypeId;
		}

		public String getInfusionTool() {
			return InfusionTool;
		}

		public void setInfusionTool(String infusionTool) {
			InfusionTool = infusionTool;
		}

		public String getParts() {
			return Parts;
		}

		public void setParts(String parts) {
			Parts = parts;
		}
	

}	 

