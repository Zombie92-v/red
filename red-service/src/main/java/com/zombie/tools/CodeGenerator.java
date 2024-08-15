package com.zombie.tools;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 *
 * @author XiePeiXun
 * @since 2024/08/14 18:17
 */
public class CodeGenerator {

    public static void main(String[] args) {
        String outputDir = System.getProperty("user.dir");
        outputDir += "/red-service";

        String packageName = "com.zombie.persistence.auto";
        String[] tableNames = new String[]{"user"};
        //不覆盖mapper接口和mapper文件
        boolean first = true;
        generate(outputDir, first, packageName, tableNames);

    }

    public static void generate(final String outputDir, boolean first, String packageName, String... tableNames) {

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir + "/src/main/java");
        gc.setAuthor("xpx");
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setFileOverride(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("%s");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/red?useUnicode=true&useSSL=false&characterEncoding=utf8&allowMultiQueries=true");
        dsc.setUsername("root");
        dsc.setPassword("zombie@159156");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        mpg.setPackageInfo(pc);

        if (first) {
            //模板配置
            String templatePath = "/templates/mapper.xml.vm";
            //自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return outputDir.replace("red-service", "red-service") + "/src/main/resources/mapper/"
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
        }

        //配置模板
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        if (!first) {
            tc.setMapper(null);
        }
        if (!first) {
            tc.setService(null); //不生成service
            tc.setServiceImpl(null); //不生成service实现类
        }

        tc.setController(null); //不生成controller
        mpg.setTemplate(tc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setEntityLombokModel(true); //是否为lombok模型

        if (null != tableNames && tableNames.length > 0) { // 表名为空，则生成全部
            strategy.setInclude(tableNames); //需要包含的表名，允许正则表达式，与exclude二选一配置）
        } else {
            strategy.setExclude(null);

        }
        strategy.setEntityColumnConstant(true); //设置是否生产字段常量
        strategy.setEntityBooleanColumnRemoveIsPrefix(true); //Boolean类型字段是否移除is前缀
        strategy.setEntityTableFieldAnnotationEnable(true); //是否生成实体时，生成字段注解
        mpg.setStrategy(strategy);
        mpg.execute();

    }
}
