// JavaScript Document 划线程序
function lineLT_RB(elementId,weight,color){
	if(weight==null || weight==0)
	{
		weight="1";
	}
	var pos=getElementPos(elementId);
	var obj=document.getElementById(elementId);
	var h=obj.getAttribute("height");
	if(!h)
	{
		h=obj.clientHeight;
		if(!h)
		{
			h=obj.offsetHeight;
		}
	}
	var w=obj.getAttribute("width");
	if(!w)
	{
		w=obj.clientWidth;
		if(!w)
		{
			w=obj.offsetWidth;
		}
	}
	line(pos.x,pos.y,pos.x+w,pos.y+h,weight,color);
}
function line(x1, y1, x2, y2,weight, color) {
	var tmp;
	if (x1 >= x2) {
		tmp = x1;
		x1 = x2;
		x2 = tmp;
		tmp = y1;
		y1 = y2;
		y2 = tmp;
	}
	for (var i = x1; i <= x2; i++) {
		x = i;
		y = (y2 - y1) / (x2 - x1) * (x - x1) + y1;
		myPoint(x, y,weight, color);
	}
}
function getTop(tdobj) {
	vParent = tdobj.offsetParent;
	t = tdobj.offsetTop;
	while (vParent.tagName.toUpperCase() != "BODY") {
		t += vParent.offsetTop;
		vParent = vParent.offsetParent;
	}
	return t;
}
function getLeft(tdobj) {
	vParent = tdobj.offsetParent;
	var t;
	if(vParent==null)
	{
		t=tdobj.client
	}else{
		t = tdobj.offsetLeft;
		while (vParent.tagName.toUpperCase() != "BODY") {
			t += vParent.offsetLeft;
			vParent = vParent.offsetParent;
		}
	}
	return t;
}
function myPoint(x, y,weight, color) {
	var obj=document.createElement("line");
	obj.setAttribute("style","position:absolute;padding:0px;margin:0xp;left:" + x + "px;top:" + y + "px;background-color:" + color + ";border-style:none;font-size:0px;height:"+weight+"px;width:"+weight+"px;font-weight:0;z-index:9000;");
	document.body.insertBefore(obj,document.body.firstChild);
}
 
function getElementPos(elementId) {
	var ua = navigator.userAgent.toLowerCase();
	var isOpera = (ua.indexOf('opera') != -1);
	var isIE = (ua.indexOf('msie') != -1 && !isOpera); // not opera spoof
	var el = document.getElementById(elementId);
	if(el.parentNode === null || el.style.display == 'none')
	{
		return false;
	}
	var parent = null;
	var pos = [];
	var box;
	if(el.getBoundingClientRect) //IE
	{
		box = el.getBoundingClientRect();
		var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
		var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
		return {x:box.left + scrollLeft, y:box.top + scrollTop};
	}else if(document.getBoxObjectFor) // gecko
	{
	box = document.getBoxObjectFor(el);
	var borderLeft = (el.style.borderLeftWidth)?parseInt(el.style.borderLeftWidth):0;
	var borderTop = (el.style.borderTopWidth)?parseInt(el.style.borderTopWidth):0;
	pos = [box.x - borderLeft, box.y - borderTop];
	}
	else // safari & opera
	{
		pos = [el.offsetLeft, el.offsetTop];
		parent = el.offsetParent;
		if (parent != el)
		{
			while (parent) {
				pos[0] += parent.offsetLeft;
				pos[1] += parent.offsetTop;
				parent = parent.offsetParent;
			}
		}
 
		if (ua.indexOf('opera') != -1 || ( ua.indexOf('safari') != -1 && el.style.position == 'absolute' ))
		{
			pos[0] -= document.body.offsetLeft;
			pos[1] -= document.body.offsetTop;
		}
	}
	if (el.parentNode) 
	{
		parent = el.parentNode; 
	}
	else
	{
		parent = null; 
	}
	while (parent && parent.tagName != 'BODY' && parent.tagName != 'HTML')
	{ // account for any scrolled ancestors
		pos[0] -= parent.scrollLeft;
		pos[1] -= parent.scrollTop;
		if (parent.parentNode) 
		{
			parent = parent.parentNode; 
		}
		else 
		{
		 parent = null; 
		}
	}
	return {x:pos[0], y:pos[1]};
} 
