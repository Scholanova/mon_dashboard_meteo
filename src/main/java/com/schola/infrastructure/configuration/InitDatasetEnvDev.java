package com.schola.infrastructure.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Conditional(value = {MockProfileCondition.class})
public class InitDatasetEnvDev {
    @Autowired
    protected DataSource dataSource;;

    @Autowired
    protected Environment env;


    @PostConstruct
    public void initDataSet() throws SQLException {

        try
            (Connection connection = dataSource.getConnection()){
                connection.getSchema();
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/db/00_drop.sql"));
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("/db/01_create.sql"));

        }

        }

}
