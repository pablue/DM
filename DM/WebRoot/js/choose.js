/**
 * 
 */
// 定义一个全局变量，basepath 为工程名称
var basepath = $("#basepath").val();
$(document).ready(function() {

	$("#start").click(function() {
		// 将div显示出来
		$(".choosecourse").show();
  
		$.ajax({
			url : basepath + '/course_getcoursebytid.action',
			cache : false,
			type : 'Get',
			dateType : 'json',
			// 设置超时时间
			timeout : 20000,
			// ajax出现错误进行的操作
			error : function() {
				$("<div style='color:red;text-align:center'>出错了</div>")
						.appendTo("#content");
			},
			// ajax成功进行的操作
			success : function(data) {
				var json = eval(data);
				var len = data.length;
				if (len != 0) {
					$("<select  id='kecheng' onchange='showbanji()' style='width:100px' name='cid' ></select>")
							.appendTo("#content");
					$("<option>请选择课程</option>")
							.appendTo("#content>select:last");

					for (var i = 0; i < json.length; i++) {
						$("<option value='" + json[i].cid + "'>"
								+ json[i].cname + "</option>")
								.appendTo("#content>select:last");
					}
				}
			}
		});
       
        
		// 将按钮设置为不可点击状态
		$(this).attr("disabled", true);
	});



});

// 这个是放在了ready() 方法外面
function showbanji(e) {
    //var obj =event.srcElement || event.target;
   /* var theEvent = window.event || arguments.callee.caller.arguments[0];
    var srcElement = theEvent.srcElement;
    if (!srcElement){
        srcElement = theEvent.target;
    }*/
   var theEvent = window.event || arguments.callee.caller.arguments[0];
    var srcElement = theEvent.srcElement;
    if (!srcElement) {
       srcElement = theEvent.target;
    }
    
    var obj = srcElement;
    alert(obj);
    var s1 = $(obj).nextAll("select");
    s1.each(function(i){
        $(this).remove();
    });
    var value1 = $(obj).val();
    

    $.ajax({
            url : basepath +"/course_getbanjibycidandtid.action?cid="+value1,
            cache : false,
            type : 'get',
            dateType : 'json',
            // 设置超时时间
            timeout : 20000,
            // ajax出现错误进行的操作
            error : function() {
                $("<div style='color:red;text-align:center'>出错了</div>")
                        .appendTo("#content");
            },
            // ajax成功进行的操作
            success : function(data) {
                var json = eval(data);
                var len = data.length;
                if (len != 0) {
                    $("<select  id='kecheng' onchange='showxiqi()' style='width:100px' name='cid' ></select>")
                            .appendTo("#content");
                    $("<option>请选择班级</option>")
                            .appendTo("#content>select:last");

                    for (var i = 0; i < json.length; i++) {
                        $("<option value='" + json[i].bid + "'>"
                                + json[i].bname + "</option>")
                                .appendTo("#content>select:last");
                    }
                }
            }
        });
    
    }
    
   function showxiqi(){
    //var obj =event.srcElement || event.target;
    var theEvent = window.event || arguments.callee.caller.arguments[0];
    var srcElement = theEvent.srcElement;
    if (!srcElement){
        srcElement = theEvent.target;
    }
    var obj = srcElement;
    alert(obj);
    var s1 = $(obj).nextAll("select");
    s1.each(function(i){
        $(this).remove();
    });
    
    $("<select  id='kecheng' onchange='showxiqi()' style='width:100px' name='cid' ></select>")
                            .appendTo("#content");
                    $("<option>请选择班级</option>")
                            .appendTo("#content>select:last");
   }


