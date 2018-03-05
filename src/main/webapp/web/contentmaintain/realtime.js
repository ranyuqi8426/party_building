Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	Ext.define('realtimeMaintain', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'realtimeinfo_id',
			type : 'string'
		}, {
			name : 'realtimeinfo_title',
			type : 'string'
		}, {
			name : 'realtimeinfo_content',
			type : 'string'
		}, {
			name : 'read_num',
			type : 'string'
		}, {
			name : 'img_url1',
			type : 'string'
		}, {
			name : 'img_url2',
			type : 'string'
		}, {
			name : 'img_url3',
			type : 'string'
		}, {
			name : 'realtimeinfo_time',
			type : 'string'
		},{
			name:'create_name',
			typrz:'string'
		},{
			name:'upload_id',
			typrz:'string'
		},{
			name:'upload_name',
			typrz:'string'
		}]
	});
	// 查询
	var realtimeMaintainStore = Ext.create('Ext.data.Store', {
		model : 'realtimeMaintain',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/realtime/search.do',
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
					realtimeinfo_title:Ext.getCmp('txttiyle_id').getValue(),
					date_start:Ext.getCmp('date_start').getValue(),
					date_end:Ext.getCmp('date_end').getValue()
				});
			}
		}
	});

	var realtimeMaintainTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [ {
			text : '添加',
			xtype : 'button',
			glyph : glyphAdd,
			handler : addrealtime
		}, '标题', {
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
				searchrealtimeMaintain();
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

	var realtimeMaintainGrid = Ext.create('Ext.grid.Panel', {
		title : '实时资讯',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : realtimeMaintainStore,
		renderTo : Ext.getBody(),
		xtype: 'row-expander-grid',
		columns : [ {
			text : '标题',
			dataIndex : 'realtimeinfo_title',
			width : 150,
			align : 'center',
			sortable : false
		}, {
			text : '内容',
			dataIndex : 'realtimeinfo_content',
			width : 300,
			align : 'center',
			sortable : false
		}, {
			text : '阅读数',
			dataIndex : 'read_num',
			width : 80,
			align : 'center',
			sortable : false
		}, {
			text : '作者',
			dataIndex : 'create_name',
			width : 300,
			align : 'center',
			sortable : false
		}, {
			text : '上传人',
			dataIndex : 'upload_name',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '上传时间',
			dataIndex : 'realtimeinfo_time',
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
				text : '删除',
				xtype : 'button',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					deleterealtime(grid.getStore().getAt(rowIndex))
				}
			} ]
		} ],
		 plugins: [{
		        ptype: 'rowexpander',
		        rowBodyTpl : new Ext.XTemplate(
			            '<p><b>图片1:</b> {img_url1:this.imgUrl}</p>',
			            '<p><b>图片2:</b> {img_url2:this.imgUrl}</p>',
			            '<p><b>图片3:</b> {img_url3:this.imgUrl}</p>'
		        	
		        ,{
		            imgUrl: function(val){
		            	if(val==null||val==""){
		            		return "暂无上传图片"
		            	}
		                return '<a href='+val+' target=view_window title=点击预览 style= text-decoration:none ;color:blue>'+val+'</a>';
     	}
		        }
		            
		            
		            )
		    }],
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
			items : [ realtimeMaintainTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : realtimeMaintainStore,
			displayInfo : true
		})
	});

	// 新建
	var realtimeMaintainAddForm = new Ext.create("Ext.form.Panel", {
		id : 'realtimeMaintainAddForm',
		frame : true,
		border : true,
		width : '100%',
		height : 230,
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
			name : 'realtimeinfo_id',
			hidden : true
		}, {
			fieldLabel : '标题',
			name : 'realtimeinfo_title',
			xtype : 'textfield',
		},{
			fieldLabel : '内容',
			name : 'realtimeinfo_content',
			xtype : 'textfield'
		}, {
			xtype : 'filefield',
			emptyText : '请选择要上传的视频',
			fieldLabel : '视频',
			id : 'learning_data',
			width : 350,
			readOnly : true,
			name : 'learning_data',
			buttonText : '',
			buttonConfig : {
				iconCls : 'icon-upload'
			}
		}, {
			xtype : 'filefield',
			emptyText : '请选择要上传的视频显示图',
			fieldLabel : '视频显示图',
			id : 'learning_pic',
			width : 350,
			readOnly : true,
			name : 'learning_pic',
			buttonText : '',
			buttonConfig : {
				iconCls : 'icon-upload'
			}
		}],
		buttons : [ {
			text : '保存',
			glyph : glyphSave,
			handler : saverealtimeMaintain
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				realtimeMaintainAddWin.hide();
			}
		} ]
	});
	
	searchrealtimeMaintain();
	// 查询
	function searchrealtimeMaintain() {
		realtimeMaintainStore.loadPage(1);
	}

	var realtimeMaintainAddWin = new Ext.Window({
		width : 400,
		height : 270,
		glyph : glyphWindow,
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ realtimeMaintainAddForm ]
	});
	// 新增
	function addrealtime() {
		realtimeMaintainAddForm.getForm().reset();
		realtimeMaintainAddWin.setTitle("『新增实时资讯』");
		realtimeMaintainAddWin.show();
		addOrUpdate = 1;
	}

	// 保存
	function saverealtimeMaintain() {
		var url = "";
		if (addOrUpdate == 1)
			url = basePath + '/pc/realtime/add.do';
		else
			url = basePath + '/pc/realtime/update.do';
		if (realtimeMaintainForm.getForm().isValid()) {
			realtimeMaintainForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					realtimeMaintainAddWin.hide();
					realtimeMaintainStore.reload();
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
	function deleterealtime(record) {
		Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/pc/realtime/delete.do',
					params : {
						learning_data_id : record.data.learning_data_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								realtimeMaintainStore.reload();
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
		realtimeMaintainGrid.getView().refresh();
		realtimeMaintainGrid.setWidth('100%')
	})
});