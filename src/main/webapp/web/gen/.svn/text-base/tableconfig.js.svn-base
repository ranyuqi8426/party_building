Ext.onReady(function() {
	// 显示文字 0-否 ，1-是
	function renderIsany(val) {
		if (val == 0) {
			return '<span style="color:' + "red" + ';">' + '否' + '</span>';
		} else if (val == 1) {
			return '<span style="color:' + "blue" + ';">' + '是' + '</span>';
		}
	}
	// 主键方式
	function renderPK(val) {
		if (val == 1) {
			return '<span >' + '自动增长' + '</span>';
		} else if (val == 2) {
			return '<span >' + '人工赋值' + '</span>';
		}
	}
	// 文本框
	function renderInput(val) {
		if (val == 1) {
			return '<span >' + '文本框' + '</span>';
		} else if (val == 2) {
			return '<span >' + '下拉框' + '</span>';
		} else if (val == 3) {
			return '<span >' + '日期框' + '</span>';
		}
	}
	// 字符类型
	function renderType(val) {
		if (val == 1) {
			return '<span >' + '英文字符' + '</span>';
		} else if (val == 2) {
			return '<span >' + '整数' + '</span>';
		} else if (val == 3) {
			return '<span >' + '小数' + '</span>';
		} else if (val == 4) {
			return '<span >' + '中文字符' + '</span>';
		}
	}
	// 居中方式
	function renderAlign(val) {
		if (val == 1) {
			return '<span >' + '左对齐' + '</span>';
		} else if (val == 2) {
			return '<span >' + '居中' + '</span>';
		} else if (val == 3) {
			return '<span >' + '右对齐' + '</span>';
		}
	}
	// 下拉选择 0-否 1-是
	var isanyStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "0",
			"content" : "否"
		}, {
			"value" : "1",
			"content" : "是"
		} ]
	});
	// 下拉选择主键方式 1-自动增长 2-手工赋值
	var PKStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "自动增长"
		}, {
			"value" : "2",
			"content" : "手工赋值"
		} ]
	});
	// 下拉选择字符类型
	var nameTypeStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "英文字符"
		}, {
			"value" : "2",
			"content" : "整数"
		}, {
			"value" : "3",
			"content" : "小数"
		}, {
			"value" : "4",
			"content" : "中文字符"
		} ]
	});
	// 数据库类型Store
	var database_typeStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "Oracle"
		}, {
			"value" : "2",
			"content" : "Mysql"
		} ]
	});
	// 下拉选择对齐
	var showalignStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "左对齐"
		}, {
			"value" : "2",
			"content" : "居中"
		}, {
			"value" : "3",
			"content" : "右对齐"
		} ]
	});
	// 下拉选择输入框类型
	var inputtypeStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "文本框"
		}, {
			"value" : "2",
			"content" : "下拉框"
		}, {
			"value" : "3",
			"content" : "日期框"
		} ]
	});
	// 下拉框数据源类型
	var cmbDataTypeStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			"value" : "1",
			"content" : "URL"
		}, {
			"value" : "2",
			"content" : "固定值"
		} ]
	});
	Ext.define('TableConfig', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'int'
		}, {
			name : 'tableName',
			type : 'string'
		}, {
			name : 'description',
			type : 'string'
		}, {
			name : 'firstCode',
			type : 'string'
		}, {
			name : 'secondCode',
			type : 'string'
		}, {
			name : 'javaPackage',
			type : 'string'
		}, {
			name : 'inputCols',
			type : 'int'
		}, {
			name : 'windowWidth',
			type : 'int'
		}, {
			name : 'windowHeight',
			type : 'int'
		}, {
			name : 'isPage',
			type : 'int'
		}, {
			name : 'isAdd',
			type : 'int'
		}, {
			name : 'isUpdate',
			type : 'int'
		}, {
			name : 'isDelete',
			type : 'int'
		}, {
			name : 'isView',
			type : 'int'
		}, {
			name : 'pkCreate',
			type : 'int'
		}, {
			name : 'pkField',
			type : 'string'
		} ]
	});

	var tableConfigStore = Ext.create('Ext.data.Store', {
		model : 'TableConfig',
		proxy : {
			type : 'ajax',
			url : basePath + '/gen/tableConfig/search.do',
			actionMethods : {
				read : "POST"
			}
		},
		autoLoad : true
	});

	/*
	 * var tableSelectStore = Ext.create('Ext.data.JsonStore', { model :
	 * "ComboboxData", proxy : { type : 'ajax', url : basePath +
	 * '/common/listTablename.do', reader : { type : 'json' } }, autoLoad : true
	 * });
	 */
	var selModel = Ext.create('Ext.selection.CheckboxModel', {
		mode : 'SINGLE'
	});
	var tableConfigGrid = Ext.create('Ext.grid.Panel', {
		title : '代码生成器配置列表',
		frame : true,
		glyph : glyphGrid,
		margin : '0 4 0 0',
		width : '100%',
		height : pageH - 100,
		columnWidth : 0.5,
		// columnLines : true,
		store : tableConfigStore,
		selModel : selModel,
		// renderTo : Ext.getBody(),
		columns : [ {
			xtype : 'rownumberer'
		}, {
			text : '数据库表名',
			dataIndex : 'tableName',
			width : 100,
			sortable : false
		}, {
			text : '描述',
			dataIndex : 'description',
			width : 100,
			sortable : false
		}, {
			text : '一级模块',
			dataIndex : 'firstCode',
			width : 100,
			sortable : false
		}, {
			text : '二级模块',
			dataIndex : 'secondCode',
			width : 100,
			sortable : false
		}, {
			text : 'JAVA包名',
			dataIndex : 'javaPackage',
			width : 100,
			value : 'com.crpay',
			sortable : false

		}, {
			text : '弹出窗口宽度',
			dataIndex : 'windowWidth',
			width : 100,
			sortable : false
		}, {
			text : '弹出窗口高度',
			dataIndex : 'windowHeight',
			width : 100,
			sortable : false
		}, {
			text : '弹出窗口字段列数',
			dataIndex : 'inputCols',
			width : 100,
			sortable : false
		}, {
			text : '是否分页',
			dataIndex : 'isPage',
			width : 80,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '是否增加',
			algin : 'center',
			dataIndex : 'isAdd',
			width : 80,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '是否修改',
			algin : 'center',
			dataIndex : 'isUpdate',
			width : 80,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '是否删除',
			algin : 'center',
			dataIndex : 'isDelete',
			width : 80,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '是否查看',
			dataIndex : 'isView',
			width : 80,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '主键生成方式',
			dataIndex : 'pkCreate',
			width : 100,
			sortable : false,
			renderer : function(val) {
				if (val == 1)
					return '自动生成'
				else if (val == 2)
					return '手工赋值'
			}
		}, {
			text : '主键字段',
			dataIndex : 'pkField',
			width : 80,
			sortable : false
		} ],
		viewConfig : {
			stripeRows : true
		},
		tbar : Ext.create('Ext.toolbar.Toolbar', {
			layout : {
				overflowHandler : 'Menu'
			},
			items : [ {
				text : '新增',
				glyph : glyphAdd,
				handler : add
			}, {
				text : '修改',
				glyph : glyphUpdate,
				handler : update
			}, {
				text : '删除',
				glyph : glyphDelete,
				handler : del
			}, {
				xtype : 'button',
				glyph : glyphRefresh,
				text : '刷新',
				handler : function() {
					tableConfigStore.reload();
				}
			} ]
		})
	});
	// 点击事件
	tableConfigGrid.on('select', function(grid, record, rowIndex, e) {
		if (record.data.id == null)
			return;
		tableFieldsStore.load({
			params : {
				tableid : record.data.id
			}
		})
	});

	var tableConfigForm = new Ext.create("Ext.form.Panel", {
		id : 'tableConfigForm',
		frame : true,
		border : true,
		width : '100%',
		height : 460,
		buttonAlign : 'center',
		defaultType : 'textfield',
		waitTitle : '正在提交中',
		layout : 'column',
		columnWidth : 0.5,
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 120,
			width : '50%',
			margin : '0 0 5 0',
			msgTarget : 'qtip'
		},
		items : [ {
			name : 'id',
			hidden : true
		}, {
			name : 'tableName',
			fieldLabel : '数据库表名',
			maxLength : 40,
			allowBlank : false
		}, {
			name : 'description',
			fieldLabel : '描述',
			maxLength : 25,
			allowBlank : false
		}, {
			name : 'firstCode',
			fieldLabel : '一级模块代码',
			maxLength : 10,
			allowBlank : false
		}, {
			name : 'secondCode',
			fieldLabel : '二级模块代码',
			maxLength : 20,
			allowBlank : false
		}, {
			name : 'javaPackage',
			fieldLabel : 'java包名',
			allowBlank : false

		}, {
			name : 'windowWidth',
			fieldLabel : '弹出窗口宽度',
			value : 800,
			allowBlank : false
		}, {
			name : 'windowHeight',
			fieldLabel : '弹出窗口高度',
			value : 460,
			allowBlank : false
		}, {
			name : 'inputCols',
			fieldLabel : '弹出窗口字段列数',
			value : 1,
			allowBlank : false
		}, {
			name : 'isPage',
			fieldLabel : '是否分页',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isAdd',
			fieldLabel : '是否增加',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isUpdate',
			fieldLabel : '是否修改',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isDelete',
			fieldLabel : '是否删除',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isView',
			fieldLabel : '是否查看',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'pkCreate',
			fieldLabel : '主键生成方式',
			maxLength : 40,
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : PKStore,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'pkField',
			fieldLabel : '主键字段',
			allowBlank : false
		} ],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : save
		}, {
			text : '清空',
			id : 'btnClear',
			glyph : glyphClear,
			handler : function() {
				tableConfigForm.getForm().reset();
			}
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				tableConfigWin.hide();
			}
		} ]
	});

	var tableConfigWin = new Ext.Window({
		width : 800,
		height : 500,
		glyph : glyphWindow,
		title : '新增/修改',
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ tableConfigForm ]
	});
	/*---------------------------------------------字段配置--*****--------------------------------------*/

	Ext.define('TableFields', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'id',
			type : 'int'
		}, {
			name : 'tableId',
			type : 'int'
		}, {
			name : 'fieldName',
			type : 'string'
		}, {
			name : 'description',
			type : 'string'
		}, {
			name : 'type',
			type : 'int'
		}, {
			name : 'dateFormat',
			type : 'string'
		}, {
			name : 'length',
			type : 'int'
		}, {
			name : 'point',
			type : 'int'
		}, {
			name : 'isListfield',
			type : 'int'
		}, {
			name : 'listLength',
			type : 'int'
		}, {
			name : 'listAlign',
			type : 'int'
		}, {
			name : 'isSearchfield',
			type : 'int'
		}, {
			name : 'isBlank',
			type : 'int'
		}, {
			name : 'inputtype',
			type : 'int'
		}, {
			name : 'inputLength',
			type : 'int'
		}, {
			name : 'cmbDataType',
			type : 'int'
		}, {
			name : 'cmbData',
			type : 'string'
		}, {
			name : 'displayOrder',
			type : 'int'
		} ]
	});

	var tableFieldsStore = Ext.create('Ext.data.Store', {
		model : 'TableFields',
		proxy : {
			type : 'ajax',
			url : basePath + '/gen/tableFields/listJson.do',
			actionMethods : {
				read : "POST"
			}
		}
	});

	var selFieldModel = Ext.create('Ext.selection.CheckboxModel', {
		mode : 'SINGLE'
	});
	var tableFieldsGrid = Ext.create('Ext.grid.Panel', {
		title : '字段配置列表',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH - 100,
		columnWidth : 0.5, // 在主窗体显示
		store : tableFieldsStore,
		selModel : selFieldModel,
		columns : [ {
			xtype : 'rownumberer'
		}, {
			text : '字段',
			dataIndex : 'fieldName',
			width : 120,
			sortable : false
		}, {
			text : '字段描述',
			dataIndex : 'description',
			width : 100,
			sortable : false
		}, {
			text : '字段类型',
			dataIndex : 'type',
			width : 100,
			sortable : false,
			renderer : renderType
		}, {
			text : '字段长度',
			dataIndex : 'length',
			width : 80,
			sortable : false
		}, {
			text : '小数位数',
			dataIndex : 'point',
			width : 80,
			sortable : false
		}, {
			text : '是否列表字段',
			dataIndex : 'isListfield',
			width : 100,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '列表显示长度',
			dataIndex : 'listLength',
			width : 100,
			sortable : false
		}, {
			text : '列表显示对齐',
			dataIndex : 'listAlign',
			width : 100,
			sortable : false,
			renderer : renderAlign
		}, {
			text : '是否查询字段',
			dataIndex : 'isSearchfield',
			width : 100,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '是否为空',
			dataIndex : 'isBlank',
			width : 100,
			sortable : false,
			renderer : renderIsany
		}, {
			text : '输入框类型',
			dataIndex : 'inputType',
			width : 100,
			sortable : false,
			renderer : renderInput
		}, {
			text : '输入框长度',
			dataIndex : 'inputLength',
			width : 100,
			sortable : false
		}, {
			text : '日期格式',
			dataIndex : 'dateFormat',
			width : 100,
			sortable : false
		}, {
			text : '下拉框数据源类型',
			dataIndex : 'cmbDataType',
			width : 100,
			sortable : false
		}, {
			text : '下拉框数据源',
			dataIndex : 'cmbData',
			width : 100,
			sortable : false
		}, {
			text : '排序',
			dataIndex : 'displayOrder',
			width : 60,
			sortable : false
		} ],
		viewConfig : {
			stripeRows : true
		},
		tbar : Ext.create('Ext.toolbar.Toolbar', {
			layout : {
				overflowHandler : 'Menu'
			},
			items : [ {
				text : '新增',
				glyph : glyphAdd,
				handler : addTableFields
			}, {
				text : '修改',
				glyph : glyphUpdate,
				handler : updateTableFields
			}, {
				text : '删除',
				glyph : glyphDelete,
				handler : delTableFields
			} ]
		})
	});

	var tableFieldsForm = new Ext.create("Ext.form.Panel", {
		id : 'tableFieldsForm',
		frame : true,
		border : true,
		width : '100%',
		height : 460,
		buttonAlign : 'center',
		defaultType : 'textfield',
		waitTitle : '正在提交中',
		layout : 'column',
		columnWidth : 0.5,
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 120,
			msgTarget : 'qtip',
			margin : '0 0 5 0',
			width : '50%'
		},
		items : [ {
			name : 'id',
			hidden : true
		}, {
			name : 'tableId',
			fieldLabel : '对应表',
			maxLength : 40,
			hidden : true
		}, {
			name : 'fieldName',
			fieldLabel : '字段名',
			allowBlank : false,
			maxLength : 25
		}, {
			name : 'description',
			fieldLabel : '字段描述',
			maxLength : 20
		}, {
			name : 'type',
			fieldLabel : '字段类型',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			value : 1,
			store : nameTypeStore,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'length',
			fieldLabel : '字段长度',
			allowBlank : false
		}, {
			name : 'point',
			fieldLabel : '小数位数',
			allowBlank : false,
			value : 0
		}, {
			name : 'isListfield',
			fieldLabel : '是否列表字段',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			editable : false,
			value : 1,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'listLength',
			fieldLabel : '列表显示长度',
			value : 100,
			allowBlank : false
		}, {
			name : 'listAlign',
			fieldLabel : '列表显示对齐',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : showalignStore,
			editable : false,
			value : 1,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isSearchfield',
			fieldLabel : '是否查询字段',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			editable : false,
			value : 0,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'isBlank',
			fieldLabel : '能否为空',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : isanyStore,
			editable : false,
			value : 1
		}, {
			name : 'inputType',
			fieldLabel : '输入框类型',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : inputtypeStore,
			editable : false,
			value : 1,
			allowBlank : false,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'inputLength',
			fieldLabel : '输入框长度',
			value : 100,
			allowBlank : false
		}, {
			name : 'dateFormat',
			fieldLabel : '日期格式'
		}, {
			name : 'cmbDataType',
			fieldLabel : '下拉框数据源类型',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : cmbDataTypeStore,
			editable : false,
			allowBlank : true,
			queryMode : 'local',
			typeAhead : true
		}, {
			name : 'cmbData',
			fieldLabel : '下拉框数据源'
		}, {
			name : 'displayOrder',
			fieldLabel : '排序',
			allowBlank : false
		} ],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : saveTableFields
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				tableFieldsWin.hide();
			}
		} ]
	});

	var tableFieldsWin = new Ext.Window({
		width : 800,
		height : 500,
		glyph : glyphWindow,
		title : '新增/修改字段',
		modal : true,
		padding : 4,
		closeAction : 'hide',
		resizable : false,
		items : [ tableFieldsForm ]
	});

	// var createDBSqlText=
	var createDBSqlWin = new Ext.Window({
		width : 600,
		height : 400,
		glyph : glyphWindow,
		title : '生成建表脚本',
		modal : true,
		padding : 4,
		closeAction : 'hide',
		resizable : false,
		items : [ Ext.create('Ext.form.TextArea', {
			id : 'createDBText',
			height : 300,
			width : 580,
			labelWidth : 80,
			fieldStyle : 'font-size:14px;line-height:150%;',
			fieldLabel : '建表Sql',
			labelAlign : 'right',
			anchor : '100%'
		}) ],
		buttonAlign : 'center',
		buttons : [ {
			text : '建表',
			glyph : glyphSave,
			handler : createDb
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				createDBSqlWin.hide();
			}
		} ]
	});
	// 代码窗口
	var createCodeWin = new Ext.Window({
		width : 1000,
		height : 550,
		glyph : glyphWindow,
		title : '生成代码',
		modal : true,
		padding : 4,
		closeAction : 'hide',
		resizable : false,
		items : [ Ext.create('Ext.form.TextArea', {
			id : 'createCodeText',
			height : 460,
			fieldStyle : 'font-size:14px;line-height:150%;',
			width : 980,
			labelWidth : 80,
			fieldLabel : '代码脚本',
			labelAlign : 'right',
			anchor : '100%'
		}) ],
		buttonAlign : 'center',
		buttons : [ {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				createCodeWin.hide();
			}
		} ]
	});

	var buttonPanel = new Ext.create('Ext.panel.Panel', {
		columnWidth : 0.3,
		title : '综合设置',
		// width : 400,
		bodyPadding : 10,
		xtype : 'container',
		margin : '0 4 0 0',
		defaults : {
			margin : '0 4 4 0'
		},
		defaultType : 'button',
		items : [ {
			text : '全局配置',
			glyph : 61573,
			handler : getGlobalConfig
		}, {
			text : '生成建表脚本',
			glyph : 61888,
			handler : createDbSql
		} /*
			 * , { text : '生成JSP代码', glyph : 61545, handler : function() {
			 * createFile(8); } }
			 */]
	});
	var buttonPanel2 = new Ext.create('Ext.panel.Panel', {
		columnWidth : 0.3,
		title : '生成代码',
		// width : 400,
		bodyPadding : 5,
		margin : '0 4 0 0',
		xtype : 'container',
		defaults : {
			margin : '0 4 4 0'
		},
		defaultType : 'button',
		items : [ {
			text : 'Model代码',
			glyph : 61861,
			handler : function() {
				createCode(1);
			}
		}, {
			text : 'SearchVO代码',
			glyph : 61861,
			handler : function() {
				createCode(2);
			}
		}, {
			text : 'Dao代码',
			glyph : 61861,
			handler : function() {
				createCode(3);
			}
		}, {
			text : 'Service代码',
			glyph : 61861,
			handler : function() {
				createCode(4);
			}
		}, {
			text : 'Controller代码',
			glyph : 61861,
			handler : function() {
				createCode(5);
			}
		}, {
			text : 'Jsp代码',
			glyph : 61861,
			handler : function() {
				createCode(6);
			}
		}, {
			text : 'js代码',
			glyph : 61861,
			handler : function() {
				createCode(7);
			}
		} ]
	});
	var buttonPanel3 = new Ext.create('Ext.panel.Panel', {
		columnWidth : 0.4,
		title : '生成文件',
		// width : 400,
		bodyPadding : 5,
		xtype : 'container',
		defaults : {
			margin : '0 4 4 0'
		},
		defaultType : 'button',
		items : [ {
			text : '生成Model',
			glyph : 61674,
			handler : function() {
				createFile(1);
			}
		}, {
			text : '生成SearchVO',
			glyph : 61674,
			handler : function() {
				createFile(2);
			}
		}, {
			text : '生成Dao',
			glyph : 61674,
			handler : function() {
				createFile(3);
			}
		}, {
			text : '生成Service',
			glyph : 61674,
			handler : function() {
				createFile(4);
			}
		}, {
			text : '生成Controller',
			glyph : 61674,
			handler : function() {
				createFile(5);
			}
		}, {
			text : '生成Jsp',
			glyph : 61674,
			handler : function() {
				createFile(6);
			}
		}, {
			text : '生成js',
			glyph : 61674,
			handler : function() {
				createFile(7);
			}
		}, {
			text : '一键生成所有代码',
			glyph : 61674,
			handler : function() {
				createFile(8);
			}
		} ]
	});
	var setPannel = Ext.create('Ext.panel.Panel', {
		renderTo : Ext.getBody(),
		layout : 'column',
		width : '100%',
		columnWidth : 1,
		height : 100,
		defaults : {
			collapsible : true,
			split : false,
			bodyPadding : 0
		},
		bodyBorder : false,
		items : [ buttonPanel, buttonPanel2, buttonPanel3 ]
	});

	// 主窗体
	var mainPanel = Ext.create('Ext.panel.Panel', {
		renderTo : Ext.getBody(),
		layout : 'column',
		width : '100%',
		height : pageH,
		defaults : {
			collapsible : true,
			split : false,
			bodyPadding : 0
		},
		bodyBorder : false,
		items : [ setPannel, tableConfigGrid, tableFieldsGrid ]
	});

	// /全局配置
	var globalConfigForm = new Ext.create("Ext.form.Panel", {
		id : 'globalConfigForm',
		frame : true,
		border : true,
		width : '100%',
		height : 360,
		buttonAlign : 'center',
		defaultType : 'textfield',
		waitTitle : '正在提交中',
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 120,
			anchor : '100%',
			margin : '0 0 5 0',
			msgTarget : 'qtip'
		},
		items : [ {
			name : 'jsp_filepath',
			fieldLabel : 'JSP文件地址',
			maxLength : 200,
			allowBlank : false
		}, {
			name : 'java_filepath',
			fieldLabel : 'Java文件地址',
			maxLength : 200,
			allowBlank : false
		}, {
			name : 'database_type',
			fieldLabel : '数据库类型',
			allowBlank : false,
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : database_typeStore,
			value : 1,
			editable : false,
			queryMode : 'local',
			typeAhead : true
		} ],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : saveConfig
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				globalConfigWin.hide();
			}
		} ]
	});

	var globalConfigWin = new Ext.Window({
		width : 600,
		height : 400,
		glyph : glyphWindow,
		title : '代码生成全局配置',
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ globalConfigForm ]
	});

	// 表配置处理方法
	function add() {
		tableConfigForm.getForm().reset();
		tableConfigWin.setTitle('『新增表配置』');
		tableConfigForm.getForm().findField("id").setValue(0);
		Ext.getCmp('btnClear').show();
		tableConfigWin.show();
	}
	function update() {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		tableConfigForm.getForm().loadRecord(record);
		tableConfigWin.setTitle('『修改表配置』');
		tableConfigWin.show();
	}
	function save() {
		if (tableConfigForm.getForm().isValid()) {
			var url = "";
			if (tableConfigForm.getForm().findField("id").getValue() == 0)
				url = basePath + '/gen/tableConfig/add.do';
			else
				url = basePath + '/gen/tableConfig/update.do';
			tableConfigForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					tableConfigWin.hide();
					tableConfigStore.reload();
				},
				failure : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText)
				}
			});
		}
	}
	function del() {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		Ext.Msg.confirm('确认删除', '确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/gen/tableConfig/delete.do',
					params : {
						id : record.data.id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								tableConfigStore.reload();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText);
						}
					}
				});
			}
		});
	}
	function search() {
		tableConfigStore.loadPage(1);
	}
	// 字段配置处理方法
	function addTableFields() {
		var tableConfigRecord = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!tableConfigRecord)
			return;
		tableFieldsForm.getForm().reset();
		tableFieldsForm.getForm().findField("id").setValue("0");
		tableFieldsForm.getForm().findField("tableId").setValue(tableConfigRecord.data.id);
		tableFieldsWin.setTitle("新增字段配置");
		tableFieldsWin.show();
	}

	function updateTableFields() {
		var record = tableFieldsGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		tableFieldsForm.getForm().loadRecord(record);
		tableFieldsWin.setTitle("修改字段配置");
		tableFieldsWin.show();
	}

	function saveTableFields() {
		if (tableFieldsForm.getForm().isValid()) {
			var url = "";
			if (tableFieldsForm.getForm().findField("id").getValue() == 0)
				url = basePath + '/gen/tableFields/add.do';
			else
				url = basePath + '/gen/tableFields/update.do';
			tableFieldsForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					tableFieldsWin.hide();
					tableFieldsStore.reload();
				},
				failure : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText)
				}
			});
		}
	}
	/**
	 * 删除功能
	 */
	function delTableFields() {
		var record = tableFieldsGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		Ext.Msg.confirm('确认删除', '确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/gen/tableFields/delete.do',
					params : {
						id : record.data.id
					},
					success : function(response) {
						unMask();//
						var result = Ext.JSON.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								tableFieldsStore.reload();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText);
						}
					}
				});
			}
		});
	}

	// /生成建表脚本
	function createDbSql() {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		Ext.Ajax.request({
			url : basePath + '/gen/tableConfig/createDbSql.do',
			params : {
				tableId : record.data.id
			},
			success : function(response) {
				var result = Ext.JSON.decode(response.responseText);
				Ext.getCmp("createDBText").setValue(result.sql);
				createDBSqlWin.show();
			}
		});
	}

	// 执行建表脚本
	function createDb() {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		Ext.Msg.confirm('确认操作', '你确认要新建数据表吗?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/gen/tableConfig/createDb.do',
					params : {
						tableId : record.data.id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '创建成功');
						} else {
							Ext.Msg.alert('操作提示', '创建失败');
						}
					}
				});
			}
		});
	}

	/***************************************************************************
	 * 生成对应的文件
	 */
	function createFile(type) {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		Ext.Ajax.request({
			url : basePath + '/gen/tableConfig/checkFileExist.do',
			params : {
				tableId : record.data.id,
				type : type
			},
			success : function(response) {
				var result = Ext.JSON.decode(response.responseText);
				if (result.success) {
					createDestFile(record.data.id, type)
				} else {
					Ext.Msg.confirm('确认操作', result.msgText + '<br/>你确认要继续创建吗?', function(btn) {
						if (btn == 'yes') {
							createDestFile(record.data.id, type)
						}
					});
				}
			}
		});
	}

	// 生成代码
	function createCode(type) {
		var record = tableConfigGrid.getSelectionModel().getLastSelected();
		if (!record)
			return;
		$.ajax({
			type : "get",
			url : basePath + '/gen/tableConfig/createCode.do',
			data : {
				tableId : record.data.id,
				type : type
			},
			dataType : "html",
			success : function(result) {
				Ext.getCmp("createCodeText").setValue(result);
				createCodeWin.show();
			}
		});

	}

	function createDestFile(tableId, type) {
		Ext.Ajax.request({
			url : basePath + '/gen/tableConfig/createFile.do',
			params : {
				tableId : tableId,
				type : type
			},
			success : function(response) {
				unMask();
				var result = Ext.decode(response.responseText);
				if (result.success) {
					Ext.Msg.alert('操作提示', '创建成功');
				} else {
					Ext.Msg.alert('操作提示', '创建失败');
				}
			}
		});
	}

	// 获取全局配置
	function getGlobalConfig() {
		Ext.Ajax.request({
			url : basePath + '/gen/tableConfig/getConfig.do',
			success : function(response) {
				var result = Ext.decode(response.responseText);
				globalConfigForm.getForm().findField("jsp_filepath").setValue(result.jsp_filepath);
				globalConfigForm.getForm().findField("java_filepath").setValue(result.java_filepath);
				globalConfigForm.getForm().findField("database_type").setValue(result.database_type);
				globalConfigWin.show();
			}
		});
	}
	// 保存全局配置
	function saveConfig() {
		if (globalConfigForm.getForm().isValid()) {
			var url = "";
			globalConfigForm.getForm().submit({
				clientValidation : true,
				url : basePath + '/gen/tableConfig/saveConfig.do',
				success : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText, function() {
						globalConfigWin.hide();
					});
				},
				failure : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText)
				}
			});
		}
	}
	// 自适应大小
	Ext.GlobalEvents.on('resize', function() {
		tableConfigGrid.getView().refresh();
		tableConfigGrid.setWidth('100%')
	})
})