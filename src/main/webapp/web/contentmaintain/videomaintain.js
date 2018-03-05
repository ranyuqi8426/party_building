Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	Ext.define('VideoMaintain', {
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
	var VideoMaintainStore = Ext.create('Ext.data.Store', {
		model : 'VideoMaintain',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/video/search.do',
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

	var VideoMaintainTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [ {
			text : '添加',
			xtype : 'button',
			glyph : glyphAdd,
			handler : addVideo
		}, '视频标题', {
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
				searchVideoMaintain();
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

	var VideoMaintainGrid = Ext.create('Ext.grid.Panel', {
		title : '党课视频信息',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : VideoMaintainStore,
		renderTo : Ext.getBody(),
		columns : [ {
			text : '视频标题',
			dataIndex : 'learning_data_title',
			width : 150,
			align : 'center',
			sortable : false
		}, {
			text : '视频地址',
			dataIndex : 'learning_data_url',
			width : 300,
			align : 'center',
			sortable : false,
			renderer : videoUrl
		}, {
			text : '视频内容',
			dataIndex : 'learning_content',
			width : 200,
			align : 'center',
			sortable : false,
		}, {
			text : '视频首图',
			dataIndex : 'learning_pic_url',
			width : 300,
			align : 'center',
			sortable : false,
			renderer : imgUrl
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
//			          {
//				text : '修改',
//				xtype : 'button',
//				handler : function(grid, rowIndex, colIndex) {
//					setGridSelect(grid, rowIndex);
//					updateVideo(grid.getStore().getAt(rowIndex));
//				}
//			},
			{
				text : '删除',
				xtype : 'button',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					deleteVideo(grid.getStore().getAt(rowIndex))
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
			items : [ VideoMaintainTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : VideoMaintainStore,
			displayInfo : true
		})
	});

	// 新建
	var VideoMaintainAddForm = new Ext.create("Ext.form.Panel", {
		id : 'VideoMaintainAddForm',
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
			name : 'display_order',
			hidden : true
		}, {
			fieldLabel : '视频标题',
			name : 'learning_data_title',
			xtype : 'textfield',
		},{
			fieldLabel : '视频内容',
			name : 'learning_content',
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
			handler : saveVideoMaintain
		}, {
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				VideoMaintainAddWin.hide();
			}
		} ]
	});
	// 修改
//	var VideoMaintainUpdateForm = new Ext.create("Ext.form.Panel", {
//		id : 'VideoMaintainUpdateForm',
//		frame : true,
//		border : true,
//		width : '100%',
//		height : 330,
//		buttonAlign : 'center',
//		defaultType : 'textfield',
//		waitTitle : '正在提交中',
//		fieldDefaults : {
//			labelAlign : 'left',
//			labelWidth : 90,
//			margin : '0 0 5 0',
//			anchor : '100%',
//			msgTarget : 'qtip',
//			columnWidth : 1
//		},
//		items : [ {
//			name : 'display_order',
//			hidden : true
//		}, {
//			fieldLabel : '视频标题',
//			name : 'learning_data_title',
//			xtype : 'textfield',
//		},{
//			fieldLabel : '视频内容',
//			name : 'learning_content',
//			xtype : 'textfield'
//		},{
//			xtype:'panel',
//			id:'videopanelId',
//			width : '100%',
//			html:'<img width="100%" height:"100%" src="http://image.elegantliving.ceconline.com/320000/320100/20110815_03_52.jpg"/>',
//			height:200
//		}],
//		buttons : [ {
//			text : '保存',
//			glyph : glyphSave,
//			handler : saveVideoMaintain
//		}, {
//			text : '返回',
//			glyph : glyphBack,
//			handler : function() {
//				VideoMaintainAddWin.hide();
//			}
//		} ]
//	});
	function videoUrl(val){
		return '<a href="'+val+'" target="view_window" title= "点击预览" style="text-decoration:none;color:blue">'+val+'</a>';
	}
	function imgUrl(val){
		return '<a href='+val+' target="view_window"title="点击预览"style="text-decoration:none ;color:blue">'+val+'</a>';
	}
	searchVideoMaintain();
	// 查询
	function searchVideoMaintain() {
		VideoMaintainStore.loadPage(1);
	}

	var VideoMaintainAddWin = new Ext.Window({
		width : 400,
		height : 270,
		glyph : glyphWindow,
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ VideoMaintainAddForm ]
	});
//	var VideoMaintainUpdateWin = new Ext.Window({
//		width : 400,
//		height : 370,
//		glyph : glyphWindow,
//		modal : true,
//		closeAction : 'hide',
//		padding : 4,
//		items : [ VideoMaintainUpdateForm ]
//	});
	// 新增
	function addVideo() {
		VideoMaintainAddForm.getForm().reset();
		VideoMaintainAddWin.setTitle("『新增党课视频』");
		VideoMaintainAddWin.show();
		addOrUpdate = 1;
	}
	// 修改
//	function updateVideo(record) {
//		VideoMaintainUpdateForm.getForm().loadRecord(record);
//		Ext.getCmp('videopanelId').html='<img width="100%" height:"100%" src="http://image.elegantliving.ceconline.com/320000/320100/20110815_03_52.jpg"/>'
//		VideoMaintainUpdateWin.setTitle("『修改党课视频』");
//		VideoMaintainUpdateWin.show();
//		addOrUpdate = 2;
//	}

	// 保存
	function saveVideoMaintain() {
		var url = "";
		if (addOrUpdate == 1)
			url = basePath + '/pc/video/add.do';
		else
			url = basePath + '/pc/video/update.do';
		if (VideoMaintainForm.getForm().isValid()) {
			VideoMaintainForm.getForm().submit({
				clientValidation : true,
				url : url,
				success : function(form, action) {
					VideoMaintainAddWin.hide();
					VideoMaintainStore.reload();
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
	function deleteVideo(record) {
		Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/pc/video/delete.do',
					params : {
						learning_data_id : record.data.learning_data_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								VideoMaintainStore.reload();
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
		VideoMaintainGrid.getView().refresh();
		VideoMaintainGrid.setWidth('100%')
	})
});