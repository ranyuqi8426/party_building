/**
 * 用JS将HTML中table直接转为Excel
 * 
 * @author Yangcf
 * 
 * @param testId
 *            主体table的ID
 * @param filename
 *            导出文件名
 * @param colspan
 *            标题行需要合并的列数
 * @param start_time
 *            起始日期
 * @param end_time
 *            结束日期
 * @example 
 *      window.iframeReport.exportHtmlToExcel ( "exportTable", "银行系统交易汇总",
 *          Ext.getCmp('chkBanks').getChecked().length+5,
 *          Ext.Date.format(Ext.getCmp('start_date').getValue(), 'Y-m-d'),
 *          Ext.Date.format(Ext.getCmp('end_date').getValue(), 'Y-m-d')
 *       );
 */
function exportHtmlToExcel(testId, filename) {
	method(testId, filename);
	var idTmr;
	function getExplorer() {
		var explorer = window.navigator.userAgent;
		// ie
		if (explorer.indexOf("MSIE") >= 0) {
			return 'ie';
		}
		// firefox
		else if (explorer.indexOf("Firefox") >= 0) {
			return 'Firefox';
		}
		// Chrome
		else if (explorer.indexOf("Chrome") >= 0) {
			return 'Chrome';
		}
		// Opera
		else if (explorer.indexOf("Opera") >= 0) {
			return 'Opera';
		}
		// Safari
		else if (explorer.indexOf("Safari") >= 0) {
			return 'Safari';
		}
	}
	function method(testId, filename) {// 整个表格拷贝到EXCEL中
		if (getExplorer() == 'ie') {
			var curTbl = document.getElementById(testId);
			var oXL = new ActiveXObject("Excel.Application");

			// 创建AX对象excel
			var oWB = oXL.Workbooks.Add();
			// 获取workbook对象
			var xlsheet = oWB.Worksheets(1);
			// 激活当前sheet
			var sel = document.body.createTextRange();
			sel.moveToElementText(curTbl);
			// 把表格中的内容移到TextRange中
			sel.select();
			// 全选TextRange中内容
			sel.execCommand("Copy");
			// 复制TextRange中内容
			xlsheet.Paste();
			// 粘贴到活动的EXCEL中
			oXL.Visible = true;
			// 设置excel可见属性

			try {
				var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
			} catch (e) {
				print("Nested catch caught " + e);
			} finally {
				oWB.SaveAs(fname);

				oWB.Close(savechanges = false);
				// xls.visible = false;
				oXL.Quit();
				oXL = null;
				// 结束excel进程，退出完成
				// window.setInterval("Cleanup();",1);
				idTmr = window.setInterval("Cleanup();", 1);

			}
		} else {
			tableToExcel(testId, filename)
		}
	}
	function Cleanup() {
		window.clearInterval(idTmr);
		CollectGarbage();
	}
	function tableToExcel(testId, filename) {
				uri = 'data:application/vnd.ms-excel;base64,',
				template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><meta http-equiv="Content-Type" charset=utf-8"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--><style type="text/css">'
						+ '.excelTabler  {'
						+ 'border:1px solid #999;background-color:#def3fc;'
						+ '}'
						+ ' .excelTable tr.altrow{ background-color:#FFF;}'
						+ '   .excelTable  th {'
						+ ' border:1px solid #a8d7f3; background-color:#7799b2; height:28px; color:#FFF; text-align:center;'
						+ ' }'
						+ ' .excelTable  td{'
						+ ' height:24px;'
						+ 'border:1px solid #a8d7f3; text-align:center;'
						+ ' }</style></head><body>'
						+ '<table class="excelTable"><table class="excelTabler">{table}</table></body></html>',
				base64 = function(s) {
					return window.btoa(unescape(encodeURIComponent(s)));
				}, format = function(s, c) {
					return s.replace(/{(\w+)}/g, function(m, p) {
						return c[p];
					})
				}
				var table = document.getElementById(testId);
		ctx = {
			worksheet : name || 'Worksheet',
			table : table.innerHTML,
		};
		$("body").append('<a href="#"  style="display: none"   id="btnExport" ><p></p></a>');
		$("#btnExport").attr("href", uri + base64(format(template, ctx)));
		$("#btnExport").attr("download", filename + ".xls");
		$("a#btnExport>p").trigger('click');
	}
}
