package com.bonbon.knowns.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yli11
 * @date 2021-01-06 19:52:10
 * @description
 */
public class CodeGenerator {

    //项目路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    //模块路径
//    private static final String MODULE_PATH = "easybi-business";
    private static final String JAVA_PATH = "src/main/java";
    private static final String RESOURCE_PATH = "src/main/resources";
    private static final String PROPERTIES_PATH = "application.yml";
    /**
     * 数据库配置
     */
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/known?characterEncoding=utf-8&useSSL=false&serverTimezone=Hongkong";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Jia19971210.";

    private static final String SCHEMA_NAME = "known";


    /**
     * 数据库表名 多个以英文逗号分隔
     */
    private static final String TABLE_NAMES = "knowns_user";

    /**
     * 作者
     */
    private static final String AUTHOR = "rocky";
    /**
     * 模块名
     */
//    private static final String MODULE_NAME = "collection";

    /**
     * 实体包路径
     */
    private static final String ENTITY_NAME = "model.entity";
    /**
     * 父路径
     */
    private static final String PARENT_PACKAGE = "com.bonbon.knowns";

    /**
     * mapper.xml路径
     */
    private static final String MAPPER_PATH = "src/main/resources/mapper/";
    /**
     * mapper模板路径
     */
    private static final String MAPPER_TEMPLATE_PATH = "/templates/mapper.xml.ftl";
    /**
     * dto模板路径
     */
    private static final String DTO_TEMPLATE_PATH = "/templates/dto.java.ftl";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = getGlobalConfig(PROJECT_PATH  + File.separator + JAVA_PATH);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = getDataSourceConfig();
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = getPackageConfig();
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = getInjectionConfig(PROJECT_PATH + File.separator , pc);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = getTemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = getStrategyConfig();

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }


    private static GlobalConfig getGlobalConfig(String outputDir) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setServiceName("%sService");
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        return gc;
    }


    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
//                if (fieldType.toLowerCase().contains("tinyint(1)")) {
//                    return DbColumnType.INTEGER;
//                }
//                return super.processTypeConvert(config, fieldType);
//            }
//        });
        dsc.setUrl(JDBC_URL);
        dsc.setDriverName(JDBC_DRIVER);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        dsc.setSchemaName(SCHEMA_NAME);
        return dsc;
    }


    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(MODULE_NAME);
        pc.setEntity(ENTITY_NAME);
        pc.setParent(PARENT_PACKAGE);
        return pc;
    }

    private static InjectionConfig getInjectionConfig(String projectPath, PackageConfig pc) {
        Map<String, Object> map = new HashMap<>();
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                PackageConfig packageConfig = getPackageConfig();
                map.put("dtoPackage", packageConfig.getParent() + StringPool.DOT + "model.dto");
//                map.put("includeFields", "userName,realName");
                map.put("excludeFields", "updateTime,createTime");
                setMap(map);
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(MAPPER_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + MAPPER_PATH
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(DTO_TEMPLATE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + JAVA_PATH + File.separator + PARENT_PACKAGE.replaceAll("\\.", "/") + File.separator + pc.getModuleName() + "/model/dto/" + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(TABLE_NAMES.split(","));
//        strategy.setTablePrefix("easybi");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntitySerialVersionUID(false);
        return strategy;
    }
}
