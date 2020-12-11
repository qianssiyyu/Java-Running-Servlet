package com.rapstar.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.rapstar.controller.AccColController;
import com.rapstar.controller.AcclistController;
import com.rapstar.controller.AccompanimentController;
import com.rapstar.controller.IndexController;
import com.rapstar.controller.UserController;
import com.rapstar.model._MappingKit;

public class AppConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// 配置视图类型
		me.setViewType(ViewType.JSP);
		// 配置开发模式，true 值为开发模式
		me.setDevMode(true);
		// 配置 encoding，默认为 UTF8
		me.setEncoding("UTF8");
		// 设置 Json 转换工厂实现类
		me.setJsonFactory(new MixedJsonFactory());
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/user", UserController.class);
		me.add("/acccollect", AccColController.class);
		me.add("/acc", AccompanimentController.class);
		me.add("/acclist", AcclistController.class);
		me.add("/", IndexController.class);
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/rapstar?useUnicode=true&characterEncoding=utf-8",
				"root", "");
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setShowSql(true);
		me.add(arp);
		arp.setDialect(new MysqlDialect());
		_MappingKit.mapping(arp);

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
