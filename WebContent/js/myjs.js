/**
 * 这个文件封装了JJ网络核心的js方法，作者刘瑾kite
 */


/**
 * 获得年月格式化函数
 * @param value 一个日期的毫秒值
 * @returns 格式化年月的日期
 * @author kite
 */
function getYearMonth(value){
	//参数value是一个毫秒值
	var date = new Date(value);
	var month = date.getMonth()+1;
	return date.getFullYear()+"年"+month+"月";
}

/**
 * 获得年月日格式化函数
 * @param value 一个日期的毫秒值
 * @returns 格式化年月日的日期
 * @author kite
 */
function getFullDate(value){
	var date = new Date(value);
	var month = date.getMonth()+1;
	return date.getFullYear()+"年"+month+"月"+date.getDate()+"日";
}

/**
 * easyui修改datagrid界面的方法
 * 本方法依赖EasyUI，JQuery
 */
function changeDatagrid(){
  $('.searchbox').css("height",'29px');
  $('.searchbox .searchbox-text').css("height",'29px');
  $('.searchbox .searchbox-text .searchbox-prompt').css("height",'29px');
  $('.searchbox-button').css("height",'29px');
  $('.searchbox-button-hover').css("height",'29px');
}