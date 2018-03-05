Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	Ext.define('businessList', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'name',
			type : 'string'
		}, {
			name : 'biz_id',
			type : 'string'
		}, {
			name : 'Location',
			type : 'string'
		}, {
			name : 'introduction',
			type : 'string'
		}, {
			name : 'status',
			type : 'string'
		}, {
			name : 'user_id',
			type : 'string'
		}, {
			name : 'username',
			type : 'string'
		}, {
			name : 'realname',
			type : 'string'
		}]
	});
	// 查询
	var businessListStore = Ext.create('Ext.data.Store', {
		model : 'businessList',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/businessmanager/search.do',
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
					date_start:Ext.getCmp('date_start').getValue()
				});
			}
		}
	});

	var businessListTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [  '商家名称', {
			xtype : 'textfield',
			width : 180,
			id : 'txttiyle_id'
		}, {
			fieldLabel : '商家状态',
			labelWidth : 70,
			xtype : 'datefield',
			width : 180,
			id : 'date_start',
			format : 'Y-m-d',
			editable : false

		},{
			xtype : 'button',
			glyph : glyphSearch,
			text : '查询',
			handler : function() {
				searchbusinessList();
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

	var businessListGrid = Ext.create('Ext.grid.Panel', {
		title : '商家列表',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : businessListStore,
		renderTo : Ext.getBody(),
		columns : [ {
			text : '商家名称',
			dataIndex : 'name',
			width : 150,
			align : 'center',
			sortable : false
		},  {
			text : '商家位置',
			dataIndex : 'location',
			width : 700,
			align : 'center',
			sortable : false,
		}, {
			text : '商家简介',
			dataIndex : 'introduction',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '商家状态',
			dataIndex : 'status',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '操作用户',
			dataIndex : 'username',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '真实姓名',
			dataIndex : 'realname',
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
				text : '审核通过',
				xtype : 'button',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					updateinfo(grid.getStore().getAt(rowIndex));
				}
			},{
				text : '审核不通过',
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
			items : [ businessListTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : businessListStore,
			displayInfo : true
		})
	});

	// 新建
	var businessListAddForm = new Ext.create("Ext.form.Panel", {
		id : 'businessListAddForm',
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
			handler : savebusinessList
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				businessListAddWin.hide();
			}
		} ]
	});
	searchbusinessList();
	// 查询
	function searchbusinessList() {
		businessListStore.loadPage(1);
	}

	var businessListAddWin = new Ext.Window({
		width : 730,
		height : 440,
		glyph : glyphWindow,
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ businessListAddForm ]
	});
	// 新增
	function addinfo() {
		businessListAddForm.getForm().reset();
		businessListAddWin.setTitle("『查看商家信息』");
		businessListAddWin.show();
		addOrUpdate = 1;
	}
	 //修改
	function updateinfo(record) {
		 businessListAddForm.getForm().loadRecord(record);
		 businessListAddWin.setTitle("『修改理论知识』");
		 businessListAddWin.show();
		addOrUpdate = 2;
	}

	// 保存
	function savebusinessList() {
		var url = "";
		if (addOrUpdate == 1)
			url = basePath + '/pc/businessmanager/add.do';
		else
			url = basePath + '/pc/businessmanager/update.do';
		if (businessListAddForm.getForm().isValid()) {
			businessListAddForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					businessListAddWin.hide();
					businessListStore.reload();
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
					url : basePath + '/pc/businessmanager/delete.do',
					params : {
						biz_id : record.data.biz_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								businessListStore.reload();
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
		businessListGrid.getView().refresh();
		businessListGrid.setWidth('100%')
	})
});