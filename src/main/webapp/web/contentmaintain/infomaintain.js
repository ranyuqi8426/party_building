Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	Ext.define('infoMaintain', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'learning_data_id',
			type : 'string'
		}, {
			name : 'learning_data_title',
			type : 'string'
		}, {
			name : 'learning_data_url',
			type : 'string'
		}, {
			name : 'learning_content',
			type : 'string'
		}, {
			name : 'learning_pic_url',
			type : 'string'
		}, {
			name : 'learning_data_type',
			type : 'string'
		}, {
			name : 'create_user_id',
			type : 'string'
		}, {
			name : 'create_date',
			type : 'string'
		},{
			name:'create_user_name',
			typrz:'string'
		}]
	});
	// 查询
	var infoMaintainStore = Ext.create('Ext.data.Store', {
		model : 'infoMaintain',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/info/search.do',
			actionMethods : {
				read : "POST"
			},
			reader : {
				rootProperty : 'root'
			}
		},
		autoLoad : false,
		listeners : {
			beforeload : function(store) {
				Ext.apply(store.proxy.extraParams, {
					learning_data_title:Ext.getCmp('txttiyle_id').getValue(),
					date_start:Ext.getCmp('date_start').getValue(),
					date_end:Ext.getCmp('date_end').getValue()
				});
			}
		}
	});

	var infoMaintainTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [ {
			text : '添加',
			xtype : 'button',
			glyph : glyphAdd,
			handler : addinfo
		}, '知识标题', {
			xtype : 'textfield',
			width : 180,
			id : 'txttiyle_id'
		}, {
			fieldLabel : '上传时间从',
			labelWidth : 70,
			xtype : 'datefield',
			width : 180,
			id : 'date_start',
			format : 'Y-m-d',
			editable : false

		}, {
			fieldLabel : '到',
			labelWidth : 30,
			xtype : 'datefield',
			width : 140,
			id : 'date_end',
			format : 'Y-m-d ',
			editable : false
		},{
			xtype : 'button',
			glyph : glyphSearch,
			text : '查询',
			handler : function() {
				searchinfoMaintain();
			}
		},{
			xtype : 'button',
			glyph : glyphClear,
			text : '清空',
			handler : function() {
				clear();
			}
		}]
	});

	var infoMaintainGrid = Ext.create('Ext.grid.Panel', {
		title : '党课理论知识',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : infoMaintainStore,
		renderTo : Ext.getBody(),
		columns : [ {
			text : '知识标题',
			dataIndex : 'learning_data_title',
			width : 150,
			align : 'center',
			sortable : false
		},  {
			text : '知识内容',
			dataIndex : 'learning_content',
			width : 700,
			align : 'center',
			sortable : false,
		}, {
			text : '上传人',
			dataIndex : 'create_user_name',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '上传时间',
			dataIndex : 'create_date',
			width : 100,
			align : 'center',
			sortable : false
		},{
			xtype : 'actioncolumn',
			width : 120,
			text : '操作',
			width : 200,
			align : 'left',
			items : [ 
			          {
				text : '修改',
				xtype : 'button',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					updateinfo(grid.getStore().getAt(rowIndex));
				}
			},
			{
				text : '删除',
				xtype : 'button',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					deleteinfo(grid.getStore().getAt(rowIndex))
				}
			} ]
		} ],
		viewConfig : {
			stripeRows : true,
			enableTextSelection : true
		},
		tbar : {
			xtype : 'container',
			layout : 'anchor',
			defaults : {
				anchor : '0'
			},
			defaultType : 'toolbar',
			items : [ infoMaintainTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : infoMaintainStore,
			displayInfo : true
		})
	});

	// 新建
	var infoMaintainAddForm = new Ext.create("Ext.form.Panel", {
		id : 'infoMaintainAddForm',
		frame : true,
		border : true,
		width : '100%',
		height : 400,
		buttonAlign : 'center',
		defaultType : 'textfield',
		waitTitle : '正在提交中',
		fieldDefaults : {
			labelAlign : 'left',
			labelWidth : 90,
			margin : '0 0 5 0',
			anchor : '100%',
			msgTarget : 'qtip',
			columnWidth : 1
		},
		items : [ {
			name : 'learning_data_id',
			hidden : true
		}, {
			fieldLabel : '知识标题',
			name : 'learning_data_title',
			xtype : 'textfield',
		},{
			fieldLabel : '知识内容',
			name : 'learning_content',
			xtype : 'textarea',
			height : 300
		}],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : saveinfoMaintain
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				infoMaintainAddWin.hide();
			}
		} ]
	});
	searchinfoMaintain();
	// 查询
	function searchinfoMaintain() {
		infoMaintainStore.loadPage(1);
	}

	var infoMaintainAddWin = new Ext.Window({
		width : 730,
		height : 440,
		glyph : glyphWindow,
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ infoMaintainAddForm ]
	});
	// 新增
	function addinfo() {
		infoMaintainAddForm.getForm().reset();
		infoMaintainAddWin.setTitle("『新增理论知识』");
		infoMaintainAddWin.show();
		addOrUpdate = 1;
	}
	 //修改
	function updateinfo(record) {
		 infoMaintainAddForm.getForm().loadRecord(record);
		 infoMaintainAddWin.setTitle("『修改理论知识』");
		 infoMaintainAddWin.show();
		addOrUpdate = 2;
	}

	// 保存
	function saveinfoMaintain() {
		var url = "";
		if (addOrUpdate == 1)
			url = basePath + '/pc/info/add.do';
		else
			url = basePath + '/pc/info/update.do';
		if (infoMaintainAddForm.getForm().isValid()) {
			infoMaintainAddForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					infoMaintainAddWin.hide();
					infoMaintainStore.reload();
				},
				failure : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText)
				}
			});
		}
	}
	/**
	 * 删除
	 */
	function deleteinfo(record) {
		Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/pc/info/delete.do',
					params : {
						learning_data_id : record.data.learning_data_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								infoMaintainStore.reload();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText);
						}
					}
				});
			}
		});
	}
	
	// 选择性条件清空
	function clear() {
		Ext.getCmp('txttiyle_id').setValue('');
		Ext.getCmp('date_start').setValue('');
		Ext.getCmp('date_end').setValue('');
		
	}
	
	
	
	// 自适应大小
	Ext.GlobalEvents.on('resize', function() {
		infoMaintainGrid.getView().refresh();
		infoMaintainGrid.setWidth('100%')
	})
});