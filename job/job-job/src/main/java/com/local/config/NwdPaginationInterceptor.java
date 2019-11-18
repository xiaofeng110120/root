package com.local.config;

import com.baomidou.mybatisplus.core.MybatisDefaultParameterHandler;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 复写分页查询queryTotlal方法，目的解决针对sharding-jdbc分库分表时存在count因无别名而报错问题
 * 改写ShardingPreparedStatement.executeQuery为ShardingPreparedStatement.execute
 */
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
)})
public class NwdPaginationInterceptor extends PaginationInterceptor {

    @Override
    protected void queryTotal(boolean overflowCurrent, String sql, MappedStatement mappedStatement, BoundSql boundSql, IPage page, Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            Throwable var8 = null;

            try {
                DefaultParameterHandler parameterHandler = new MybatisDefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
                parameterHandler.setParameters(statement);
                long total = 0L;
                boolean ret = statement.execute();
                Throwable var13 = null;

                ResultSet resultSet = null;
                try {
                    if (ret) {
                        resultSet = statement.getResultSet();
                        if (resultSet.next()) {
                            total = resultSet.getLong(1);
                        }
                    }
                } catch (Throwable var38) {
                    var13 = var38;
                    throw var38;
                } finally {
                    if (resultSet != null) {
                        if (var13 != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var37) {
                                var13.addSuppressed(var37);
                            }
                        } else {
                            resultSet.close();
                        }
                    }

                }

                page.setTotal(total);
                long pages = page.getPages();
                if (overflowCurrent && page.getCurrent() > pages) {
                    page.setCurrent(1L);
                }
            } catch (Throwable var40) {
                var8 = var40;
                throw var40;
            } finally {
                if (statement != null) {
                    if (var8 != null) {
                        try {
                            statement.close();
                        } catch (Throwable var36) {
                            var8.addSuppressed(var36);
                        }
                    } else {
                        statement.close();
                    }
                }

            }

        } catch (Exception var42) {
            throw ExceptionUtils.mpe("Error: Method queryTotal execution error.", var42, new Object[0]);
        }
    }

}