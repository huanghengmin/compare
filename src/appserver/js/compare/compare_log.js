/**
 * Created by IntelliJ IDEA.
 * User: 钱晓盼
 * Date: 12-6-19
 * Time: 上午10:19
 * To change this template use File | Settings | File Templates.
 * 用户日志审计(用户操作审计表)
 */
Ext.onReady(function() {

    Ext.BLANK_IMAGE_URL = '../../js/ext/resources/images/default/s.gif';

    Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';

    var start = 0;
    var pageSize = 15;
    var tb = new Ext.Toolbar({
        width : setWidth(),
        height : 30,
        items : ['身份证',{
            id:'idCard.tb.info',
            xtype:'textfield',
            emptyText :'输入身份证',
            width : 100
        }, {
            xtype : 'tbspacer',
            width : 10
        }, {
            text : '查询',
            iconCls:'query',
            listeners : {
                click : function() {
                    var idCard = Ext.fly('idCard.tb.info').dom.value == '--请输入身份证--'
                        ? null
                        : Ext.fly('idCard.tb.info').dom.value;
                    store.setBaseParam('idCard', idCard);
                    store.load({
                        params : {
                            start : start,
                            limit : pageSize
                        }
                    });
                }
            }
        }]
    });
    var record = new Ext.data.Record.create([
        {name:'id',			mapping:'id'},
        {name:'session_id',			mapping:'session_id'},
        {name:'idCard',		mapping:'idCard'},
        {name:'code',		    mapping:'code'},
        {name:'xq',	mapping:'xq'},
        {name:'log_time',	mapping:'log_time'}
    ]);
    var proxy = new Ext.data.HttpProxy({
        url:'../../IdentityQueryLogAction_find.action'
    });
    var reader = new Ext.data.JsonReader({
        totalProperty:"total",
        root:"rows",
        id:'id'
    },record);
    var store = new Ext.data.GroupingStore({
        id:"store.info",
        proxy : proxy,
        reader : reader
    });

//    var boxM = new Ext.grid.CheckboxSelectionModel();   //复选框
//    var boxM = new Ext.grid.RadioboxSelectionModel();   //单选框
    var rowNumber = new Ext.grid.RowNumberer();         //自动 编号
    var colM = new Ext.grid.ColumnModel([
//        boxM,
        rowNumber,
        {header:'身份证',		dataIndex:'idCard',		   align:'center',sortable:true,menuDisabled:true,width:120},
        {header:"代码",			dataIndex:"code",       align:'center',sortable:true,menuDisabled:true,width:100},
        {header:'详情',	    dataIndex:'xq',	   align:'center',sortable:true,menuDisabled:true,width:100},
        {header:'日志时间',	    dataIndex:'log_time',      align:'center',sortable:true,menuDisabled:true}

    ]);
    /*for(var i=6;i<14;i++){
     colM.setHidden(i,!colM.isHidden(i));                // 加载后 不显示 该项
     }
     colM.defaultSortable = true;*/
    var page_toolbar = new Ext.PagingToolbar({
        pageSize : pageSize,
        store:store,
        displayInfo:true,
        displayMsg:"显示第{0}条记录到第{1}条记录，一共{2}条",
        emptyMsg:"没有记录",
        beforePageText:"当前页",
        afterPageText:"共{0}页"
    });
    var grid_panel = new Ext.grid.GridPanel({
        id:'grid.info',
        plain:true,
        height:setHeight(),
        width:setWidth(),
        animCollapse:true,
        loadMask:{msg:'正在加载数据，请稍后...'},
        border:false,
        collapsible:false,
        cm:colM,
//        sm:boxM,
        store:store,
        stripeRows:true,
        autoExpandColumn:'Position',
        disableSelection:true,
        bodyStyle:'width:100%',
        enableDragDrop: true,
        selModel:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{
            forceFit:true,
            enableRowBody:true,
            getRowClass:function(record,rowIndex,p,store){
                return 'x-grid3-row-collapsed';
            }
        },
        tbar:[tb],
        view:new Ext.grid.GroupingView({
            forceFit:true,
            groupingTextTpl:'{text}({[values.rs.length]}条记录)'
        }),
        bbar:page_toolbar
    });
    var port = new Ext.Viewport({
        layout:'fit',
        renderTo: Ext.getBody(),
        items:[grid_panel]
    });
    store.load({
        params:{
            start:start,limit:pageSize
        }
    });
});
function setHeight(){
    var h = document.body.clientHeight-8;
    return h;
}

function setWidth(){
    return document.body.clientWidth-8;
}
