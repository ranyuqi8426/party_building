Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	Ext.define('businessDiscount', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'sale_id',
			type : 'string'
		}, {
			name : 'biz_id',
			type : 'string'
		}, {
			name : 'title',
			type : 'string'
		}, {
			name : 'content',
			type : 'string'
		}, {
			name : 'end_time',
			type : 'string'
		}, {
			name : 'pic_url1',
			type : 'string'
		}]
	});
	// 查询
	var businessDiscountStore = Ext.create('Ext.data.Store', {
		model : 'businessDiscount',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/businessdiscount/search.do',
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

	var businessDiscountTb = Ext.create('Ext.toolbar.Toolbar', {
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
				searchbusinessDiscount();
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

	var businessDiscountGrid = Ext.create('Ext.grid.Panel', {
		title : '商家列表',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : businessDiscountStore,
		renderTo : Ext.getBody(),
		columns : [ {
			text : '标题',
			dataIndex : 'title',
			width : 150,
			align : 'center',
			sortable : false
		},  {
			text : '优惠内容',
			dataIndex : 'content',
			width : 700,
			align : 'center',
			sortable : false,
		}, {
			text : '失效日期',
			dataIndex : 'end_time',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '优惠卡预览',
			dataIndex : 'pic_url1',
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
			items : [ businessDiscountTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : businessDiscountStore,
			displayInfo : true
		})
	});

	// 新建
	var businessDiscountAddForm = new Ext.create("Ext.form.Panel", {
		id : 'businessDiscountAddForm',
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
			handler : savebusinessDiscount
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				businessDiscountAddWin.hide();
			}
		} ]
	});
	searchbusinessDiscount();
	// 查询
	function searchbusinessDiscount() {
		businessDiscountStore.loadPage(1);
	}

	var businessDiscountAddWin = new Ext.Window({
		width : 730,
		height : 440,
		glyph : glyphWindow,
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ businessDiscountAddForm ]
	});
	// 新增
	function addinfo() {
		businessDiscountAddForm.getForm().reset();
		businessDiscountAddWin.setTitle("『查看商家信息』");
		businessDiscountAddWin.show();
		addOrUpdate = 1;
	}
	 //修改
	function updateinfo(record) {
		 businessDiscountAddForm.getForm().loadRecord(record);
		 businessDiscountAddWin.setTitle("『修改理论知识』");
		 businessDiscountAddWin.show();
		addOrUpdate = 2;
	}

	// 保存
	function savebusinessDiscount() {
		var url = "";
		if (addOrUpdate == 1)
			url = basePath + '/pc/businessdiscount/add.do';
		else
			url = basePath + '/pc/businessdiscount/update.do';
		if (businessDiscountAddForm.getForm().isValid()) {
			businessDiscountAddForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					businessDiscountAddWin.hide();
					businessDiscountStore.reload();
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
					url : basePath + '/pc/businessdiscount/delete.do',
					params : {
						biz_id : record.data.biz_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								businessDiscountStore.reload();
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
		businessDiscountGrid.getView().refresh();
		businessDiscountGrid.setWidth('100%')
	})
});