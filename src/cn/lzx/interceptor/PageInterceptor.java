package cn.lzx.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;

import cn.lzx.domin.Page;

//Github上面有pageHelper开源插件
@Intercepts({@Signature(method="prepare",type=StatementHandler.class,args= {Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		/*StatementHandler statementHandler = (StatementHandler)invocation.getTarget();  
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");  
        String id = mappedStatement.getId();  
        if(id.matches(".+ByPage$")){  
            BoundSql boundSql = statementHandler.getBoundSql();  
            Map<String,Object> params = (Map<String,Object>)boundSql.getParameterObject();  
            Page page = (Page)params.get("page");  
            String sql = boundSql.getSql();  
            String countSql = "select count(*)from ("+sql+")a";  
            Connection connection = (Connection) invocation.getArgs()[0];  
            PreparedStatement countStatement = connection.prepareStatement(countSql);  
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");  
            parameterHandler.setParameters(countStatement);  
            ResultSet rs = countStatement.executeQuery();  
            if(rs.next()){  
                page.setTotalCount((rs.getInt(1)));
            }  
            String pageSql = sql+" limit "+page.getStartIndex()+","+page.getSelectCount();  
            metaObject.setValue("delegate.boundSql.sql", pageSql);  
        }  
        return invocation.proceed();  */
		//获取目标对象
		StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
		//利用反射机制
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
		MappedStatement mappedStatement=(MappedStatement)metaObject.getValue("delegate.mappedStatement");
		//获取xml配置文件的mysql语句的对应id
		String id=mappedStatement.getId();
		if(id.matches(".+ByPage$")) {
			//获取xml的sql配置东西
			BoundSql boundSql=statementHandler.getBoundSql();
			//获取sql语句的参数
			Map<String,Object> params=(Map<String,Object>)boundSql.getParameterObject();
			Page page=(Page)params.get("page");
			//获取sql语句
			String sql=boundSql.getSql();
			//获取查询总数目
			String countSql="select count(*) from ("+sql+")a";
			Connection connection=(Connection)invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);  
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");  
            parameterHandler.setParameters(countStatement);  
            ResultSet rs = countStatement.executeQuery();  
            if(rs.next()){  
                page.setTotalCount((rs.getInt(1)));
            }
            //拼接sql分页语句
            String pageSql=sql+" limit "+page.getStartIndex()+","+page.getSelectCount();
            //使用pageSql覆盖原来的sql
            metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// 获取代理对象，执行intercept的方法
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
