(function ($) {
	
	//异步请求方法
	$.getMyJSON = function(url,data,callback){
		$.ajax({
			"url": url,
			"context": this,
			"data": data,
			"type": "post",
			"cache":false,
			"dataType": "json",
			"success": function(html){
				callback.call(this,html);
			}
		});
	};
	
	//异步请求方法
	$.getMyContentJSON = function(url,data,callback){
		$.ajax({
			"url": url,
			"context": this,
			"data": data,
			"type": "post",
			"cache":false,
			"dataType": "json",
			"contentType": "application/json; charset=utf-8",
			"success": function(html){
				callback.call(this,html);
			}
		});
	};
	
	//同步请求方法
	$.getMyJSON2 = function(url,data,callback){
		$.ajax({
			"async":false, 
			"url": url,
			"context": this,
			"data": data,
			"type": "post",
			"cache":false,
			"dataType": "json",
			"success": function(html){
				callback.call(this,html);
			}
		});
	};
	
	$.aotucompleter = function(target,url,data,callback){
		$(target).autocomplete({
			serviceUrl: url,
			dataType: 'json',
			params: data,
			onSelect: function(suggestion){
				callback.call(this,suggestion)
			}
	    });
	};
	
	$.aotucompleterPost = function(target,url,data,callback){
		$(target).autocomplete({
			serviceUrl: url,
			dataType: 'json',
			params: data,
			type:'POST',
			isPost:true,
			onSelect: function(suggestion){
				callback.call(this,suggestion)
			}
	    });
	};
	
})(jQuery);





