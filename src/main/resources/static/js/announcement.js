//获取根路径
function getRootPath(){
	var pathname=window.location.pathname;
	var index= pathname.indexOf("/",1);
	var rootPath=pathname.substring(0,index);
	return rootPath;
}
//公告类别标签
function showAnType(d){
	//拼接标签
	var html= "<li> <a href='"+getRootPath()+"/announcement?pageIndex=1&atId="+d.atId+"'>"+d.atName+"</a> </li>";
	$(html).appendTo($("#antype"));
	
};

//初始化所有公告类别
function initantype(){
	$.get(getRootPath()+"/announcement/alltypes",
			null,
			function(d){
		if(d.stateCode==200){
			$("#antype").children().remove();
			$.each(d.data,function(){
				showAnType(this);
			})
		}else{
			alert("系统错误，请联系管理员")
		}
	})
}