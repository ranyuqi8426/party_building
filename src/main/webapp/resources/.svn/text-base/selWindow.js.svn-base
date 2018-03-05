// 选择路局form
var bureauForm = new Ext.create("Ext.form.Panel", {
	id : 'bureauForm',
	frame : true,
	border : true,
	width : '100%',
	height : 260,
	bodyPadding : 4,
	buttonAlign : 'center',
	defaultType : 'textfield',
	waitTitle : '正在提交中',
	fieldDefaults : {
		labelAlign : 'right',
		margin : '0 0 5 0'
	},
	items : [ {
		xtype : 'container',
		layout : 'hbox',
		margin : '0 0 0 50',
		width : 160,
		items : [ {
			xtype : 'checkbox',
			boxLabel : '全选',
			checked : true,
			handler : function(chk, val) {
				selectAll("chkBureaus", val)
			}
		}, {
			xtype : 'checkbox',
			boxLabel : '反选',
			checked : false,
			handler : function(chk, val) {
				unSelectAll("chkBureaus", val)
			}
		} ]
	}, {
		xtype : 'checkboxgroup',
		fieldLabel : '路局',
		labelWidth : 40,
		id : 'chkBureaus',
		columns : 3,
		vertical : false
	} ],
	buttons : [ {
		text : '选择',
		glyph : glyphSave,
		handler : selectBureau
	}, {
		text : '返回',
		glyph : glyphBack,
		handler : function() {
			bureauWin.hide();
		}
	} ]
});

var bureauWin = new Ext.Window({
	width : 400,
	height : 300,
	glyph : glyphWindow,
	title : '选择路局',
	modal : true,
	closeAction : 'hide',
	padding : 4,
	items : [ bureauForm ]
});
// 选择银行
var bankForm = new Ext.create("Ext.form.Panel", {
	id : 'bankForm',
	frame : true,
	border : true,
	width : '100%',
	height : 260,
	bodyPadding : 4,
	buttonAlign : 'center',
	defaultType : 'textfield',
	waitTitle : '正在提交中',
	fieldDefaults : {
		labelAlign : 'right',
		margin : '0 0 5 0'
	},
	items : [ {
		xtype : 'container',
		layout : 'hbox',
		margin : '0 0 0 50',
		width : 160,
		items : [ {
			xtype : 'checkbox',
			boxLabel : '全选',
			checked : false,
			handler : function(chk, val) {
				selectAll("chkBanks", val)
			}
		}, {
			xtype : 'checkbox',
			boxLabel : '反选',
			checked : false,
			handler : function(chk, val) {
				unSelectAll("chkBanks", val)
			}
		} ]
	}, {
		xtype : 'checkboxgroup',
		fieldLabel : '银行',
		labelWidth : 40,
		columns : 3,
		vertical : false,
		id : 'chkBanks'
	} ],
	buttons : [ {
		text : '保存',
		glyph : glyphSave,
		handler : selectBank
	}, {
		text : '返回',
		glyph : glyphBack,
		handler : function() {
			bankWin.hide();
		}
	} ]
});
var bankWin = new Ext.Window({
	width : 400,
	height : 300,
	glyph : glyphWindow,
	title : '选择银行',
	modal : true,
	closeAction : 'hide',
	padding : 4,
	items : [ bankForm ]
});

// 选择支付方式
var channelForm = new Ext.create("Ext.form.Panel", {
	id : 'channelForm',
	frame : true,
	border : true,
	width : '100%',
	height : 260,
	bodyPadding : 4,
	buttonAlign : 'center',
	defaultType : 'textfield',
	waitTitle : '正在提交中',
	fieldDefaults : {
		labelAlign : 'right',
		margin : '0 0 5 0'
	},
	items : [ {
		xtype : 'container',
		layout : 'hbox',
		margin : '0 0 0 50',
		width : 160,
		items : [ {
			xtype : 'checkbox',
			boxLabel : '全选',
			checked : true,
			handler : function(chk, val) {
				selectAll("chkChannels", val)
			}
		}, {
			xtype : 'checkbox',
			boxLabel : '反选',
			checked : false,
			handler : function(chk, val) {
				unSelectAll("chkChannels", val)
			}
		} ]
	}, {
		xtype : 'checkboxgroup',
		fieldLabel : '支付方式',
		labelWidth : 40,
		id : 'chkChannels',
		columns : 3,
		vertical : false
	} ],
	buttons : [ {
		text : '选择',
		glyph : glyphSave,
		handler : selectChannel
	}, {
		text : '返回',
		glyph : glyphBack,
		handler : function() {
			channelWin.hide();
		}
	} ]
});

var channelWin = new Ext.Window({
	width : 400,
	height : 300,
	glyph : glyphWindow,
	title : '选择支付方式',
	modal : true,
	closeAction : 'hide',
	padding : 4,
	items : [ channelForm ]
});

// 选择银行
function selectBank() {
	var chkBanks = Ext.getCmp('chkBanks').getChecked();
	if (chkBanks.length == 0) {
		Ext.Msg.alert('操作提示', '请选择银行');
		return;
	}
	bankWin.hide();
}
// 选择路局
function selectBureau() {
	var chkBureaus = Ext.getCmp('chkBureaus').getChecked();
	if (chkBureaus.length == 0) {
		Ext.Msg.alert('操作提示', '请选择路局');
		return;
	}
	bureauWin.hide();
}

// 选择支付方式
function selectChannel() {
	var chkChannels = Ext.getCmp('chkChannels').getChecked();
	if (chkChannels.length == 0) {
		Ext.Msg.alert('操作提示', '请选择支付方式');
		return;
	}
	channelWin.hide();
}