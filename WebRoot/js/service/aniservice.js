var AniUtil = {};
AniUtil.addAni = function(ani,success,fail){
	$.ajax({
		type:"post",
		url:"/anime/ani/addAni",
		data:ani,
		success:function(data){
			success(data);
		},
		error:function(){

		}
	});
};

AniUtil.queryAniById = function(id,success,fail){
	$.ajax({
		type:"post",
		url:"/anime/ani/queryAniById",
		data:"id="+id,
		success:function(data){
			success(data);
		},
		error:function(){
			fail(data);
		}
	});
}
