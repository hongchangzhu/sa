<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="com.analysis.service.*"%>
<%
RegoinServiceImpl serviceImpl = new RegoinServiceImpl();
String regoinId = serviceImpl.getDefaultRegoinId();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<title>��ӭʹ����ԴӦ��ͳ��ϵͳ</title>
		<script language="JavaScript" src="<%=request.getContextPath()%>/js/FusionCharts.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/jquery/miniui/miniui.js" type="text/javascript"></script>
		<link href="<%=request.getContextPath()%>/js/jquery/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/js/default.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/js/stat.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/js/jquery/miniui/themes/icons.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/js/jquery/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />

<style type="text/css">
.one{
background-color:#FFFFff;
}
.two{
background-color: #eaf0f7;
}
.over{
background-color:#FF00FF;
}
</style>

	</head>
<body>
	<div style="width:100%;">
		<div class="main">
			<div class="header" style="width:100%;height:150px;padding:0;over-flow:hidden;background:url(../images/tj-2_03.gif);"></div>
	    	<div class="bodycontent">
	    		<div id="form1" class="leftdiv" style="width:234px;height:605px;float:left;background:#eaf0f7">
    				<div class="title1" style="width:100%;height:30px;background:url(../images/tj-2_05.gif);"></div>
    				<p class="lineheight8"></p>
    				
    				<div id="cond9" class="lefttile">
						<span class="title">ͳ������</span>
						<span class=""><input id="opttypeid" name="opttypeid" class="mini-combobox condcss4" url="data/opttypes.txt" value="1" textField="text" valueField="id" style="width:145px;"/></span>
					</div>
					<p class="lineheight2"></p>
    				<!-- ��ʡ�����ն�ͳ�� -->
    				<div id="cond1" class="lefttile">
						<span class="title">ʡ</span>
						<span class="condcss"><input id="provinceid" name="provinceid" class="mini-combobox" value="" textField="nodeName" valueField="id" onvaluechanged="onProvinceChanged" style="width:145px;"/></span>
					</div>
					<p class="lineheight2"></p>
					<div id="cond2" class="lefttile">
						<span class="title">��</span>
						<span class="condcss"><input id="cityid" name="cityid" class="mini-combobox" showNullItem="false" value="" textField="nodeName" valueField="id" onvaluechanged="onCityChanged" style="width:145px;"/></span>
					</div>
					<p class="lineheight2"></p>
					<div id="cond3" class="lefttile">
						<span class="title">�����أ�</span>
						<span class="condcss4"><input id="countryid" name="countryid" class="mini-combobox" showNullItem="false" value="" textField="nodeName" valueField="id" onvaluechanged="onCountryChanged" style="width:145px;"/></span>
					</div>
					<p class="lineheight2"></p>
					<div id="cond4" class="lefttile unbootDiv">
						<span class="title">�ն�վ��</span>
						<span class="condcss4">
						<!-- 
						<input id="termid" name="termid" class="mini-combobox" showNullItem="false" value="" textField="termName" valueField="termId" style="width:145px;"/>
						 -->
						 <input id="termid" name="termid" class="mini-textbox" value="" style="width:145px;"/>
						</span>
					</div>
					<p class="lineheight2"></p>
					<!-- ʱ��� -->
					<div class="lefttile startdate1">
						<span class="title">��ʼʱ��</span>
						<span class="datecss"><input id="date1" name="date1" class="mini-datepicker condcss6" format="yyyy-MM-dd" value="" 
							required="true" style="width:145px;" requiredErrorText="��ʼʱ�䲻��Ϊ��"/></span>
					</div>
					<p class="lineheight2"></p>
					<div class="lefttile enddate1">
						<span class="title">����ʱ��</span>
						<span class="datecss"><input id="date2" name="date2" class="mini-datepicker condcss6" format="yyyy-MM-dd" value="" 
							required="true" style="width:145px;" requiredErrorText="����ʱ�䲻��Ϊ��"/></span>
					</div>
					<p class="lineheight2"></p>	
					<div class="lefttile resclickcount">
						<span class="title">��Դ�����</span>
						<span class="condcss9">
						<input id="resclickcount" name="resclickcount" class="mini-textbox" required="false" vtype="int" style="width:145px;"/>
						</span>
					</div>	
					<p class="lineheight2"></p>
					<div id="tj">
						<span></span>
						<span class="tjcss"><img src="<%=request.getContextPath() %>/images/tj-2_12.gif" onclick="submitForm()" style="cursor:pointer;"></span>
					</div>
					<p class="lineheight8"></p>
					
					
					
					
					
					
					
					
					
					<!-- ��̨���� -->
					<div class="title1" style="width:100%;height:30px;background:url(../images/tj-2_15.gif);"></div>
					<p class="lineheight8"></p>
					<div class="">
						<span></span>
						<span class="condcss5"><input id="restype" name="restype" class="mini-combobox" url="data/restypes.txt" 
							value="1" textField="text" valueField="id" style="width:145px;"/>
						</span>
					</div>
					<p class="lineheight2"></p>
					<div class="">
						<span></span>
						<span class="condcss5"><input id="reststat" name="reststat" class="mini-combobox" url="data/resstat.txt" 
							value="1" textField="text" valueField="id" style="width:145px;"/>
						</span>
					</div>
					<p class="lineheight2"></p>
					<div class="periodmodel2">
						<div>
							<span></span>
							<span class="condcss6">��&nbsp;<input id="date3" name="date3" class="mini-datepicker" format="yyyy-MM-dd" value="" required="false" style="width:145px;"/></span>
						</div>
						<div>
							<span></span>
							<span class="condcss6">��&nbsp;<input id="date4" name="date4" class="mini-datepicker" format="yyyy-MM-dd" value="" required="false" style="width:145px;"/></span>
						</div>
					</div>
					
					<!-- ���� -->
    				<div class="weekmodel2">
						<span></span>
						<span class=""><input id="week2" name="week2" 
							showNullItem="false" class="mini-combobox condcss52" url="loadData.jsp?method=LoadWeekData" value="-1" textField="text" 
							valueField="id" style="width:65px;"/>
						</span>
					</div>
					
					<p class="lineheight2"></p>
					<div id="cond8" class="lefttile backsub">
						<span class="title">ѧ��</span>
						<span class="condcss2"><input id="subjectid2" name="subjectid2" showNullItem="false" class="mini-combobox" onvaluechanged="onSubjectChanged2" value="" textField="subjectName" valueField="subjectId" style="width:145px;"/></span>
					</div>
					
					<p class="lineheight2"></p>
					<div id="cond7" class="lefttile backcls">
						<span class="title">�꼶</span>
						<span class="condcss2"><input id="classid2" name="classid2" nullItemText="" showNullItem="false" class="mini-combobox" value="" textField="bookCatelogName" valueField="bookCatelogId" style="width:145px;"/></span>
					</div>
					
					<p class="lineheight2"></p>
					<div id="tj2">
						<span></span>
						<span class="tjcss"><img src="<%=request.getContextPath() %>/images/tj-2_12.gif" onclick="submitForm2()" style="cursor:pointer;"></span>
					</div>
	    		</div>
	    		
	    		<div class="bgDiv" style="width:755px;float:left;height:605px;background:url(../images/tj-2_07.gif);">
	    		
	    			<div class="gridcss">
		    			<p style="margin:10px">
		    			<div style="width:700px;">
					        <div  style="border-bottom:0;padding:0px;">
					            <table style="width:100%;">
					                <tr>
					                    <td style="width:100%;" align="left">
					                        <span class="resulttitle"></span>     
					                    </td>
					                    
					                </tr>
					            </table>           
					        </div>
					    </div>
		    			<!-- ��Դ���� -->
		    			<div id="datagrid1" class="mini-datagrid" style="width:700px;height:300px;" allowResize="false"
						    url="loadData.jsp?method=statResCount" sizeList="[20,30,50,100]" pageSize="10">
						    
						    <div property="columns">
	        					<div type="indexcolumn" ></div>
								<div field="adddate" width="80" headerAlign="center" align="center" allowSort="false">����</div>
								<div field="termname" width="200" headerAlign="center" align="left" allowSort="false">վ����</div>
								<div field="regoinname" width="250" headerAlign="center" align="left" allowSort="false">��������</div>
								<div field="retotal" width="60" headerAlign="center" align="right" allowSort="false">��Դ������</div>
							</div>
						</div>
						
						<!-- �ն˻�Ծ�� -->
		    			<div id="datagrid2" class="mini-datagrid" style="width:700px;height:300px;" allowResize="false"
						    url="loadData.jsp?method=statResClickCount" sizeList="[20,30,50,100]" pageSize="10">
						    
						    <div property="columns">
	        					<div type="indexcolumn" ></div>
								<div field="termname" width="200" headerAlign="center" align="left" allowSort="false">վ����</div>
								<div field="regoinname" width="310" headerAlign="center" align="left" allowSort="false">��������</div>
								<div field="retotal" width="80" headerAlign="center" align="right" allowSort="false">��Դ�ܵ����</div>
							</div>
						</div>
						
						<!-- ������Դ -->
		    			<div id="datagrid3" class="mini-datagrid" style="width:700px;height:300px;" allowResize="false"
						    url="loadData.jsp?method=statHotRes" sizeList="[20,30,50,100]" pageSize="10">
						    
						    <div property="columns">
	        					<div type="indexcolumn" ></div>
								<div field="resname" width="200" headerAlign="center" align="left" allowSort="false">��Դ��</div>
								<div field="respath" width="330" headerAlign="center" align="left" allowSort="false">��Դ·��</div>
								<div field="clickcount" width="60" headerAlign="center" align="right" allowSort="false">��Դ�����</div>
							</div>
						</div>
					
					</div>
					
	    			
					
	    			<div class="fusionchartsDiv" id="form2">
		    			<p style="margin:10px">
		    			<div class="chartstypecss">
		    				<span style="height:30px;"><input id="charttypesid" name="charttypesid" class="mini-combobox" url="data/chartstypes.txt" 
		    					value="../fusioncharts/Column3D.swf" textField="text" valueField="id" onvaluechanged="onChartsChanged"/></span>
		    				<span style="right:-412px;position:relative;height:30px;cursor:pointer;">
		    					<img src="<%=request.getContextPath() %>/images/xls.gif" onclick="exportRs()" title="����excel">
		    					<!-- <a href="#" onclick="exportRs()">��������</a> -->
		    					
		    				</span>
		    				<input id="exportcond" class="mini-hidden"/>
		    			</div>
		    			<p style="margin:5px">
		    			<div id="chartdiv" align="center"> </div>
		    		</div>
	    		
	    		</div>
	    	</div>
	    	
	    	<div class="footer" style="width:100%;height:22px;float:left;background:#e6e6e6;">
	    		<div style="width:100%;">
	    			<span style="font-family:Arial;font-size:13px;font-weight:normal;font-style:normal;text-decoration:none;color:#333333;">��Ȩ���У�����绯������</span>
	    		</div>
	    	</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
mini.parse();

var grid1 = mini.get("datagrid1");
var grid2 = mini.get("datagrid2");
var grid3 = mini.get("datagrid3");

var province = mini.get("provinceid");
var city = mini.get("cityid");
var country = mini.get("countryid");
var term = mini.get("termid");
//var times = mini.get("times");
var charttypes = mini.get("charttypesid");
var opttype = mini.get("opttypeid");
var exportcond = mini.get("exportcond");
var restype = mini.get("restype");
var reststat = mini.get("reststat");
//var subject = mini.get("subjectid");
var grade = mini.get("classid");
var subject2 = mini.get("subjectid2");
var grade2 = mini.get("classid2");

$(".periodmodel").hide();
$(".weekmodel").hide();
$(".semestermodel").hide();
//$(".fusionchartsDiv").hide();
$(".chartstypecss").hide();
$(".weekmodel2").hide();
$(".backsub").hide();
$(".backcls").hide();
//$(".startdate1").hide();
$(".resclickcount").hide();

$("#datagrid1").hide();
$("#datagrid2").hide();
$("#datagrid3").hide();

//Ĭ����ʾ����		
var defaultregoinId = "<%=regoinId%>";
var nullData = [];
var all = {"id":"-","nodeName":"ȫ��"};
var allterm = {"termId":"-","termName":"ȫ��"};

//����������������
$.ajax({
    url: "loadData.jsp?method=LoadRegionData&pid=1",
    type: "post",
    success: function (text) {
        var data = mini.decode(text);   //�����л��ɶ���
        data.unshift(all);
        province.setData(data);
        province.select(0);
        //province.setValue(defaultregoinId);
        //initCity(defaultregoinId);//�Զ�����Ĭ��ʡ�������
        
        city.setData(all);
        city.select(0);
        
        country.setData(all);
        country.select(0);
        //term.setData(allterm);
        //term.select(0);
    }
});

var allsubject = {"subjectId":"-","subjectName":"ȫ��"};
var allgrade = {"bookCatelogId":"-","bookCatelogName":"ȫ��"};
//����ѧ���꼶����
$.ajax({
    url: "loadData.jsp?method=LoadSubjectData",
    type: "post",
    success: function (text) {
        var data = mini.decode(text);   //�����л��ɶ���
        var data2 = mini.clone(data);
         
   		data.unshift(allsubject);
        //subject.setData(data);
        //subject.select(0);
        
        data2.unshift(allsubject);
        subject2.setData(data2);
        subject2.select(0);
    }
});

var chartxml;
function submitForm() {
	var form = new mini.Form("#form1");
	form.validate();
	if (form.isValid() == false) return;
	
	var starttimemillis = mini.get("date1").getValue().getTime();
	var endtimemillis = mini.get("date2").getValue().getTime();
	//alert(startdate1 + " " + enddate1);
	if(starttimemillis > endtimemillis){
		mini.alert("��ʼʱ�䲻�ܴ��ڽ�ֹʱ��");
		return;
	}
	        
    var data = form.getData();      //��ȡ������ؼ�������
    var json = mini.encode(data);   //���л���JSON
    var opttypeid = data.opttypeid;
    var url = "";
    if(opttypeid == 1){
    	$("#datagrid1").show();
    	
    	$("#datagrid2").hide();
    	$("#datagrid3").hide();
    	
    	$(".resulttitle").text("��Դ����");
    	url = "loadData.jsp?method=statResCount";
    }else if(opttypeid == 2){
    	$("#datagrid2").show();
    	
    	$("#datagrid1").hide();
    	$("#datagrid3").hide();
    	
    	$(".resulttitle").text("�ն˻�Ծ��");
    	url = "loadData.jsp?method=statResClickCount";
    }else if(opttypeid == 3){
    	$("#datagrid3").show();
    	
    	$("#datagrid2").hide();
    	$("#datagrid1").hide();
    	
    	$(".resulttitle").text("������Դ");
    	url = "loadData.jsp?method=statHotRes";
    }
    
    var pageIndex = grid1.getPageIndex();
    var pageSize = grid1.getPageSize();
    
    $.ajax({
	    url: url,
	    type: "post",
	    data: { submitData: json, pageIndex: pageIndex, pageSize: pageSize},
	    success: function (text) {
	        var result = mini.decode(text);
	        var totalCount = result.total;
	        var data = result.data;
	        if(opttypeid == 1){
	        	grid1.setTotalCount(totalCount);
	        	grid1.setData(data);
	        }else if(opttypeid == 2){
	        	grid2.setTotalCount(totalCount);
	        	grid2.setData(data);
	        }else if(opttypeid == 3){
	        	grid3.setTotalCount(totalCount);
	        	grid3.setData(data);
	        }
	    }
	});
}
function submitForm_bak() {
    //�ύ������
    var form = new mini.Form("#form1");            
    var data = form.getData();      //��ȡ������ؼ�������
    var json = mini.encode(data);   //���л���JSON
    $(".chartstypecss").show();
    //$(".bgDiv").hide();
    exportcond.setValue(json);
    
    $.ajax({
        url: "<%=request.getContextPath()%>/termStatServlet.do",
        type: "post",
        data: { submitData: json },
        success: function (text) {
        	chartxml = text;
            var chartUrl = charttypes.getValue();
            fusionChartsShow(chartUrl);
        }
    });
}

function submitForm2() {
    //�ύ������
    var form = new mini.Form("#form1");            
    var data = form.getData();      //��ȡ������ؼ�������
    var vrestype = restype.getValue();
    var vreststat = reststat.getValue();
    
    var _begin = mini.get("date3").getFormValue();//data.date3;
    var _end = mini.get("date4").getFormValue();
    var subjectId = mini.get("subjectid2").getFormValue();
    var gradeId = mini.get("classid2").getFormValue();
    var beginStr = "";
    var endStr = "";
    data.date3 = _begin;
    data.date4 = _end;
    var stattypename;
    var title;
    var term = "";
    
    if(vrestype == 1){
          	title = "����Դ�ϴ�ͳ��";
    	if(vreststat == 1){
    		stattypename = "��Դ�ϴ�����";
    	}else if(vreststat == 2){
    		stattypename = "��Դ�ϴ��ܵ�����(KB)";
    	}
    }else if(vrestype == 2){//��������
    	stattypename = "����(KB)";
    	if(vreststat == 1){
    		title = "��Դ����-��ѧ��ͳ��";
    		if(subjectId == null || typeof(subjectId) == "undefined" || subjectId == "-"){
    			mini.alert("��ѡ��ѧ�ƣ�");
    			return;
    		}
    	}else if(vreststat == 2){
    		title = "��Դ����-���꼶ͳ��";
    		if(subjectId == null || typeof(subjectId) == "undefined" || subjectId == "-"){
    			mini.alert("��ѡ��ѧ�ƣ�");
    			return;
    		}
    		if(gradeId == null || typeof(gradeId) == "undefined" || gradeId == "-"){
    			mini.alert("��ѡ���꼶��");
    			return;
    		}
    	}else if(vreststat == 3){
    		title = "��Դ����-������ͳ��";
    		term = mini.get("week2").getValue();
    		if(term == null || typeof(term) == "undefined" || term == "-1"){
    			mini.alert("��ѡ��������");
    			return;
    		}
    	}else if(vreststat == 4){
    		title = "��Դ����-��ʱ���ͳ��";
    		stattypename = "�ܵ�����(KB)";
    	}
    }else if(vrestype == 3){//��������
    	stattypename = "����(KB)";
    	if(vreststat == 1){
    		title = "��Դ����-��ѧ��ͳ��";
    		if(subjectId == null || typeof(subjectId) == "undefined" || subjectId == "-"){
    			mini.alert("��ѡ��ѧ�ƣ�");
    			return;
    		}
    	}else if(vreststat == 2){
    		title = "��Դ����-���꼶ͳ��";
    		if(subjectId == null || typeof(subjectId) == "undefined" || subjectId == "-"){
    			mini.alert("��ѡ��ѧ�ƣ�");
    			return;
    		}
    		if(gradeId == null || typeof(gradeId) == "undefined" || gradeId == "-"){
    			mini.alert("��ѡ���꼶��");
    			return;
    		}
    	}else if(vreststat == 3){
    		title = "��Դ����-������ͳ��";
    		term = mini.get("week2").getValue();
    		if(term == null || typeof(term) == "undefined" || term == "-1"){
    			mini.alert("��ѡ��������");
    			return;
    		}
    	}else if(vreststat == 4){
    		title = "��Դ����-��ʱ���ͳ��";
    		stattypename = "�ܵ�����(KB)";
    	}
    }else if(vrestype == 4){//��������
    	stattypename = "����(KB)";
		if(vreststat == 3){
			title = "��������-������ͳ��";
    		term = mini.get("week2").getValue();
    		if(term == null || typeof(term) == "undefined" || term == "-1"){
    			mini.alert("��ѡ��������");
    			return;
    		}
    	}else if(vreststat == 4){
    		title = "��������-��ʱ���ͳ��";
    	}
    }
    
    var json = mini.encode(data);   //���л���JSON
    $(".chartstypecss").hide();
    $.ajax({
        url: "<%=request.getContextPath()%>/backStageServlet.do",
        type: "post",
        data: { submitData: json },
        success: function (text) {
        	//alert(text);
        	var table = $("<table></table>").addClass("stattable");
        	var _rv = mini.decode(text);
        	var code = _rv.ReCode;
            var resultNum = 0;
            
            var subjectName = _rv.subjectName;
            var gradeName = _rv.gradeName;
            if(code == 0){
	            resultNum = _rv.ReValue;
            }
		    		
		    var tr0 = $("<tr></tr>");
            var td01 = $("<th colspan='2'></th>").addClass("subitle").text(title);
            var col0 = tr0.append(td01);
            table.append(col0);
		    
		    if((vrestype == 2 || vrestype == 3) && vreststat == 1){
		    	var tr2 = $("<tr></tr>");
	            var td21 = $("<td></td>").addClass("tdTitle").text("ѧ�ƣ�");
	            var td22 = $("<td></td>").addClass("tdRight").text(subjectName);
	            var col2 = tr2.append(td21, td22);
	            table.append(col2);
		    }else if((vrestype == 2 || vrestype == 3) && vreststat == 2){
		    	var tr2 = $("<tr></tr>");
	            var td21 = $("<td></td>").addClass("tdTitle").text("ѧ�ƣ�");
	            var td22 = $("<td></td>").addClass("tdRight").text(subjectName);
	            var col2 = tr2.append(td21, td22);
	            table.append(col2);
	            
		    	var tr3 = $("<tr></tr>");
	            var td31 = $("<td></td>").addClass("tdTitle").text("�꼶��");
	            var td32 = $("<td></td>").addClass("tdRight").text(gradeName);
	            var col3 = tr3.append(td31, td32);
	            table.append(col3);
		    }else if(((vrestype == 2 || vrestype == 3) && vreststat == 3) || (vrestype == 4 && vreststat == 3)){
		    	var tr2 = $("<tr></tr>");
	            var td21 = $("<td></td>").addClass("tdTitle").text("������");
	            var td22 = $("<td></td>").addClass("tdRight").text("��" + term + "��");
	            var col2 = tr2.append(td21, td22);
	            table.append(col2);
		    }
		    
		    if(vrestype == 1 || vreststat == 4){
	            var tr2 = $("<tr></tr>");
	            var td21 = $("<td></td>").addClass("tdTitle").text("��ʼʱ�䣺");
	            var td22 = $("<td></td>").addClass("tdRight").text(_begin);
	            var col2 = tr2.append(td21, td22);
	            table.append(col2);
	            
	            var tr3 = $("<tr></tr>");
	            var td31 = $("<td></td>").addClass("tdTitle").text("��ֹʱ�䣺");
	            var td32 = $("<td></td>").addClass("tdRight").text(_end);
	            var col3 = tr3.append(td31, td32);
	            table.append(col3);
		    }
		    
		    var tr1 = $("<tr></tr>");
            var td11 = $("<td></td>").addClass("tdTitle").text(stattypename + "��");
            var td12 = $("<td></td>").addClass("tdRight").text(resultNum);
            var col1 = tr1.append(td11, td12);
            table.append(col1);

            $("#chartdiv").html(table);
            changerow();
        }
    });
}

function exportRs(){
	var exJson = exportcond.getValue();
	window.location.href = "<%=request.getContextPath()%>/exportDataServlet.do?submitData="+exJson;
}

function loading() {
	mini.mask({
	    el: document.body,
	    cls: 'mini-mask-loading',
	    html: '������...'
	});
	setTimeout(function () {
	    mini.unmask(document.body);
	}, 2000);
}

function GetRegionData() {
    $.ajax({
        url: "loadData.jsp?method=SubmitData",
        type: "post",
        beforeSend:function() {
        	mini.mask({
	            el: document.body,
	            cls: 'mini-mask-loading',
	            html: '���ݸ����У����Ե�...'
        	});
        },
        success: function (text) {
            //alert("�������������ɹ���");
            mini.unmask(document.body);
            showTips();
        }
    });
}
function showTips() {
    var x = "center";
    var y = "center";
    var state = "success";;
    mini.showTips({
        content: "���ݸ��³ɹ�",
        state: state,
        x: x,
        y: y,
        timeout: 3000
    });
}
//��Ⱦͳ��ͼ��
function fusionChartsShow(chartUrl){
	var chart = new FusionCharts(chartUrl, "ChartId", "600", "500", "0", "0");
	   chart.setDataXML(chartxml);
	   chart.render("chartdiv");
}

//ͼ�������¼�
function onChartsChanged(e){
	var chartUrl = charttypes.getValue();
	fusionChartsShow(chartUrl);
}

function initCity(pid){
	$.ajax({
	    url: "loadData.jsp?method=LoadRegionData&pid=" + pid,
	    type: "post",
	    success: function (text) {
	        var data = mini.decode(text);   //�����л��ɶ���
	        var length = data.length;
	        if(length >= 1){
	        	data.unshift(all);
		        city.setData(data);
		        city.select(0);
	        }
	    }
	});
}

//ѡ��ʡͬʱ�г��������������
function onProvinceChanged(e) {
    var id = province.getValue();
    city.setData(nullData);
    country.setData(nullData);
    //term.setData(nullData);
    
    city.setValue("");
    country.setValue("");
    //term.setValue("");
    var url = "loadData.jsp?method=LoadRegionData&pid=" + id
    city.setUrl(url);
    
    var data = city.getData();
   	data.unshift(all);
    city.setData(data);
    city.select(0);
}

//ѡ����ͬʱ�г�����������
function onCityChanged(e) {
    var id = city.getValue();
    country.setData(nullData);
    //term.setData(nullData);
    country.setValue("");
    //term.setValue("");
    var url = "loadData.jsp?method=LoadRegionData&pid=" + id
    country.setUrl(url);
    
    var data = country.getData();
    var length = data.length;
  	data.unshift(all);
    country.setData(data);
    country.select(0);
}

//ѡ����ͬʱ�г����������ն�վ��
function onCountryChanged(e) {
    var id = country.getValue();
    //term.setData(nullData);
    //term.setValue("");
    var url = "loadData.jsp?method=LoadTermData&regionid=" + id
    //term.setUrl(url);
    
    //var data = term.getData();
   	//data.unshift(allterm);
    //term.setData(data);
    //term.select(0);
}

function onSubjectChanged(e){
	var id = subject.getValue();
    grade.setData(nullData);
    grade.setValue("");
    var url = "loadData.jsp?method=LoadBookCatelogData&subjectId=" + id
    grade.setUrl(url);

    var data = grade.getData();
   	data.unshift(allgrade);
    grade.setData(data);
    grade.select(0);
}

function onSubjectChanged2(e){
	var id = subject2.getValue();;
	grade2.setData(nullData);
	grade2.setValue("");
	var url = "loadData.jsp?method=LoadBookCatelogData&subjectId=" + id
	grade2.setUrl(url);
	
	var data = grade2.getData();
   	data.unshift(allgrade);
    grade2.setData(data);
    grade2.select(0);
}

opttype.on("valuechanged", function (e) {
	var value = this.getValue();
    if(value == '1'){
    	//$(".startdate1").hide();
    	//$(".enddate1").show();
    	
    	$("#cond1").show();
    	$("#cond2").show();
    	$("#cond3").show();
    	$("#cond4").show();
    	$(".resclickcount").hide();
    }else if(value == '2'){
    	//$(".startdate1").show();
    	//$(".enddate1").show();
    	
    	$("#cond1").show();
    	$("#cond2").show();
    	$("#cond3").show();
    	$("#cond4").show();
    	
    	$(".resclickcount").show();
    }else{
    	//$(".startdate1").show();
    	//$(".enddate1").show();
    	
    	$("#cond1").hide();
    	$("#cond2").hide();
    	$("#cond3").hide();
    	$("#cond4").hide();
    	$(".resclickcount").hide();
    }
});

restype.on("valuechanged", function (e) {
	var value = this.getValue();
    if(value == '2' || value == '3'){
    	reststat.setUrl("data/resstat2.txt");
    	$(".backsub").show();
   		$(".backcls").hide();
   		$(".weekmodel2").hide();
   		$(".periodmodel2").hide();
    }else if(value == '1'){
    	reststat.setUrl("data/resstat.txt");
    	$(".backsub").hide();
   		$(".backcls").hide();
   		$(".weekmodel2").hide();
   		$(".periodmodel2").show();
    }else if(value == '4'){
    	reststat.setUrl("data/resstat3.txt");
    	$(".backsub").show();
   		$(".backcls").hide();
   		$(".weekmodel2").hide();
   		$(".periodmodel2").hide();
    }
    reststat.select(0);
});

reststat.on("valuechanged", function (e) {
	var restypeV = restype.getValue();
	var value = this.getValue();
    if((restypeV == '2' || restypeV == '3' || restypeV == '4' || restypeV == '5')){
    	if(value == '1'){//��ѧ��ͳ����Դ
    		$(".backsub").show();
    		$(".backcls").hide();
    		$(".weekmodel2").hide();
    		$(".periodmodel2").hide();
    	}else if(value == '2'){//���꼶ͳ����Դ
    		$(".backsub").show();
    		$(".backcls").show();
    		$(".weekmodel2").hide();
    		$(".periodmodel2").hide();
    	}else if(value == '3'){//������ͳ����Դ
    		$(".backsub").hide();
    		$(".backcls").hide();
    		$(".weekmodel2").show();
    		$(".periodmodel2").hide();
    	}else if(value == '4'){//��ʱ���ͳ����Դ
    		$(".backsub").hide();
    		$(".backcls").hide();
    		$(".weekmodel2").hide();
    		$(".periodmodel2").show();
    	}
    }else{
    	$(".backsub").hide();
    	$(".backcls").hide();
    	$(".weekmodel2").hide();
    	$(".periodmodel2").show();
    }
});

/*
times.on("valuechanged", function (e) {
	var value = this.getValue();
	
    if(value == '1'){//����ͳ��
    	$(".weekmodel").show();
    	$(".periodmodel").hide();
    	$(".semestermodel").hide();
    }else if(value == '2'){//��ʱ���ͳ��
    	$(".periodmodel").show();
    	$(".weekmodel").hide();
		$(".semestermodel").hide();
    }else if(value == '3'){//��ѧ��ͳ��
    	$(".semestermodel").show();
		$(".weekmodel").hide();
		$(".periodmodel").hide();
    }else {
		$(".periodmodel").hide();
		$(".weekmodel").hide();
		$(".semestermodel").hide();
    }
});*/


// ��Date����չ���� Date ת��Ϊָ����ʽ��String   
// ��(M)����(d)��Сʱ(h)����(m)����(s)������(q) ������ 1-2 ��ռλ����   
// ��(y)������ 1-4 ��ռλ��������(S)ֻ���� 1 ��ռλ��(�� 1-3 λ������)   
// ���ӣ�   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt){ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //�·�   
    "d+" : this.getDate(),                    //��   
    "h+" : this.getHours(),                   //Сʱ   
    "m+" : this.getMinutes(),                 //��   
    "s+" : this.getSeconds(),                 //��   
    "q+" : Math.floor((this.getMonth()+3)/3), //����   
    "S"  : this.getMilliseconds()             //����   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}

function changerow(){
	$(document).ready(function(){     
	     $(".stattable tr:even").addClass("one");     //even�����Ƶ�������ʽ��
	     $(".stattable tr:odd").addClass("two");      //odd������ż������ʽ��
	     $(".stattable tr").mouseover(function(){   
	         //$(this).addClass("over");   
	     });   
	        
	     $(".stattable tr").mouseout(function(){    
	         //$(this).removeClass("over");   
	     });   
	});
}
</script>
