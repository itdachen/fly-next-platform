/** The Web UI Theme-v1.9.0 */;layui.define("admin",function(a){var l=layui.setter,s=layui.element,o=layui.admin,r=o.tabsPage,e=layui.view,y="layadmin-layout-tabs",u=layui.$,e=(u(window),o.screen()<2&&o.sideFlexible(),e().autoRender(),{openTabsPage:function(e,a){function i(){s.tabChange(y,e),o.tabsBodyChange(r.index,{url:e,text:a})}var n,t=u("#LAY_app_tabsheader>li"),d=e.replace(/(^http(s*):)|(\?[\s\S]*$)/g,"");t.each(function(a){u(this).attr("lay-id")===e&&(n=!0,r.index=a)}),a=a||"\u65b0\u6807\u7b7e\u9875";l.pageTabs?n||(setTimeout(function(){u("#LAY_app_body").append(['<div class="layadmin-tabsbody-item layui-show">','<iframe src="'+e+'" frameborder="0" class="layadmin-iframe"></iframe>',"</div>"].join("")),i()},10),r.index=t.length,s.tabAdd(y,{title:"<span>"+a+"</span>",id:e,attr:d})):o.tabsBody(o.tabsPage.index).find(".layadmin-iframe")[0].contentWindow.location.href=e,i()}});u.extend(o,e),a("adminIndex",e)});