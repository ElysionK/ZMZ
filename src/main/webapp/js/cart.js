var setting = {
		init : function(){
			setting.calculate();
			
			$(".m-checkbox.checkbox").on("click", function(){
				var checked;
				if($(this).hasClass("checked")){
					checked = 0;
					$(this).removeClass("checked").addClass("check");
				}else{
					checked = 1;
					$(this).removeClass("check").addClass("checked");
				}
				setting.updCartChecked($(this).parents(".item.pro").attr("data"), checked)
				setting.calculate();
			});
			
			$(".m-selnum i").on("click", function(){
				var count = Number($(this).parent().find("input[type=tel]").val());
				if($(this).hasClass("more")){
					//加
					count += 1;
					$(this).parent().find("input[type=tel]").val(count);
				}else{
					//减
					if(count - 1 <= 0){
						return;
					}
					count -= 1;
					$(this).parent().find("input[type=tel]").val(count);
				}
				setting.addCart($(this).parents(".item.pro").attr("data"), count)
				setting.calculate();
			});
			
			$("#confirm").on("click", function(){
				var checked = $(".m-checkbox.checkbox.checked").parents(".item.pro");
				if(checked.length <= 0){
					layer.msg("请选择要购买的商品");
					return;
				}
				var data = {};
				checked.each(function(){
					var pid = $(this).attr("data") + "|" + $(this).attr("data-c");
					var count = $(this).find("input[type=tel]").val();
					data[pid] = count;
				});
				setting.addNewOrder(data);
			});
		},
		URL : {
	        basePath : function() {
	            return "/";
	        },
	        updCartChecked : function(){
	        	return setting.URL.basePath() + "order/updCartChecked";
	        },
	        addCart : function(){
	        	return setting.URL.basePath() + "order/addCart";
	        },
	        addNewOrder : function(){
	        	return setting.URL.basePath() + "order/addNewOrder";
	        }
	    },
	    updCartChecked : function(pid, checked){
			$.getMyContentJSON(setting.URL.updCartChecked(), JSON.stringify({"pid":pid,"checked":checked}), function(data){
				if(data.returncode == 0){
					//layer.msg("已加入购物车");
				}else{
					layer.alert("系统错误", {icon:"2"});
				}
			});
		},
		addCart : function(pid, count){
			$.getMyContentJSON(setting.URL.addCart(), JSON.stringify({"pid":pid,"count":count}), function(data){
				if(data.returncode == 0){
					//layer.msg("已加入购物车");
				}else{
					layer.alert("系统错误", {icon:"2"});
				}
			});
		},
		calculate : function(){
			var total = 0;
			$(".m-checkbox.checkbox.checked").parents(".item.pro").each(function(){
				var count = Number($(this).find("input[type=tel]").val());
				var price = Number($(this).find(".dis-price").html()).toFixed(2);
				total += (count * price);
			});
			$("#total").html(total.toFixed(2))
		},
		addNewOrder : function(data){
			$.getMyContentJSON(setting.URL.addNewOrder(), JSON.stringify(data), function(data){
				if(data.returncode == 0){
					window.location.href="/order/confirm/" + data.data[0] + "/0";
				}else{
					layer.alert("系统错误", {icon:"2"});
				}
			});
		}
}