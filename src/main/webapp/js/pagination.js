var pagination = {

    init : function (params) {
        //获取当前页
        var pageNum = params['pageNum'];
        //获取总页数
        var totalPages = params['totalPages'];
        //获取总数量
        var totalCount = params['totalCount'];

      
        if (totalPages <= 1) {
        	$(".j_page_info").text("1/1");
        	$(".j_page_prev_btn").addClass("disabled");
        	$(".j_page_next_btn").addClass("disabled");
        	$(".j_madule_page_search_submit").addClass("disabled");
        }else {
            pagination.loadPage(pageNum, totalPages);
        }
    },

    funcUrlDel : function (name) {
        var loca = window.location;
        var baseUrl = loca.origin + loca.pathname + "?";
        var query = loca.search.substr(1);
        if (query.indexOf(name)>-1) {
            var obj = {}
            var arr = query.split("&");
            for (var i = 0; i < arr.length; i++) {
                arr[i] = arr[i].split("=");
                obj[arr[i][0]] = arr[i][1];
            }
            delete obj[name];
            var url = baseUrl + JSON.stringify(obj).replace(/["\{\}]/g,"").replace(/\:/g,"=").replace(/\,/g,"&");
            if (arr.length >= 2) url = url + "&";
            return url
        } else {
            if (query == undefined || query == "") return baseUrl + query;
            return baseUrl + query + "&";
        }
    },

    loadPage : function (pageNum, totalPages) {     
        var url = pagination.funcUrlDel("page");
       
        $(".j_page_info").text(pageNum+"/"+totalPages);
        $(".j_page_prev_btn").attr("href",""+url+"page=" + (pageNum-1));
        $(".j_page_next_btn").attr("href",""+url+"page=" + (pageNum+1));
        
        $(".j_madule_page_search_submit").click(function(){
	       	 var num = $(".base_page_search_input").val();
	       	 if(!isNaN(num)){
	       		 if(num>=totalPages){
	       			location.href= url +"page="+totalPages
	       		 }else if(num < 1){
	       			$(".base_page_search_input").val("");
	       		 }else{
	       			location.href= url +"page="+num  			
	       		 }     		 
	       	 }else{
	       		$(".base_page_search_input").val("");
	       	 }    	 
        });
        
        if (pageNum == 1) {
            $(".j_page_prev_btn").addClass("disabled");
            $(".j_page_prev_btn").attr("href","javascript:void(0);");
        }
        if (pageNum == totalPages) {
            $(".j_page_next_btn").addClass("disabled");
            $(".j_page_next_btn").attr("href","javascript:void(0);");
        }
    }

}