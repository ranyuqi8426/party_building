Ext.onReady(function() {
var addOrUpdate = 0;// 定义新增还是修改的标示

	
	
	
	
	Ext.define('DicNews', {
		extend : 'Ext.data.Model',
		fields : [{name : 'id',type : 'int'},{name : 'title',type : 'string'},{name : 'content',type : 'string'},{name : 'type',type : 'int'} ]
	});

	var newsStore = Ext.create('Ext.data.Store', {
		model : 'DicNews',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/dic/news/search.do',
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
					title : Ext.getCmp('txtTitle').getValue(),type : Ext.getCmp('txtType').getValue()
				});
			}
		}
	});

	var selNewsModel = Ext.create('Ext.selection.CheckboxModel', {
		mode : 'SINGLE'
	});

	var newsTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [ {
			text : '新增',
			glyph : glyphAdd,
			handler : addNews
		}, '标题',{xtype : 'textfield',width : 100,id : 'txtTitle'},'分类',{xtype : 'textfield',width : 100,id : 'txtType'}, {
			xtype : 'button',
			glyph : glyphSearch,
			text : '查询',
			handler : function() {
				searchNews();
			}
		} , {
			xtype : 'button',
			glyph : glyphClear,
			text : '清空',
			handler : function() {
				clearNews();
			}
		}]
	});

	var newsGrid = Ext.create('Ext.grid.Panel', {
		title : '新闻管理列表',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : newsStore,
		selModel : selNewsModel,
		renderTo : Ext.getBody(),
		columns : [ {
			xtype : 'rownumberer',
			width : 40
		}, {text : '标题',dataIndex : 'title',width : 300,align:'left',sortable : false}, {text : '内容',dataIndex : 'content',width : 100,align:'left',sortable : false}, {text : '分类',dataIndex : 'type',width : 100,align:'left',sortable : false},{
			xtype : 'actioncolumn',
			text : '操作',
			width : 120,
			align : 'left',
			items : [ {
				text : '修改',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					updateNews(grid.getStore().getAt(rowIndex));
				}
			}, {
				text : '删除',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					deleteNews(grid.getStore().getAt(rowIndex))
				}
			}, {
				text : '查看',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					viewNews(grid.getStore().getAt(rowIndex))
				}
			} ]
			} ],
		viewConfig : {
			stripeRows : true,
			enableTextSelection : true
		},
		tbar : newsTb,
		bbar : Ext.create('Ext.PagingToolbar', {
			store : newsStore,
			displayInfo : true
		})
	});
	var newsForm = new Ext.create("Ext.form.Panel", {
		id : 'newsForm',
		frame : true,
		border : true,
		width : '100%',
		height : 420,
		bodyPadding : 4,
		layout:'column',
		buttonAlign : 'center',
		defaultType : 'textfield',
		waitTitle : '正在提交中',
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 120,
			anchor : '100%',
			margin : '0 0 5 0',
			msgTarget : 'qtip',
			columnWidth:0.5
		},
		items : [ {fieldLabel:'id',xtype : 'textfield',width : 100,name : 'id',allowBlank:false,maxLength:12},{fieldLabel:'标题',xtype : 'textfield',width : 100,name : 'title',maxLength:50},{fieldLabel:'内容',xtype : 'textfield',width : 100,name : 'content',maxLength:200},{fieldLabel:'分类',xtype : 'textfield',width : 100,name : 'type',allowBlank:false,maxLength:10}],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : saveNews
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				newsWin.hide();
			}
		} ]
	});

	var newsWin = new Ext.Window({
		width : 800,
		height : 460,
		glyph : glyphWindow,
		title : '新增/修改',
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ newsForm ]
	});

	var newsViewForm = new Ext.create("Ext.form.Panel", {
		id : 'newsViewForm',
		width : '100%',
		height : 420,
		bodyPadding : 4,
		layout:'column',
		defaultType : 'textfield',
		buttonAlign : 'center',
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 90,
			anchor : '100%',
			margin : '0 0 5 0',
			msgTarget : 'qtip',
			columnWidth:0.5
		},
		items : [ {fieldLabel:'id',xtype : 'textfield',width : 100,name : 'id',allowBlank:false,maxLength:12},{fieldLabel:'标题',xtype : 'textfield',width : 100,name : 'title',maxLength:50},{fieldLabel:'内容',xtype : 'textfield',width : 100,name : 'content',maxLength:200},{fieldLabel:'分类',xtype : 'textfield',width : 100,name : 'type',allowBlank:false,maxLength:10}],
		buttons : [ {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				newsViewWin.hide();
			}
		} ]
	});
	var newsViewWin = new Ext.Window({
		width : 800,
		height : 460,
		glyph : glyphWindow,
		title : '『查看新闻管理』',
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ newsViewForm ]
	});
	
	searchNews();
	// 查询
	function searchNews() {
		newsStore.loadPage(1);
	}
	// 选择性条件清空
	function clearNews() {
		Ext.getCmp('txtTitle').setValue('');
Ext.getCmp('txtType').setValue('');

	}
	
	// 新增
	function addNews() {
		newsForm.getForm().reset();
		newsForm.getForm().findField("id").setValue("0");
		newsWin.setTitle("『新增新闻管理』");
		newsWin.show();
		addOrUpdate=1;
	}
	
	// 修改
	function updateNews(record) {
		newsForm.getForm().loadRecord(record);
		newsWin.setTitle("『修改新闻管理』");
		newsWin.show();
		addOrUpdate=2;
	}
	
	// 保存
	function saveNews() {
		var url = "";
		if (addOrUpdate==1)
			url = basePath + '/dic/news/add.do';
		else if(addOrUpdate==2)
			url = basePath + '/dic/news/update.do';
		if (newsForm.getForm().isValid()) {
			newsForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					newsWin.hide();
					newsStore.reload();
				},
				failure : function(form, action) {
					Ext.Msg.alert('操作提示', action.result.msgText)
				}
			});
		}
	}
	
	// 删除
	function deleteNews(record) {
		Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/dic/news/delete.do',
					params : {
						id : record.data.id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								newsStore.reload();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText);
						}
					}
				});
			}
		});
	}

	// 查看
	function viewNews(record) {
		newsViewForm.getForm().loadRecord(record);
		setFormReadOnly(newsViewForm, true);
		newsViewWin.show();
	}

	// 自适应大小
	Ext.GlobalEvents.on('resize', function() {
		newsGrid.getView().refresh();
		newsGrid.setWidth('100%')
	})
});