Ext.onReady(function() {
	var addOrUpdate = 0;// 定义新增还是修改的标示
	var selModel = Ext.create('Ext.selection.CheckboxModel', {
		mode : 'MULTI'
	});
	Ext.define('PointExchange', {
		extend : 'Ext.data.Model',
		fields : [ {
			name : 'show_id',
			type : 'string'
		}, {
			name : 'content',
			type : 'string'
		}, {
			name : 'create_time',
			type : 'string'
		}, {
			name : 'location_desc',
			type : 'string'
		}, {
			name : 'audit_time',
			type : 'string'
		}, {
			name : 'auditor_id',
			type : 'string'
		}, {
			name : 'audit_status',
			type : 'string'
		}, {
			name : 'read_num',
			type : 'string'
		},{
			name : 'img_one',
			type : 'string'
		}, {
			name : 'img_two',
			type : 'string'
		}, {
			name : 'img_three',
			type : 'string'
		},{
			name : 'img_four',
			type : 'string'
		}, {
			name : 'img_five',
			type : 'string'
		}, {
			name : 'img_six',
			type : 'string'
		},{
			name : 'img_seven',
			type : 'string'
		}, {
			name : 'img_eight',
			type : 'string'
		}, {
			name : 'img_nine',
			type : 'string'
		},{
			name : 'imgnum',
			type : 'string'
		},{
			name:'user_name',
			type : 'string'
		},{
			name:'user_id',
			type : 'string'
		}]
	});

	var exchangeStore = Ext.create('Ext.data.Store', {
		model : 'PointExchange',
		pageSize : pagelimit,
		proxy : {
			type : 'ajax',
			url : basePath + '/pc/happyinfoshow/searchpc.do',
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
				// goods_name : Ext.getCmp('create_time_star').getValue(),
				// deli_mobile : Ext.getCmp('create_time_end').getValue(),
				// status : Ext.getCmp('cmbStatus').getValue()
//					statrans_date : Ext.Date.format(Ext.getCmp('txtStatrans_date').getValue(),'Y-m-d'),
				});
			}
		}
	});
	function renderStatus(val) {
		if (val == '1') {
			return '<span style="color:blue;">审核通过</span>';
		} else if (val == '2') {
			return '<span style="color:' + "red" + ';">' + '审核不通过' + '</span>';
		}else
			return '';
	}
	var statusStore = Ext.create('Ext.data.Store', {
		model : 'ComboboxData',
		data : [ {
			'value' : '1',
			'content' : '审核通过'
		}, {
			'value' : '2',
			'content' : '审核不通过'
		}]
	})

	var exchangeTb = Ext.create('Ext.toolbar.Toolbar', {
		layout : {
			overflowHandler : 'Menu'
		},
		items : [ '发布开始时间', {
			xtype : 'datefield',
			format : 'Y-m-d',
			width : 120,
//			value : apply_date_start,
			id : 'create_time_star'
		}, '发布结束时间', {
			xtype : 'datefield',
			format : 'Y-m-d',
			width : 120,
//			value : apply_date_start,
			id : 'create_time_end'
		}, '审核状态', {
			id : 'cmbStatus',
			xtype : 'combobox',
			valueField : 'value',
			displayField : 'content',
			store : statusStore,
			queryMode : 'local',
			width : 150,
			typeAhead : true,
			editable : false
		}, {
			xtype : 'button',
			glyph : glyphSearch,
			text : '查询',
			handler : function() {
				searchExchange();
			}
		}, {
			xtype : 'button',
			glyph : glyphClear,
			text : '清空',
			handler : function() {
				clearExchange();
			}
		} ]
	});
	var exchangeGrid = Ext.create('Ext.grid.Panel', {
		title : '晒晒发布列表',
		frame : true,
		glyph : glyphGrid,
		width : '100%',
		height : pageH,
		collapsible : true,// 表头缩回按钮
		store : exchangeStore,
		selModel : selModel,
		renderTo : Ext.getBody(),
		columns : [ {
			xtype : 'rownumberer',
			width : 40
		},{
			text : '发布人',
			dataIndex : 'user_name',
			width : 180,
			align : 'center',
			sortable : false
		}, {
			text : '发布内容',
			dataIndex : 'content',
			width : 180,
			align : 'center',
			sortable : false
		}, {
			text : '发布时间',
			dataIndex : 'create_time',
			width : 160,
			align : 'center',
			renderer : datesFormat,
			sortable : false
		}, {
			text : '发布地点',
			dataIndex : 'location_desc',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '阅读人数',
			dataIndex : 'read_num',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			text : '审核人',
			dataIndex : 'auditor_id',
			width : 190,
			align : 'center',
			sortable : false
		},  {
			text : '审核状态',
			dataIndex : 'audit_status',
			width : 100,
			align : 'center',
			sortable : false,
			renderer : renderStatus
		}, {
			text : '审核时间',
			dataIndex : 'audit_time',
			width : 100,
			align : 'center',
			sortable : false
		}, {
			xtype : 'actioncolumn',
			text : '操作',
			width : 200,
			align : 'center',
			items : [ {
				text : '查看',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					viewExchange(grid.getStore().getAt(rowIndex))
				}
			}, {
				text : '审核通过',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					check(grid.getStore().getAt(rowIndex))
				}
			}, {
				text : '审核不通过',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					uncheck(grid.getStore().getAt(rowIndex))
				}
			}, {
				text : '删除',
				handler : function(grid, rowIndex, colIndex) {
					setGridSelect(grid, rowIndex);
					viewExchange(grid.getStore().getAt(rowIndex))
				}
			}]
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
			items : [ exchangeTb ]
		},
		bbar : Ext.create('Ext.PagingToolbar', {
			store : exchangeStore,
			displayInfo : true
		})
	});

	var exchangeViewForm = new Ext.create("Ext.form.Panel", {
		id : 'exchangeViewForm',
		width : '100%',
		height : 320,
		bodyPadding : 4,
		layout : 'column',
		defaultType : 'textfield',
		buttonAlign : 'center',
		fieldDefaults : {
			labelAlign : 'right',
			labelWidth : 90,
			anchor : '100%',
			margin : '0 0 5 0',
			msgTarget : 'qtip',
			columnWidth : 1
		},
		items : [ {
			fieldLabel : '发布人',
			name : 'user_name'
		}, {
			fieldLabel : '发布内容',
			name : 'content'
		}, {
			fieldLabel : '发布时间',
			name : 'create_time'
		}, {
			fieldLabel : '发布地点',
			name : 'location_desc'
		}, {
			fieldLabel : '阅读人数',
			name : 'read_num'
		}, {
			fieldLabel : '审核人',
			name : 'auditor_id'
		},  {
			fieldLabel : '审核状态',
			name : 'audit_status',
			id:'audit_status'
		}, {
			fieldLabel : '审核时间',
			name : 'audit_time'
		}],
		 
		buttons : [ {
			text : '审核通过',
			glyph : glyphBack,
			handler : function() {
				check();
			}
		},{
			text : '审核不通过',
			glyph : glyphBack,
			handler : function() {
				uncheck();
			}
		},{
			text : '返回',
			glyph : glyphBack,
			handler : function() {
				exchangeViewWin.hide();
			}
		} ]
	});
	var exchangeViewWin = new Ext.Window({
		width : 600,
		height : 360,
		glyph : glyphWindow,
		title : '『查看晒晒详情』',
		modal : true,
		closeAction : 'hide',
		padding : 4,
		items : [ exchangeViewForm ]
	});

	 searchExchange();
	// 查询
	function searchExchange() {
		exchangeStore.loadPage(1);
	}
	// 选择性条件清空
	function clearExchange() {
		Ext.getCmp('txtGoods_name').setValue('');
		Ext.getCmp('cmbStatus').setValue('');
		Ext.getCmp('txtDeli_mobile').setValue('');

	}
	function check(record) {
		Ext.Msg.confirm('操作提示', '确定通过该记录吗', function(btn, text) {
			if (btn == 'yes') {
				showMask();
				var show_id = "";
				if(record == null || record == ""){
					show_id = exchangeViewForm.getForm().findField("show_id").getValue();
				}else{
					show_id = record.data.show_id
				}
				Ext.Ajax.request({
					url : basePath + '/pc/happyinfoshow/updatepc.do',
					params : {
						show_id : show_id,
						status:"1"
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', result.msgText, function() {
								exchangeStore.reload();
								exchangeViewWin.hide();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText, function() {
								exchangeStore.reload();
							});
						}
					}
				});
			}
		});
	}

	// 审核不通过
	function uncheck(record) {
		Ext.Msg.confirm('操作提示', '确定不通过该记录吗', function(btn, text) {
			if (btn == 'yes') {
				showMask();
				var show_id = "";
				if(record == null || record == ""){
					show_id = exchangeViewForm.getForm().findField("show_id").getValue();
				}else{
					show_id = record.data.show_id
				}
				Ext.Ajax.request({
					url : basePath + '/pc/happyinfoshow/updatepc.do',
					params : {
						show_id : show_id,
						status:"2"
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', result.msgText, function() {
								exchangeStore.reload();
								exchangeViewWin.hide();
							});
						} else {
							Ext.Msg.alert('操作提示', result.msgText, function() {
								exchangeStore.reload();
							});
						}
					}
				});
			}
		});
	}
	function deleteRecord(record) {
		Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				showMask();
				Ext.Ajax.request({
					url : basePath + '/pc/happyinfoshow/deletepc.do',
					params : {
						show_id : record.data.show_id
					},
					success : function(response) {
						unMask();
						var result = Ext.decode(response.responseText);
						if (result.success) {
							Ext.Msg.alert('操作提示', '删除成功', function() {
								exchangeStore.reload();
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
	function viewExchange(record) {
		exchangeViewForm.getForm().loadRecord(record);
		var audit_status = exchangeViewForm.getForm().findField("audit_status").getValue();
		Ext.getCmp('audit_status').setValue(auditStatusFormat(audit_status));
		setFormReadOnly(exchangeViewForm, true);
		exchangeViewWin.show();
	}
	// 自适应大小
	Ext.GlobalEvents.on('resize', function() {
		exchangeGrid.getView().refresh();
		exchangeGrid.setWidth('100%')
	})
});